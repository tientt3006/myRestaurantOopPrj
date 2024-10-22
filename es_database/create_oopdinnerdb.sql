
-- File: create_user_database.sql

CREATE DATABASE IF NOT EXISTS oopdinnerdb;
USE oopdinnerdb;

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS role;

CREATE TABLE role (
    roleId INT AUTO_INCREMENT PRIMARY KEY,
    roleName VARCHAR(32) NOT NULL UNIQUE
);

-- Tạo bảng người dùng
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

-- Thêm tài khoản mẫu
INSERT INTO role (roleName) VALUES 
('customer'),
('manager'),
('chairman');

INSERT INTO users (firstName, lastName, password, email, phone, roleId) VALUES 
('admin', 'mod', SHA2('123456', 256), 'admin.doe@gmail.com', '0234567890', 2),
('Khanh', 'Nguyen', SHA2('123456', 256), 'khanh@gmail.com', '1234567890', 1),
('Hieu', 'Nguyen', SHA2('123456', 256), 'hieu.doe@gmail.com', '2234567890', 1),
('Huong', 'Nguyen', SHA2('123456', 256), 'huong.doe@gmail.com', '3234567890', 1),
('Son', 'Nguyen', SHA2('123456', 256), 'son.doe@gmail.com', '4234567890', 1),
('Tien', 'Nguyen', SHA2('123456', 256), 'tien.doe@gmail.com', '5234567890', 1);
