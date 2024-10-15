<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PTIT Cuisine - Login</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f2f2f2;
        }
        /* Header styles */
        .header {
            background-color: #000;
            color: white;
            padding: 10px 20px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .header img {
            width: 100px;
        }
        .header .nav-links a {
            color: white;
            margin: 0 15px;
            text-decoration: none;
            font-weight: bold;
        }
        .header .nav-links a:hover {
            color: #ffdd00;
        }
        /* Main content styles */
        .main-container {
            display: flex;
            justify-content: space-between;
            padding: 40px;
        }
        .login-box {
            background-color: #ffdd00;
            padding: 20px;
            border: 2px solid #000;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
            width: 300px;
        }
        .login-box h2 {
            color: #d40000;
            text-align: center;
        }
        .login-box input[type="email"],
        .login-box input[type="password"] {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #000;
            border-radius: 5px;
        }
        .login-box .google-btn {
            width: 100%;
            background-color: #d40000;
            color: white;
            border: none;
            padding: 10px;
            cursor: pointer;
            border-radius: 5px;
            font-weight: bold;
        }
        .login-box .google-btn:hover {
            background-color: #ff3333;
        }
        .right-image {
            width: 50%;
            background: url('${pageContext.request.contextPath}/img/PTITCursineLogo.png') no-repeat center center;
            background-size: cover;
            height: 400px; /* Adjust the height as needed */
        }
        /* Footer styles */
        .footer {
            background-color: #000;
            color: white;
            padding: 20px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .footer img {
            width: 80px;
        }
        .footer .social-icons a {
            color: white;
            margin: 0 10px;
            text-decoration: none;
        }
        .footer .social-icons a:hover {
            color: #ffdd00;
        }
    </style>
</head>
<body>

    <!-- Header Section -->
    <div class="header">
        <img src="${pageContext.request.contextPath}/img/PTITCursineLogo.png" alt="PTIT Cuisine Logo">
        <div class="nav-links">
            <a href="#">Trang chủ</a>
            <a href="#">Giới thiệu</a>
            <a href="#">Menu</a>
            <a href="#">Giỏ hàng</a>
            <a href="#">Đăng ký</a>
            <a href="#">Đăng nhập</a>
        </div>
    </div>

    <!-- Main Content Section -->
    <div class="main-container">
        <div class="login-box">
            <h2>Đăng Nhập</h2>
            <form action="Experiment_login" method="post">
                <input type="email" name="email" placeholder="Email" required>
                <input type="password" name="password" placeholder="Mật khẩu" required>
                <button type="submit">Đăng Nhập</button>
                <button type="button" class="google-btn">Đăng nhập bằng Google</button>
            </form>
        </div>
        <div class="right-image"></div>
    </div>

    <!-- Footer Section -->
    <div class="footer">
        <img src="${pageContext.request.contextPath}/img/PTITCursineLogo.png" alt="PTIT Cuisine Logo">
        <div>
            <p>Liên hệ: 0123-456-789 | Email: support@ptitcuisine.com</p>
        </div>
        <div class="social-icons">
            <a href="#">Facebook</a>
            <a href="#">YouTube</a>
            <span>© 2024 PTIT Cuisine</span>
        </div>
    </div>

</body>
</html>
