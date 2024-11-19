///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//
//package com.nolaneg.myrestaurantprj.web.servlets;
//import java.util.*;
//import java.io.*;
//import java.math.*;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebServlet("/account/logout")
//public class LogoutServlet extends HttpServlet {
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        // Invalidate the current session
//        req.getSession().invalidate();
//        
//        // Redirect to login page or homepage after logging out
//        resp.sendRedirect(req.getContextPath() + "/login");
//    }
//}
