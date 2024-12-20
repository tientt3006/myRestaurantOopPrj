/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nolaneg.myrestaurantprj.web.servlets;

import com.nolaneg.myrestaurantprj.db.InterfaceDAO.DAO;
import com.nolaneg.myrestaurantprj.db.entity.Category;
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
import javax.servlet.http.HttpSession;
@WebServlet("/menu")

public class MenuServlet extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int category = Integer.parseInt(req.getParameter("category"));
        int page = Integer.parseInt(req.getParameter("page"));
        int dishesInPage = Integer.parseInt(req.getParameter("dishesInPage"));
        String sortBy = req.getParameter("sortBy");
        HttpSession session = req.getSession();
        try {
            if (session.getAttribute("categories") == null) {
                List<Category> categories = DAO.getDAO().getCategoryDAO().getAllCategories();
                session.setAttribute("categories", categories);
            }
            
            List<Dish> dishes;
            int totalPages;
            if (category == 0) {
                dishes = DAO.getDAO().getDishDAO().getSortedDishesOnPage(sortBy, dishesInPage, page);
                totalPages = DAO.getDAO().getDishDAO().getDishesNumber();
            } else {
                dishes = DAO.getDAO().getDishDAO().getSortedDishesFromCategoryOnPage(category, sortBy, dishesInPage, page);
                totalPages = DAO.getDAO().getDishDAO().getDishesNumberInCategory(category);
            }
            totalPages = (int) Math.ceil((double) totalPages / dishesInPage) - 1;

            req.setAttribute("totalPages", totalPages);
            req.setAttribute("dishes", dishes);
            req.getRequestDispatcher("/WEB-INF/jsp/menu.jsp").forward(req, resp);  
        }
        catch (DbException ex) {
            Logger.getLogger(MenuServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
