/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.nolaneg.myrestaurantprj.web.servlets;
import com.nolaneg.myrestaurantprj.db.InterfaceDAO.DAO;
import com.nolaneg.myrestaurantprj.db.entity.User;
import com.nolaneg.myrestaurantprj.exceptions.AppException;
import com.nolaneg.myrestaurantprj.exceptions.DbException;
import java.util.*;
import java.io.*;
import java.math.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author $_{user}
 */
@WebServlet("/account/login")
public class LoginServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/Login.jsp").forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if ("".equals(username) || "".equals(password)) {
            req.getRequestDispatcher("/WEB-INF/jsp/Login.jsp").forward(req, resp);
            return;
        }
        try {
            User user = DAO.getDAO().getUserDAO().logIn(username, password);
            if (user == null) {
                req.setAttribute("err", "true");
                req.getRequestDispatcher("/WEB-INF/jsp/Login.jsp").forward(req, resp);
            } else {
                req.getSession().setAttribute("user", user);
                 req.getRequestDispatcher("/WEB-INF/jsp/Experiment_login_success.jsp").forward(req, resp);
            }
        } catch (DbException e) {
            throw new AppException(e);
        }
    }
}
