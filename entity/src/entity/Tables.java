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
    
}
