/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nolaneg.myrestaurantprj.db.entity;

/**
 *
 * @author admin
 */
import java.io.*;
import java.util.*;
public class Tables implements Serializable {
    private int tableId;
    private String status;
    
    public int getTableId(){
        return tableId;
    }
//    public Branch getBranch(){
//        return branch;
//    }
    public String getStatus(){
        return status;
    }
    
    public static class Builder{
        Tables table = new Tables();
        public Builder setTableId(int id){
            table.tableId = id;
            return this;
        }
//        public Builder setBranchId(int branchId){
//            table.d = branchId;
//            return this;
//        }
        public Builder setStatus(String status){
            table.status = status;
            return this;
        }
        public Tables getTables(){
            return table;
        }
    }
    //
}
