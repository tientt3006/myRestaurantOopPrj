
-- File: create_user_database.sql

CREATE DATABASE IF NOT EXISTS oopdinnerdb;
USE oopdinnerdb;

DROP TABLE IF EXISTS users;

-- Tạo bảng người dùng
CREATE TABLE IF NOT EXISTS users (
    userID INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
);

-- Thêm tài khoản mẫu
INSERT INTO users (username, password) VALUES 
('admin@haha', SHA2('adminhaha', 256)),
('a@a', SHA2('123456', 256)),
('admin', SHA2('admin_password', 256)),
('user1', SHA2('user1_password', 256));
