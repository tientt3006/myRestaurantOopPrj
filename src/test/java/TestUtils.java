
import com.nolaneg.myrestaurantprj.util.*;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author $_{user}
 */
public class TestUtils {
    public static void main(String[] args) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        System.out.println(c);
    }

    
}
class ConnectionPool {

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
}