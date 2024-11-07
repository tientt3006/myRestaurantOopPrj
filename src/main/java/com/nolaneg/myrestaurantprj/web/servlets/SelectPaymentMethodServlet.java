/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.nolaneg.myrestaurantprj.web.servlets;
import com.nolaneg.myrestaurantprj.db.InterfaceDAO.DAO;
import com.nolaneg.myrestaurantprj.db.entity.Branch;
import com.nolaneg.myrestaurantprj.db.entity.Category;
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
import javax.sql.DataSource;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import org.slf4j.LoggerFactory;

/**
 *
 * @author $_{user}
 */
@WebServlet("/select_payment_method")
public class SelectPaymentMethodServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String branchName = req.getParameter("branchName");
        String date = req.getParameter("date");
        String time = req.getParameter("time");
        int numOfPeople = Integer.parseInt(req.getParameter("people"));
        int numOfTables = Integer.parseInt(req.getParameter("tables"));

        req.setAttribute("reservationBranchName", branchName);
        req.setAttribute("reservationDate", date);
        req.setAttribute("reservationTime", time);
        req.setAttribute("numberOfPeople", numOfPeople);
        req.setAttribute("selectedTableNumber", numOfTables);
        
        req.getRequestDispatcher("/WEB-INF/jsp/select_payment_method.jsp").forward(req, resp);
        
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
       
        String branchName = req.getParameter("branchName");
        String date = req.getParameter("date");
        String time = req.getParameter("time");
        int numOfPeople = Integer.parseInt(req.getParameter("people"));
        int numOfTables = Integer.parseInt(req.getParameter("tables"));

        // Lưu thông tin vào session
        String redirectUrl = String.format("%s/complete_reservation?branchName=%s&date=%s&time=%s&people=%d&tables=%d",
            req.getContextPath(), branchName, date, time, numOfPeople, numOfTables
        );
        resp.sendRedirect(redirectUrl);
    }
}
