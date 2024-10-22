package com.nolaneg.myrestaurantprj.web.servlets;


import com.nolaneg.myrestaurantprj.db.entity.User;
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
        // Fetch the User object from the session
        User user = (User) req.getSession().getAttribute("user");
        
        // If user is not logged in, redirect to login page
        if (user == null) {
            resp.sendRedirect(req.getContextPath() + "/account/login");
            return;
        }

        // Set the user object as a request attribute to be used in JSP
        req.setAttribute("user", user);

        // Forward the request to the JSP page
        req.getRequestDispatcher("/WEB-INF/jsp/account.jsp").forward(req, resp);
    }
}

