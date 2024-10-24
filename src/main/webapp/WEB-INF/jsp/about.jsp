
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
            <h2>About</h2>
            <p>Lời chào</p>
            <p>Lời giới thiệu</p>
            <p>câu truyện</p>
            <p>Thông tin liên hệ</p>
            <p>Địa điểm các chi nhánh</p>
            <p>các thành viên chủ chốt nhà hàng, đầu bếp, ...</p>
            <p>Lời chào</p>
            <p>Lời giới thiệu</p>
            <p>câu truyện</p>
            <p>Thông tin liên hệ</p>
            <p>Địa điểm các chi nhánh</p>
            <p>các thành viên chủ chốt nhà hàng, đầu bếp, ...</p>
        </div>
        <!-- Footer -->
        <%@ include file="cus_footer.jspf" %>
    </div>
</body>
</html>