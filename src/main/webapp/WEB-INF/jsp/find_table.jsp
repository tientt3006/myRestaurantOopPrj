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
                    <% if ("true".equals(request.getParameter("out_of_table"))) { %>
                        <div class="error-message" style="color: red; text-align: center; margin-bottom: 10px;">
                            Out of table at the time you picked.
                        </div>
                    <% } %>
                    <form id="findTableForm" action="${pageContext.request.contextPath}/find_table" method="post"  onsubmit="return validateTime()">
                        
                        <p class="password-text"> Branch: </p>
                        <select name="branch" required>
                            <c:forEach var="branch" items="${applicationScope.branchs}">
                                <option ${param.branch == branch.branchId ? "selected" : ""} value="${branch.branchId}">
                                        ${branch.location}
                                </option>
                            </c:forEach>
                        </select>
                        
                        <p class="password-text"> Date: </p>
                        <input type="date" name="date" required>
                        
                        <p class="password-text"> Time: </p>
                        <input type="time" name="time" min="17:00" max="23:00" required>
                        
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

            const now = new Date();
            const nowPlusOneMinute = new Date(now);
            nowPlusOneMinute.setMinutes(now.getMinutes() + 5);
            const currentTimePlusOneMinute = nowPlusOneMinute.toTimeString().slice(0, 5);
            const currentTime = now.toTimeString().slice(0, 5);
            //const today = now.toISOString().split('T')[0];
            const today = now.toLocaleDateString('en-CA');
            
            const nextDayDate = new Date();
            nextDayDate.setDate(now.getDate() + 1);
            //const nextDay = nextDayDate.toISOString().split('T')[0];
            const nextDay = nextDayDate.toLocaleDateString('en-CA');

//            console.log("Múi giờ hiện tại:", Intl.DateTimeFormat().resolvedOptions().timeZone);
//            console.log("Giờ hiện tại:", now, currentTime);
//            console.log("Ngày hiện tại:", today, currentTime);
//            console.log("Ngày hôm sau:", nextDay);

            if (now.getHours() >= 23) {
                dateInput.value = nextDay;
                dateInput.setAttribute('min', nextDay);
                timeInput.setAttribute('min', "17:00");
            } else {
                dateInput.value = today;
                dateInput.setAttribute('min', today);
                timeInput.setAttribute('min', currentTime < "17:00" ? "17:00" : currentTime);
            }
            timeInput.value = ((currentTime < "17:00" || currentTime > "23:00") ? "17:00" : currentTimePlusOneMinute);
        });
        function validateTime() {
            const dateInput = document.querySelector('input[name="date"]').value;
            const timeInput = document.querySelector('input[name="time"]').value;
            const selectedDate = new Date(dateInput + 'T' + timeInput);

            const now = new Date();
            const minTime = new Date(dateInput + 'T17:00');
            const maxTime = new Date(dateInput + 'T23:00');

            if (selectedDate < now) {
                alert("The selected date and time must not be in the past.");
                return false;
            }

            if (selectedDate < minTime || selectedDate > maxTime) {
                alert("The selected time must be between 17:00 and 23:00.");
                return false;
            }

            return true;
        };
    </script>
</body>
</html>
