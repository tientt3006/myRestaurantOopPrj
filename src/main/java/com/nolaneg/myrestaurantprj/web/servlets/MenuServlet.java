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
    
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        
//    }
//    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

        List<Dish> dishes = null;
        try {
            dishes = DAO.getDAO().getDishDAO().getDishes();
            int totalItems = dishes.size(); 
            int itemsPerPage = 8;

            // Tính số trang
            int totalPages = (int) Math.ceil((double) totalItems / itemsPerPage);

            // Lấy trang hiện tại từ request
            String pageParam = req.getParameter("page");
            int currentPage = (pageParam != null) ? Integer.parseInt(pageParam) : 1;

            // Xác định phạm vi món ăn cần hiển thị
            int startItem = (currentPage - 1) * itemsPerPage;
            int endItem = Math.min(startItem + itemsPerPage, totalItems);
          
            List<Dish> currentDishes = dishes.subList(startItem, endItem);
            
//            int category = Integer.parseInt(req.getParameter("category")); 
//            String sort = req.getParameter("sort"); 
//
//            // Giả sử bạn có sẵn một danh sách món ăn
//            List<Dish> filteredDishes = new ArrayList<>();
//
//            // Lọc theo category nếu có
//            for (Dish dish : dishes) {
//                if (dish.getCategoryId()==category) {
//                    filteredDishes.add(dish);
//                } else {
//                }
//            }
//
//            // Sắp xếp theo giá nếu cần
//            if ("price-asc".equals(sort)) {
//                filteredDishes.sort(Comparator.comparing(Dish::getPrice));
//            } else if ("price-desc".equals(sort)) {
//                filteredDishes.sort(Comparator.comparing(Dish::getPrice).reversed());
//            }
//
//            // Đưa danh sách đã lọc vào request để hiển thị
//            req.setAttribute("dishes", filteredDishes);
            
            // Truyền dữ liệu sang JSP
            req.setAttribute("dishes", currentDishes);
            req.setAttribute("currentPage", currentPage);
            req.setAttribute("totalPages", totalPages);
            
            
            
//            
            req.getRequestDispatcher("/WEB-INF/jsp/menu.jsp").forward(req, response);

            
        }
        catch (DbException ex) {
            Logger.getLogger(MenuServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
