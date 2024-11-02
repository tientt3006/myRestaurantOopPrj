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
            <div class="select-container">
                <!-- Danh sách món ăn -->
                <div class="menu">
                    <c:forEach var="dish" items="${dishes}">
                        <div class="menu-item">
                            <img src="${pageContext.request.contextPath}/img/dish-${dish.dishId}.jpg" alt="${dish.dishName}">
                            <h3>${dish.dishName}</h3>
                            <p>${dish.ingredient}</p>
                            <p>${dish.price} VND</p>
                            <button onclick="addToCart(${dish.dishId}, '${dish.dishName}', ${dish.price})">Select</button>
                        </div>
                    </c:forEach>
                </div>
                      
<!--            Bảng chọn món -->  
                <div class="selected-items">
                    <h3>Chọn món cho bàn số 01</h3>
                    <div class="cart-dishes" id="cart-dishes">
                    </div>
                    <div class="total-and-save">
                        <div>
                          
                        </div>
                        <div class="total" id="total">
                        </div>
                        <button class="save-button" onclick="saveOrder()">SAVE</button>
                    </div>
                    
                </div>
                <a href="#top" class="back-to-top">^</a>
            </div>
            <script>
                const contextPath = "${pageContext.request.contextPath}";
            </script>
            <script src = "${pageContext.request.contextPath}/js/addToCart.js">
                
            </script>
            

            </div>
        </div>        
                <!-- Footer -->
                <%@ include file="cus_footer.jspf" %>
    </div>
</body>
</html>                

