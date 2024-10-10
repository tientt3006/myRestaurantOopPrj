/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author admin
 */
import java.io.*;
import java.util.*;
public class Tables implements Serializable{
    private int table_id;
    private int restaurant_id;
    private int table_number;
    private int seats = 6;
    private int floor;
    private String status = "Available";
    //
    public int getTable_id(){
        return table_id;
    }
    public int getRestaurant_id(){
        return restaurant_id;
    }
    public int getTable_number(){
        return table_number;
    }
    public int getSeats(){
        return seats;
    }
    public int getFloor(){
        return floor;
    }
    public String getStatus(){
        return status;
    }
    //
    public static class Build{
        Tables table = new Tables();
        public Build setTable_id(int table_id){
            table.table_id = table_id;
            return this;
        }
        public Build setRestaurant_id(int restaurant_id){
            table.restaurant_id = restaurant_id;
            return this;
        }
        public Build setTable_number(int table_number){
            table.table_number = table_number;
            return this;
        }
        public Build setSeats(int seats){
            table.seats = seats;
            return this;
        }
        public Build setFloor(int floor){
            table.floor = floor;
            return this;
        }
        public Build setStatus(String status){
            table.status = status;
            return this;
        }
        public Tables getTables(){
            return table;
        }
    }
    //
}
