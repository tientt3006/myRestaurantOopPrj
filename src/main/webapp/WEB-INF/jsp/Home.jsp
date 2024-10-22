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
        <a href="home">Trang chủ</a>
        <a href="#">Giới thiệu</a>
        <a href="#">Menu</a>
        <a href="#">Đặt bàn</a>
        <a href="#">Liên hệ</a>
        <a href="#">Giỏ hàng</a>
        <a href="account/login">Tài khoản</a>
    </nav>
</header>

<!-- Main content -->
<main>
    <h2>Chào mừng đến với Nhà hàng OOP!</h2>
    <p>Trải nghiệm ẩm thực tuyệt vời cùng không gian sang trọng và ấm cúng.</p>
    <img src="images/restaurant.jpg" alt="Hình ảnh nhà hàng XYZ">
</main>

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
