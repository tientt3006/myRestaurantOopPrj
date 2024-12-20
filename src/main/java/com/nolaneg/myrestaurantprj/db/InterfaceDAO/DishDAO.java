/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.nolaneg.myrestaurantprj.db.InterfaceDAO;
// File: UserDAO.java
import com.nolaneg.myrestaurantprj.db.entity.Dish;
import com.nolaneg.myrestaurantprj.db.entity.User;
import com.nolaneg.myrestaurantprj.exceptions.DbException;
import com.nolaneg.myrestaurantprj.util.Pair;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface DishDAO {

    Dish getDishById(int id) throws DbException;
    ArrayList<Dish> getAllDishes() throws DbException;
    ArrayList<Dish> getSortedDishesFromCategoryOnPage(int categoryId, String sortBy, int dishesInPage, int pageNum) throws DbException;
    ArrayList<Dish> getSortedDishesOnPage(String sortBy, int dishesInPage, int pageNum) throws DbException;
    int getDishesNumber() throws DbException;
    int getDishesNumberInCategory(int categoryId) throws DbException;
    Map<Integer, Pair<String, Integer>> getDishesOrderCount() throws DbException;

    public ArrayList<Dish> getDishes()throws DbException;
    public ArrayList<Dish> getDishByReceiptId(int receiptId) throws DbException;
    int getDishQuant(int receiptId, int dishId) throws DbException;
}
