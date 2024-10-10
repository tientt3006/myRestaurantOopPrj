/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.*;
import java.util.*;
public class Restaurants implements Serializable{
    private int restaurant_id;
    private String name;
    private String location;
    private String phone;
    private int manager_id; //String//
    //
    public int getRestaurant_id(){
        return restaurant_id;
    }
    public String getName(){
        return name;
    }
    public String getLocation(){
        return location;
    }
    public String getPhone(){
        return phone;
    }
    public int getManager_id(){
        return manager_id;
    }
    //
    public static class Build{
        Restaurants restaurants = new Restaurants();
        
        public Build setRestaurant_id(int restaurant_id){
            restaurants.restaurant_id = restaurant_id;
            return this;
        }
        public Build setName(String name){
            restaurants.name = name;
            return this;
        }
        public Build setLocation(String location){
            restaurants.location = location;
            return this;
        }
        public Build setPhone(String phone){
            restaurants.phone = phone;
            return this;
        }
        public Build setManager_id(int manager_id){
            restaurants.manager_id = manager_id;
            return this;
        }
        public Restaurants getRestaurant(){
            return restaurants;
        }
    }
}
