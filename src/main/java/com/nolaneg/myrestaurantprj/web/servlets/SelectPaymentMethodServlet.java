/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.nolaneg.myrestaurantprj.web.servlets;
import static com.mysql.cj.conf.PropertyKey.logger;
import com.nolaneg.myrestaurantprj.db.InterfaceDAO.DAO;
import com.nolaneg.myrestaurantprj.db.entity.Branch;
import com.nolaneg.myrestaurantprj.db.entity.Category;
import com.nolaneg.myrestaurantprj.db.entity.Receipt;
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
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
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
        req.getRequestDispatcher("/WEB-INF/jsp/select_payment_method.jsp").forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String numOfTables = req.getParameter("tables");
        String numOfPeople =  req.getParameter("people");
        String date = req.getParameter("date");
        String time = req.getParameter("time");
        String branchId = req.getParameter("branchId");

        int people = Integer.parseInt(numOfPeople);
        int tables = Integer.parseInt(numOfTables);    
        
        User user = (User) req.getSession().getAttribute("user");
        
        try {
            if (tables <= Utils.MAX_TABLE - DAO.getDAO().getTableDAO().getReservedTable(Integer.parseInt(branchId), date) 
                                          - DAO.getDAO().getTableDAO().getUnpaidTable(Integer.parseInt(branchId), date)) {
                
                // add to receipt table:
                Receipt receipt = new Receipt.Builder()
                        .setReservationFee((float) (tables*100000.0))
                        .setReservationDate(LocalDate.parse(date))
                        .setReservationTime(LocalTime.parse(time))
                        .setStatus("reserved")
                        .setNumOfPeople(people)
                        .getReceipt();
                receipt = DAO.getDAO().getReceiptDAO().addReceipt(user.getUserId(), Integer.parseInt(branchId), receipt);
                int receiptId = receipt.getReceiptId();
                while(tables-- >= 1){
                    DAO.getDAO().getTableDAO().addTable(receiptId);
                }
                
                resp.sendRedirect(req.getContextPath() + "/complete_reservation?receipt_id=" + receiptId);
            } else {
                resp.sendRedirect(req.getContextPath() + "/find_table?out_of_table=true");
            }
        }
        catch (DbException ex) {
                Logger.getLogger(SelectPaymentMethodServlet.class.getName()).log(Level.SEVERE, null, ex);
                resp.sendRedirect(req.getContextPath() + "/find_table?error=db_error");
        }
    }
}
