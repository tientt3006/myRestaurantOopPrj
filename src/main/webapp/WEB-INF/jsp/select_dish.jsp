<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.nolaneg.myrestaurantprj.db.entity.Dish"%>
<%@page import="com.nolaneg.myrestaurantprj.db.entity.Receipt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <!DOCTYPE html>
    <html lang="en">

    <c:set var="title" value="OOP Dinner - Select Dish" scope="page"/>
    <c:set var="currentPage" value="select_dish" scope="page"/>
    <%@ include file="head.jspf" %>

    <body>
        <div class="wrapper">
            <!-- Header Section -->
            <%@ include file="cus_header.jspf" %>
            <!-- Main Content Section -->
            <div class="main-container">
                <div class="select-container">
                   <!-- Bảng chọn món -->  
                    <div class="selected-items">
                        <h3>ORDER</h3>
                        <div class="cart-dishes" id="cart-dishes">
                            
                        </div>
                        <div class="total-and-save" style="align-content: space-between; display: flex">
                            <div class="total" id="total">
                                
                            </div>
                            <button class="save-button" onclick="saveOrder(${param.receipt_id})">SAVE</button>
                        </div>
                    </div>
                    
                    <!-- Danh sách món ăn -->
                    <div class="menu">
                        <c:forEach var="dish" items="${dishes}">
                            <div class="menu-item">
                                <img src="${pageContext.request.contextPath}/img/dish-${dish.dishId}.jpg" alt="${dish.dishName}">
                                <h3>${dish.dishName}</h3>
                                <p>${dish.ingredient}</p>
                                <p><fmt:formatNumber value="${dish.price}" type="number" groupingUsed="true" /> VND</p>
                                <button onclick="addToCart(${dish.dishId}, '${dish.dishName}', ${dish.price})">Select</button>
                            </div>
                        </c:forEach>
                    </div>
                    <a href="#top" class="back-to-top">^</a>
                </div>
            </div>
            <!-- Footer -->
            <%@ include file="cus_footer.jspf" %>
        </div>
                    
        <script>
            const contextPath = "${pageContext.request.contextPath}";
        </script>
        <script src = "${pageContext.request.contextPath}/js/addToCart.js">

        </script>
        <script>
            const initialCart = [];
            <c:forEach items="${receipt.dishesMap}" var="entry">
                <c:set var="dish" value="${entry.key}" />
                initialCart.push({
                    id: ${dish.dishId},
                    name: "${dish.dishName}",
                    price: ${dish.price},
                    quantity: ${entry.value}
                });
            </c:forEach>
            document.addEventListener("DOMContentLoaded", function () {
                cart = initialCart; // Gán dữ liệu từ `initialCart`
                renderCart(); // Hiển thị giỏ hàng
            });
        </script>
 
    </body>
    </html>                