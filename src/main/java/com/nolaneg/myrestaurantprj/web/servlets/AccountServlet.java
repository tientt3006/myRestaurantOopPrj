package com.nolaneg.myrestaurantprj.web.servlets;


import com.nolaneg.myrestaurantprj.db.entity.User;
import com.nolaneg.myrestaurantprj.util.Utils;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/account")
public class AccountServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("logout") != null) {
            Utils.logout(req, resp);
            return;
        }
        req.getRequestDispatcher("/WEB-INF/jsp/account.jsp").forward(req, resp);
    }
}

