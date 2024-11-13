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
                            <p>${dish.price} VNĐ</p>
                            <!-- Thêm dấu nháy đơn quanh tên món ăn -->
                            <button onclick="addToCart('${dish.dishName}', ${dish.price})">Select</button>
                        </div>
                    </c:forEach>
                </div> 

                <!-- Bảng chọn món -->
                <div class="selected-items">
                    <h3>Chọn món cho bàn số 01</h3>
                    <div id="cart-items">
                        <!-- Các món được chọn sẽ hiển thị ở đây -->
                    </div>
                    <button class="save-button" onclick="saveOrder()">SAVE</button>
                </div>

                <script>
                    let cart = [];

                    // Lấy contextPath từ JSP
                    const contextPath = '<%= request.getContextPath() %>';

                    // Hàm thêm món vào giỏ hàng
                    function addToCart(dish, price) {
                        console.log("Tên món:", dish, "Giá:", price); // Kiểm tra xem tên món và giá có được truyền đúng không

                        const item = {
                            name: dish,
                            price: price,
                            quantity: 1
                        };


                        // Kiểm tra nếu món đã tồn tại trong giỏ hàng
                        const existingItem = cart.find(cartItem => cartItem.name === dish);
                        if (existingItem) {
                            existingItem.quantity += 1;  // Tăng số lượng
                        } else {
                            cart.push(item);
                        }

                        // Cập nhật giao diện giỏ hàng
                        renderCart();
                    }

                    // Hàm render giỏ hàng
                    function renderCart() {
                        const cartItemsDiv = document.getElementById('cart-items');
                        cartItemsDiv.innerHTML = '';  // Xóa nội dung cũ

                        let totalAmount = 0; // Tổng tiền giỏ hàng

                        cart.forEach((item, index) => {
                            const itemTotal = item.price * item.quantity; // Tổng tiền của món
                            totalAmount += itemTotal; // Cộng dồn vào tổng tiền giỏ hàng

                            cartItemsDiv.innerHTML += `
                                <div class="selected-item">
                                    <img src="${contextPath}/img/PRRestauant.jpg" alt="${item.name}">
                                    <span>${item.name}</span>
                                    <input type="number" value="${item.quantity}" min="1" onchange="updateQuantity(${index}, this.value)">
                                    <span>${itemTotal} VND</span>
                                    <button onclick="removeFromCart(${index})">Remove</button>
                                </div>
                            `;
                        });

                        // Hiển thị tổng tiền giỏ hàng
                        cartItemsDiv.innerHTML += `
                            <div class="total-amount">
                                <strong>Total: ${totalAmount} VND</strong>
                            </div>
                        `;
                    }

                    // Hàm cập nhật số lượng
                    function updateQuantity(index, quantity) {
                        cart[index].quantity = parseInt(quantity);
                        renderCart();
                    }

                    // Hàm xóa món khỏi giỏ hàng
                    function removeFromCart(index) {
                        cart.splice(index, 1);  // Xóa 1 phần tử tại vị trí index
                        renderCart();
                    }

                    // Hàm lưu đơn hàng
                    function saveOrder() {
                        const order = JSON.stringify(cart);
                        alert("Đơn hàng đã được lưu: " + order);
                    }
                </script>

            </div>
        </div>        
        <!-- Footer -->
        <%@ include file="cus_footer.jspf" %>
    </div>
</body>
</html>                
