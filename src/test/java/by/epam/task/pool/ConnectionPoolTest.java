package by.epam.task.pool;

import by.epam.task.model.pool.ConnectionPool;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.Connection;

import static org.testng.Assert.*;

public class ConnectionPoolTest {
    private Connection connectionProxy;
    private boolean expected = false;

    @BeforeClass
    public void createConnectionPoolAndConnection() {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        connectionProxy = connectionPool.getConnection();
    }

    @Test(groups = "connection" , priority = 1)
    public void getConnectionPositiveTest() {
        boolean result;
        if(connectionProxy.equals(null))
            result = false;
        else result = true;
        assertTrue(result);
        ConnectionPool.getInstance().releaseConnection(connectionProxy);
    }

    @AfterClass
    public void destroyConnectionPool() {
        ConnectionPool.getInstance().destroyPool();
    }
}
