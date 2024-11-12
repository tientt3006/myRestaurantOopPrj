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

@WebServlet("/account/change_info")

public class ChangeInfoServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(SqlUtils.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User currentUser = (User) req.getSession().getAttribute("user");
        if (currentUser == null) {
            req.getRequestDispatcher("/WEB-INF/jsp/home.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/WEB-INF/jsp/change_info.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        
        User currentUser = (User) req.getSession().getAttribute("user");
        
        if (currentUser == null) {
            req.setAttribute("sessionExpired", "true");  // Đặt một cờ để thông báo session hết hạn
            req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);  // Chuyển hướng đến trang đăng nhập
            return;
        }
        try {
            if( (currentUser.getPhone().equals(phone) && !currentUser.getEmail().equals(email) && DAO.getDAO().getUserDAO().isLoginUnique(email))
                 || (currentUser.getEmail().equals(email) && !currentUser.getPhone().equals(phone) && DAO.getDAO().getUserDAO().isLoginUnique(phone))
                 || (currentUser.getEmail().equals(email) && currentUser.getPhone().equals(phone))
                 || (!currentUser.getEmail().equals(email) && !currentUser.getPhone().equals(phone) && DAO.getDAO().getUserDAO().isLoginUnique(email) && DAO.getDAO().getUserDAO().isLoginUnique(phone))) {
                
                DAO.getDAO().getUserDAO().changeInfo(currentUser.getUserId(), firstName, lastName, email, phone);
                currentUser = new User.Builder()
                    .setUserId(currentUser.getUserId())
                    .setFirstName(firstName)
                    .setLasttName(lastName)
                    //.setPassword(rs.getString(++k))
                    .setEmail(email)
                    .setPhone(phone)
                    .setRoleId(currentUser.getRoleId())
                    .setCreateDate(currentUser.getCreateDate())
                    .getUser();
                req.getSession().setAttribute("user", currentUser);
                resp.sendRedirect(req.getContextPath() + "/account");
            }else {
                resp.sendRedirect(req.getContextPath() + "/account/change_info?error=duplicate");
            }
        } catch (DbException e) {
            log.error(Utils.getErrMessage(e)); 
            throw new AppException(e);
        }
    }
}
