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
                        <input type="number" name="people" min="1" max="300" required>
                        
                        <p class="password-text"> Number Of Tables: </p>
                        <input type="number" name="tables" min="1" max="50" required>
                        
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

//        // Restrict past dates and times
//        document.addEventListener("DOMContentLoaded", function() {
//            const dateInput = document.querySelector('input[name="date"]');
//            const timeInput = document.querySelector('input[name="time"]');
//
//            const now = new Date();
//            const today = now.toISOString().split('T')[0];
//            dateInput.setAttribute('min', today);
//
//            dateInput.addEventListener('change', function() {
//                if (this.value === today) {
//                    const currentTime = now.toTimeString().slice(0, 5);
//                    timeInput.setAttribute('min', currentTime);
//                } else {
//                    timeInput.removeAttribute('min');
//                }
//            });
//        });
        // Restrict past dates and times and limit time input to 5 PM - 11 PM
//        document.addEventListener("DOMContentLoaded", function() {
//            const dateInput = document.querySelector('input[name="date"]');
//            const timeInput = document.querySelector('input[name="time"]');
//
//            // Restrict date to today and future dates only
//            const now = new Date();
//            const today = now.toISOString().split('T')[0];
//            dateInput.setAttribute('min', today);
//
//            dateInput.addEventListener('change', function() {
//                const selectedDate = this.value;
//                const currentTime = now.toTimeString().slice(0, 5);
//
//                // Limit time selection to 17:00 (5 PM) to 23:00 (11 PM)
//                timeInput.setAttribute('min', selectedDate === today ? Math.max("17:00", currentTime) : "17:00");
//                timeInput.setAttribute('max', "23:00");
//
//                // Reset time if it doesn't fall within the allowed range
//                if (timeInput.value && (timeInput.value < timeInput.min || timeInput.value > timeInput.max)) {
//                    timeInput.value = "";
//                }
//            });
//        });
        document.addEventListener("DOMContentLoaded", function() {
            const dateInput = document.querySelector('input[name="date"]');
            const timeInput = document.querySelector('input[name="time"]');

            const now = new Date();
            const today = now.toISOString().split('T')[0];
            const currentHour = now.getHours();

            // Check if it's past 11 PM, if so, set the minimum date to tomorrow
            if (currentHour >= 23) {
                const tomorrow = new Date(now);
                tomorrow.setDate(now.getDate() + 1);
                dateInput.setAttribute('min', tomorrow.toISOString().split('T')[0]);
            } else {
                dateInput.setAttribute('min', today);
            }

            // Restrict time selection from 5 PM to 11 PM
            dateInput.addEventListener('change', function() {
                if (this.value === today && currentHour < 23) {
                    const currentTime = now.toTimeString().slice(0, 5);
                    timeInput.setAttribute('min', currentTime < "17:00" ? "17:00" : currentTime);
                } else {
                    timeInput.setAttribute('min', "17:00");
                }
                timeInput.setAttribute('max', "23:00");
            });
        });
    </script>
</body>
</html>
