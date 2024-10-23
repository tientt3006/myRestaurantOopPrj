
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
        
        <!-- Main Content -->
        <div class="main-container">
            <div class="reservations-container">
                <div class="form-box">
                    <h2>Find A Table</h2>

                    <label for="branch">Branch Location</label>
                    <select id="branch" name="branch">
                        <option value="">làm thế nào đó chọn chi nhánh ở đây</option>
                    </select>

                    <label for="date">Date</label>
                    <input type="date" id="date" name="date" placeholder="làm thế nào đó chọn ngày ở đây">

                    <label for="time">Time</label>
                    <input type="time" id="time" name="time" placeholder="làm thế nào đó chọn giờ ở đây">

                    <label for="people">Number of people</label>
                    <input type="number" id="people" name="people" min="1" max="6" placeholder="làm thế nào đó chọn số người ở đây">

                    <p class="error-message">If there are more than six people, please reserve a second table</p>

                    <button type="submit">Search button</button>
                </div>
                
            </div>
        </div>

        <!-- Footer -->
        <%@ include file="cus_footer.jspf" %>
    </div>
</body>
</html>
