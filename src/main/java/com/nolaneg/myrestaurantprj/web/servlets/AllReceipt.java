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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
//        if(req.getParameter("search_name") == null || req.getParameter("search_name").isEmpty()){
//            AllReceipt.getCustomerByDayAndBranch(req);
//        } else {
//            String searchName =req.getParameter("search_name");
//            AllReceipt.getCustomerByNameAndDayAndBranch(req, searchName);
//        }
        AllReceipt.getCustomers(req);
        req.getRequestDispatcher("/WEB-INF/jsp/all_receipt.jsp").forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String status = req.getParameter("status");
        String cancel_reser = req.getParameter("cancel_reser");
        int receiptId = Integer.parseInt(String.valueOf(req.getParameter("receipt_id")));
        // cancel reservation handle
        if(cancel_reser != null && cancel_reser.equals("true")) {
            try {
                Receipt receipt = DAO.getDAO().getReceiptDAO().getReceiptByReceiptId(receiptId);
                if (Utils.canCancelReservation(receipt)) {
                    DAO.getDAO().getReceiptDAO().refundReservation(receiptId);
                    AllReceipt.getCustomers(req);
                    req.setAttribute("errorMessage", "Refunded.");
                    req.getRequestDispatcher("/WEB-INF/jsp/all_receipt.jsp").forward(req, resp);
                } else {
                    AllReceipt.getCustomers(req);
                    req.setAttribute("errorMessage", "Cant cancel, not eligible.");
                    req.getRequestDispatcher("/WEB-INF/jsp/all_receipt.jsp").forward(req, resp);
                }
            } catch (DbException e) {
                log.error(Utils.getErrMessage(e)); 
                req.setAttribute("errorMessage", "Something wrong, please try again later.");
                req.getRequestDispatcher("/WEB-INF/jsp/all_receipt.jsp").forward(req, resp);
            }
        }
        // change status handle
        else if (status != null && !status.isEmpty()){
            try{
                DAO.getDAO().getReceiptDAO().setStatusReceipt(receiptId, status);
                resp.setStatus(HttpServletResponse.SC_OK);
            } catch (DbException e) {
                log.error(Utils.getErrMessage(e)); 
            }
        }
        
    }
    
    private static void getCustomerByDayAndBranch(HttpServletRequest req) {
        try {
            Map<User, ArrayList<Receipt>> Customers = new HashMap<>();
            User user = (User) req.getSession().getAttribute("user");
            Branch branch = DAO.getDAO().getBranchDAO().getBranch(user.getUserId());
            
            ArrayList<Integer> userIdsByBranchId = DAO.getDAO().getReceiptDAO().getUserIdsByBranchId(branch.getBranchId());
            
            String todayString = (String) req.getAttribute("today");
            LocalDate todayLocalDate = LocalDate.parse(todayString);
            String today = todayLocalDate.format(DateTimeFormatter.ISO_DATE);
            
            for(Integer id : userIdsByBranchId){
                User temp_user = DAO.getDAO().getUserDAO().getUserById(id);
                ArrayList<Receipt> receipts = DAO.getDAO().getReceiptDAO().getAllReceiptByUserIdBranchIdToday(temp_user.getUserId(),branch.getBranchId(), today);
                if(receipts.size() >= 1){
                    Customers.put(temp_user, receipts);
                }
            }
            
            req.setAttribute("branchName", branch.getLocation());
            req.setAttribute("Customers",Customers);
            
        } catch (DbException ex) {
            log.error(Utils.getErrMessage(ex)); 
            req.setAttribute("errorMessage", "Unable to fetch data. Please try again later.");
        }
    }
    
    private static void getCustomerByNameAndDayAndBranch(HttpServletRequest req, String searchName) {
        try {
            Map<User, ArrayList<Receipt>> Customers = new HashMap<>();
            User user = (User) req.getSession().getAttribute("user");
            Branch branch = DAO.getDAO().getBranchDAO().getBranch(user.getUserId());
            
            ArrayList<Integer> userIdsByBranchId = DAO.getDAO().getReceiptDAO().getUserIdsByBranchId(branch.getBranchId());
            ArrayList<Integer> userIdsBySearchName = DAO.getDAO().getUserDAO().getUserIdsBySearchName(searchName);
            ArrayList<Integer> userIdsIntersection = new ArrayList<>(userIdsByBranchId);
            userIdsIntersection.retainAll(userIdsBySearchName);
            
            String todayString = (String) req.getAttribute("today");
            LocalDate todayLocalDate = LocalDate.parse(todayString);
            String today = todayLocalDate.format(DateTimeFormatter.ISO_DATE);
            
            for(Integer id : userIdsIntersection){
                User temp_user = DAO.getDAO().getUserDAO().getUserById(id);
                ArrayList<Receipt> receipts = DAO.getDAO().getReceiptDAO().getAllReceiptByUserIdBranchIdToday(temp_user.getUserId(),branch.getBranchId(), today);
                if(receipts.size() >= 1){
                    Customers.put(temp_user, receipts);
                }
            }
            
            req.setAttribute("branchName", branch.getLocation());
            req.setAttribute("Customers",Customers);
            
        } catch (DbException ex) {
            log.error(Utils.getErrMessage(ex)); 
            req.setAttribute("errorMessage", "Unable to fetch data. Please try again later.");
        }
    }
    
    private static void getCustomerByNameAndBranch(HttpServletRequest req, String searchName) {
        try {
            Map<User, ArrayList<Receipt>> Customers = new HashMap<>();
            User user = (User) req.getSession().getAttribute("user");
            Branch branch = DAO.getDAO().getBranchDAO().getBranch(user.getUserId());
            
            ArrayList<Integer> userIdsByBranchId = DAO.getDAO().getReceiptDAO().getUserIdsByBranchId(branch.getBranchId());
            ArrayList<Integer> userIdsBySearchName = DAO.getDAO().getUserDAO().getUserIdsBySearchName(searchName);
            ArrayList<Integer> userIdsIntersection = new ArrayList<>(userIdsByBranchId);
            userIdsIntersection.retainAll(userIdsBySearchName);

            for(Integer id : userIdsIntersection){
                User temp_user = DAO.getDAO().getUserDAO().getUserById(id);
                ArrayList<Receipt> receipts = DAO.getDAO().getReceiptDAO().getAllReceiptByUserIdBranchIdSearchName(temp_user.getUserId(),branch.getBranchId());
                if(receipts.size() >= 1){
                    Customers.put(temp_user, receipts);
                }
            }
            
            req.setAttribute("branchName", branch.getLocation());
            req.setAttribute("Customers",Customers);
            
        } catch (DbException ex) {
            log.error(Utils.getErrMessage(ex)); 
            req.setAttribute("errorMessage", "Unable to fetch data. Please try again later.");
        }
    }
    
    private static void getCustomers(HttpServletRequest req) {
        // TH ngay trong, ten khong trong, chi filter theo ten 
        if((req.getParameter("today") == null || req.getParameter("today").isEmpty())
            && (req.getParameter("search_name") != null && !req.getParameter("search_name").isEmpty())){
            String searchName =req.getParameter("search_name");
            AllReceipt.getCustomerByNameAndBranch(req, searchName);
        } 
        // TH ngay trong, ten trong, chi filter theo ngay
        else if((req.getParameter("today") == null || req.getParameter("today").isEmpty())
                && (req.getParameter("search_name") == null || req.getParameter("search_name").isEmpty())){
            AllReceipt.getCustomerByDayAndBranch(req);
        } 
        // TH ngay khong trong, filter theo ca ngay va ten
        else {
            String searchName =req.getParameter("search_name");
            AllReceipt.getCustomerByNameAndDayAndBranch(req, searchName);
        }
    }
}
