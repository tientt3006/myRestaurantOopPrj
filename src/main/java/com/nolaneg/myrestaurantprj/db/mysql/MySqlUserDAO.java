/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.nolaneg.myrestaurantprj.db.mysql;

import com.nolaneg.myrestaurantprj.db.InterfaceDAO.UserDAO;
import com.nolaneg.myrestaurantprj.db.entity.User;
import com.nolaneg.myrestaurantprj.exceptions.DbException;
import com.nolaneg.myrestaurantprj.util.JDBCUtil;
import com.nolaneg.myrestaurantprj.util.Util;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author $_{user}
 */
public class MySqlUserDAO implements UserDAO {
    
    private static User mapUser(ResultSet rs) throws SQLException {
        int k = 0;
        return new User.Builder()
                .setUserId(++k)
                .setUsername(rs.getString(++k))
                .setPassword(rs.getString(++k))
                .getUser();
    }
    
    @Override
    public User logIn(String username, String password) throws DbException {
        String hashPass = Util.hashPassword(password);
        try (Connection c = ConnectionPool.getInstance().getConnection();
                PreparedStatement ps = c.prepareStatement(JDBCUtil.LOG_IN)) {
            int k = 0;
            ps.setString(++k, username);
            ps.setString(++k, hashPass);
            try (ResultSet rs = ps.executeQuery()) {
                if(!rs.next()) 
                    return null;
                return mapUser(rs);
            }
        } catch (SQLException e) {
            throw new DbException("Cannot login", e);
        }
    }

    
}
