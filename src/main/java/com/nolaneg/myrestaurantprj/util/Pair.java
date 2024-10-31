/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.nolaneg.myrestaurantprj.util;
import java.util.*;
import java.io.*;
import java.math.*;

/**
 *
 * @author $_{user}
 */
public class Pair<T, S> {
   private T first;    
   private S second;
   public Pair(T firstElement, S secondElement) {
        first = firstElement;
        second = secondElement;
   }    
   public T getFirst() { 
        return first; 
   }    
   public S getSecond() { 
        return second; 
   } 
}
