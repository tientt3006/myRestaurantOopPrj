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
import java.util.*;


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
    public User getUserById(int id) throws DbException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement(SqlUtils.FIND_USER_BY_ID)) {
            ps.setString(1, String.valueOf(id));
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) return null;
                return mapUser(rs);
            }
        } catch (SQLException ex) {
            throw new DbException("Cannot getUserById", ex);
        }
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
        return getUserByEmail(login) == null && getUserByPhone(login) == null;
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
    
    @Override
    public void changePassword(int userId, String newPassword) throws DbException {
        String hashPass = Utils.hashPassword(newPassword);
        try(Connection con = ConnectionPool.getInstance().getConnection();
            PreparedStatement ps = con.prepareStatement(SqlUtils.CHANGE_PASSWORD)) {
            int k = 0;
            ps.setString(++k, hashPass);
            ps.setInt(++k, userId);
            
            if(ps.executeUpdate() == 0) {
                throw new DbException("Changing password failed, no rows were changed");
            }
            con.commit();
        } catch  (SQLException e) {
            throw new DbException("Cannot changePassword", e);
        }
    }
    
    @Override
    public void changeInfo(int userId, String firstName, String lastName, String email, String phone) throws DbException {
        try(Connection con = ConnectionPool.getInstance().getConnection();
            PreparedStatement ps = con.prepareStatement(SqlUtils.CHANGE_INFO)) {
            int k = 0;
            ps.setString(++k, firstName);
            ps.setString(++k, lastName);
            ps.setString(++k, email);
            ps.setString(++k, phone);

            ps.setInt(++k, userId);
            
            if(ps.executeUpdate() == 0) {
                throw new DbException("Changing info failed, no rows were changed");
            }
            con.commit();
        } catch  (SQLException e) {
            throw new DbException("Cannot changeInfo", e);
        }
    }
    
    
    @Override
    public ArrayList<Integer> getUserIds(int branchId) throws DbException {
        ArrayList<Integer> UserIds = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = ConnectionPool.getInstance().getConnection();
            ps = con.prepareStatement(SqlUtils.GET_USERID_BY_BRANCHID);
            ps.setInt(1, branchId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                UserIds.add(rs.getInt(1));
            }
        } catch (SQLException ex) {
            throw new DbException("Cannot get getUserIds", ex);
        } finally {
            SqlUtils.close(con);
            SqlUtils.close(ps);
        }
        return UserIds;
    }
    
    @Override
    public ArrayList<Integer> getUserIdsBySearchName(String searchName) throws DbException {
        ArrayList<Integer> UserIds = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = ConnectionPool.getInstance().getConnection();
            ps = con.prepareStatement(SqlUtils.GET_USERID_BY_SEARCHNAME);
            ps.setString(1, "%" + searchName + "%");
            ps.setString(2, "%" + searchName + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                UserIds.add(rs.getInt(1));
            }
        } catch (SQLException ex) {
            throw new DbException("Cannot get getUserIdsBySearchName", ex);
        } finally {
            SqlUtils.close(con);
            SqlUtils.close(ps);
        }
        return UserIds;
    }
}
