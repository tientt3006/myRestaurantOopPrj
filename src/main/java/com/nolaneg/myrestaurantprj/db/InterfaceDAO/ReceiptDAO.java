/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.nolaneg.myrestaurantprj.db.InterfaceDAO;
import com.nolaneg.myrestaurantprj.db.entity.Receipt;
import com.nolaneg.myrestaurantprj.exceptions.DbException;
import java.util.*;
import java.io.*;
import java.math.*;

/**
 *
 * @author $_{user}
 */
public interface ReceiptDAO {
    Receipt getLastestReceiptOfAUser(int userId, int branchId) throws DbException;
    Receipt addReceipt(int userId, int branchId, Receipt receipt ) throws DbException;
    int getUserIdByReceiptId(int receiptId) throws DbException;
    Receipt getReceiptByReceiptId(int receiptId) throws DbException;
    void addReceiptHasDish(int receiptId, int dishId, int quantity)throws DbException;
    
}
