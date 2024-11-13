/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.nolaneg.myrestaurantprj.db.mysql;
import com.nolaneg.myrestaurantprj.db.InterfaceDAO.ReceiptDAO;
import com.nolaneg.myrestaurantprj.db.entity.Receipt;
import com.nolaneg.myrestaurantprj.exceptions.DbException;
import com.nolaneg.myrestaurantprj.util.SqlUtils;
import java.util.*;
import java.io.*;
import java.math.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 *
 * @author $_{user}
 */
public class MySqlReceiptDAO implements ReceiptDAO {

    private static Receipt mapReceipt(ResultSet rs) throws SQLException {
        return new Receipt.Builder()
                .setReceiptId(rs.getInt(1))
                .setReservationFee(rs.getFloat(4))
                .setReservationDate(LocalDate.parse(rs.getString(7)))
                .setReservationTime(LocalTime.parse(rs.getString(8)))
                .setStatus(rs.getString(11))
                .setCreatDate(LocalDateTime.parse(rs.getString(12)))
                .getReceipt();
    }
    
    @Override
    public Receipt addReceipt(int userId, int branchId, Receipt receipt) throws DbException {
        Connection con = null;
        PreparedStatement ps = null;
        
        try {
            con = ConnectionPool.getInstance().getConnection();
            ps = con.prepareStatement(SqlUtils.ADD_RECEIPT);
            int k = 0;
            ps.setInt(++k, userId);
            ps.setInt(++k, branchId);
            ps.setFloat(++k, receipt.getReservationFee());
            ps.setString(++k, receipt.getReservationDate().toString());
            ps.setString(++k, receipt.getReservationTime().toString());
            ps.setString(++k, receipt.getStatus());
            
            if (ps.executeUpdate() == 0) {
                throw new DbException("add receipt failed, no rows attached");
            }
            con.commit();
            return getLastestReceiptOfAUser(userId, branchId);
        } catch (SQLException ex) {
            if (con != null) SqlUtils.rollback(con);
            throw new DbException("Cannot add receipt", ex);
        } finally {
            SqlUtils.close(con);
            SqlUtils.close(ps);
        }
    }

    public Receipt getLastestReceiptOfAUser(int userId, int branchId) throws DbException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement(SqlUtils.GET_LASTEST_RECEIPT)) {
            ps.setString(1, String.valueOf(userId));
            ps.setString(2, String.valueOf(branchId));
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) return null;
                return mapReceipt(rs);
            }
        } catch (SQLException ex) {
            throw new DbException("Cannot getUserByEmail", ex);
        }
    }

    
}
