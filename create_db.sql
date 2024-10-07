-- Tạo cơ sở dữ liệu
CREATE DATABASE RestaurantManagement;
USE RestaurantManagement;

-- Bảng quản lý thông tin người dùng
CREATE TABLE Users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    full_name VARCHAR(100),
    email VARCHAR(100),
    phone VARCHAR(15),
    role ENUM('Customer', 'Manager', 'Receptionist', 'President', 'VicePresident', 'Secretary') NOT NULL
);

-- Bảng quản lý nhà hàng
CREATE TABLE Restaurants (
    restaurant_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    location VARCHAR(255),
    phone VARCHAR(15),
    manager_id INT,
    FOREIGN KEY (manager_id) REFERENCES Users(user_id)
);

-- Bảng quản lý các bàn ăn trong nhà hàng
CREATE TABLE Tables (
    table_id INT AUTO_INCREMENT PRIMARY KEY,
    restaurant_id INT,
    table_number INT NOT NULL,
    seats INT DEFAULT 6,
    floor INT,
    status ENUM('Available', 'Reserved', 'Occupied') DEFAULT 'Available',
    FOREIGN KEY (restaurant_id) REFERENCES Restaurants(restaurant_id)
);

-- Bảng quản lý menu món ăn
CREATE TABLE Menu (
    dish_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    category VARCHAR(50),
    price DECIMAL(10, 2),
    rating DECIMAL(2, 1),
    restaurant_id INT,
    FOREIGN KEY (restaurant_id) REFERENCES Restaurants(restaurant_id)
);

-- Bảng quản lý các đơn hàng
CREATE TABLE Orders (
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    table_id INT,
    customer_id INT,
    order_time DATETIME DEFAULT CURRENT_TIMESTAMP,
    total_amount DECIMAL(10, 2),
    status ENUM('Pending', 'Confirmed', 'Completed', 'Cancelled') DEFAULT 'Pending',
    FOREIGN KEY (table_id) REFERENCES Tables(table_id),
    FOREIGN KEY (customer_id) REFERENCES Users(user_id)
);

-- Bảng quản lý chi tiết món ăn trong mỗi đơn hàng
CREATE TABLE OrderDetails (
    order_detail_id INT AUTO_INCREMENT PRIMARY KEY,
    order_id INT,
    dish_id INT,
    quantity INT,
    price DECIMAL(10, 2),
    FOREIGN KEY (order_id) REFERENCES Orders(order_id),
    FOREIGN KEY (dish_id) REFERENCES Menu(dish_id)
);

-- Bảng quản lý nhân sự trong nhà hàng
CREATE TABLE Staff (
    staff_id INT AUTO_INCREMENT PRIMARY KEY,
    restaurant_id INT,
    user_id INT,
    position ENUM('Chef', 'Waiter', 'Cleaner', 'Guard', 'Receptionist'),
    salary DECIMAL(10, 2),
    join_date DATE,
    FOREIGN KEY (restaurant_id) REFERENCES Restaurants(restaurant_id),
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

-- Bảng quản lý kho hàng (Inventory)
CREATE TABLE Inventory (
    inventory_id INT AUTO_INCREMENT PRIMARY KEY,
    restaurant_id INT,
    item_name VARCHAR(100) NOT NULL,
    quantity INT,
    supplier VARCHAR(100),
    expiration_date DATE,
    FOREIGN KEY (restaurant_id) REFERENCES Restaurants(restaurant_id)
);

-- Bảng quản lý các nhà cung cấp
CREATE TABLE Suppliers (
    supplier_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    contact_info VARCHAR(255),
    product_list TEXT
);

-- Bảng quản lý tài chính
CREATE TABLE FinancialReports (
    report_id INT AUTO_INCREMENT PRIMARY KEY,
    restaurant_id INT,
    report_date DATE,
    revenue DECIMAL(15, 2),
    expenses DECIMAL(15, 2),
    profit DECIMAL(15, 2),
    FOREIGN KEY (restaurant_id) REFERENCES Restaurants(restaurant_id)
);

-- Thêm dữ liệu mẫu vào bảng Users
INSERT INTO Users (username, password, full_name, email, phone, role) VALUES
('john_doe', 'password123', 'John Doe', 'john@example.com', '123456789', 'Manager'),
('alice_manager', 'password456', 'Alice Smith', 'alice@example.com', '987654321', 'Manager'),
('receptionist1', 'password789', 'Receptionist One', 'receptionist1@example.com', '555555555', 'Receptionist'),
('president', 'adminpass', 'President', 'president@example.com', '111111111', 'President'),
('vice_president', 'vpadminpass', 'Vice President', 'vp@example.com', '222222222', 'VicePresident');

-- Thêm dữ liệu mẫu vào bảng Restaurants
INSERT INTO Restaurants (name, location, phone, manager_id) VALUES
('Luxury Dining', '123 Main St, City A', '987654321', 1),
('Gourmet Palace', '456 High Rd, City B', '123456789', 2);

-- Thêm dữ liệu mẫu vào bảng Tables
INSERT INTO Tables (restaurant_id, table_number, seats, floor, status) VALUES
(1, 1, 6, 1, 'Available'),
(1, 2, 8, 1, 'Reserved'),
(2, 1, 4, 2, 'Occupied');

-- Thêm dữ liệu mẫu vào bảng Menu
INSERT INTO Menu (name, category, price, rating, restaurant_id) VALUES
('Grilled Salmon', 'Seafood', 25.50, 4.8, 1),
('Steak', 'Meat', 30.00, 4.5, 1),
('Caesar Salad', 'Salad', 12.00, 4.2, 2);

-- Thêm dữ liệu mẫu vào bảng Orders
INSERT INTO Orders (table_id, customer_id, order_time, total_amount, status) VALUES
(1, 3, NOW(), 50.00, 'Pending'),
(2, 3, NOW(), 75.00, 'Confirmed');

-- Thêm dữ liệu mẫu vào bảng OrderDetails
INSERT INTO OrderDetails (order_id, dish_id, quantity, price) VALUES
(1, 1, 2, 51.00),
(2, 2, 1, 30.00);

-- Thêm dữ liệu mẫu vào bảng Staff
INSERT INTO Staff (restaurant_id, user_id, position, salary, join_date) VALUES
(1, 4, 'Chef', 2000.00, '2022-01-01'),
(1, 5, 'Waiter', 1500.00, '2022-06-15');

-- Thêm dữ liệu mẫu vào bảng Inventory
INSERT INTO Inventory (restaurant_id, item_name, quantity, supplier, expiration_date) VALUES
(1, 'Chicken Breast', 50, 'Food Supplier A', '2024-12-31'),
(2, 'Olive Oil', 20, 'Food Supplier B', '2025-01-15');

-- Thêm dữ liệu mẫu vào bảng Suppliers
INSERT INTO Suppliers (name, contact_info, product_list) VALUES
('Food Supplier A', 'contact@suppliera.com, 333333333', 'Meat, Seafood, Vegetables'),
('Food Supplier B', 'contact@supplierb.com, 444444444', 'Oil, Spices, Dairy Products');

-- Thêm dữ liệu mẫu vào bảng FinancialReports
INSERT INTO FinancialReports (restaurant_id, report_date, revenue, expenses, profit) VALUES
(1, '2024-09-30', 10000.00, 7000.00, 3000.00),
(2, '2024-09-30', 15000.00, 10000.00, 5000.00);
