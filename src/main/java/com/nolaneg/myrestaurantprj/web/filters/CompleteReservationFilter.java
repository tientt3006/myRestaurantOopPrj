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
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author $_{user}
 */
public class CompleteReservationFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
       
        User user = (User) req.getSession().getAttribute("user");
        if (user == null) {
            res.sendRedirect(req.getContextPath() + "/login?message=Please log in to continue.");
            return;
        }
        
        int receiptId = Integer.parseInt(req.getParameter("receipt_id"));
        int tmpUserId;
        try {
            tmpUserId = DAO.getDAO().getReceiptDAO().getUserIdByReceiptId(receiptId);
        } catch (DbException ex) {
            Logger.getLogger(CompleteReservationFilter.class.getName()).log(Level.SEVERE, null, ex);
            res.sendRedirect(req.getContextPath() + "/find_table?error=db_error");
            return;
        }
        if(tmpUserId != user.getUserId()) {
            res.sendRedirect(req.getContextPath() + "/find_table");
            return;
        }
        
        chain.doFilter(req, res);
        
    }
}
