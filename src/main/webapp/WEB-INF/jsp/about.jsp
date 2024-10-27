
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
        <!--Main content -->
        <div class="about-content">
            <h2>Welcome</h2>
            <div class="welcome">
                <div class="left">
                    <p>Welcome to OOPDinner – where delicious cuisine meets exceptional experiences!</p>
                    <p>We are delighted to serve you and bring you unforgettable moments.</p>    
                </div>
                <div class="right">
                    <img src="${pageContext.request.contextPath}/img/about-welcome-transformed.jpeg" alt="Hình ảnh nhà hàng XYZ">
                </div>
            </div>
            
            <h2>Introduce</h2>
            <div class ="introduce">
                <div class="left">
                    <img src="${pageContext.request.contextPath}/img/about-introduce.webp" alt="Hình ảnh nhà hàng XYZ">    
                </div>
                <div class="right">
                    <p>OOPDinner is not just a restaurant chain but a hub of culinary excellence from around the world. With a blend of modern and traditional styles, we are committed to providing you with high-quality meals and dedicated service.</p>
                </div>
            </div>
                
            <h2>Our Story</h2>
            <div class="story">
                <div class="left">
                    <p>OOPDinner was born from a passion for cuisine and the desire to connect people through every meal.</p>
                    <p> Starting as a small restaurant, we have grown into a renowned chain, staying true to our core values: quality, creativity, and sharing.</p>    
                </div>
                <div class="right">
                    <img src="${pageContext.request.contextPath}/img/about-story.webp" alt="Hình ảnh nhà hàng XYZ">
                </div>
            </div>
            
            <h2>Our Members</h2>
            <div class="member">
                <div class="left">
                    <img src="${pageContext.request.contextPath}/img/about-member.jpg" alt="Hình ảnh nhà hàng XYZ">
                </div>
                <div class="right">
                    <p>Nguyen Dinh Tien - Head Chef & Specialist in Asian and European Cuisine</p>
                    <p>Hoang Van Huong - Restaurant Manager, dedicated to ensuring exceptional customer experiences.</p>
                </div>
            </div>
        </div>
        <!-- Footer -->
        <%@ include file="cus_footer.jspf" %>
    </div>
</body>
</html>