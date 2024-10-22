<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>OOP Dinner - Find A Table</title>
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

<!-- Header -->
<header>
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
                        <a href="FindTable">Reservations</a>
                        <a href="account/login">Account</a>
                </div>
            </div>
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
</footer>

</body>
</html>
