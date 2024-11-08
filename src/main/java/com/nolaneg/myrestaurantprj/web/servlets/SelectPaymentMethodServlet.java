/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.nolaneg.myrestaurantprj.web.servlets;
import static com.mysql.cj.conf.PropertyKey.logger;
import com.nolaneg.myrestaurantprj.db.InterfaceDAO.DAO;
import com.nolaneg.myrestaurantprj.db.entity.Branch;
import com.nolaneg.myrestaurantprj.db.entity.Category;
import com.nolaneg.myrestaurantprj.db.entity.User;
import com.nolaneg.myrestaurantprj.exceptions.AppException;
import com.nolaneg.myrestaurantprj.exceptions.DbException;
import com.nolaneg.myrestaurantprj.util.SqlUtils;
import com.nolaneg.myrestaurantprj.util.Utils;
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
import javax.servlet.http.HttpSession;
import org.slf4j.LoggerFactory;

/**
 *
 * @author $_{user}
 */
@WebServlet("/select_payment_method")
public class SelectPaymentMethodServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String branchName = req.getParameter("branchName");
//        if (branchName == null || branchName.isEmpty()) {
//            resp.sendRedirect(req.getContextPath() + "/select_payment_method?error=missing_parametersNAME");
//            return;
//        }
//        
        String date = req.getParameter("date");
//        if (date == null || date.isEmpty()) {
//            resp.sendRedirect(req.getContextPath() + "/select_payment_method?error=missing_parametersDATE");
//            return;
//        }
        
        String time = req.getParameter("time");
//        if (time == null || time.isEmpty()) {
//            resp.sendRedirect(req.getContextPath() + "/select_payment_method?error=missing_parametersTIME");
//            return;
//        }
//        if (req.getParameter("people") == null || req.getParameter("people").isEmpty()) {
//            resp.sendRedirect(req.getContextPath() + "/select_payment_method?error=missing_parametersPEOPLE");
//            return;
//        }
        int numOfPeople = Integer.parseInt(req.getParameter("people"));
        
//        if (req.getParameter("tables") == null || req.getParameter("tables").isEmpty()) {
//            resp.sendRedirect(req.getContextPath() + "/select_payment_method?error=missing_parametersTABLES");
//            return;
//        }
        int numOfTables = Integer.parseInt(req.getParameter("tables"));
        System.out.println(branchName);
        System.out.println(date);
        System.out.println(time);
        System.out.println(numOfPeople);
        System.out.println(numOfTables);
        
//        ReservationPay reservationDay = getReservationPay(req);
        req.setAttribute("reservationBranchName", branchName);
        req.setAttribute("reservationDate", date);
        req.setAttribute("reservationTime", time);
        req.setAttribute("numberOfPeople", numOfPeople);
        req.setAttribute("selectedTableNumber", numOfTables);
//        
        req.getRequestDispatcher("/WEB-INF/jsp/select_payment_method.jsp").forward(req, resp);
        
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        
        String branchName = req.getParameter("branchName1");
        String date = req.getParameter("date1");
        String time = req.getParameter("time1"); 
        int numOfPeople = Integer.parseInt(req.getParameter("people1"));
        int numOfTables = Integer.parseInt(req.getParameter("tables1"));
//        ReservationPay reservationDay = getReservationPay(req);
        int branchId = 0;
        List<Branch> branchs = null;
        try {
            branchs = DAO.getDAO().getBranchDAO().getBranchs();
            for(Branch x:branchs){
                if(x.getLocation().equals(branchName)){
                    branchId = x.getBranchId();
                }
            }    
        } catch (DbException ex) {
            Logger.getLogger(SelectPaymentMethodServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Lưu thông tin vào DataBase tables;
        if(branchId ==0 || numOfPeople ==0 || numOfTables ==0 || 
                date == null || date.isEmpty() || 
                time == null || time.isEmpty()){
            resp.sendRedirect(req.getContextPath() + "/select_payment_method?error=paymentfalse");
            return;
        }
        try {
            
            DAO.getDAO().getTableDAO().addTable(date , time ,"reserved", numOfPeople , branchId);
            resp.sendRedirect(req.getContextPath() + "/complete_reservation");
        } catch (DbException ex) {
//            ex.printStackTrace();
            Logger.getLogger(SelectPaymentMethodServlet.class.getName()).log(Level.SEVERE, null, ex);
            resp.sendRedirect(req.getContextPath() + "/select_payment_method?error=db_error");
        }
    }
}
