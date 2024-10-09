/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.*;
import java.util.*;
public class Inventory implements Serializable{
    private int inventory_id;
    private int restaurant_id;
    private String item_name;
    private int quantity;
    private String supplier;
    private Date expiration_date;
}
