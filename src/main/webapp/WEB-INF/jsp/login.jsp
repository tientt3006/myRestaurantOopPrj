<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
    
<c:set var="title" value="OOP Dinner - Log in" scope="page"/>
<%@ include file="head.jspf" %>

<body>
    <div class="wrapper">
        <!-- Header Section -->
        <c:set var="currentPage" value="login" scope="page"/>
        <%@ include file="cus_header.jspf" %>

        <!-- Main Content Section -->
        <% if ("true".equals(request.getAttribute("sessionExpired"))) { %>
            <div class="error-message" style="color: red; text-align: center;">
                Your session has expired. Please log in again.
            </div>
        <% } %>
        <% String message = request.getParameter("message"); 
            if (message != null) { 
        %>
            <div class="alert alert-warning" style="color: red; text-align: center;">
                <%= message %>
            </div>
        <% } %>
        <div class="main-container">
            
            
            <div class="login-container">
                <div class="left-image"></div>
                <div class="login-box">
                    <h2>Log in</h2>
                    <% if ("true".equals(request.getAttribute("err"))) { %>
                        <div class="error-message" style="color: red; text-align: center; margin-bottom: 10px;">
                            Invalid username or password.
                        </div>
                    <% } %>
                    <form action="${pageContext.request.contextPath}/login" method="post">
                        <p class="email-text"> Email </p>
                        <input type="email" name="email" placeholder="Email" required>
                        <p class="password-text"> Password </p>
                        <input type="password" name="password" placeholder="Password" required>

                        <a href="#" class="forgot-pass-link" >Forgot Password?</a>

                        <button type="submit">Log in</button>
                        <!--<button type="button" class="google-btn">Log in by Google</button> -->
                        <p class="sign-in-text">Don't have an account?
                            <a href="signup" class="signup-link">Sign up</a> now!
                        </p>
                    </form>
                </div>
            </div>
        </div>

        <!-- Footer Section -->
        <%@ include file="cus_footer.jspf" %>
    </div>
</body>

</html>
