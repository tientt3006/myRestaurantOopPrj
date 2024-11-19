<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
    
<c:set var="title" value="OOP Dinner - Account" scope="page"/>
<%@ include file="head.jspf" %>

<body>
    <div class="wrapper">
        <!-- Header Section -->
        <c:set var="currentPage" value="account" scope="page"/>
        <%@ include file="cus_header.jspf" %>

        <!-- Main Content Section -->
        
        <div class="main-container">
            <div class="login-container">
                <div class="login-box account-box">
                    <h2>Your Account</h2>
                    <div class="info-row">
                        <div class="info-label">Your Name:</div>
                        <div class="info-value">${user.full_name}</div>
                    </div>
                    <div class="info-row">
                        <div class="info-label">Your Email:</div>
                        <div class="info-value">${user.email}</div>
                    </div>
                    <div class="info-row">
                        <div class="info-label">Your Phone Number:</div>
                        <div class="info-value">${user.phone}</div>
                    </div>

                    <div class = "button-container">
                        <form action="${pageContext.request.contextPath}/account/change_info" method="get">
                            <button type="submit" class="btn">Change Info</button>
                        </form>
                        <form action="${pageContext.request.contextPath}/account/change_password" method="get">
                            <button type="submit" class="btn">Change Password</button>
                        </form>

                        <form action="${pageContext.request.contextPath}/account" method="get">
                            <input type="hidden" name="logout" value="true">
                            <button type="submit" class="btn">Logout</button>
                        </form> 
                    </div>
                </div>
            </div>      
        </div>
        <!-- Footer Section -->
        <%@ include file="cus_footer.jspf" %>
    </div>
</body>
</html>
