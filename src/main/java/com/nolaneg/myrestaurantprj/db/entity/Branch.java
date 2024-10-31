/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nolaneg.myrestaurantprj.db.entity;

import java.io.*;
import java.util.*;
public class Branch implements Serializable{
    private int branchId;
    private String location;
    private User manager;
    private Tables[] tables;
    //
    public int getBranchId(){
        return branchId;
    }
    public String getLocation(){
        return location;
    }
    public User getManager(){
        return manager;
    }
    public Tables[] getTables(){
        return tables;
    }
    //
    public static class Builder{
        Branch branch = new Branch();
        
        public Builder setBranchId(int branchId){
            branch.branchId = branchId;
            return this;
        }
        public Builder setLocation(String location){
            branch.location = location;
            return this;
        }
        public Builder setManager(User manager){
            branch.manager = manager;
            return this;
        }
        public Builder setTables(Tables[] tables){
            branch.tables = tables;
            return this;
        }
        public Branch getBranch(){
            return branch;
        }
    }
}
