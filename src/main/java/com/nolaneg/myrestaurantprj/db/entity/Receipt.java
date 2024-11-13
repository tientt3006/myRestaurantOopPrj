/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.nolaneg.myrestaurantprj.db.entity;
import java.util.*;
import java.io.*;
import java.math.*;
import java.time.*;

/**
 *
 * @author $_{user}
 */
public class Receipt {
    private int receiptId;
    private float reservationFee;
    private float foodCost;
    private float totalAmont;
    private float totalAmount;
    private LocalDate reservationDate;
    private LocalTime reservationTime;
    private LocalDateTime startTime; 
    private LocalDateTime endTime;
    private String status;
    private LocalDateTime createDate;

    public int getReceiptId() {
        return receiptId;
    }

    public float getReservationFee() {
        return reservationFee;
    }

    public float getFoodCost() {
        return foodCost;
    }

    public float getTotalAmont() {
        return totalAmont;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }

    public LocalTime getReservationTime() {
        return reservationTime;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }
    
    public static class Builder{
        Receipt receipt = new Receipt();
        public Builder setReceiptId(int id){
            receipt.receiptId = id;
            return this;
        }

        public Builder setReservationFee(float reservationFee) {
            receipt.reservationFee = reservationFee;
            return this;
        }

        public Builder setFoodCost(float foodCost) {
            receipt.foodCost = foodCost;
            return this;
        }

        public Builder setTotalAmont(float totalAmont) {
            receipt.totalAmont = totalAmont;
            return this;
        }

        public Builder setTotalAmount(float totalAmount) {
            receipt.totalAmount = totalAmount;
            return this;
        }

        public Builder setReservationDate(LocalDate reservationDate) {
            receipt.reservationDate = reservationDate;
            return this;
        }

        public Builder setReservationTime(LocalTime reservationTime) {
            receipt.reservationTime = reservationTime;
            return this;
        }

        public Builder setStartTime(LocalDateTime startTime) {
            receipt.startTime = startTime;
            return this;
        }

        public Builder setEndTime(LocalDateTime endTime) {
            receipt.endTime = endTime;
            return this;
        }

        public Builder setStatus(String status) {
            receipt.status = status;
            return this;
        }
        public Builder setCreatDate(LocalDateTime dateTime) {
            receipt.createDate = dateTime;
            return this;
        }
        public Receipt getReceipt(){
            return receipt;
        }
    }
}
