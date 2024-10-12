/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nolaneg.myrestaurantprj.db.entity;

import java.io.*;
import java.util.*;
public class Inventorys implements Serializable{
    private int inventory_id;
    private int restaurant_id;
    private String item_name;
    private int quantity;
    private String supplier;
    private Date expiration_date;
    //
    public int getInventory_id(){
        return inventory_id;
    }
    public int getRestaurant_id(){
        return restaurant_id;
    }
    public String getItem_name(){
        return item_name;
    }
    public int getQuantity(){
        return quantity;
    }
    public String getSupplier(){
        return supplier;
    }
    public Date getExpiraion_date(){
        return expiration_date;
    }
    //
    public static class Build{
        Inventorys inventory = new Inventorys();
        
        public Build setInventory_id(int inventory_id){
            inventory.inventory_id = inventory_id;
            return this;
        }
        public Build setRestaurant_id(int restaurant_id){
            inventory.restaurant_id = restaurant_id;
            return this;
        }
        public Build setItem_name(String item_name){
            inventory.item_name = item_name;
            return this;
        }
        public Build setQuantity(int quantity){
            inventory.quantity = quantity;
            return this;
        }
        public Build setSupplier(String supplier){
            inventory.supplier = supplier;
            return this;
        }
        public Build setExpiration_date(Date expiration_date){
            inventory.expiration_date = expiration_date;
            return this;
        }
        public Inventorys inventory(){
            return inventory;
        }
    }
}
