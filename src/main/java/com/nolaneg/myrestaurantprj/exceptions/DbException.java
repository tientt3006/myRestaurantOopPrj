/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.nolaneg.myrestaurantprj.exceptions;
import java.util.*;
import java.io.*;
import java.math.*;

/**
 *
 * @author $_{user}
 */
public class DbException extends Exception{
    
    public DbException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public  DbException(String message) {
        super(message);
    }
}
