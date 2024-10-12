/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.nolaneg.myrestaurantprj.web.servlets;
import com.nolaneg.myrestaurantprj.db.DAOclasses.*;
import com.nolaneg.myrestaurantprj.db.entity.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/Experiment_register")
public class Experiment_UserServlet extends HttpServlet {
    private Experiment_UserDAO userDAO;

    public void init() {
        userDAO = new Experiment_UserDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        Experiment_User newUser = new Experiment_User();
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setEmail(email);

        try {
            userDAO.insertUser(newUser);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("user-list.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Experiment_register.jsp");
        dispatcher.forward(request, response);
    }
}
