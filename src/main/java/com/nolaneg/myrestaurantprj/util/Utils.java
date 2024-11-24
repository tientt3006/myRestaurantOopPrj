/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.nolaneg.myrestaurantprj.util;
import com.nolaneg.myrestaurantprj.db.entity.Receipt;
import java.util.*;
import java.io.*;
import java.math.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Duration;
import java.time.LocalDateTime;
/**
 *
 * @author $_{user}
 */
public class Utils {
    
    // MAX constain in a branch, every branch have the same this MAX constain.
    public static final int MAX_TABLE = 50;
    public static final int MAX_PEOPLE = 300;
    
    public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            throw new IllegalArgumentException(ex);
        }
    }
    
    /**
     * Get formatted error message for logging
     * @return formatted string with error and it's cause
     */
    public static String getErrMessage(Exception e) {
        return e + "; Caused by: " + e.getCause().toString();
    }
    
    /**
     * invalidate session and redirect to home
     */
    public static void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.getSession().invalidate();
        resp.sendRedirect(req.getContextPath() + "/login");
    }
    

    public static boolean canCancelReservation(Receipt receipt) {
        LocalDateTime now = LocalDateTime.now();
        
        // Kiểm tra điều kiện 1: Trong vòng 12 giờ từ lúc đặt
        Duration timeSinceCreate = Duration.between(receipt.getCreateDateLocalDT(), now);
        boolean isWithin12Hours = timeSinceCreate.toHours() <= 12;

        // Kiểm tra điều kiện 2: Trước giờ đặt ít nhất 24 giờ
        LocalDateTime reservationDateTime = receipt.getReservationDate().atTime(receipt.getReservationTime());
        Duration timeUntilReservation = Duration.between(now, reservationDateTime);
        boolean isAtLeast24HoursBefore = timeUntilReservation.toHours() >= 24;

        // Chỉ cho phép hủy nếu cả hai điều kiện đều đúng
        return isWithin12Hours && isAtLeast24HoursBefore;
    }

}
