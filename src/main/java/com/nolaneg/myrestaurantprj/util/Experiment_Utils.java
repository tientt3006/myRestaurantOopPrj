/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.nolaneg.myrestaurantprj.util;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Experiment_Utils {
    private DataSource dataSource;

    public Experiment_Utils(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public boolean testConnection() {
        try (Connection connection = dataSource.getConnection()) {
            return connection != null && !connection.isClosed();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
