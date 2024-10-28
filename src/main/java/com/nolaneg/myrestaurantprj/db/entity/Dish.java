package com.nolaneg.myrestaurantprj.db.entity;

/**
 *
 * @author Hoàng Hướng
 */
public class Dish {
    private int dishId;
    private String dishName;
    private float price;

    public Dish(int dishId, String dishName, float price) {
        this.dishId = dishId;
        this.dishName = dishName;
        this.price = price;
    }

    public int getDishId() {
        return dishId;
    }

    public String getDishName() {
        return dishName;
    }



    public float getPrice() {
        return price;
    }

   

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

 

    public void setPrice(float price) {
        this.price = price;
    }


    
    
}
