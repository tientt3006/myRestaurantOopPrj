/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nolaneg.myrestaurantprj.web.servlets;

import com.nolaneg.myrestaurantprj.db.InterfaceDAO.DAO;
import com.nolaneg.myrestaurantprj.db.entity.Dish;
import com.nolaneg.myrestaurantprj.exceptions.DbException;
import jakarta.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;
@WebServlet("/menu")

public class MenuServlet extends HttpServlet{
    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
//        Dish dish = null;
//        try {
//            dish = DAO.getDAO().getDishDAO().getDish();
//        } catch (DbException ex) {
//            Logger.getLogger(MenuServlet.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        req.setAttribute("dish", dish);
//        req.getRequestDispatcher("/WEB-INF/jsp/menu.jsp").forward(req, response);
//    }
    
    protected void doGet(HttpServletRequest req, HttpServletResponse response) 
            throws ServletException, IOException {

        // Giả sử chúng ta có tổng cộng 32 món ăn
        
        // Giả lập danh sách món ăn
        
        List<Dish> dishes = null;
        try {
            dishes = DAO.getDAO().getDishDAO().getDishes();
            int totalItems = dishes.size(); 
            int itemsPerPage = 8;

            // Tính số trang
            int totalPages = (int) Math.ceil((double) totalItems / itemsPerPage);

            // Lấy trang hiện tại từ request
    //        String pageParam = "2";
            String pageParam = req.getParameter("page");
            int currentPage = (pageParam != null) ? Integer.parseInt(pageParam) : 1;

            // Xác định phạm vi món ăn cần hiển thị
            int startItem = (currentPage - 1) * itemsPerPage;
            int endItem = Math.min(startItem + itemsPerPage, totalItems);
    
            
//        for (int i = 1; i <= totalItems; i++) {
//            try {
//                dishes.add(DAO.getDAO().getDishDAO().getDishes());
//            } catch (DbException ex) {
//                Logger.getLogger(MenuServlet.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
            List<Dish> currentDishes = dishes.subList(startItem, endItem);

            // Truyền dữ liệu sang JSP
            req.setAttribute("dishes", currentDishes);
            req.setAttribute("currentPage", currentPage);
            req.setAttribute("totalPages", totalPages);

            req.getRequestDispatcher("/WEB-INF/jsp/menu.jsp").forward(req, response);
        }
        catch (DbException ex) {
            Logger.getLogger(MenuServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Lấy danh sách món ăn cho trang hiện tại
        
    }
}
