/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.nolaneg.myrestaurantprj.db.mysql;

import com.nolaneg.myrestaurantprj.db.InterfaceDAO.UserDAO;
import com.nolaneg.myrestaurantprj.db.entity.User;
import com.nolaneg.myrestaurantprj.exceptions.DbException;
import com.nolaneg.myrestaurantprj.util.SqlUtils;
import com.nolaneg.myrestaurantprj.util.Utils;
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
                .setUserId(rs.getInt(++k))
                .setFirstName(rs.getString(++k))
                .setLasttName(rs.getString(++k))
                //.setPassword(rs.getString(++k))
                .setEmail(rs.getString(k += 2))
                .setPhone(rs.getString(++k))
                .setRoleId(rs.getInt(++k))
                .getUser();
    }
    
    @Override
    public User getUserByEmail(String email) throws DbException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement(SqlUtils.FIND_USER_BY_EMAIL)) {
            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) return null;
                return mapUser(rs);
            }
        } catch (SQLException ex) {
            throw new DbException("Cannot getUserByEmail", ex);
        }
    }
    
    @Override
    public User getUserByPhone(String phone) throws DbException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement(SqlUtils.FIND_USER_BY_PHONE)) {
            ps.setString(1, phone);
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) return null;
                return mapUser(rs);
            }
        } catch (SQLException ex) {
            throw new DbException("Cannot getUserByPhone", ex);
        }
    }
    
    @Override
    public boolean isLoginUnique(String login) throws DbException {
        if(getUserByEmail(login) == null && getUserByPhone(login) == null)
            return true;
        return false;
    }
    
    @Override
    public User logIn(String email, String password) throws DbException {
        String hashPass = Utils.hashPassword(password);
        try (Connection c = ConnectionPool.getInstance().getConnection();
                PreparedStatement ps = c.prepareStatement(SqlUtils.LOG_IN)) {
            int k = 0;
            ps.setString(++k, email);

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
    
    @Override
    public User signUp(User user, String password) throws DbException {
        String hashPass = Utils.hashPassword(password);
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = ConnectionPool.getInstance().getConnection();
            ps = con.prepareStatement(SqlUtils.SIGN_UP);
            int k = 0;
            ps.setString(++k, user.getFirstName());
            ps.setString(++k, user.getLastName());
            
            ps.setString(++k, hashPass);
            ps.setString(++k, user.getEmail());
            ps.setString(++k, user.getPhone());
            
            if (ps.executeUpdate() == 0) {
                throw new DbException("SignUp failed, no rows attached");
            }
            con.commit();
            return getUserByEmail(user.getEmail());
        } catch (SQLException ex) {
            if (con != null) SqlUtils.rollback(con);
            throw new DbException("Cannot logIn", ex);
        } finally {
            SqlUtils.close(con);
            SqlUtils.close(ps);
        }
    }
    
}
