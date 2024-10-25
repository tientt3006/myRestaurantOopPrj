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
            <div class="menu-container">
                <h2>Menu</h2>
                <p>Vui lòng đặt bàn để chọn món</p>
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
                        for (int i = 0; i < totalItems; i++) {
                            dishes[i] = "Món ăn " + (i + 1);  // Tên giả lập cho các món
                        }

                        // Hiển thị các món ăn của trang hiện tại
                        for (int i = startItem; i < endItem; i++) {
                     %>
                    <div class="menu-item">
                        <img src="${pageContext.request.contextPath}/img/PRRestaurant.jpg" alt="<%= dishes[i] %>">
                        <h3><%= dishes[i] %></h3>
                        <p>Chi tiết về món ăn <%= dishes[i] %></p>
                    </div>
                    <% } %>
                </div>

                <!-- Phân trang -->
                <div class="pagination">
                    <% if (currentPage > 1) { %>
                        <a href="?page=<%= (currentPage - 1) %>">Trang trước</a>
                    <% } %>

                    <% for (int i = 1; i <= totalPages; i++) { %>
                        <a href="?page=<%= i %>" 
                           style="<%= (i == currentPage) ? "font-weight: bold;" : "" %>">
                           <%= i %>
                        </a>
                    <% } %>

                    <% if (currentPage < totalPages) { %>
                        <a href="?page=<%= (currentPage + 1) %>">Trang sau</a>
                    <% } %>
                </div>
            </div>
        </div>        
                <!-- Footer -->
                <%@ include file="cus_footer.jspf" %>
            </div>
</body>
</html>                

