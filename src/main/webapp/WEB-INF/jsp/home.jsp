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
        .main-container {
            flex: 1; /* Push the footer to the bottom */
            display: flex;
            justify-content: center; /* Center the content horizontally */
            align-items: center; /* Center the content vertically */
            padding: 0; /* Remove extra padding */
            background-color: #f4f4f4;
        }

        .main-container img {
            width: 90%; /* Make the image span the full width of the container */
            height: 10%; /* Make the image span the full height */
            object-fit: cover; /* Ensure the image covers the space without distortion */
            border-radius:0px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }


        main {
            text-align: center;
            padding: 50px 0;
            background-color: #f4f4f4;
        }
        main img {
            max-width: 80%;
            height: auto;
            border-radius: 0px;
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
                        <img href="home" src="${pageContext.request.contextPath}/img/OOPDinnerLogo.png" alt="Logo" class="logo">
                        <a href="${pageContext.request.contextPath}/home">OOP Dinner</a>
                </div>
                <div class="nav-links">
                        <a href="#">About</a>
                        <a href="#">Location</a>S
                        <a href="#">Menu</a>
                        <a href="#">Cart</a>
                        <a href="FindTable">Reservations</a>
                        <a href="account/login">Account</a>
                </div>
            </div>
        
        <!-- Main content -->
        <div class="main-container">
            <div class="illustration">
                <img src="${pageContext.request.contextPath}/img/PRRestaurant.jpg" alt="Hình ảnh nhà hàng XYZ">
            </div>
            <div class="intro">
                <p>Chào mừng đến với OOP Dinner</p>
                <p>Giờ hoạt động: 5 PM - 11 PM</p>
            </div>
        </div>
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
                
    </div>
</body>
</html>
