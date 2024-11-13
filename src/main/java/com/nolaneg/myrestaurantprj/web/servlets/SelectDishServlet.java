package com.nolaneg.myrestaurantprj.web.servlets;

import com.nolaneg.myrestaurantprj.db.entity.Dish;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/select_dish")
public class SelectDishServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Tạo đối tượng Dish bằng Builder
        Dish dish = new Dish.Builder()

        
        // Truyền đối tượng Dish vào request
        request.setAttribute("dish", dish);
        
        // Forward đến JSP để hiển thị thông tin
        request.getRequestDispatcher("/WEB-INF/jsp/select_dish.jsp").forward(request, response);
    }
}





