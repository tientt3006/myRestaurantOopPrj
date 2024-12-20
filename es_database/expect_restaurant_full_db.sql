
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

DROP TABLE IF EXISTS restaurant;
DROP TABLE IF EXISTS ingredient;
DROP TABLE IF EXISTS supplier;
DROP TABLE IF EXISTS warehouseHasIngredient;
DROP TABLE IF EXISTS supplierHasIngredient;
DROP TABLE IF EXISTS warehouseSupplies;
DROP TABLE IF EXISTS payroll;

-- Bảng lưu thông tin nhà hàng
CREATE TABLE restaurant (
    restaurantId INT AUTO_INCREMENT PRIMARY KEY,
    restaurantName VARCHAR(255) NOT NULL UNIQUE,
    address VARCHAR(255) NOT NULL,
    phone VARCHAR(20) NOT NULL, -- phone cua quan ly nha hang
    FOREIGN KEY (ownerId) REFERENCES users(userId) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Bảng nguyên liệu
CREATE TABLE ingredient (
    ingredientId INT AUTO_INCREMENT PRIMARY KEY,
    ingredientName VARCHAR(255) NOT NULL UNIQUE,
    ingredientUnit VARCHAR(255) NOT NULL UNIQUE
);

-- Bảng nhà cung cấp
CREATE TABLE supplier (
    supplierId INT AUTO_INCREMENT PRIMARY KEY,
    supplierName VARCHAR(255) NOT NULL,
    contactInfo VARCHAR(255) NOT NULL
);

-- Bảng trung gian giữa nhà kho và nguyên liệu (Nhiều - Nhiều)
CREATE TABLE warehouseHasIngredient (
    warehouseId INT,              -- Mã nhà kho
    ingredientId INT,             -- Mã nguyên liệu
    quantity INT NOT NULL,        -- Số lượng nguyên liệu trong kho
    PRIMARY KEY (warehouseId, ingredientId),
    FOREIGN KEY (warehouseId) REFERENCES restaurant(restaurantId) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (ingredientId) REFERENCES ingredient(ingredientId) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Bảng trung gian giữa nhà cung cấp và nguyên liệu (Nhiều - Nhiều)
CREATE TABLE supplierHasIngredient (
    supplierId INT,               -- Mã nhà cung cấp
    ingredientId INT,             -- Mã nguyên liệu
    price DECIMAL(10, 2) NOT NULL,-- Giá của nguyên liệu từ nhà cung cấp
    PRIMARY KEY (supplierId, ingredientId),
    FOREIGN KEY (supplierId) REFERENCES supplier(supplierId) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (ingredientId) REFERENCES ingredient(ingredientId) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Bảng trung gian giữa nhà kho và nhà cung cấp (Nhiều - Nhiều) để quản lý việc cung cấp nguyên liệu từ nhà cung cấp cho kho
CREATE TABLE warehouseSupplies (
    warehouseId INT,              -- Mã nhà kho
    supplierId INT,               -- Mã nhà cung cấp
    ingredientId INT,             -- Mã nguyên liệu
    supplyDate DATE NOT NULL,     -- Ngày cung cấp nguyên liệu
    quantity INT NOT NULL,        -- Số lượng nguyên liệu cung cấp
    PRIMARY KEY (warehouseId, supplierId, ingredientId),
    FOREIGN KEY (warehouseId) REFERENCES restaurant(restaurantId) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (supplierId) REFERENCES supplier(supplierId) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (ingredientId) REFERENCES ingredient(ingredientId) ON DELETE CASCADE ON UPDATE CASCADE
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
	restaurantId INT,  -- Reference to the restaurant they work for,
	FOREIGN KEY (restaurantId) REFERENCES restaurant(restaurantId) ON DELETE SET NULL ON UPDATE CASCADE,
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
CREATE TABLE tables (
    tableId INT PRIMARY KEY,               -- Mã ID duy nhất cho mỗi bàn
    maxSeats INT DEFAULT 6,                -- Số lượng người tối đa mỗi bàn có thể phục vụ, mặc định là 6
    status VARCHAR(20) NOT NULL,            -- Trạng thái của bàn: 'available'(trống), 'reserved' (đã đặt), 'occupied' (đang ngồi ăn)
    reservation_date DATE,                  -- Ngày đặt bàn, NULL nếu chưa có đặt chỗ
    reservation_time TIME,                  -- Giờ đặt bàn, NULL nếu chưa có đặt chỗ
    num_people INT,                         -- Số lượng người đặt chỗ, NULL nếu chưa có đặt chỗ
    start_time DATETIME,                    -- Thời gian bắt đầu sử dụng bàn, NULL nếu chưa sử dụng
    end_time DATETIME,                       -- Thời gian kết thúc sử dụng bàn, NULL nếu bàn chưa hoàn tất phục vụ
    restaurantId INT NOT NULL,  -- Reference to the restaurant
	FOREIGN KEY (restaurantId) REFERENCES restaurant(restaurantId) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (userId) REFERENCES users(userId) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE TABLE receiptHasTable (
    receiptId INT,                              -- Mã hóa đơn (khóa ngoại)
    tableId INT,                                -- Mã bàn (khóa ngoại)
    FOREIGN KEY (receiptId) REFERENCES receipt(receiptId) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (tableId) REFERENCES tables(table_id) ON DELETE CASCADE ON UPDATE CASCADE,
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
    FOREIGN KEY (tableId) REFERENCES tables(table_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (dishId) REFERENCES dish(dishId) ON DELETE CASCADE ON UPDATE CASCADE,
    PRIMARY KEY (tableId, dishId)               -- Khóa chính kết hợp giữa bàn và món ăn
);
-- New table to manage employee payroll
CREATE TABLE payroll (
    payrollId INT AUTO_INCREMENT PRIMARY KEY,
    userId INT NOT NULL,  -- Employee (user with role 2)
    salary DECIMAL(10, 2) NOT NULL,  -- Monthly salary
    payDate DATE NOT NULL,  -- Payment date
    hoursWorked INT NOT NULL,  -- Number of hours worked
    FOREIGN KEY (userId) REFERENCES users(userId) ON DELETE CASCADE ON UPDATE CASCADE
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
