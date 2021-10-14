package by.epam.task.controller.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import by.epam.task.model.pool.ConnectionPool;

@WebListener
public class ServletContextListenerImpl implements ServletContextListener {
        @Override
        public void contextInitialized(ServletContextEvent sce)  {
            ConnectionPool.getInstance();
        }
        @Override
        public void contextDestroyed(ServletContextEvent sce)  {
            ConnectionPool.getInstance().destroyPool();
        }
}
