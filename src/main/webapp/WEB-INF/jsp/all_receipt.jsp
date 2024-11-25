<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en-GB">
    
<c:set var="title" value="OOP Dinner - Cart" scope="page"/>
<%@ include file="head.jspf" %>
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
            <div class="all-receipt">
                <div class="filter-option">
                    <form method="get" action="${pageContext.request.contextPath}/all_receipt">
                        <input type="text" name="search_name" placeholder="Tìm kiếm theo username" />
                        <input type="date" name="today" value="${requestScope.today}" />
                        <button type="submit">Filter</button>
                    </form>
                </div>

                
                <div class="content-receipt">
                    <p><strong>Branch:</strong> ${branchName}</p>
                    <c:forEach var="User" items="${Customers.keySet()}">
                        <p><strong>Customer's: </strong>${User.getFull_name()} - ${User.getEmail()} </p>
                        <table>
                            <tr>
                                <th>Receipt ID</th>
                                <th>Receipt's Information</th>
                                <th>Dishes</th>
                                <th>Status</th>
                                <th>Option</th>
                            </tr>
                            <c:forEach var="receipt" items="${Customers.get(User)}">
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
                                            <select name="status" onchange="updateStatus(${receipt.receiptId}, this.value, this)" data-original-value="${receipt.status}">
                                                <option ${receipt.status == "reserved" ? "selected" : ""} value="reserved">Reserved</option>
                                                <option ${receipt.status == "unpaid" ? "selected" : ""} value="unpaid">Unpaid</option>
                                                <option ${receipt.status == "paid" ? "selected" : ""} value="paid">Paid</option>
                                                <option ${receipt.status == "refunded" ? "selected" : ""} value="refunded">Refunded</option>
                                                <option ${receipt.status == "canceled" ? "selected" : ""} value="canceled">Canceled</option>
                                            </select>
                                        </td>
                                        <td>

                                            <div class="cart_css" style="display: flex; flex-direction: column; align-items: center; gap: 10px;">
                                                <form action="${pageContext.request.contextPath}/select_dish" method="GET">
                                                    <input type="hidden" name="receipt_id" value="${receipt.receiptId}">
                                                    <button type="submit">Change Dishes</button>
                                                </form>
                                                <form action="${pageContext.request.contextPath}/all_receipt" method="POST">
                                                    <input type="hidden" name="receipt_id" value="${receipt.receiptId}">
                                                    <input type="hidden" name="cancel_reser" value="true">
                                                    <button type="submit" style="width: 139.58px">Cancel</button>
                                                </form>    
                                            </div>

                                        </td>
                                    </tr>
                                </tbody>
                            </c:forEach>   
                        </table>
                    </c:forEach>
                </div>
            </div>     
        </div>              

        <!-- Footer -->
        <%@ include file="cus_footer.jspf" %>
    </div>
    <script>
        const contextPath = "${pageContext.request.contextPath}";
    </script>
    <script src = "${pageContext.request.contextPath}/js/updateStatus.js">

    </script>
</body>
</html>
