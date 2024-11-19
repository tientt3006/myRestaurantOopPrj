/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.nolaneg.myrestaurantprj.web.filters;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.FilterChain;

import com.nolaneg.myrestaurantprj.db.entity.User;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author admin
 */
@WebFilter({"/select_payment_method"})
public class SelectPaymentMethodFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String numOfTables = req.getParameter("tables");
        String numOfPeople = req.getParameter("people");
        String date = req.getParameter("date");
        String time = req.getParameter("time");
        String branchId = req.getParameter("branchId");
        
        if (numOfTables == null || numOfTables.isEmpty()
                || numOfPeople == null || numOfPeople.isEmpty()
                || date == null || date.isEmpty()
                || time == null || time.isEmpty()
                || branchId == null || branchId.isEmpty()) {
            res.sendRedirect(req.getContextPath() + "/find_table");
            return;
        }
        
        chain.doFilter(req, res);
        
    }
}