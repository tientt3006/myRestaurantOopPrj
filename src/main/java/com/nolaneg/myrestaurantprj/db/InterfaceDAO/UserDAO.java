/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.nolaneg.myrestaurantprj.db.InterfaceDAO;
// File: UserDAO.java
import com.nolaneg.myrestaurantprj.db.entity.User;
import com.nolaneg.myrestaurantprj.exceptions.DbException;
import java.sql.*;
import java.util.*;

public interface UserDAO {

    /**
     * Hash password and getting user from db. If no user returns, then wrong
     * login or password was entered and function return null object.
     * Otherwise, return user object
     * @param login login of user
     * @param password original(not hashed) password in char array
     * @return null if there isn't user with this login and password
     * or user object
     * @throws com.nolaneg.myrestaurantprj.exceptions.DbException
     */
    User logIn(String email, String password) throws DbException;
    
    User signUp(User user, String password) throws DbException;

    User getUserById(int id) throws DbException;
    
    User getUserByEmail(String email) throws DbException;
    
    User getUserByPhone(String email) throws DbException;
    
    boolean isLoginUnique(String email) throws DbException;
    
    void changePassword(int userId, String newPassword) throws DbException;
    
    void changeInfo(int userId, String firstName, String lastName, String email, String phone) throws DbException;
    
    ArrayList<Integer> getUserIds(int branchId) throws DbException;
}
