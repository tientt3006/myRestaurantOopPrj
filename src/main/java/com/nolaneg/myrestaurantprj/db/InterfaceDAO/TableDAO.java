/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.nolaneg.myrestaurantprj.db.InterfaceDAO;
import com.nolaneg.myrestaurantprj.exceptions.DbException;
import java.util.*;
import java.io.*;
import java.math.*;

/**
 *
 * @author $_{user}
 */
public interface TableDAO {
    int getReservedTable(int branchId, String date) throws DbException;
    int getUnpaidTable(int branchId, String date) throws DbException;

    void addTable(int receiptId) throws DbException;
}