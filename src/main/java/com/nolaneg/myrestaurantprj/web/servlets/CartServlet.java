/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nolaneg.myrestaurantprj.web.servlets;

import com.nolaneg.myrestaurantprj.db.InterfaceDAO.DAO;
import com.nolaneg.myrestaurantprj.db.entity.Dish;
import com.nolaneg.myrestaurantprj.db.entity.Receipt;
import com.nolaneg.myrestaurantprj.db.entity.User;
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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
@WebServlet("/cart")

public class CartServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        Receipt receipt = null;
        try {
            receipt = DAO.getDAO().getReceiptDAO().getReceiptByUserId(user.getUserId());
        } catch (DbException ex) {
            Logger.getLogger(CartServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        //
        List<Dish> dishes = null;
        try {
            dishes = DAO.getDAO().getDishDAO().getDishByReceiptId(receipt.getReceiptId());
        } catch (DbException ex) {
            Logger.getLogger(CartServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        long foodcost = 0;
        for(Dish x:dishes){
            foodcost += x.getPrice();
        }
        req.setAttribute("id", receipt.getReceiptId());
        req.setAttribute("number_of_table", (int)receipt.getReservationFee()/100000);
        req.setAttribute("date", receipt.getReservationDate());
        req.setAttribute("time", receipt.getReservationTime());
        req.setAttribute("number_of_people", receipt.getNumOfPeople());
        req.setAttribute("deposit", receipt.getReservationFee());
        req.setAttribute("foodcost", foodcost);
        req.setAttribute("totalamount", foodcost+receipt.getReservationFee());
        req.setAttribute("status", receipt.getStatus());
        req.setAttribute("dishes", dishes);
        
        req.getRequestDispatcher("/WEB-INF/jsp/cart.jsp").forward(req, resp);
    }
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        
//    }
}
