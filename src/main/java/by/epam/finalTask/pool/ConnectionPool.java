package by.epam.finalTask.pool;

import by.epam.finalTask.exception.ConnectionException;
import by.epam.finalTask.util.PropertyReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool {
    private static final Logger logger = LogManager.getLogger();

    public static final String DATABASE_PROPERTY_PATH = "database.properties";
    public static final String DATABASE_URL = "url";
    public static final String DATABASE_DRIVER = "driverClassName";

    private static ConnectionPool instance;
    private static final ReentrantLock locker = new ReentrantLock();
    private static final AtomicBoolean create = new AtomicBoolean(false);

    private static final int CONNECTION_POOL_SIZE = 8;
    private BlockingQueue<ProxyConnection> freeConnections;
    private BlockingQueue<ProxyConnection> busyConnections;

    private ConnectionPool() {
        try{
            PropertyReader reader = new PropertyReader();
            Properties properties = reader.read(DATABASE_PROPERTY_PATH);
            String url = properties.getProperty(DATABASE_URL);
            String driver = properties.getProperty(DATABASE_DRIVER);
            Class.forName(driver);
            freeConnections = new LinkedBlockingDeque<>(CONNECTION_POOL_SIZE);
            busyConnections = new LinkedBlockingDeque<>();
            for (int i = 0; i < CONNECTION_POOL_SIZE; i++) {
                freeConnections.add(new ProxyConnection(DriverManager.getConnection(url, properties)));
            }
        } catch (SQLException | ClassNotFoundException | ConnectionException e) {
            logger.error("Error during connection pool creation.", e);
            throw new RuntimeException("Error during connection pool creation.",e);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ConnectionPool getInstance() {
        if (!create.get()) {
            try {
                locker.lock();
                if (instance == null) {
                    instance = new ConnectionPool();
                    create.set(true);
                }
            } finally {
                locker.unlock();
            }
        }
        return instance;
    }

    public Connection getConnection() {
        ProxyConnection connection = null;
        try {
            connection = freeConnections.take();
            busyConnections.put(connection);
        } catch (InterruptedException e) {
            logger.error("Error while getting connection.", e);
            Thread.currentThread().interrupt();
        }
        return connection;
    }

    public void releaseConnection(Connection connection) {
        if(connection instanceof ProxyConnection){
            busyConnections.remove(connection);
            try {
                freeConnections.put((ProxyConnection) connection);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                logger.error("Error: wrong connection to put in free connections.");
            }
        } else {
            logger.error("Error: wrong connection to release.");
        }
    }

    public void destroyPool() {
        try {
            for (ProxyConnection freeConnection : freeConnections) {
                freeConnection.reallyClose();
            }
            deregisterDrivers();
        } catch (SQLException e) {
            logger.error("Error while destroying connection pool.");
        }
    }

    private void deregisterDrivers() throws SQLException {
        while(DriverManager.getDrivers().hasMoreElements()){
            DriverManager.deregisterDriver(DriverManager.getDrivers().nextElement());
        }
    }
}
