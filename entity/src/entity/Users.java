/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package entity;

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
    public int getID(){
        return user_id;
    }
    
}
