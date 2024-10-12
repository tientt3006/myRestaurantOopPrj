/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.nolaneg.myrestaurantprj.web.servlets;


//import com.nolaneg.myrestaurantprj.db.DAOclasses.*;
import com.nolaneg.myrestaurantprj.db.mysql.*;
import com.nolaneg.myrestaurantprj.db.entity.Experiment_User;
import com.nolaneg.myrestaurantprj.exceptions.*;
import com.nolaneg.myrestaurantprj.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/Experiment_login")
public class Experiment_LoginServlet extends HttpServlet {

    private static final Logger log = LogManager.getLogger(Experiment_LoginServlet.class.getName());
    private Experiment_MySqlUserDao userDAO;

    @Override
    public void init() {
        userDAO = new Experiment_MySqlUserDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/Experiment_login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String login = req.getParameter("login");
        char[] password = req.getParameter("password").toCharArray();
        if (login.isEmpty() || password.length == 0) {
            resp.sendRedirect(req.getContextPath() + "/WEB-INF/jsp/Experiment_login-fail");
            return;
        }
        try {
            Experiment_User user = userDAO.logIn(login, password);
            if (user == null) {
                req.setAttribute("err", "true");
                resp.sendRedirect(req.getContextPath() + "/WEB-INF/jsp/Experiment_login-fail?err=");
            } else {
                req.getSession().setAttribute("user", user);
                resp.sendRedirect(req.getContextPath() + "/WEB-INF/jsp/Experiment_login-success");
            }
        } catch (SQLException e) {
            log.error(Experiment_Utils.getErrMessage(e));
            throw new Experiment_AppException(e);
        }
    }
}


