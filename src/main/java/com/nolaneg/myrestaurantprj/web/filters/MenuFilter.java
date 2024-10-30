/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
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
@WebFilter({"/","/menu"})
public class MenuFilter extends HttpFilter {
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        int category = req.getIntHeader("category");
        String sort = req.getParameter("sort");
        if (category == 0 || sort == null) {
            res.sendRedirect(req.getContextPath() + "/menu?category=0&sort=categoryId&page=0&dishesOnPage=5");
        }else {
            chain.doFilter(req, res);
        }
    }
}
