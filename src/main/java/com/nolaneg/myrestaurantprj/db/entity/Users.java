/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.nolaneg.myrestaurantprj.db.entity;

import java.io.*;
import java.util.*;
public class Users implements Serializable{
    private int user_id;
    private String username;
    private String password;
    private String full_name;
    private String email;
    private String phone;
    private String role;
    
    public int getUser_id(){
        return user_id;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public String getFull_name(){
        return full_name;
    }
    public String getEmail(){
        return email;
    }
    public String getPhone(){
        return phone;
    }
    public String getRole(){
        return role;
    }
    //
    public static class Build{
        Users user = new Users();
        public Build setUser_id(int user_id){
            user.user_id = user_id;
            return this;
        }
        public Build setUsername(String username){
            user.username = username;
            return this;
        }
        public Build setPassword(String password){
            user.password = password;
            return this;
        }
        public Build setFull_name(String full_name){
            user.full_name = full_name;
            return this;
        }
        public Build setEmail(String email){
            user.email = email;
            return this;
        }
        public Build setPhone(String phone){
            user.phone = phone;
            return this;
        }
        public Build setRole(String role){
            user.role = role;
            return this;
        }
        public Users getUsers(){
            return user;
        }
    }
    //
    
    
//    public String toString(){
//        return "";
//    }
}
