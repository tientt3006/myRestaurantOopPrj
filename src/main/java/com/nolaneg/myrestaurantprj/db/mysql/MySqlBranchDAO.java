/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.nolaneg.myrestaurantprj.db.mysql;
import com.nolaneg.myrestaurantprj.db.InterfaceDAO.BranchDAO;
import com.nolaneg.myrestaurantprj.db.InterfaceDAO.DAO;
import com.nolaneg.myrestaurantprj.db.entity.Branch;
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
public class MySqlBranchDAO implements BranchDAO{

    private static Branch mapBranch(ResultSet rs) throws SQLException, DbException {
        return new Branch.Builder()
                .setBranchId(rs.getInt("branchId"))
                .setLocation(rs.getString("address"))
                .setManager(DAO.getDAO().getUserDAO().getUserById(rs.getInt("mnId")))
                .getBranch();        
    }
    
    @Override
    public ArrayList<Branch> getBranchs() throws DbException {
        ArrayList<Branch> branchs = new ArrayList<>();
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement(SqlUtils.GET_BRANCHS);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                branchs.add(mapBranch(rs));
            }
        } catch (SQLException ex) {
            throw new DbException("Cannot get branchs", ex);
        }
        return branchs;
    }
    @Override
    public Branch getBranch(int managerID) throws DbException {
        Connection con= null;
        PreparedStatement ps = null;
        try {
            con = ConnectionPool.getInstance().getConnection();
            ps = con.prepareStatement(SqlUtils.GET_BRANCHID_BY_MANAGERID); 
            ps.setInt(1, managerID);
            try(ResultSet rs = ps.executeQuery();){
                if(rs.next()){
                    return mapBranch(rs);
                }
                else{
                    return null;
                }
            }
        } catch (SQLException ex) {
            throw new DbException("Cannot getBranch", ex);
        } finally {
            SqlUtils.close(con);
            SqlUtils.close(ps);
        }
    }
}
