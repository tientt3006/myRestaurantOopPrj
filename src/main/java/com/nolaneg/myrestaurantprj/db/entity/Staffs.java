/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nolaneg.myrestaurantprj.db.entity;

import java.io.*;
import java.util.*;
public class Staffs implements Serializable{
    private int staff_id;
    private int restaurant_id;
    private int user_id;
    private String position;
    private float salary;
    private Date join_date;
    //
    public int getStaff_id(){
        return staff_id;
    }
    public int getRestaurant_id(){
        return restaurant_id;
    }
    public int getUser_id(){
        return user_id;
    }
    public String getPosition(){
        return position;
    }
    public float getSalary(){
        return salary;
    }
    public Date getJoin_date(){
        return join_date;
    }
    //
    public static class Build{
        Staffs staff = new Staffs();
        
        public Build setStaff_id(int staff_id){
            staff.staff_id = staff_id;
            return this;
        }
        public Build setRestaurant_id(int restaurant_id){
            staff.restaurant_id = restaurant_id;
            return this;
        }
        public Build setUser_id(int user_id){
            staff.user_id = user_id;
            return this;
        }
        public Build setPosition(String position){
            staff.position = position;
            return this;
        }
        public Build setSalary(float salary){
            staff.salary = salary;
            return this;
        }
        public Build setJoin_date(Date join_date){
            staff.join_date = join_date;
            return this;
        }
        public Staffs staff(){
            return staff;
        }
    }
    //
}
