

package com.nolaneg.myrestaurantprj.db.mysql;
import com.nolaneg.myrestaurantprj.db.InterfaceDAO.*;
import java.util.*;
import java.io.*;
import java.math.*;


public class MySqlDAO extends DAO {
    
    @Override
    public UserDAO getUserDAO() {
        return new MySqlUserDAO();
    }
    
    @Override
    public DishDAO getDishDAO() {
        return new MySqlDishDAO();
    }
    
    @Override
    public CategoryDAO getCategoryDAO() {
        return new MySqlCategoryDAO();
    }
    
    @Override
    public TableDAO getTableDAO() {
        return new MySqlTableDAO();
    }
    
    @Override
    public BranchDAO getBranchDAO() {
        return new MySqlBranchDAO();
    }
    
    @Override
    public ReceiptDAO getReceiptDAO() {
        return new MySqlReceiptDAO();
    }
}
