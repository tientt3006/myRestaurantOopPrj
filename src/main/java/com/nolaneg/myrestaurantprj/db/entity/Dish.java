package com.nolaneg.myrestaurantprj.db.entity;

/**
 *
 * @author Hoàng Hướng
 */
public class Dish {
    private int dishId;
    private String dishName;
    private float price;
    private String ingredient;
    public Dish(int dishId, String dishName, float price, String ingredient) {
        this.dishId = dishId;
        this.dishName = dishName;
        this.price = price;
        this.ingredient = ingredient;
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
    public String getIngredient() {
        return ingredient;
    }

   

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }
    public void setIngrediet(String ingredient) {
        this.ingredient = ingredient;
    }
 

    public void setPrice(float price) {
        this.price = price;
    }


    
    
}
