package com.nolaneg.myrestaurantprj.web.servlets;

import com.nolaneg.myrestaurantprj.db.InterfaceDAO.DAO;
import com.nolaneg.myrestaurantprj.db.entity.Category;
import com.nolaneg.myrestaurantprj.db.entity.Dish;
import com.nolaneg.myrestaurantprj.db.entity.User;
import com.nolaneg.myrestaurantprj.exceptions.DbException;
import jakarta.annotation.Resource;
import java.io.BufferedReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONArray;
import org.json.JSONObject;


@WebServlet("/select_dish")
public class SelectDishServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Dish> dishes = null;
        try {
            dishes = DAO.getDAO().getDishDAO().getDishes();
            req.setAttribute("dishes", dishes);
            req.getRequestDispatcher("/WEB-INF/jsp/select_dish.jsp").forward(req, resp);    
        } catch (DbException ex) {
            Logger.getLogger(SelectDishServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
//        int receiptId = Integer.parseInt(req.getParameter("receipt_id"));
//        req.setAttribute("receipt_id", receiptId);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     
        StringBuilder jsonString = new StringBuilder();
        String line;

        // Đọc JSON từ body của yêu cầu
        try (BufferedReader reader = req.getReader()) {
            while ((line = reader.readLine()) != null) {
                jsonString.append(line);
            }
        }

        // Chuyển chuỗi JSON thành đối tượng JSONArray
        JSONArray cartArray = new JSONArray(jsonString.toString());

        // Xử lý đơn hàng từ JSONArray
        User user = (User) req.getSession().getAttribute("user");
        String tmp = String.valueOf(req.getParameter("receipt_id"));
        int receiptId = Integer.parseInt(String.valueOf(req.getParameter("receipt_id")));
        float foodCost = 0;
        for (int i = 0; i < cartArray.length(); i++) {
            JSONObject item = cartArray.getJSONObject(i);
            int id = item.getInt("id");
            String name = item.getString("name");
            int price = item.getInt("price");
            int quantity = item.getInt("quantity");
            foodCost += price*quantity;
            try {
                // Xử lý logic của đơn hàng tại đây (ví dụ: lưu vào database)
                DAO.getDAO().getReceiptDAO().addReceiptHasDish(receiptId, id, quantity);
               
            } catch (DbException ex) {
                Logger.getLogger(SelectDishServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            DAO.getDAO().getReceiptDAO().addFoodCost(receiptId, foodCost);
            
        } catch (DbException  ex) {
            Logger.getLogger(SelectDishServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Phản hồi lại client với trạng thái thành công
        resp.setContentType("application/json");
        resp.getWriter().write("{\"status\":\"success\"}");
    
    }
}





