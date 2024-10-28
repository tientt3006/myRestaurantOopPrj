/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.nolaneg.myrestaurantprj.db.InterfaceDAO;
import com.nolaneg.myrestaurantprj.db.mysql.MySqlDAO;
import java.util.*;
import java.io.*;
import java.math.*;


/**
 *
 * @author $_{user}
 */
public abstract class DAO {
    public static DAO getDAO() {
        return new MySqlDAO();
    }
    
    public abstract UserDAO getUserDAO();
    public abstract DishDAO getDishDAO();
}
