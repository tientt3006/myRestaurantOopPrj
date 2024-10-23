<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
    
<c:set var="title" value="OOP Dinner - Sign up" scope="page"/>
<%@ include file="head.jspf" %>

<body>
    <div class="wrapper">
        <!-- Header Section -->
        <c:set var="currentPage" value="signup" scope="page"/>
        <%@ include file="cus_header.jspf" %>

        <!-- Main Content Section -->
        <div class="main-container">
            <div class="signup-box">
                <h2>Sign up</h2>
                <% if ("duplicate".equals(request.getParameter("error"))) { %>
                    <div class="error-message">
                        Email or phone number already exists.
                    </div>
                <% } %>
                <form action="${pageContext.request.contextPath}/signup" method="post">
                    <p class="sigup-text"> First name </p>
                    <input type="text" name="firstName" placeholder="First name" required>
                    <p class="sigup-text"> Last name </p>
                    <input type="text" name="lastName" placeholder="Last name" required>
                    <p class="sigup-text"> Email </p>
                    <input type="email" name="email" placeholder="Email" required>
                    <p class="sigup-text"> Phone number </p>
                    <input type="tel" name="phone" placeholder="Phone number" pattern="[0-9]+" minlength="10" maxlength="10" required>
                    <p class="sigup-text"> Password </p>
                    <input type="password" name="password" placeholder="Password" required>
                    <button type="submit">Sign in</button>
                </form>
            </div>
        </div>

        <!-- Footer Section -->
        <%@ include file="cus_footer.jspf" %>
    </div>
</body>

</html>
