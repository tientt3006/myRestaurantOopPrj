/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.nolaneg.myrestaurantprj.util;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Experiment_Utils {

    /**
     * Hash array of chars using SHA-512
     *
     * @param arr what to encode
     * @return hashed string
     */
    public static String hash(char[] arr) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(new String(arr).getBytes(StandardCharsets.UTF_8));
            byte[] hash = md.digest();
            StringBuilder answ = new StringBuilder();
            for (byte b : hash) {
                answ.append(String.format("%02X", b));
            }
            return answ.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e);
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
     * invalidate session and redirect to catalog
     */
    public static void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.getSession().invalidate();
        resp.sendRedirect(req.getContextPath() + "/catalog");
    }
}
