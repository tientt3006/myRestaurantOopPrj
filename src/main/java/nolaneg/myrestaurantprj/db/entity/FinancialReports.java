/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;


import java.io.*;
import java.util.*;
public class FinancialReports implements Serializable{
    private int report_id;
    private int restaurant_id;
    private Date report_date;
    private float revenue;
    private float expenses;
    private float profit;
    //
    public int getReport_id(){
        return report_id;
    }
    public int getRestaurant_id(){
        return restaurant_id;
    }
    public Date getReport_date(){
        return report_date;
    }
    public float getRevenue(){
        return revenue;
    }
    public float getExpenses(){
        return expenses;
    }
    public float getProfit(){
        return profit;
    }
    //
    public static class Build{
        FinancialReports financialreport = new FinancialReports();
        
        public Build setReport_id(int report_id){
            financialreport.report_id = report_id;
            return this;
        }
        public Build setRestaurant_id(int restaurant_id){
            financialreport.restaurant_id = restaurant_id;
            return this;
        }
        public Build setReport_date(Date report_date){
            financialreport.report_date = report_date;
            return this;
        }
        public Build setRevenue(float revenue){
            financialreport.revenue = revenue;
            return this;
        }
        public Build setExpenses(float expenses){
            financialreport.expenses = expenses;
            return this;
        }
        public Build setProfit(float profit){
            financialreport.profit = profit;
            return this;
        }
        public FinancialReports financialreport(){
            return financialreport;
        }
    }
    //
}
