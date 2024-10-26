/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.nolaneg.myrestaurantprj.util;
import java.util.*;
import java.io.*;
import java.math.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author $_{user}
 */
public class SqlUtils {

    public static final String LOG_IN = "SELECT * FROM users WHERE email LIKE ? AND password LIKE ?";
    public static final String SIGN_UP = "INSERT INTO users (firstName, lastName, password, email, phone) VALUES (?, ?, ?, ?, ?)";
    public static final String FIND_USER_BY_EMAIL = "SELECT * FROM users WHERE email LIKE ?";
    public static final String FIND_USER_BY_PHONE = "SELECT * FROM users WHERE phone LIKE ?";
    public static final String CHANGE_PASSWORD = "UPDATE users SET password = ? WHERE userId = ?";
    private static final Logger logger = LoggerFactory.getLogger(SqlUtils.class);

    // Other constants and methods

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
