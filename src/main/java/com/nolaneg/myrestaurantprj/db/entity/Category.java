package com.nolaneg.myrestaurantprj.db.entity;

import java.io.Serializable;

/**
 *
 * @author Hoàng Hướng
 */
public class Category implements Serializable {
    private int categoryId;
    private String categoryName;

    public int getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }
    
    public static class Builder {
        Category category = new Category();

        public Category getCategory() {
            return category;
        }

        public Builder setCategoryId(int id) {
            category.categoryId = id;
            return this;
        }

        public Builder setCategoryName(String name) {
            category.categoryName = name;
            return this;
        }
    }
}
