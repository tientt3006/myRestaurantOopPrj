/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.nolaneg.myrestaurantprj.util;
import com.nolaneg.myrestaurantprj.db.InterfaceDAO.DAO;
import com.nolaneg.myrestaurantprj.db.entity.Branch;
import com.nolaneg.myrestaurantprj.exceptions.AppException;
import com.nolaneg.myrestaurantprj.exceptions.DbException;
import java.util.*;
import java.io.*;
import java.math.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.logging.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author $_{user}
 */
public class SqlUtils {
    
    public static final String GET_BRANCHS = "SELECT * FROM branch";
    
    public static final String FIND_RESERVED_TABLE = "SELECT COUNT(*) FROM tables WHERE branchId = ? AND reservation_date = ? AND status = 'reserved';";
    public static final String FIND_OCCUPIED_TABLE = "SELECT COUNT(*) FROM tables WHERE branchId = ? AND reservation_date = ? AND status = 'occupied';";
    public static final String ADD_TABLE = "INSERT INTO tables (reservation_date, reservation_time,status, num_people, branchId) VALUES (?, ?, ?, ?, ?)";
    public static final String LOG_IN = "SELECT * FROM users WHERE email LIKE ? AND password LIKE ?";
    public static final String SIGN_UP = "INSERT INTO users (firstName, lastName, password, email, phone) VALUES (?, ?, ?, ?, ?)";
    public static final String FIND_USER_BY_ID = "SELECT * FROM users WHERE userId LIKE ?";
    public static final String FIND_USER_BY_EMAIL = "SELECT * FROM users WHERE email LIKE ?";
    public static final String FIND_USER_BY_PHONE = "SELECT * FROM users WHERE phone LIKE ?";
    public static final String CHANGE_PASSWORD = "UPDATE users SET password = ? WHERE userId = ?";
    
    public static final String GET_ALL_CATEGORIES = "SELECT * FROM category";
    
    public static final String CHANGE_INFO = "UPDATE users SET firstName = ?, lastName = ?, email = ?, phone = ? WHERE userId = ?";
    public static final String GET_DISHES = "SELECT * FROM dish";
    public static final String GET_DISH_BY_ID = "SELECT * FROM dish WHERE dishId = ?";
    public static final String GET_SORTED_DISHES_FROM_CATEGORY = "SELECT * FROM dish WHERE categoryId = ? ORDER BY ";
    public static final String GET_SORTED_DISHES = "SELECT * FROM dish ORDER BY ";
    public static final String GET_DISHES_COUNT = "SELECT COUNT(*) FROM dish";
    public static final String GET_DISHES_COUNT_IN_CATEGORY = "SELECT COUNT(*) FROM dish WHERE categoryId = ?";
    
    public static final String GET_DISH_ORDERS_COUNT = "SELECT dishId, dishName, IFNULL((SELECT SUM(count) FROM receiptHasDish WHERE receiptHasDish.dishId = dish.dishId), 0) AS orders FROM dish ORDER BY dishId";
    
    private static final Logger logger = LoggerFactory.getLogger(SqlUtils.class);

    // Other constants and methods
    public static ArrayList<Branch> branchs;
    static {
        try {
            branchs = DAO.getDAO().getBranchDAO().getBranchs();
        } catch (DbException e) {
            logger.error("Failed to initialize branchs", e);
        }
    }
    
    public static final Map<String, String> sortingTypes = new HashMap<>();
    static {
        sortingTypes.put("Price", "price");
        sortingTypes.put("Name", "dishName");
        sortingTypes.put("Category", "categoryId");
    }
    
    
    
    public static void rollback(Connection con) {
        try {
            con.rollback();
        } catch (SQLException e) {
            logger.error("Rollback failed", e);
        }
    }

    public static void rollback(Connection con, Savepoint s) {
        try {
            con.rollback(s);
        } catch (SQLException e) {
            logger.error("Rollback to savepoint failed", e);
        }
    }

    public static void close(AutoCloseable closeable) {
        try {
            closeable.close();
        } catch (Exception e) {
            logger.error("Closing resource failed", e);
        }
    }

}
