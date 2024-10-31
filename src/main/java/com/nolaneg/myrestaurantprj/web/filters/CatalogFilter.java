///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//
//package com.nolaneg.myrestaurantprj.web.filters;
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
// * Redirect access to / or /catalog to /catalog page with parameters
// */
//@WebFilter({"/", "/catalog"})
//public class CatalogFilter extends HttpFilter {
//
//    @Override
//    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
//        String category = req.getParameter("category");
//        String sortBy = req.getParameter("sortBy");
//        User user = (User) req.getSession().getAttribute("user");
//        if (category == null || sortBy == null) {
//            res.sendRedirect(req.getContextPath() + "/catalog?category=0&sortBy=category_id&page=0&dishesOnPage=5");
//        } else {
//            chain.doFilter(req, res);
//        }
//    }
//}