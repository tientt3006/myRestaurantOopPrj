<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="en">
    
<c:set var="title" value="OOP Dinner - Complete Reservation" scope="page"/>
<%@ include file="head.jspf" %>
    
<body>
    <div class="wrapper">
        <!-- Header Section -->
        <c:set var="currentPage" value="complete_reservation" scope="page"/>
        <%@ include file="cus_header.jspf" %>
        
        <!-- Main Content -->
        <div class="main-container">
            <div class="login-container cpl-reser-container" style="align-items: flex-start;">

                <div class="cpl-reser-box login-box" style="color: white;">
                    <h2>Reservation successful</h2>
                    <p><strong>Selected Table(s):</strong>  <fmt:formatNumber value="${receipt.reservationFee / 100000}" maxFractionDigits="0" /></p>
                    <p><strong>Number of People:</strong> ${receipt.numOfPeople}</p>
                    <p><strong>Date:</strong> ${receipt.reservationDate}</p>
                    <p><strong>Time:</strong> ${receipt.reservationTime}</p>
                    <p><strong>Branch:</strong> ${receipt.branch.location}</p>
                    <p><strong>Deposit Amount:</strong> <fmt:formatNumber value="${receipt.reservationFee}" type="number" groupingUsed="true" /> VND</p>
                    <p style="text-align: center;">You can choose your dishes now or review your reserved tables.</p>
                    <div style="display: flex; gap: 20px;">
                    <a href="${pageContext.request.contextPath}/select_dish?receipt_id=${receipt.receiptId}">Select Dish</a>
                    <a href="${pageContext.request.contextPath}/cart">Go to cart</a>
                    </div>
                </div>
                
            </div>
        </div>
        <!-- Footer -->
        <%@ include file="cus_footer.jspf" %>
    </div>
    
</body>
</html>
