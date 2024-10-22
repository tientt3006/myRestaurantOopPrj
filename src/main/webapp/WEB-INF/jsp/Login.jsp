<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
    
<c:set var="title" value="OOP Dinner - Login" scope="page"/>
<%@ include file="head.jspf" %>

<body>
    <div class="wrapper">
        <c:set var="currentPage" value="account" scope="page"/>
        <%@ include file="cus_header.jspf" %>
        
        <div class="main-container">
            <div class="left-image"></div>
            <div class="login-box">
                <h2>Log in</h2>
                <% if ("true".equals(request.getAttribute("err"))) { %>
                    <div class="error-message" style="color: red; text-align: center; margin-bottom: 10px;">
                        Invalid username or password.
                    </div>
                <% } %>
                <form action="${pageContext.request.contextPath}/account/login" method="post">
                    <input type="email" name="email" placeholder="Email" required>
                    <input type="password" name="password" placeholder="Password" required>
                    
                    <a href="#" class="forgot-pass-link">Forgot Password?</a>
                    
                    <button type="submit">Log in</button>
                    <button type="button" class="google-btn">Log in by Google</button>
                    
                    <p class="sign-in-text">Don't have an account?
                        <a href="signup" class="signup-link">Sign up</a> now!
                    </p>
                </form>
            </div>
        </div>
                    
        <%@ include file="cus_footer.jspf" %>
    </div>
</body>

</html>