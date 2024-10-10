/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.*;
import java.util.*;
public class OrderDetails implements Serializable{
    private int order_detail_id;
    private int order_id;
    private int dish_id;
    private int quantity;
    private float price;
    //
    public int getOrder_detail_id(){
        return order_detail_id;
    }
    public int getOrder_id(){
        return order_id;
    }
    public int getDish_id(){
        return dish_id;
    }
    public int getQuantity(){
        return quantity;
    }
    public float getPrice(){
        return price;
    }
    //
    public static class Build{
        OrderDetails orderdetail = new OrderDetails();
        
        public Build setOrder_detail_id(int order_detail_id){
            orderdetail.order_detail_id = order_detail_id;
            return this;
        }
        public Build setOrder_id(int order_id){
            orderdetail.order_id = order_id;
            return this;
        }
        public Build setDish_id(int dish_id){
            orderdetail.dish_id = dish_id;
            return this;
        }
        public Build setQuantity(int quantity){
            orderdetail.quantity = quantity;
            return this;
        }
        public Build setPrice(float price){
            orderdetail.price = price;
            return this;
        }
        public OrderDetails getOrderdetail(){
            return orderdetail;
        }
    }
}

