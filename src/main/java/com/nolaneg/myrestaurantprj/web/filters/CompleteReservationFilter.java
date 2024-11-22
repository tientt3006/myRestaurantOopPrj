/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.nolaneg.myrestaurantprj.web.filters;
import com.nolaneg.myrestaurantprj.db.InterfaceDAO.DAO;
import com.nolaneg.myrestaurantprj.db.entity.Receipt;
import com.nolaneg.myrestaurantprj.db.entity.User;
import com.nolaneg.myrestaurantprj.exceptions.DbException;
import java.util.*;
import java.io.*;
import java.math.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author $_{user}
 */
@WebFilter({"/complete_reservation", "/select_dish"})
public class CompleteReservationFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        if (req.getSession().getAttribute("user") == null) {
            res.sendRedirect(req.getContextPath() + "/login?message=Please log in to continue.");
            return;
        }
        
        String receiptIdParam = req.getParameter("receipt_id");
        if (receiptIdParam == null || receiptIdParam.isEmpty()) {
            res.sendRedirect(req.getContextPath() + "/find_table?error=empty_receipt_id");
            return;
        }
        int receiptId;
        try {
            receiptId = Integer.parseInt(receiptIdParam);
        } catch (NumberFormatException ex) {
            Logger.getLogger(CompleteReservationFilter.class.getName()).log(Level.SEVERE, null, ex);
            res.sendRedirect(req.getContextPath() + "/find_table?error=wrong_receipt_id");
            return;
        }
        
        User user = (User) req.getSession().getAttribute("user");
        int tmpUserId;
        try {
            tmpUserId = DAO.getDAO().getReceiptDAO().getUserIdByReceiptId(receiptId);
        } catch (DbException ex) {
            Logger.getLogger(CompleteReservationFilter.class.getName()).log(Level.SEVERE, null, ex);
            res.sendRedirect(req.getContextPath() + "/find_table?error=db_error_getUserByReceiptId");
            return;
        }
        if(tmpUserId != user.getUserId()) {
            res.sendRedirect(req.getContextPath() + "/find_table?error=not_match_receipt_id");
            return;
        }
        
        chain.doFilter(req, res);
        
    }
}
