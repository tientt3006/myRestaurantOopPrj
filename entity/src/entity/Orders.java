/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.*;
import java.util.*;
public class Orders implements Serializable{
    private int order_id;
    private int table_id;
    private int customer_id;
    private Date order_time;
    private float total_amount;
    private String status = "Pending";
}
