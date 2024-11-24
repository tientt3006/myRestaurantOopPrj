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
import com.nolaneg.myrestaurantprj.util.SqlUtils;
import com.nolaneg.myrestaurantprj.util.Utils;
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
import org.slf4j.LoggerFactory;
@WebServlet("/all_receipt")

public class AllReceipt extends HttpServlet{
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(SqlUtils.class);
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Map<User, ArrayList<Receipt>> Customers = new HashMap<>();
            User user = (User) req.getSession().getAttribute("user");
            ArrayList<User> Users = new ArrayList<>();
            Branch branch = DAO.getDAO().getBranchDAO().getBranch(user.getUserId());
            ArrayList<Integer> UserIds = DAO.getDAO().getUserDAO().getUserIds(branch.getBranchId());
            for(Integer id:UserIds){
                User temp_user = DAO.getDAO().getUserDAO().getUserById(id);
                Users.add(temp_user);
            }
            for(User temp:Users){
                ArrayList<Receipt> receipts = DAO.getDAO().getReceiptDAO().getAllReceiptByUserIdBranchId(temp.getUserId(),branch.getBranchId());
                Customers.put(temp, receipts);
            }
            req.setAttribute("branchName", branch.getLocation());
            req.setAttribute("Customers",Customers);
            req.getRequestDispatcher("/WEB-INF/jsp/all_receipt.jsp").forward(req, resp);
        } catch (DbException ex) {
            log.error(Utils.getErrMessage(ex)); 
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String status = req.getParameter("status");
        String cancel_reser = req.getParameter("cancel_reser");
        int receiptId = Integer.parseInt(String.valueOf(req.getParameter("receipt_id")));
        if(cancel_reser != null && cancel_reser.equals("true")) {
            try {
                Receipt receipt = DAO.getDAO().getReceiptDAO().getReceiptByReceiptId(receiptId);
                if (Utils.canCancelReservation(receipt)) {
                    DAO.getDAO().getReceiptDAO().refundReservation(receiptId);
                    
                    //----------------copy from doget-------------------
                    Map<User, ArrayList<Receipt>> Customers = new HashMap<>();
                    User user = (User) req.getSession().getAttribute("user");
                    ArrayList<User> Users = new ArrayList<>();
                    Branch branch = DAO.getDAO().getBranchDAO().getBranch(user.getUserId());
                    ArrayList<Integer> UserIds = DAO.getDAO().getUserDAO().getUserIds(branch.getBranchId());
                    for(Integer id:UserIds){
                        User temp_user = DAO.getDAO().getUserDAO().getUserById(id);
                        Users.add(temp_user);
                    }
                    for(User temp:Users){
                        ArrayList<Receipt> receipts = DAO.getDAO().getReceiptDAO().getAllReceiptByUserIdBranchId(temp.getUserId(),branch.getBranchId());
                        Customers.put(temp, receipts);
                    }
                    req.setAttribute("branchName", branch.getLocation());
                    req.setAttribute("Customers",Customers);
                    //----------------copy from doget-------------------
                    
                    req.setAttribute("errorMessage", "Refunded.");
                    req.getRequestDispatcher("/WEB-INF/jsp/all_receipt.jsp").forward(req, resp);
                } else {
                    
                    //----------------copy from doget-------------------
                    Map<User, ArrayList<Receipt>> Customers = new HashMap<>();
                    User user = (User) req.getSession().getAttribute("user");
                    ArrayList<User> Users = new ArrayList<>();
                    Branch branch = DAO.getDAO().getBranchDAO().getBranch(user.getUserId());
                    ArrayList<Integer> UserIds = DAO.getDAO().getUserDAO().getUserIds(branch.getBranchId());
                    for(Integer id:UserIds){
                        User temp_user = DAO.getDAO().getUserDAO().getUserById(id);
                        Users.add(temp_user);
                    }
                    for(User temp:Users){
                        ArrayList<Receipt> receipts = DAO.getDAO().getReceiptDAO().getAllReceiptByUserIdBranchId(temp.getUserId(),branch.getBranchId());
                        Customers.put(temp, receipts);
                    }
                    req.setAttribute("branchName", branch.getLocation());
                    req.setAttribute("Customers",Customers);
                    //----------------copy from doget-------------------
                    
                    req.setAttribute("errorMessage", "Cant cancel, not eligible.");
                    req.getRequestDispatcher("/WEB-INF/jsp/all_receipt.jsp").forward(req, resp);
                }
            } catch (DbException e) {
                log.error(Utils.getErrMessage(e)); 
                req.setAttribute("errorMessage", "Something wrong, please try again later.");
                req.getRequestDispatcher("/WEB-INF/jsp/all_receipt.jsp").forward(req, resp);
            }
        }
        if (status != null && !status.isEmpty()){
            try{
                DAO.getDAO().getReceiptDAO().setStatusReceipt(receiptId, status);
                resp.setStatus(HttpServletResponse.SC_OK);
            } catch (DbException e) {
                log.error(Utils.getErrMessage(e)); 
            }
        }
        
    }
}
