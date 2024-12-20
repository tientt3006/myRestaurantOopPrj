/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.nolaneg.myrestaurantprj.db.InterfaceDAO;
import com.nolaneg.myrestaurantprj.db.entity.Category;
import com.nolaneg.myrestaurantprj.exceptions.DbException;
import java.util.*;
import java.io.*;
import java.math.*;
import java.util.List;

public interface CategoryDAO {
    List<Category> getAllCategories() throws DbException;
}
