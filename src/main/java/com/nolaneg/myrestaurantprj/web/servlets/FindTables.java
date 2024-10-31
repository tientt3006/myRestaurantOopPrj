/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.nolaneg.myrestaurantprj.web.servlets;
import com.nolaneg.myrestaurantprj.db.InterfaceDAO.DAO;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import org.slf4j.LoggerFactory;
@WebServlet("/find_table")

public class FindTables extends HttpServlet{
        private static final org.slf4j.Logger logger = LoggerFactory.getLogger(SqlUtils.class);

    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/find_table.jsp").forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int branchId = Integer.parseInt(req.getParameter("branch"));
        String date = req.getParameter("date");
        String time = req.getParameter("time");
        int numOfPeople = Integer.parseInt(req.getParameter("people"));
        int numOfTables = Integer.parseInt(req.getParameter("tables"));

        try {
            if (numOfTables <= Utils.MAX_TABLE - DAO.getDAO().getTableDAO().getReservedTable(branchId, date, time) - DAO.getDAO().getTableDAO().getOccupiedTable(branchId, date, time)) {
                resp.sendRedirect(req.getContextPath() + "/complete_reservation");
            } else {
                resp.sendRedirect(req.getContextPath() + "/find_table?failure=outOfTable");
            }
        } catch (DbException e) {
            logger.error(Utils.getErrMessage(e), e);
            throw new AppException(e);
        }
    }
}