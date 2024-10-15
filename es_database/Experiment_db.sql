
-- File: create_user_database.sql

CREATE DATABASE IF NOT EXISTS experiment_db;
USE experiment_db;

DROP TABLE IF EXISTS Experiment_User;

-- Tạo bảng người dùng
CREATE TABLE IF NOT EXISTS Experiment_User (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password_hash VARCHAR(255) NOT NULL
);

-- Thêm tài khoản mẫu
INSERT INTO Experiment_User (username, password_hash) VALUES 
('admin', SHA2('admin_password', 256)),
('user1', SHA2('user1_password', 256));
