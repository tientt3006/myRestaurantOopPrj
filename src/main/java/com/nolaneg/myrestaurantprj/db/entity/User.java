/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.nolaneg.myrestaurantprj.db.entity;

import java.io.*;
import java.util.*;
public class User implements Serializable{
    private int userId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private int roleId;
    private Date createDate;
    
    public int getUserId(){
        return userId;
    }
    
    public String getFirstName(){
        return firstName;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public String getEmail(){
        return email;
    }
    
    public String getPhone(){
        return phone;
    }
    
    public int getRoleId(){
        return roleId;
    }
    
    public Date getCreateDate() {
        return createDate;
    }
    
    public String getFull_name(){
        return this.firstName + " " + this.lastName;
    }
    
    @Override
    public String toString() {
        return "User{" +
                "id=" + userId +
                ", email='" + email + '\'' +
                ", roleId=" + roleId +
                ", createDate=" + createDate +
                '}';
    }
    
    public static class Builder{
        User user = new User();
        
        public Builder setUserId(int userId){
            user.userId = userId;
            return this;
        }
        
        public Builder setFirstName(String firstName){
            user.firstName = firstName;
            return this;
        }
        
        public Builder setLasttName(String lastName){
            user.lastName = lastName;
            return this;
        }
        
        public Builder setEmail(String email){
            user.email = email;
            return this;
        }
        
        public Builder setPhone(String phone){
            user.phone = phone;
            return this;
        }
        
        public Builder setRoleId(int roleId){
            user.roleId = roleId;
            return this;
        }
        
        public Builder setCreateDate(Date createDate) {
            user.createDate = createDate;
            return this;
        }
        
        public User getUser(){
            return user;
        }
    }
    
}
