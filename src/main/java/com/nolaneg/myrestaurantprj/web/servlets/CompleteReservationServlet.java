/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.nolaneg.myrestaurantprj.web.servlets;
import java.io.IOException;
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
        HttpSession session = req.getSession();
        
        String branchName = req.getParameter("branchName");
        String date = req.getParameter("date");
        String time = req.getParameter("time");
        int numOfPeople = Integer.parseInt(req.getParameter("people"));
        int numOfTables = Integer.parseInt(req.getParameter("tables"));

        req.setAttribute("completereservationBranchName", branchName);
        req.setAttribute("completereservationDate", date);
        req.setAttribute("completereservationTime", time);
        req.setAttribute("completenumberOfPeople", numOfPeople);
        req.setAttribute("completeselectedTableNumber", numOfTables);
//        
        req.getRequestDispatcher("/WEB-INF/jsp/complete_reservation.jsp").forward(req, resp);
        
    }
    
}
