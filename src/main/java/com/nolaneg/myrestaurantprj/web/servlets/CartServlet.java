/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nolaneg.myrestaurantprj.web.servlets;

import com.nolaneg.myrestaurantprj.db.InterfaceDAO.DAO;
import com.nolaneg.myrestaurantprj.db.entity.Dish;
import com.nolaneg.myrestaurantprj.db.entity.Receipt;
import com.nolaneg.myrestaurantprj.db.entity.User;
import com.nolaneg.myrestaurantprj.exceptions.AppException;
import com.nolaneg.myrestaurantprj.exceptions.DbException;
import com.nolaneg.myrestaurantprj.util.SqlUtils;
import com.nolaneg.myrestaurantprj.util.Utils;
import com.nolaneg.myrestaurantprj.util.Utils.*;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.slf4j.LoggerFactory;
@WebServlet("/cart")

public class CartServlet extends HttpServlet{
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(SqlUtils.class);
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        try {
//            // Tạm dừng 3 giây (3000 milliseconds)
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            // Xử lý ngoại lệ nếu luồng bị gián đoạn
//            System.err.println("Sleep interrupted: " + e.getMessage());
//        }
        
        User user = (User) req.getSession().getAttribute("user");
        ArrayList<Receipt> receipts = null;
        try {
            receipts = DAO.getDAO().getReceiptDAO().getAllReceiptByUserId(user.getUserId());
        } catch (DbException ex) {
            log.error(Utils.getErrMessage(ex));
        }
        req.setAttribute("receipts", receipts);
        req.getRequestDispatcher("/WEB-INF/jsp/cart.jsp").forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        
        int receiptId = Integer.parseInt(String.valueOf(req.getParameter("receipt_id")));
        try {
            Receipt receipt = DAO.getDAO().getReceiptDAO().getReceiptByReceiptId(receiptId);
            if (Utils.canCancelReservation(receipt)) {
                DAO.getDAO().getReceiptDAO().refundReservation(receiptId);
                //copy from doget
                User user = (User) req.getSession().getAttribute("user");
                ArrayList<Receipt> receipts = DAO.getDAO().getReceiptDAO().getAllReceiptByUserId(user.getUserId());
                req.setAttribute("receipts", receipts);
                //
                req.setAttribute("errorMessage", "Refunded.");
                req.getRequestDispatcher("/WEB-INF/jsp/cart.jsp").forward(req, resp);
            } else {
                //copy from doget
                User user = (User) req.getSession().getAttribute("user");
                ArrayList<Receipt> receipts = DAO.getDAO().getReceiptDAO().getAllReceiptByUserId(user.getUserId());
                req.setAttribute("receipts", receipts);
                //
                req.setAttribute("errorMessage", "Cant cancel, not eligible.");
                req.getRequestDispatcher("/WEB-INF/jsp/cart.jsp").forward(req, resp);
            }
        } catch (DbException e) {
            log.error(Utils.getErrMessage(e)); 
            req.setAttribute("errorMessage", "Something wrong, please try again later.");
            req.getRequestDispatcher("/WEB-INF/jsp/cart.jsp").forward(req, resp);
        }
        
    }
}
