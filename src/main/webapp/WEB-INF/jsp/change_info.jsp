<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.nolaneg.myrestaurantprj.db.entity.User"%>

<!DOCTYPE html>
<html lang="en">
    
<c:set var="title" value="OOP Dinner - Change Info" scope="page"/>
<%@ include file="head.jspf" %>

<body>
    <div class="wrapper">
        <!-- Header Section -->
        <c:set var="currentPage" value="change_info" scope="page"/>
        <%@ include file="cus_header.jspf" %>

        <!-- Main Content Section -->
        <div class="main-container">
            <div class="login-container">
                <div class="login-box">
                    <h2>Change infor</h2>
                    <% if ("duplicate".equals(request.getParameter("err"))) { %>
                        <div class="error-message" style="color: red; text-align: center; margin-bottom: 10px;">
                            Duplicate new email or new phone.
                        </div>
                    <% } %>
                    <c:choose>
                        <c:when test="${sessionScope.user != null}">
                            <!--<form action="${pageContext.request.contextPath}/account/change_info" method="post">-->
                            <form action="<c:url value='/account/change_info' />" method="post">
                                <p class="email-text"> First name </p>
                                <input type="text" id="firstName" name="firstName" value="${sessionScope.user.firstName}" required>                        

                                <p class="email-text"> Last name </p>
                                <input type="text" id="lastName" name="lastName" value="${sessionScope.user.lastName}" required>

                                <p class="password-text"> Email </p>
                                <input type="email" id="email" name="email" value="${sessionScope.user.email}" required>

                                <p class="password-text"> Phone </p>
                                <input type="tel" id="phone" name="phone" value="${sessionScope.user.phone}" pattern="[0-9]+" minlength="10" maxlength="10" required>

                                <button type="submit">Save change</button>
                            </form>
                        </c:when>
        
                        <c:otherwise>
                            <p>Your session has expired. Please <a href="<c:url value='/login' />">log in</a> again.</p>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>

        <!-- Footer Section -->
        <%@ include file="cus_footer.jspf" %>
    </div>
    
</body>

</html>
