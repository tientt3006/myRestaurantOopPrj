/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.*;
import java.util.*;
public class Suppliers implements Serializable{
    private int supplier_id;
    private String name;
    private String contact_info;
    private String product_list;
    //
    public int getSupplier_id(){
        return supplier_id;
    }
    public String getName(){
        return name;
    }
    public String getContact_info(){
        return contact_info;
    }
    public String getProduct_list(){
        return product_list;
    }
    //
    public static class Build{
        Suppliers supplier = new Suppliers();
        
        public Build setSupplier_id(int supplier_id){
            supplier.supplier_id = supplier_id;
            return this;
        }
        public Build setName(String name){
            supplier.name = name;
            return this;
        }
        public Build setContact_info(String contact_info){
            supplier.contact_info = contact_info;
            return this;
        }
        public Build setProduct_list(String product_list){
            supplier.product_list = product_list;
            return this;
        }
        public Suppliers supplier(){
            return supplier;
        }
    }
    //
}
