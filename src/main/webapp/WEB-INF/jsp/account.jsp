
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Your Account</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/cus_all_body_style.css">
</head>
<body>
    <header>
        <h1>OOP Dinner</h1>
        <nav>
            <ul>
                <li><a href="${pageContext.request.contextPath}/about">About</a></li>
                <li><a href="${pageContext.request.contextPath}/location">Location</a></li>
                <li><a href="${pageContext.request.contextPath}/menu">Menu</a></li>
                <li><a href="${pageContext.request.contextPath}/cart">Cart</a></li>
                <li><a href="${pageContext.request.contextPath}/reservations">Reservations</a></li>
                <li><a href="${pageContext.request.contextPath}/account">Account</a></li>
            </ul>
        </nav>
    </header>

    <main>
        <h2>Your Account</h2>
        <p>Your Name: ${user.full_name}</p>
        <p>Your Email: ${user.email}</p>
        <p>Your Phone Number: ${user.phone}</p>
        
        <form action="${pageContext.request.contextPath}/account/changeInfo" method="get">
            <button type="submit" class="btn">Change Info</button>
        </form>
        <form action="${pageContext.request.contextPath}/account/changePassword" method="get">
            <button type="submit" class="btn">Change Password</button>
        </form>
        <form action="${pageContext.request.contextPath}/account/delete" method="post">
            <button type="submit" class="btn">Delete Account</button>
        </form>
            <!-- Logout button -->
        <form action="${pageContext.request.contextPath}/account/logout" method="post">
            <button type="submit" class="btn">Logout</button>
        </form>
    </main>

    <footer>
        <p>Contact: 0123-456-789 | Email: support@oopdinner.com</p>
        <p>&copy; 2024 OOP Dinner</p>
        <div>
            <a href="https://www.facebook.com/">Facebook</a>
            <a href="https://www.instagram.com/">Instagram</a>
            <a href="https://www.youtube.com/">YouTube</a>
        </div>
    </footer>
</body>
</html>
