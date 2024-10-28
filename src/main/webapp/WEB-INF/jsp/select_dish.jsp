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
                    <% 
                        // Tổng số món ăn (giả sử)
                        int totalItems = 32; 

                        // Số món ăn hiển thị trên mỗi trang
                        int itemsPerPage = 8;

                        // Tổng số trang
                        int totalPages = (int) Math.ceil((double) totalItems / itemsPerPage);

                        // Lấy trang hiện tại từ URL (mặc định là trang 1)
                        String pageParam = request.getParameter("page");
                        int currentPage = (pageParam != null) ? Integer.parseInt(pageParam) : 1;

                        // Tính toán món ăn bắt đầu và kết thúc cho trang hiện tại
                        int startItem = (currentPage - 1) * itemsPerPage;
                        int endItem = Math.min(startItem + itemsPerPage, totalItems);

                        // Giả sử danh sách món ăn là một mảng (hoặc lấy từ database)
                        String[] dishes = new String[totalItems];
                        int[] prices = new int[totalItems];
                        for (int i = 0; i < totalItems; i++) {
                            dishes[i] = "Món ăn " + (i + 1);  // Tên giả lập cho các món
                            prices[i] = 10000;
                        }

                        // Hiển thị các món ăn của trang hiện tại
                        for (int i = startItem; i < endItem; i++) {
                     %>
                    <div class="menu-item">
                        <img src="${pageContext.request.contextPath}/img/PRRestauant.jpg" alt="<%= dishes[i] %>">
                        <h3><%= dishes[i] %></h3>
                        <p><%= prices[i] %> VND</p>
                        <button onclick="addToCart('<%= dishes[i] %>', <%= prices[i] %>)">Select</button>
                    </div>
                    <% } %>
                </div>

                <!-- Bảng chọn món -->
                <div class="selected-items">
                    <h3>Chọn món cho bàn số 01</h3>
                    <div id="cart-items">
                        <!-- Các món được chọn sẽ hiển thị ở đây -->
                    </div>
                    <button class="save-button" onclick="saveOrder()">SAVE</button>
                </div>
            </div>

            <script>
                let cart = [];

                // Hàm thêm món vào giỏ hàng
                function addToCart(dish, price) {
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

                    cart.forEach((item, index) => {
                        cartItemsDiv.innerHTML += `
                            <div class="selected-item">
                                <img src="path/to/your/image.jpg" alt="${item.name}">
                                <span>${item.name}</span>
                                <input type="number" value="${item.quantity}" min="1" onchange="updateQuantity(${index}, this.value)">
                                <span>${item.price * item.quantity} VND</span>
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

