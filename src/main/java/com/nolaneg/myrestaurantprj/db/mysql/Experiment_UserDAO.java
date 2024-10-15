/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.nolaneg.myrestaurantprj.db.mysql;
// File: Experiment_UserDAO.java
import com.nolaneg.myrestaurantprj.db.entity.Experiment_User;
import java.sql.*;

public class Experiment_UserDAO {
    private Connection connection;

    public Experiment_UserDAO(Connection connection) {
        this.connection = connection;
    }

    public Experiment_User getUserByUsername(String username) {
        Experiment_User user = null;
        String query = "SELECT * FROM experiment_user WHERE username = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    user = new Experiment_User(rs.getInt("id"), rs.getString("username"), rs.getString("password_hash"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
