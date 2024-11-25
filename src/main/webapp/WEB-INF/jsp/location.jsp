<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
    
<c:set var="title" value="OOP Dinner - Location" scope="page"/>
<%@ include file="head.jspf" %>

<body>
    <div class="wrapper">
        <!-- Header Section -->
        <c:set var="currentPage" value="account" scope="page" />
        <%@ include file="cus_header.jspf" %>
        <!-- Main-container -->
        <div class="main-container">
            <div class="location-main">
                <div class="option">
                    <div id="address1" class="address" onclick="map(1, this)">Address 1: Post and Telecommunications Institute of Technology</div>
                    <div id="address2" class="address" onclick="map(2, this)">Address 2: Ha Noi Opera House</div>
                    <div id="address3" class="address" onclick="map(3, this)">Address 3: Ho Tay</div>
                    <div id="address4" class="address" onclick="map(4, this)">Address 4: Keangnam Landmark 72</div>
                </div>
                <div id="map" class="map"></div>
            </div>
        </div>

        <script src="${pageContext.request.contextPath}/js/findmap.js"></script>

        <script>
            window.onload = function() {
                var firstAddress = document.getElementById('address1');
                map(1, firstAddress);
            };
        </script>

        <!-- Footer -->
        <%@ include file="cus_footer.jspf" %>
    </div>
</body>
</html>
