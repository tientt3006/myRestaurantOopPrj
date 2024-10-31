
package com.nolaneg.myrestaurantprj.db.InterfaceDAO;
import com.nolaneg.myrestaurantprj.db.mysql.MySqlDAO;
import java.util.*;
import java.io.*;
import java.math.*;



public abstract class DAO {
    public static DAO getDAO() {
        return new MySqlDAO();
    }
    
    public abstract UserDAO getUserDAO();
    public abstract DishDAO getDishDAO();
    public abstract CategoryDAO getCategoryDAO();
    public abstract TableDAO getTableDAO();
    public abstract BranchDAO getBranchDAO();
}
