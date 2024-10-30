/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.nolaneg.myrestaurantprj.web.filters;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
@WebFilter({"/","/menu"})
public class MenuFilter extends HttpFilter {
    protected void doFilter(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        int category = req.getIntHeader("category");
        String sort = req.getParameter("sort");
        if (category == 0 || sort == null) {
            res.sendRedirect(req.getContextPath() + "/menu?category=0&sort=categoryId&page=0&dishesOnPage=5");
        }
    }
}
