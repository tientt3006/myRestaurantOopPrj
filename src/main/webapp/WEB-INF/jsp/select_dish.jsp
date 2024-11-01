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
                        <div class="menu-item" data-id="${dish.dishId}" data-name="${dish.dishName}" data-price="${dish.price}">
                            <img src="${pageContext.request.contextPath}/img/dish-${dish.dishId}.jpg" alt="${dish.dishName}">
                            <h3>${dish.dishName}</h3>
                            <p>${dish.ingredient}</p>
                            <p>${dish.price} VNĐ</p>
                            <button onclick="addToCart(${dish.dishId}, '${dish.dishName}', ${dish.price})">Select</button>
                        </div>
                    </c:forEach>
                </div>
                      
<!--            Bảng chọn món -->  
                <div class="selected-items">
                    <h3>Chọn món cho bàn số 01</h3>
                    <div id="cart-dishes">
                    </div>
                    <button class="save-button" onclick="saveOrder()">SAVE</button>
                </div>
            </div>
            
            <script>
                let cart = [];
                // Hàm thêm món vào giỏ hàng
                function addToCart(id, name, price) {
                    
                    const item = {
                        id: parseInt(id),
                        name: name,
                        price: parseInt(price),
                        quantity: 1
                    };
                    const existingItem = cart.find(cartItem => cartItem.name === name);
                    if (existingItem) {
                        existingItem.quantity += 1;  // Tăng số lượng
                    } else {
                        cart.push(item);
                    }
                    
                    renderCart();
                }
                function renderCart() {
                    const cartItemsDiv = document.getElementById("cart-dishes");
                    cartItemsDiv.innerHTML = "";  
                    cart.forEach((item, index) => {
                        const id = item.id;
                        cartItemsDiv.innerHTML += `
                            <div class="cart-dish">
                                <img src="${pageContext.request.contextPath}/img/dish-${id}.jpg" alt="${item.name}">
                                <span>${item.name}</span>
                                <input type="number" value="${item.quantity}" min="1" onchange="updateQuantity(${index}, this.value)">
                                <span>${item.quantity * item.price} VND</span>
                                <button onclick="removeFromCart(${index})">Remove</button>
                            </div>
                        `;
                    });
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
                    // Chuyển giỏ hàng thành JSON để gửi về server
                    const order = JSON.stringify(cart);
                    alert("Đơn hàng đã được lưu: " + order);

                    // Ở đây bạn có thể dùng AJAX để gửi đơn hàng về server
                }
            </script>

            </div>
        </div>        
                <!-- Footer -->
                <%@ include file="cus_footer.jspf" %>
    </div>
</body>
</html>                

