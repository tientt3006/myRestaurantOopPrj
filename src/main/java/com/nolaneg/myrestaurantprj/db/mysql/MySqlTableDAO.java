/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.nolaneg.myrestaurantprj.db.mysql;
import com.nolaneg.myrestaurantprj.db.InterfaceDAO.TableDAO;
import com.nolaneg.myrestaurantprj.exceptions.DbException;
import java.util.*;
import java.io.*;
import java.math.*;

/**
 *
 * @author $_{user}
 */
public class MySqlTableDAO implements TableDAO{

    @Override
    public int getReservedTable(int branchId, String date, String time) throws DbException {
        
        return 0;
        
    }

    @Override
    public int getOccupiedTable(int branchId, String date, String time) throws DbException {

        return 0;

    }
    
}
