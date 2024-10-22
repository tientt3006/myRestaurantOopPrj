<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Nhà hàng OOP - Trang chủ</title>
    <style>
        body {
            margin: 0;
            font-family: Arial, sans-serif;
        }
        /* Header styles */
        header {
            background-color: #333;
            color: white;
            padding: 15px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        nav a {
            color: white;
            text-decoration: none;
            margin: 0 10px;
        }
        nav a:hover {
            text-decoration: underline;
        }

        /* Main content styles */
        main {
            text-align: center;
            padding: 50px 0;
            background-color: #f4f4f4;
        }
        main img {
            max-width: 80%;
            height: auto;
            border-radius: 15px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        /* Footer styles */
        footer {
            background-color: #222;
            color: white;
            text-align: center;
            padding: 20px 0;
            margin-top: 30px;
        }
        footer img {
            height: 50px;
        }
        footer .social-links a {
            margin: 0 10px;
            color: white;
            text-decoration: none;
        }
        footer .social-links a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

<!-- Header -->
<header>
    <h1>Nhà hàng OOP</h1>
    <nav>
        <a href="Home">Trang chủ</a>
        <a href="#">Giới thiệu</a>
        <a href="#">Menu</a>
        <a href="#">Đặt bàn</a>
        <a href="#">Liên hệ</a>
        <a href="#">Giỏ hàng</a>
        <a href="account/login">Tài khoản</a>
    </nav>
</header>

    <title>OOP Dinner - Find a Table</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #e0e0e0;
        }

        .header, .footer {
            background-color: #1c1c1c;
            color: white;
            padding: 10px;
            text-align: center;
        }

        .navbar {
            background-color: #333;
            padding: 10px 0;
            text-align: center;
        }

        .navbar a {
            color: white;
            padding: 14px 20px;
            text-decoration: none;
            font-size: 16px;
        }

        .navbar a:hover {
            background-color: #575757;
        }

        .container {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .form-box {
            background-color: #333;
            color: white;
            padding: 30px;
            border-radius: 8px;
            width: 300px;
        }

        .form-box h2 {
            text-align: center;
            margin-bottom: 20px;
        }

        .form-box label {
            display: block;
            margin: 10px 0 5px;
        }

        .form-box input, .form-box select {
            width: 100%;
            padding: 8px;
            margin-bottom: 15px;
            border-radius: 4px;
            border: 1px solid #ccc;
        }

        .form-box button {
            width: 100%;
            padding: 10px;
            background-color: #d32f2f;
            border: none;
            color: white;
            font-size: 16px;
            cursor: pointer;
            border-radius: 4px;
        }

        .form-box button:hover {
            background-color: #b71c1c;
        }

        .footer a {
            color: white;
            text-decoration: none;
            margin: 0 10px;
        }

        .footer a:hover {
            text-decoration: underline;
        }

        .error-message {
            color: red;
            font-size: 12px;
            text-align: center;
        }
    </style>
</head>
<body>

    <div class="container">
        <div class="form-box">
            <h2>Find a table</h2>
            
            <label for="branch">Branch (địa điểm của chi nhánh)</label>
            <select id="branch" name="branch">
                <option value="">làm thế nào đó chọn chi nhánh ở đây</option>
            </select>

            <label for="date">Date</label>
            <input type="date" id="date" name="date" placeholder="làm thế nào đó chọn ngày ở đây">

            <label for="time">Time</label>
            <input type="time" id="time" name="time" placeholder="làm thế nào đó chọn giờ ở đây">

            <label for="people">Number of people</label>
            <input type="number" id="people" name="people" min="1" max="6" placeholder="làm thế nào đó chọn số người ở đây">

            <p class="error-message">If there are more than six people, please reserve a second table</p>
            
            <button type="submit">Search button</button>
        </div>
    </div>

<!-- Footer -->
<footer>
    <div>
        <img src="images/logo.png" alt="Logo nhà hàng XYZ">
    </div>
    <p>Liên hệ: 0123-456-789 | Email: info@nhahangoop.com</p>
    <p>&copy; 2024 Nhà hàng OOP. Bản quyền thuộc về chúng tôi.</p>
    <div class="social-links">
        <a href="https://facebook.com" target="_blank">Facebook</a>
        <a href="https://instagram.com" target="_blank">Instagram</a>
        <a href="https://twitter.com" target="_blank">Twitter</a>
    </div>
</footer>

</body>
</html>
