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
@WebFilter({"/find_table", "/account/change_password", "/account/change_info"})
public class FindTablesFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        if (req.getSession().getAttribute("user") == null) {
            res.sendRedirect(req.getContextPath() + "/login?message=Please log in to continue.");
        } else {
            chain.doFilter(req, res);
        }
        
    }
}