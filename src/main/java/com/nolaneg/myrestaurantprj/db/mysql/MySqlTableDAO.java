/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.nolaneg.myrestaurantprj.db.mysql;
import com.nolaneg.myrestaurantprj.db.InterfaceDAO.TableDAO;
import com.nolaneg.myrestaurantprj.exceptions.DbException;
import com.nolaneg.myrestaurantprj.util.SqlUtils;
import java.util.*;
import java.io.*;
import java.math.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author $_{user}
 */
public class MySqlTableDAO implements TableDAO{

    @Override
    public int getReservedTable(int branchId, String date) throws DbException {
        int reservedTableCount = 0;
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement(SqlUtils.RESERVED_TABLE_COUNT)) {
            ps.setInt(1, branchId);
            ps.setString(2, date);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    reservedTableCount = rs.getInt(1);
                }
            }
        } catch (SQLException ex) {
            throw new DbException("Cannot getReservedTable", ex);
        }
        return reservedTableCount;
    }

    @Override
    public int getUnpaidTable(int branchId, String date) throws DbException {
        int unpaidTableCount = 0;
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement(SqlUtils.UNPAID_TABLE_COUNT)) {
            ps.setInt(1, branchId);
            ps.setString(2, date);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    unpaidTableCount = rs.getInt(1);
                }
            }
        } catch (SQLException ex) {
            throw new DbException("Cannot getReservedTable", ex);
        }
        return unpaidTableCount;
    }
    
    /**
     *
     * @param date
     * @param time
     * @param numOfPeople
     * @param branchId
     * @throws DbException
     */
    @Override
    public void addTable(int receiptId) throws DbException {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = ConnectionPool.getInstance().getConnection();
            ps = con.prepareStatement(SqlUtils.ADD_TABLE);
            int k = 0;
            ps.setInt(++k, receiptId);
            if (ps.executeUpdate() == 0) {
                throw new DbException("AddTable failed, no rows attached");
            }
            con.commit();
        } catch (SQLException ex) {
            if (con != null) SqlUtils.rollback(con);
            throw new DbException("Cannot addition table", ex);
        } finally {
            SqlUtils.close(con);
            SqlUtils.close(ps);
        }
    }

}
