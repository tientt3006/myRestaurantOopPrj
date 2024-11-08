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
    public int getReservedTable(int branchId, String date, String time) throws DbException {
        int reservedTableCount = 0;
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement(SqlUtils.FIND_RESERVED_TABLE)) {
            ps.setInt(1, branchId);
            ps.setString(2, date);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    reservedTableCount = rs.getInt(1); // Assuming the query returns the count in the first column
                }
            }
        } catch (SQLException ex) {
            throw new DbException("Cannot getReservedTable", ex);
        }
        return reservedTableCount;
    }

    @Override
    public int getOccupiedTable(int branchId, String date, String time) throws DbException {
        int occupiedTableCount = 0;
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement(SqlUtils.FIND_OCCUPIED_TABLE)) {
            ps.setInt(1, branchId);
            ps.setString(2, date);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    occupiedTableCount = rs.getInt(1); // Assuming the query returns the count in the first column
                }
            }
        } catch (SQLException ex) {
            throw new DbException("Cannot getReservedTable", ex);
        }
        return occupiedTableCount;
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
    public void addTable(String date,String time,String status,int numOfPeople,int branchId) throws DbException {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = ConnectionPool.getInstance().getConnection();
            ps = con.prepareStatement(SqlUtils.ADD_TABLE);
            int k = 0;
            ps.setString(++k, date);
            ps.setString(++k, time);
            ++k;
            ps.setString(++k, status);
            ps.setInt(++k, numOfPeople);
            k+=2;
            ps.setInt(++k, branchId);

            if (ps.executeUpdate() == 0) {
                throw new DbException("AddTable failed, no rows attached");
            }
        } catch (SQLException ex) {
            throw new DbException("Cannot addition table", ex);
        } finally {
            SqlUtils.close(con);
            SqlUtils.close(ps);
        }
        return;
    }

}
