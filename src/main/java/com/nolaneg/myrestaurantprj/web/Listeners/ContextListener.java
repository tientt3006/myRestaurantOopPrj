package com.nolaneg.myrestaurantprj.web.Listeners;

import com.nolaneg.myrestaurantprj.util.SqlUtils;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebListener
public class ContextListener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {
    private static final Logger logger = LoggerFactory.getLogger(ContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        try {
            context.setAttribute("sortTypes", SqlUtils.sortingTypes);
            context.setAttribute("branchs", SqlUtils.branchs);
            logger.info("Application context initialized successfully.");
        } catch (Exception e) {
            logger.error("Error initializing application context.", e);
        }
        
    }
    /*
    Không cần đóng kết nối trong contextDestroyed:

    Vì bạn đang sử dụng JNDI với một DataSource được quản lý bởi container (Tomcat), 
    container sẽ tự động xử lý việc cleanup connection pool khi ứng dụng dừng.
    
    Bạn chỉ cần đảm bảo mọi kết nối từ connection pool được trả lại đúng cách
    bằng cách gọi Connection.close() sau khi sử dụng. 
    Kết nối này sẽ không bị đóng thực sự mà sẽ được trả lại pool để tái sử dụng.
    */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            Driver driver = drivers.nextElement();
            try {
                DriverManager.deregisterDriver(driver);
                logger.info("Deregistered driver: {}", driver);
            } catch (SQLException e) {
                logger.error("Error deregistering driver: {}", driver, e);
            }
        }
        try {
            com.mysql.cj.jdbc.AbandonedConnectionCleanupThread.checkedShutdown();
            logger.info("AbandonedConnectionCleanupThread stopped.");
        } catch (Exception e) {
            logger.error("Error stopping AbandonedConnectionCleanupThread.", e);
        }
    }
}
