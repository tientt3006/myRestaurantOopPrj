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
        req.getRequestDispatcher("/WEB-INF/jsp/select_payment_method.jsp").forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String numOfTables = (String) req.getAttribute("tables");
        String numOfPeople = (String) req.getAttribute("people");
        String date = (String) req.getAttribute("date");
        String time = (String) req.getAttribute("time");
        String branchName = (String) req.getAttribute("branchName");

        int people = Integer.parseInt(numOfPeople);
        int tables = Integer.parseInt(numOfTables);

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
        try {
            if (tables <= Utils.MAX_TABLE 
                        - DAO.getDAO().getTableDAO().getReservedTable(branchId, date, time) 
                        - DAO.getDAO().getTableDAO().getOccupiedTable(branchId, date, time)){
                while(tables-- > 1){
                    if(people > 6){
                        DAO.getDAO().getTableDAO().addTable(date , time ,"reserved", 6 , branchId);
                        people -= 6;
                    }
                    DAO.getDAO().getTableDAO().addTable(date , time ,"reserved", people , branchId);
                }
                resp.sendRedirect(req.getContextPath() + "/complete_reservation");
            } else {
                resp.sendRedirect(req.getContextPath() + "/find_table?out_of_table=true");
            }
        }
        catch (DbException ex) {
                Logger.getLogger(SelectPaymentMethodServlet.class.getName()).log(Level.SEVERE, null, ex);
                resp.sendRedirect(req.getContextPath() + "/select_payment_method?error=db_error");
        }
    }
}
