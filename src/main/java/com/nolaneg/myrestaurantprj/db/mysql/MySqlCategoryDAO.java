/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.nolaneg.myrestaurantprj.db.mysql;
import com.nolaneg.myrestaurantprj.db.InterfaceDAO.CategoryDAO;
import com.nolaneg.myrestaurantprj.db.entity.Category;
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
public class MySqlCategoryDAO implements CategoryDAO {

    private static Category mapCategory(ResultSet rs) throws SQLException {
        return new Category.Builder()
                .setCategoryId(rs.getInt("categoryId"))
                .setCategoryName(rs.getString("categoryName"))
                .getCategory();
    }

    @Override
    public List<Category> getAllCategories() throws DbException {
        List<Category> categories = new ArrayList<>();
        try (Connection c = ConnectionPool.getInstance().getConnection();
             PreparedStatement ps = c.prepareStatement(SqlUtils.GET_ALL_CATEGORIES);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                categories.add(mapCategory(rs));
            }
            return categories;
        } catch (SQLException e) {
            throw new DbException("Cannot getAllCategories", e);
        }
    }
}