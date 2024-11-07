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
    public List<Branch> getBranchs() throws DbException {
        List<Branch> branchs = new ArrayList<>();
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement(SqlUtils.GET_BRANCHS);
             ResultSet rs = ps.executeQuery()) {

            // Lặp qua tất cả các kết quả và thêm từng món vào danh sách
            while (rs.next()) {
                branchs.add(mapBranch(rs));
            }
        } catch (SQLException ex) {
            throw new DbException("Cannot get dishes", ex);
        }
        return branchs;
    }
}
