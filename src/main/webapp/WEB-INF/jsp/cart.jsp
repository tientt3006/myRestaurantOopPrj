<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en-GB">
    

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
            text-align: center;
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
<c:set var="title" value="OOP Dinner - Cart" scope="page"/>
<body>
    <div class="wrapper">
        <!-- Header Section -->
        
        <c:set var="currentPage" value="cart" scope="page"/>
        <%@ include file="cus_header.jspf" %>
        
        <!-- Main Content -->
        <div class="main-container">
            <div class="cart">
                <table>
                    <tr>
                        <th>Invoice</th>
                        <th>Table Number</th>
                        <th>Date</th>
                        <th>Time</th>
                        <th>Number of People</th>
                        <th>Reservation Deposit</th>
                        <th>Amount Due</th>
                        <th>Total Amount</th>
                        <th>Payment Status</th>
                        <th>Dishes</th>
                    </tr>
                    <c:forEach var="dish" items="${dishes}">
                    <tr>
                    
                        <td>${dish.dishName} </td>
                        <td>${dish.dishName} </td>
                        <td>${dish.dishName} </td>
                        <td> ${dish.dishName}</td>
                        <td>${dish.dishName} </td>
                        <td>${dish.dishName} </td>
                        <td>${dish.dishName} </td>
                        <td>${dish.dishName} </td>
                        <td>
                            <select name="paymentStatus">
                                <option value="booked">Booked</option>
                                <option value="unpaid">Unpaid</option>
                                <option value="paid">Paid</option>
                                <option value="cancelled">Cancelled</option>
                            </select>
                        </td>
                        <td>
                            <c:forEach var="dish" items="${dishes}">
                                ${dish.dishName} 
                            </c:forEach> 
                             
                        </td>
                        <td><button class="action-btn" onclick="changeDishes()">Change Dishes</button></td>
                        <td><button class="action-btn" onclick="cancelReservation()">Cancel Reservation</button></td>
                        
                                              
                    </tr>
                    </c:forEach> 

                    <!-- Bạn có thể thêm nhiều hàng khác vào đây nếu cần -->

                </table>
                
            </div>
            
        </div>

        <!-- Footer -->
        <%@ include file="cus_footer.jspf" %>
    </div>
    
   <script>
    function changeDishes() {
        alert("Thay đổi món ăn!");
        // Thêm mã xử lý thay đổi món ăn ở đây
    }

    function cancelReservation() {
        if (confirm("Bạn có chắc muốn hủy đặt bàn?")) {
            alert("Đã hủy đặt bàn!");
            // Thêm mã xử lý hủy đặt bàn ở đây
        }
    }
</script>
    
</body>
</html>
