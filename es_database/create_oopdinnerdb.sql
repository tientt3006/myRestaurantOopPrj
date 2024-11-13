
-- File: creat_oopdinnerdb.sql

CREATE DATABASE IF NOT EXISTS oopdinnerdb CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE oopdinnerdb;

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS role;
DROP TABLE IF EXISTS receipt;
DROP TABLE IF EXISTS tables;
DROP TABLE IF EXISTS receiptHasTable;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS dish;
DROP TABLE IF EXISTS tableHasDish;
DROP TABLE IF EXISTS branch;

CREATE TABLE role (
    roleId INT AUTO_INCREMENT PRIMARY KEY,
    roleName VARCHAR(32) NOT NULL UNIQUE
);
CREATE TABLE users (
    userId INT AUTO_INCREMENT PRIMARY KEY,
    firstName VARCHAR(255) NOT NULL,
    lastName VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    phone VARCHAR(20) NOT NULL UNIQUE,
    roleId INT NOT NULL DEFAULT 1,
    createDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (roleId) REFERENCES role(roleId) ON DELETE CASCADE ON UPDATE CASCADE
)AUTO_INCREMENT = 1001;

CREATE TABLE branch (
    branchId INT AUTO_INCREMENT PRIMARY KEY,
    address VARCHAR(255),
    mnId INT NOT NULL,
    FOREIGN KEY (mnId) REFERENCES users(userId) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE TABLE receipt (
    receiptId INT PRIMARY KEY AUTO_INCREMENT,
    userId INT NOT NULL,
	branchId INT,
    reservationFee DECIMAL(10, 2) NOT NULL,
    foodCost DECIMAL(10, 2),
    totalAmount DECIMAL(10, 2),
    reservation_date DATE,
    reservation_time TIME, 
    start_time DATETIME,
    end_time DATETIME,
    status VARCHAR(20) NOT NULL, -- reserved (đã đặt bàn thành công, các bàn đợi được dùng), unpaid (chưa thanh toán tiền ăn, các bàn đang được sử dụng), paid (đã thanh toán tất cả, các bàn nhàn dỗi), refunded, canceled
	createDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	FOREIGN KEY (userId) REFERENCES users(userId) ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (branchId) REFERENCES branch(branchId) ON DELETE CASCADE ON UPDATE CASCADE
);
-- Maximum 50 tables per branch. So that each branch can handle maximun 300 people at a time
CREATE TABLE tables (
    tableId INT PRIMARY KEY AUTO_INCREMENT,      
    receiptId INT,
    num_people INT, 
    FOREIGN KEY (receiptId) REFERENCES receipt(receiptId)  ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE TABLE category (
	categoryId INT AUTO_INCREMENT PRIMARY KEY,
    categoryName VARCHAR(255) NOT NULL UNIQUE
);
CREATE TABLE dish (
    dishId INT AUTO_INCREMENT PRIMARY KEY,
    dishName VARCHAR(255) NOT NULL UNIQUE,
    categoryId INT NOT NULL,
    price INT NOT NULL,
    ingredient VARCHAR(1023),
    FOREIGN KEY (categoryId) REFERENCES category(categoryId) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE TABLE tableHasDish (
    tableId INT, 
    dishId INT,  
    quantity INT NOT NULL,
    FOREIGN KEY (tableId) REFERENCES tables(tableId) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (dishId) REFERENCES dish(dishId) ON DELETE CASCADE ON UPDATE CASCADE,
    PRIMARY KEY (tableId, dishId) 
);

INSERT INTO role (roleId, roleName) VALUES 
(1, 'customer'),
(2, 'staff'),
(3, 'manager'),
(4, 'chairman'),
(5, 'admin');

INSERT INTO users (userId, firstName, lastName, password, email, phone, roleId) VALUES 
(101, 'mn1', 'mn', SHA2('123456', 256), 'mn1@mn', '1111111111', 3),
(201, 'mn2', 'mn', SHA2('123456', 256), 'mn2@mn', '2222222222', 3),
(301, 'mn3', 'mn', SHA2('123456', 256), 'mn3@mn', '3333333333', 3),
(401, 'mn4', 'mn', SHA2('123456', 256), 'mn4@mn', '4444444444', 3),
(51, 'chair1', 'man', SHA2('123456', 256), 'chair1@man', '5555555555', 4),
(1, 'ad1', 'min', SHA2('123456', 256), 'ad1@min', '0000000000', 5);
-- user id from 1 -> 50 for role 5, 
-- from 51 -> 100 for role 4, 
-- from 101 -> 200 for manager (role 3) and employees (role 2) of branchId 1
-- from 201 -> 300 for manager (role 3) and employees (role 2) of branchId 2
-- ... 
-- from 1001 for customer (role 1)

INSERT INTO oopdinnerdb.branch (branchId, address, mnId) VALUES 
(1, 'Posts and Telecommunications Institute of Technology', 101),
(2, 'Hanoi Opera House', 201),
(3, 'Ho Tay', 301),
(4, 'Keangnam Landmark 72', 401);

INSERT INTO oopdinnerdb.category (categoryId, categoryName) VALUES 
(1, "Meat"),
(2, "Drink"),
(3, "Vergetable");

INSERT INTO oopdinnerdb.dish (dishId, dishName, categoryId, price, ingredient) VALUES 
(1, 'Grilled Beef', 1, 350000, 'Beef - Garlic - Pepper'),
(2, 'Chicken Curry', 1, 280000, 'Chicken - Coconut Milk - Curry Powder'),
(3, 'Pork Ribs BBQ', 1, 320000, 'Pork Ribs - BBQ Sauce - Honey'),
(4, 'Roast Duck', 1, 500000, 'Duck - Five-Spice Powder - Soy Sauce'),
(5, 'Lamb Chops', 1, 450000, 'Lamb - Rosemary - Olive Oil'),
(6, 'Beef Pho', 1, 150000, 'Beef - Rice Noodles - Herbs'),
(7, 'Steamed Chicken', 1, 300000, 'Chicken - Ginger - Fish Sauce'),
(8, 'Braised Pork Belly', 1, 350000, 'Pork Belly - Soy Sauce - Eggs'),
(9, 'Turkey Roast', 1, 650000, 'Turkey - Butter - Thyme'),
(10, 'Seafood Hotpot', 1, 700000, 'Prawns - Fish - Clams - Vegetables'),
(11, 'Red Wine', 2, 900000, 'Cabernet Sauvignon'),
(12, 'White Wine', 2, 850000, 'Chardonnay'),
(13, 'Craft Beer', 2, 120000, 'Hops - Malt'),
(14, 'Green Tea', 2, 50000, 'Green Tea Leaves'),
(15, 'Iced Coffee', 2, 60000, 'Coffee - Ice - Milk'),
(16, 'Mango Smoothie', 2, 80000, 'Mango - Yogurt - Honey'),
(17, 'Coconut Water', 2, 70000, 'Fresh Coconut'),
(18, 'Whiskey Sour', 2, 250000, 'Whiskey - Lemon - Sugar'),
(19, 'Mojito', 2, 180000, 'Rum - Mint - Lime - Soda'),
(20, 'Sparkling Water', 2, 40000, 'Mineral Water - Carbonation'),
(21, 'Caesar Salad', 3, 120000, 'Lettuce - Croutons - Parmesan Cheese'),
(22, 'Spinach Soup', 3, 90000, 'Spinach - Cream - Onion'),
(23, 'Grilled Asparagus', 3, 150000, 'Asparagus - Olive Oil - Garlic'),
(24, 'Roasted Vegetables', 3, 200000, 'Zucchini - Bell Peppers - Carrots'),
(25, 'Vegetarian Spring Rolls', 3, 100000, 'Rice Paper - Vegetables - Vermicelli'),
(26, 'Mixed Greens', 3, 110000, 'Lettuce - Cucumber - Tomatoes'),
(27, 'Avocado Toast', 3, 130000, 'Avocado - Bread - Olive Oil'),
(28, 'Kimchi', 3, 80000, 'Cabbage - Chili - Garlic'),
(29, 'Miso Soup', 3, 90000, 'Seaweed - Tofu - Miso Paste'),
(30, 'Vegetable Stir-fry', 3, 150000, 'Broccoli - Carrots - Mushrooms');
