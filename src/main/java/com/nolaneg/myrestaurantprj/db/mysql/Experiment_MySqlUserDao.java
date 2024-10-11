package com.nolaneg.myrestaurantprj.db.mysql;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author $_{user}
 */
import com.nolaneg.myrestaurantprj.db.entity.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Experiment_MySqlUserDao {
    public Experiment_User logIn(String login, char[] password) throws SQLException {
        Experiment_User user = null;
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";

        try (Connection connection = Experiment_ConectionDao.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, login);
            statement.setString(2, new String(password));
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user = new Experiment_User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setEmail(resultSet.getString("email"));
                // Set other fields as needed
            }
        }
        return user;
    }
}
