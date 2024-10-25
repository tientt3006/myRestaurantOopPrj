
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
            <h2>Lời chào</h2>
            <div class="welcome">
                <div class="left">
                    <p>Chào mừng bạn đến với OOPDinner – nơi những món ăn ngon hòa quyện cùng trải nghiệm tuyệt vời! 
                        Chúng tôi rất hân hạnh được phục vụ bạn và mang đến những khoảnh khắc đáng nhớ.</p>    
                </div>
                <div class="right">
                    <img src="${pageContext.request.contextPath}/img/PRRestaurant.jpg" alt="Hình ảnh nhà hàng XYZ">
                </div>
            </div>
            
            <h2>Lời giới thiệu</h2>
            <div class ="introduce">
                <div class="left">
                    <img src="${pageContext.request.contextPath}/img/PRRestaurant.jpg" alt="Hình ảnh nhà hàng XYZ">    
                </div>
                <div class="right">
                    <p>OOPDinner không chỉ là một chuỗi nhà hàng, mà còn là nơi hội tụ tinh hoa ẩm thực từ khắp nơi. 
                        Với sự kết hợp giữa phong cách hiện đại và truyền thống, chúng tôi cam kết mang đến cho bạn những 
                        bữa ăn chất lượng cùng dịch vụ tận tâm.</p>
                </div>
            </div>
                
            <h2>Câu truyện</h2>
            <div class="story">
                <div class="left">
                    <p>OOPDinner khởi nguồn từ niềm đam mê ẩm thực và mong muốn kết nối mọi người qua từng bữa ăn. 
                        Từ một nhà hàng nhỏ, chúng tôi đã phát triển thành một chuỗi nhà hàng uy tín, luôn giữ vững 
                        giá trị cốt lõi: chất lượng, sáng tạo và sự sẻ chia.</p>    
                </div>
                <div class="right">
                    <img src="${pageContext.request.contextPath}/img/PRRestaurant.jpg" alt="Hình ảnh nhà hàng XYZ">
                </div>
            </div>
            
            <h2>Các thành viên</h2>
            <div class="member">
                <div class="left">
                    <img src="${pageContext.request.contextPath}/img/PRRestaurant.jpg" alt="Hình ảnh nhà hàng XYZ">
                </div>
                <div class="right">
                    <p>Nguyễn Đình Tiến - Bếp trưởng, chuyên gia ẩm thực Á - Âu</p>
                    <p>Hoàng Văn Hướng - Quản lý nhà hàng, người luôn theo sát trải nghiệm khách hàng</p>
                </div>
            </div>
        </div>
        <!-- Footer -->
        <%@ include file="cus_footer.jspf" %>
    </div>
</body>
</html>