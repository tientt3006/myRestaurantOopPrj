<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>OOP Dinner - Home</title>
    <style>
        html, body {
			height: 100%;
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f2f2f2;
        }
        .wrapper {
                display: flex;
                flex-direction: column;
                min-height: 100vh; /* Đảm bảo wrapper chiếm toàn bộ chiều cao của trang */
        }
        /* Header styles */
        .header {
            background-color: #333;
            color: white;
            padding: 15px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .header img {
            width: 100px;
        }
        .header .nav-links a {
            color: white;
            margin: 0 10px;
            text-decoration: none;
        }
        .header .nav-links a:hover {
            text-decoration: underline;
        }
		.logo-container {
			display: flex;
			align-items: center;
		}
		.logo {
			width: 50px;
			height: auto;
			margin-right: 10px; /* Khoảng cách giữa logo và dòng chữ */
		}
		.logo-container a {
			position: relative;
			font-size: 26px;
			color: white;
            text-decoration: none;
		}
		.logo-container a:hover {
			color: #ffdd00;
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
        .footer {
            background-color: #333;
            color: white;
            padding: 10px 20px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .footer img {
            width: 100px;
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
    <div class="wrapper">
        <!-- Header -->
            <div class="header">
                <div class="logo-container">
                        <img href="Home" src="${pageContext.request.contextPath}/img/OOPDinnerLogo.png" alt="Logo" class="logo">
                        <a href="${pageContext.request.contextPath}/Home">OOP Dinner</a>
                </div>
                <div class="nav-links">
                        <a href="#">About</a>
                        <a href="#">Location</a>
                        <a href="#">Menu</a>
                        <a href="#">Cart</a>
                        <a href="#">Reservations</a>
                        <a href="account/login">Account</a>
                </div>
            </div>
        
        <!-- Main content -->
        <div class="main-container">
            <img src="${pageContext.request.contextPath}/img/PRRestaurant.jpg" alt="Hình ảnh nhà hàng XYZ">
        </div>

<<<<<<< HEAD
<!-- Header -->
<header>
    <h1>Nhà hàng OOP</h1>
    <nav>
        <a href="Home">Trang chủ</a>
        <a href="#">Giới thiệu</a>
        <a href="#">Menu</a>
        <a href="FindTable">Đặt bàn</a>
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
=======
        <!-- Footer -->
            <div class="footer">
                    <img src="${pageContext.request.contextPath}/img/OOPDinnerLogo.png" alt="PTIT Cuisine Logo">
                    <div align="center">
                            <p>Contact: 0123-456-789 | Email: support@oopdinner.com</p>
                            <span->© 2024 OOP Dinner</span>
                    </div>
                    <div class="social-icons">
                            <a href="#">Facebook</a>
                            <a href="#">Instagram</a>
                            <a href="#">YouTube</a>
                    </div>
            </div>
>>>>>>> 1e74810de13d529f5828579c20380aef6dc4fe54
    </div>
</body>
</html>
