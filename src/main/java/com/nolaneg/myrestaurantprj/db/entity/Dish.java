package com.nolaneg.myrestaurantprj.db.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Hoàng Hướng
 */
public class Dish implements Serializable {
    private int dishId;
    private String dishName;
    private float price;
    private String ingredient;
    private int categoryId;

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
    public int getCategoryId(){
        return categoryId;
    }
   
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dish dish = (Dish) o;
        return dishId == dish.dishId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dishId);
    }

    public int getQuantity() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public static class Builder {
        Dish dish = new Dish();

        public Dish getDish() {
            return dish;
        }

        public Builder setDishId(int id) {
            dish.dishId = id;
            return this;
        }

        public Builder setDishName(String name) {
            dish.dishName = name;
            return this;
        }

        public Builder setCategoryId(int categoryId) {
            dish.categoryId = categoryId;
            return this;
        }

        public Builder setPrice(float price) {
            dish.price = price;
            return this;
        }

        public Builder setIngredient(String ingre) {
            dish.ingredient = ingre;
            return this;
        }
    }
}
