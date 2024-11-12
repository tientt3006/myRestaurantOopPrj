<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
    
<c:set var="title" value="OOP Dinner - Find Table" scope="page"/>
<%@ include file="head.jspf" %>
    
<body>
    <div class="wrapper">
        <!-- Header Section -->
        <c:set var="currentPage" value="find_table" scope="page"/>
        <%@ include file="cus_header.jspf" %>
        
        <!-- Main Content -->
        <div class="main-container">
            <%--<jsp:useBean id="branchs" scope="session" type="java.util.List"/>--%>
            <div class="login-container findTable-container">
                <div class="findTable-box login-box">
                    <h2>Find A Table</h2>
                    <% if ("outOfTable".equals(request.getParameter("failure"))) { %>
                        <div class="error-message" style="color: red; text-align: center; margin-bottom: 10px;">
                            Out of table at the time you picked.
                        </div>
                    <% } %>
                    <form id="findTableForm" action="${pageContext.request.contextPath}/find_table" method="post"  onsubmit="return validateNumOfTables()">
                        
                        <p class="password-text"> Branch: </p>
                        <select name="branch" required>
                            <c:forEach var="branch" items="${branchs}">
                                <option ${param.branch == branch.branchId ? "selected" : ""} value="${branch.branchId}">
                                        ${branch.location}
                                </option>
                            </c:forEach>
                        </select>
                        
                        <p class="password-text"> Date: </p>
                        <input type="date" name="date" required>
                        
                        <p class="password-text"> Time: </p>
                        <input type="time" name="time" required>
                        
                        <p class="password-text"> Number Of People: </p>
                        <input type="number" name="people" min="1" max="300" value="1" required>
                        
                        <p class="password-text"> Number Of Tables: </p>
                        <input type="number" name="tables" min="1" max="50" value="1" required>
                        
                        <p style="color: white; text-align: center; font-size: 14px;">Maximum 6 people per table.</p>
                        
                        <button type="submit">Search</button>
                        
                    </form>

                </div>
                
            </div>
        </div>

        <!-- Footer -->
        <%@ include file="cus_footer.jspf" %>
    </div>
    
    <!-- JavaScript code -->
    <script>
        // Auto-increase tables based on the number of people
        document.querySelector('input[name="people"]').addEventListener('input', function() {
            const numPeople = parseInt(this.value) || 0;
            const numTables = Math.ceil(numPeople / 6);
            const tablesInput = document.querySelector('input[name="tables"]');
            
            tablesInput.value = numTables; 
            tablesInput.min = numTables;
        });
        // Auto date time
        document.addEventListener("DOMContentLoaded", function() {
            const dateInput = document.querySelector('input[name="date"]');
            const timeInput = document.querySelector('input[name="time"]');

            // Lấy ngày hiện tại
            const now = new Date();
            const today = now.toISOString().split('T')[0];

            // Đặt ngày hiện tại làm giá trị mặc định cho ô Date
            dateInput.value = today;
            dateInput.setAttribute('min', today);

            // Đặt giờ mặc định là 5 giờ chiều (17:00) cho ô Time
            timeInput.value = "17:00";
            timeInput.setAttribute('min', "17:00");
            timeInput.setAttribute('max', "23:00");

            // Nếu người dùng chọn ngày hôm nay, giới hạn giờ bắt đầu từ giờ hiện tại hoặc 17:00
            dateInput.addEventListener('change', function() {
                if (this.value === today) {
                    const currentHour = now.getHours();
                    const currentTime = now.toTimeString().slice(0, 5);
                    timeInput.setAttribute('min', currentTime < "17:00" ? "17:00" : currentTime);
                } else {
                    timeInput.setAttribute('min', "17:00");
                }
            });
        });
    </script>
</body>
</html>
