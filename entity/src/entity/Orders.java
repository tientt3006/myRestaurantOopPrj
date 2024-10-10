/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.*;
import java.util.*;
public class Orders implements Serializable{
    private int order_id;
    private int table_id; //foreign
    private int customer_id; //foreign
    private Date order_time;
    private float total_amount;
    private String status = "Pending";
    //

    public int getOrder_id(){
        return order_id;
    }
    public int getTable_id(){
        return table_id;
    }
    public int getCustomer_id(){
        return customer_id;
    }
    public Date getOrder_time(){
        return order_time;
    }
    public float getTotal_amount(){
        return total_amount;
    }
    public String getStatus(){
        return status;
    }
    //
    
    public static class Build{
        Orders order = new Orders();
        
        public Build setOrder_id(int order_id){
            order.order_id = order_id;
            return this;
        }
        public Build setTable_id(int table_id){
            order.table_id = table_id;
            return this;
        }
        public Build setCustomer_id(int customer_id){
            order.customer_id = customer_id;
            return this;
        }
        public Build setOrder_time(Date order_time){
            order.order_time = order_time;
            return this;
        }
        public Build setTotal_amount(float total_amount){
            order.total_amount = total_amount;
            return this;
        }
        public Build setStatus(String status){
            order.status = status;
            return this;
        }
        public Orders order(){
            return order;
        }
    }
    //
}
