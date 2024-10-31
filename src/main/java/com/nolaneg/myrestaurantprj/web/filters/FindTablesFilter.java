//package com.nolaneg.myrestaurantprj.web.filters;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import javax.servlet.FilterChain;
//
//import com.nolaneg.myrestaurantprj.db.entity.User;
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// *
// * @author admin
// */
//@WebFilter({"/","/menu"})
//public class FindTablesFilter extends HttpFilter {
//    @Override
//    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
//        String category = req.getParameter("category");
//        String sortBy = req.getParameter("sortBy");
////        User user = (User) req.getSession().getAttribute("user");
////        if (user != null && user.getRoleId() == 2) {
////            res.sendRedirect(req.getContextPath() + "/users");
////            return;
////        }
//        if (category == null || sortBy == null) {
//            res.sendRedirect(req.getContextPath() + "/menu?category=0&sortBy=categoryId&page=0&dishesInPage=8");
//        } else {
//            chain.doFilter(req, res);
//        }
//    }
//}