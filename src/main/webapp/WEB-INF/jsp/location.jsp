
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
    
<c:set var="title" value="OOP Dinner - Location" scope="page"/>
<%@ include file="head.jspf" %>

<body>
    <div class="wrapper">
        <!-- Header Section -->
        <c:set var="currentPage" value="account" scope="page"/>
        <%@ include file="cus_header.jspf" %>
        <!-- Main-container -->
        <div class ="main-container">
            <div class="location-main">                
                <div class ="option">
                    <div onclick="showLocation(20.981559,105.787367)">Address 1: Hoc vien Cong nghe Buu chinh vien thong  </div>
                    <div onclick="showLocation(21.024135,105.8558972,813)">Address 2: Nha hat Lon Ha Noi </div>
                    <div onclick="showLocation(21.0580308,105.8032223,6502)">Address 3: Ho Tay </div>
                    <div onclick="showLocation(21.0173705,105.7827373,406)">Address 4: Keangnam </div>
                </div> 
                <div id="map" class="map"></div>
            </div>
        </div>
        
        <!-- Google Maps API -->
        <script>
            let map;
            let marker;

            function initMap() {
                // Vị trí mặc định ban đầu
                const defaultLocation = { lat: 21.028511, lng: 105.804817 };

                // Khởi tạo bản đồ
                map = new google.maps.Map(document.getElementById("map"), {
                    zoom: 12,
                    center: defaultLocation,
                });

                // Đặt marker tại vị trí mặc định
                marker = new google.maps.Marker({
                    position: defaultLocation,
                    map: map,
                });
            }

            // Hàm thay đổi vị trí marker và tâm bản đồ
            function showLocation(lat, lng) {
                const location = { lat: lat, lng: lng };
                marker.setPosition(location); // Cập nhật vị trí marker
                map.setCenter(location); // Cập nhật tâm bản đồ
            }
        </script>

        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyB-TdJcRDViUGjoJKNtmIpppOUp5RaC5Z8&callback=initMap" 
                async defer></script>
                
        <!-- Footer -->
        <%@ include file="cus_footer.jspf" %>
    </div>
</body>
</html>
