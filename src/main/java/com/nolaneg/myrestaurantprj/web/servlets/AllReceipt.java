/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nolaneg.myrestaurantprj.web.servlets;

import com.nolaneg.myrestaurantprj.db.InterfaceDAO.DAO;
import com.nolaneg.myrestaurantprj.db.entity.Branch;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
@WebServlet("/all_receipt")

public class AllReceipt extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<User, ArrayList<Receipt>> Customers = new HashMap<>();
        User user = (User) req.getSession().getAttribute("user");
        Branch branch = null;
        try {
            branch = DAO.getDAO().getBranchDAO().getBranch(user.getUserId());
        } catch (DbException ex) {
            Logger.getLogger(AllReceipt.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<Integer> UserIds = new ArrayList<>();
        try {
            UserIds = DAO.getDAO().getUserDAO().getUserIds(branch.getBranchId());
        } catch (DbException ex) {
            Logger.getLogger(AllReceipt.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<User> Users = new ArrayList<>();
        for(Integer id:UserIds){
            User temp_user = null;
            try {
                temp_user = DAO.getDAO().getUserDAO().getUserById(id);
                Users.add(temp_user);
            } catch (DbException ex) {
                Logger.getLogger(AllReceipt.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        for(User temp:Users){
            ArrayList<Receipt> receipts = new ArrayList<>();
            try {
                receipts = DAO.getDAO().getReceiptDAO().getAllReceiptByUserIdBranchId(temp.getUserId(),branch.getBranchId());
            } catch (DbException ex) {
                Logger.getLogger(AllReceipt.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Customers.put(temp, receipts);
        }
        
        req.setAttribute("branchName", branch.getLocation());
//        req.setAttribute("Users", Users);
        req.setAttribute("Customers",Customers);
        req.getRequestDispatcher("/WEB-INF/jsp/all_receipt.jsp").forward(req, resp);
    }
}
