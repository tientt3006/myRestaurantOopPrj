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
    private Dish[] dishes;
    
    public int getTableId(){
        return tableId;
    }
    
    public static class Builder{
        Tables table = new Tables();
        public Builder setTableId(int id){
            table.tableId = id;
            return this;
        }

        public Tables getTables(){
            return table;
        }
    }
}
