<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Nhà hàng XYZ - Trang chủ</title>
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
    <h1>Nhà hàng XYZ</h1>
    <nav>
        <a href="index.jsp">Trang chủ</a>
        <a href="gioithieu.jsp">Giới thiệu</a>
        <a href="menu.jsp">Menu</a>
        <a href="datban.jsp">Đặt bàn</a>
        <a href="lienhe.jsp">Liên hệ</a>
        <a href="giohang.jsp">Giỏ hàng</a>
        <a href="taikhoan.jsp">Tài khoản</a>
    </nav>
</header>

<!-- Main content -->
<main>
    <h2>Chào mừng đến với Nhà hàng XYZ!</h2>
    <p>Trải nghiệm ẩm thực tuyệt vời cùng không gian sang trọng và ấm cúng.</p>
    <img src="images/restaurant.jpg" alt="Hình ảnh nhà hàng XYZ">
</main>

<!-- Footer -->
<footer>
    <div>
        <img src="images/logo.png" alt="Logo nhà hàng XYZ">
    </div>
    <p>Liên hệ: 0123-456-789 | Email: info@nhahangxyz.com</p>
    <p>&copy; 2024 Nhà hàng XYZ. Bản quyền thuộc về chúng tôi.</p>
    <div class="social-links">
        <a href="https://facebook.com" target="_blank">Facebook</a>
        <a href="https://instagram.com" target="_blank">Instagram</a>
        <a href="https://twitter.com" target="_blank">Twitter</a>
    </div>
</footer>

</body>
</html>
