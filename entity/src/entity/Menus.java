/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package entity;
import java.io.*;
import java.util.*;
public class Menus implements Serializable {
    private int dish_id;
    private String name;
    private String category;
    private float price;
    private float rating;
    private int restaurant_id;
    //
    public int getDish_id(){
        return dish_id;
    }
    public String getName(){
        return name;
    }
    public String getCategory(){
        return category;
    }
    public float getPrice(){
        return price;
    }
    public float getRating(){
        return rating;
    }
    public int getRestaurant_id(){
        return restaurant_id;
    }
    
    //
    public static class Build{
        Menus menu = new Menus();
        
        public Build setDish_id(int dish_id){
            menu.dish_id = dish_id;
            return this;
        }
        public Build setName(String name){
            menu.name = name;
            return this;
        }
        public Build setCategory(String category){
            menu.category = category;
            return this;
        }
        public Build setPrice(float price){
            menu.price = price;
            return this;
        }
        public Build setRating(float rating){
            menu.rating = rating;
            return this;
        }
        public Build setRestaurant_id(int restaurant_id){
            menu.restaurant_id = restaurant_id;
            return this;
        }
        public Menus getMenu(){
            return menu;
        }
    }
    //
}

