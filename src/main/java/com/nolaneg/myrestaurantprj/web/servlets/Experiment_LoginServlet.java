/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.nolaneg.myrestaurantprj.web.servlets;




import com.nolaneg.myrestaurantprj.db.mysql.Experiment_UserDAO;
import com.nolaneg.myrestaurantprj.db.entity.Experiment_User;
import com.nolaneg.myrestaurantprj.util.Experiment_Utils;

import jakarta.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@WebServlet("/LoginServlet")
public class Experiment_LoginServlet extends HttpServlet {
    @Resource(name = "jdbc/experiment_db")
    private DataSource dataSource;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // Chuyển hướng người dùng đến trang đăng nhập khi yêu cầu là GET
        request.getRequestDispatcher("/WEB-INF/jsp/Experiment_login.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try (var connection = dataSource.getConnection()) {
            Experiment_Utils dbUtil = new Experiment_Utils(dataSource);
            if (dbUtil.testConnection()) {
                System.out.println("Database connection is valid.");
            } else {
                System.out.println("Database connection is invalid.");
            }
            
            Experiment_UserDAO userDAO = new Experiment_UserDAO(connection);
            Experiment_User user = userDAO.getUserByUsername(username);

            if (user != null && user.getPasswordHash().equals(hashPassword(password))) {
                request.setAttribute("username", username);
                request.getRequestDispatcher("/WEB-INF/jsp/Experiment_login_success.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("/WEB-INF/jsp/Experiment_login_fail.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.getRequestDispatcher("/WEB-INF/jsp/Experiment_login_fail.jsp").forward(request, response);
        }
    }

    

    private String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = md.digest(password.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b : hashBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

}