<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="en-GB">
    
<c:set var="title" value="OOP Dinner - Cart" scope="page"/>
<%@ include file="head.jspf" %>
<head>
    <title>Quản lý hóa đơn đặt bàn</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid black;
            padding: 8px;
        }
        th {
            background-color: #f2f2f2;
        }
        .action-btn {
            padding: 5px 10px;
            margin: 2px;
            cursor: pointer;
        }
    </style>
</head>  

<body>
    <div class="wrapper">
        <!-- Header Section -->
        
        <c:set var="currentPage" value="cart" scope="page"/>
        <%@ include file="cus_header.jspf" %>

        <!-- Main Content -->
        <div class="main-container">
            <% String errorMessage = (String) request.getAttribute("errorMessage"); %>
            <% if (errorMessage != null) { %>
                <script>
                    alert('<%= errorMessage %>');
                </script>
            <% } %>
            <div class="cart">

                <table>
                    <tr>
                        <th>Recipt ID</th>
                        <th>Receipt's Information</th>
                        <th>Dishes</th>
                        <th>Status</th>
                        <th>Option</th>
                    </tr>
                    <c:forEach var="receipt" items="${receipts}">
                        <tbody>
                            <tr>
                                <td>Number ${receipt.receiptId}</td>
                                <td>
                                    <strong>Create Date:</strong> ${receipt.createDate}<br>
                                    <strong>Number Of Tables: </strong> <fmt:formatNumber value="${receipt.reservationFee / 100000}" maxFractionDigits="0" /><br>
                                    <strong>Number Of People:</strong> ${receipt.numOfPeople}<br>
                                    <strong>Date reserved:</strong> ${receipt.reservationDate}<br>
                                    <strong>Time reserved:</strong> ${receipt.reservationTime}<br>
                                    <strong>Reservation Fee:</strong> <fmt:formatNumber value="${receipt.reservationFee}" type="number" groupingUsed="true" /> VND<br>
                                    <strong>Food Cost:</strong> <fmt:formatNumber value="${receipt.foodCost}" type="number" groupingUsed="true" /> VND<br>
                                    <strong>Total Fee:</strong> <fmt:formatNumber value="${receipt.reservationFee + receipt.foodCost}" type="number" groupingUsed="true" /> VND<br>
                                    <strong>Branch:</strong> ${receipt.branch.location}
                                </td>
                                <td>
                                    <c:forEach var="dish" items="${receipt.dishes}">
                                        <div>${dish.dishName}</div>
                                    </c:forEach>
                                </td>
                                <td>
                                    <div><strong>${receipt.status}</strong></div>
                                </td>
                                <td>
                                    
                                    <div class="cart_css" style="display: flex; flex-direction: column; align-items: center; gap: 10px;">
                                        <form action="${pageContext.request.contextPath}/select_dish" method="GET">
                                            <input type="hidden" name="receipt_id" value="${receipt.receiptId}">
                                            <button type="submit">Change Dishes</button>
                                        </form>
                                        <form action="${pageContext.request.contextPath}/cart" method="POST">
                                            <input type="hidden" name="receipt_id" value="${receipt.receiptId}">
                                            <button type="submit" style="width: 139.58px">Cancel</button>
                                        </form>    
                                    </div>
                                        
                                </td>
                            </tr>
                        </tbody>
                    </c:forEach>   
                </table>
                
            </div>
            
        </div>

        <!-- Footer -->
        <%@ include file="cus_footer.jspf" %>
    </div>
    
</body>
</html>
