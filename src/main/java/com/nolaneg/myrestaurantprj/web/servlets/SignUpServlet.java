/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.nolaneg.myrestaurantprj.web.servlets;

import com.nolaneg.myrestaurantprj.db.InterfaceDAO.DAO;
import com.nolaneg.myrestaurantprj.db.entity.User;
import com.nolaneg.myrestaurantprj.exceptions.AppException;
import com.nolaneg.myrestaurantprj.exceptions.DbException;
import com.nolaneg.myrestaurantprj.util.SqlUtils;
import com.nolaneg.myrestaurantprj.util.Utils;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(SqlUtils.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/signup.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        User tmpUser = new User.Builder()
                .setFirstName(firstName)
                .setLasttName(lastName)
                //.setPassword(rs.getString(++k))
                .setEmail(email)
                .setPhone(phone)
                .getUser();
        if (firstName == null || firstName.isEmpty() || 
            lastName == null || lastName.isEmpty() || 
            password == null || password.isEmpty() || 
            email == null || email.isEmpty() || 
            phone == null || phone.isEmpty()) {
            
            // Redirect back to signup with an error message if fields are missing
            resp.sendRedirect(req.getContextPath() + "/signup?error=missingFields");
            return;
        }
        try {
            if (!DAO.getDAO().getUserDAO().isLoginUnique(email) || 
                !DAO.getDAO().getUserDAO().isLoginUnique(phone)) {
                resp.sendRedirect(req.getContextPath() + "/signup?error=duplicate");
                return;
            }
            User user = DAO.getDAO().getUserDAO().signUp(tmpUser, password);
            req.getSession().setAttribute("user", user);
            resp.sendRedirect(req.getContextPath() + "/account");
        } catch (DbException e) {
            logger.error(Utils.getErrMessage(e), e);
            throw new AppException(e);
        }
    }
}