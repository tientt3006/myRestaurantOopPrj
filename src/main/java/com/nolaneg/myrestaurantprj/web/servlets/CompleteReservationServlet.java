/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.nolaneg.myrestaurantprj.web.servlets;
import com.nolaneg.myrestaurantprj.db.InterfaceDAO.DAO;
import com.nolaneg.myrestaurantprj.db.entity.Receipt;
import com.nolaneg.myrestaurantprj.exceptions.DbException;
import com.nolaneg.myrestaurantprj.web.filters.CompleteReservationFilter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author $_{user}
 */
@WebServlet("/complete_reservation")
public class CompleteReservationServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int receiptId = Integer.parseInt(req.getParameter("receipt_id"));
        Receipt receipt;
        try {
            receipt = DAO.getDAO().getReceiptDAO().getReceiptByReceiptId(receiptId);
        } catch (DbException ex) {
            Logger.getLogger(CompleteReservationFilter.class.getName()).log(Level.SEVERE, null, ex);
            resp.sendRedirect(req.getContextPath() + "/find_table?error=db_error");
            return;
        }
        req.setAttribute("receipt", receipt);
        req.getRequestDispatcher("/WEB-INF/jsp/complete_reservation.jsp").forward(req, resp);
        
    }
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        int receiptId = Integer.parseInt(req.getParameter("receipt_id"));
//        Receipt receipt;
//        try {
//            receipt = DAO.getDAO().getReceiptDAO().getReceiptByReceiptId(receiptId);
//        } catch (DbException ex) {
//            Logger.getLogger(CompleteReservationFilter.class.getName()).log(Level.SEVERE, null, ex);
//            resp.sendRedirect(req.getContextPath() + "/find_table?error=db_error");
//            return;
//        }
//        req.setAttribute("receipt", receipt);
//        req.getRequestDispatcher("/WEB-INF/jsp/complete_reservation.jsp").forward(req, resp);
//        
//    }
}
