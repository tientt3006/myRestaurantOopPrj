/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.nolaneg.myrestaurantprj.db.mysql;
import java.util.*;
import java.io.*;
import java.math.*;
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
//import javax.sql.DataSource;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

/**
 *
 * @author $_{user}
 */
public class ConnectionPool {
    private static ConnectionPool instance;
    private final DataSource ds;
    private ConnectionPool() {
        try {
            Context context = new InitialContext();
            ds = (DataSource) context.lookup("java:comp/env/jdbc/oopdinnerdb");
        } catch (NamingException e) {
            throw new IllegalStateException("Cannot init DBManager", e);
        }
        
    }
    public static ConnectionPool getInstance() {
        if(instance == null) {
            instance = new ConnectionPool();
        }
        return instance;
    }

    
    public Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
    
    public void getDataSourceInfo() throws SQLException {
        org.apache.tomcat.jdbc.pool.ConnectionPool pool = ds.getPool();
        System.out.println("==== Pool Stats ====");
        System.out.println("Max Active: " + pool.getPoolProperties().getMaxActive());
        System.out.println("Active Connections: " + pool.getActive());
        System.out.println("Idle Connections: " + pool.getIdle());
        System.out.println("Total Connections: " + pool.getSize());
    }
}
