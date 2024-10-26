package com.nolaneg.myrestaurantprj.web.servlets;

import com.nolaneg.myrestaurantprj.db.InterfaceDAO.DAO;
import com.nolaneg.myrestaurantprj.db.entity.User;
import com.nolaneg.myrestaurantprj.exceptions.AppException;
import com.nolaneg.myrestaurantprj.exceptions.DbException;
import com.nolaneg.myrestaurantprj.util.SqlUtils;
import com.nolaneg.myrestaurantprj.util.Utils;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author $_{user}
 */
@WebServlet("/account/change_password")
public class ChangePasswordServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(SqlUtils.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User currentUser = (User) req.getSession().getAttribute("user");
        if (currentUser == null) {
            req.getRequestDispatcher("/WEB-INF/jsp/home.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/WEB-INF/jsp/change_password.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String newPassword = req.getParameter("newPassword");
        String oldPassword = req.getParameter("oldPassword");
        User currentUser = (User) req.getSession().getAttribute("user");
        
        if (currentUser == null) {
            req.setAttribute("sessionExpired", "true");  // Đặt một cờ để thông báo session hết hạn
            req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);  // Chuyển hướng đến trang đăng nhập
            return;
        }
        
        try {
            User user = DAO.getDAO().getUserDAO().logIn(currentUser.getEmail(), oldPassword);
            if (user == null) {
                req.setAttribute("err", "true");
                req.getRequestDispatcher("/WEB-INF/jsp/change_password.jsp").forward(req, resp);
            } else {
                DAO.getDAO().getUserDAO().changePassword(user.getUserId(), newPassword);
                resp.sendRedirect(req.getContextPath() + "/account");
            }
        } catch (DbException e) {
            log.error(Utils.getErrMessage(e));
            throw new AppException(e);
        } catch (ServletException e) {
            log.error("Servlet error: " + e.getMessage());
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An internal error occurred.");
        }
    }
}
