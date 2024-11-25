/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.nolaneg.myrestaurantprj.web.filters;
import com.nolaneg.myrestaurantprj.db.entity.User;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
@WebFilter({"/all_receipt"})
public class AllReceiptFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        User user = (User) req.getSession().getAttribute("user");
        if (user == null) {
            res.sendRedirect(req.getContextPath() + "/login?message=Please log in to continue.");
            return;
        }
        if (user.getRoleId() < 2){
            req.getRequestDispatcher("/WEB-INF/jsp/error404.jsp").forward(req, res);
            return;
        }
       
        // TH ngay trong, ten khong trong, chi filter theo ten 
        if((req.getParameter("today") == null || req.getParameter("today").isEmpty())
            && (req.getParameter("search_name") != null && !req.getParameter("search_name").isEmpty())){
            req.setAttribute("today", "");
        } 
        // TH ngay trong, ten trong, chi filter theo ngay
        else if((req.getParameter("today") == null || req.getParameter("today").isEmpty())
            && (req.getParameter("search_name") == null || req.getParameter("search_name").isEmpty())){
            LocalDate today = LocalDate.now();
            String todayFormatted = today.format(DateTimeFormatter.ISO_DATE); // yyyy-MM-dd format
            req.setAttribute("today", todayFormatted);
        } 
        // TH ngay khong trong, filter theo ca ngay va ten
        else {
            LocalDate today = LocalDate.parse(req.getParameter("today"));
            String todayFormatted = today.format(DateTimeFormatter.ISO_DATE); // yyyy-MM-dd format
            req.setAttribute("today", todayFormatted);
        }
        chain.doFilter(req, res);
        
    }
}