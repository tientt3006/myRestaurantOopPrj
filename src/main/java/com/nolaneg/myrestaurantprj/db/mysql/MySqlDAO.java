

package com.nolaneg.myrestaurantprj.db.mysql;
import com.nolaneg.myrestaurantprj.db.InterfaceDAO.UserDAO;
import com.nolaneg.myrestaurantprj.db.InterfaceDAO.DAO;
import com.nolaneg.myrestaurantprj.db.InterfaceDAO.DishDAO;
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
}
