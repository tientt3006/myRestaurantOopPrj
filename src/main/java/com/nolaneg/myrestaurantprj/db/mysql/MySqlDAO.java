/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.nolaneg.myrestaurantprj.db.mysql;
import com.nolaneg.myrestaurantprj.db.InterfaceDAO.UserDAO;
import com.nolaneg.myrestaurantprj.db.InterfaceDAO.DAO;
import java.util.*;
import java.io.*;
import java.math.*;

/**
 *
 * @author $_{user}
 */
public class MySqlDAO extends DAO {
    
    @Override
    public UserDAO getUserDAO() {
        return new MySqlUserDAO();
    }
}
