
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
    
<c:set var="title" value="OOP Dinner - Log in" scope="page"/>
<%@ include file="head.jspf" %>

<body>
    <div class="wrapper">
        <!-- Header Section -->
        <c:set var="currentPage" value="account" scope="page"/>
        <%@ include file="cus_header.jspf" %>
        
        <!-- Main Content Section -->
        <div class="main-container">
            <div class = "home-main">
                <div class="main-container">
                    <div class="illustration">
                        <img src="${pageContext.request.contextPath}/img/PRRestaurant.jpg" alt="Hình ảnh nhà hàng XYZ">
                    </div>
                    <div class="intro">
                        <p>Chào mừng đến với OOP Dinner</p>
                        <p>Giờ hoạt động: 5 PM - 11 PM</p>
                    </div>
                </div>
            </div> 
        </div>        
        <!-- Footer -->
        <%@ include file="cus_footer.jspf" %>
    </div>
</body>
</html>
