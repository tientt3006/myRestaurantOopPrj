
-- File: creat_oopdinnerdb.sql

CREATE DATABASE IF NOT EXISTS oopdinnerdb;
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

CREATE TABLE branch (
    branchId INT AUTO_INCREMENT PRIMARY KEY,
    address VARCHAR(255),
    mnId INT NOT NULL,
    FOREIGN KEY (mnId) REFERENCES users(userId) ON DELETE CASCADE ON UPDATE CASCADE
);

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
);
CREATE TABLE receipt (
    receiptId INT PRIMARY KEY AUTO_INCREMENT,   -- Mã hóa đơn (khóa chính, tự động tăng)
    userId INT NOT NULL,
    totalAmount DECIMAL(10, 2) NOT NULL,        -- Tổng số tiền trong hóa đơn
    receiptDate DATE NOT NULL,                  -- Ngày lập hóa đơn
    receiptTime TIME NOT NULL,                   -- Thời gian lập hóa đơn
    receiptType VARCHAR(20) NOT NULL,            -- Loại hóa đơn: 'deposit' (cọc bàn) hoặc 'food' (tiền thức ăn)
    FOREIGN KEY (userId) REFERENCES users(userId) ON DELETE CASCADE ON UPDATE CASCADE
);
-- Maximum 50 tables per branch, in real life. So that each branch can handle maximun 300 people at the same time
CREATE TABLE tables (
    tableId INT PRIMARY KEY,               
    reservation_date DATE PRIMARY KEY,               
    reservation_time TIME PRIMARY KEY,
    maxSeats INT DEFAULT 6,
    status VARCHAR(20) NOT NULL, -- available, reserved, occupied  
    num_people INT, 
    start_time DATETIME,
    end_time DATETIME,
    branchId INT,
    FOREIGN KEY (branchId) REFERENCES branch(branchId) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE TABLE receiptHasTable (
    receiptId INT,                              -- Mã hóa đơn (khóa ngoại)
    tableId INT,                                -- Mã bàn (khóa ngoại)
    FOREIGN KEY (receiptId) REFERENCES receipt(receiptId) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (tableId) REFERENCES tables(tableId) ON DELETE CASCADE ON UPDATE CASCADE,
    PRIMARY KEY (receiptId, tableId)            -- Khóa chính kết hợp giữa hóa đơn và bàn
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
    tableId INT,                                -- Mã bàn (khóa ngoại)
    dishId INT,                                 -- Mã món ăn (khóa ngoại)
    quantity INT NOT NULL,                      -- Số lượng món ăn được gọi
    FOREIGN KEY (tableId) REFERENCES tables(tableId) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (dishId) REFERENCES dish(dishId) ON DELETE CASCADE ON UPDATE CASCADE,
    PRIMARY KEY (tableId, dishId)               -- Khóa chính kết hợp giữa bàn và món ăn
);

INSERT INTO role (roleName) VALUES 
('customer'),
('staff'),
('manager'),
('chairman');
