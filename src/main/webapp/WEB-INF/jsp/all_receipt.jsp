<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
            <div class="all-receipt">
                <div class="filter-option">
                    <input type="text" placeholder="Tìm kiếm theo user/email/số điện thoại" />
                    <input type="date" />
                    <button>Filter</button>
                </div>

                
                <div class="content-receipt">
                    <p><strong>Branch:</strong> ${branchName}</p>
                    <c:forEach var="User" items="${Customers.keySet()}">
                        <p><strong>Customer's: </strong>${User.getFull_name()} - ${User.getEmail()} </p>
                        <table>
                            <thead>
                                <tr>
                                    <th>Recipt ID</th>
                                    <th>Table's Information</th>
                                    <th>Status</th>
                                    <th>Dishes</th>
                                    <th>Option</th>
                                </tr>
                            </thead>
                            <c:forEach var="receipt" items="${Customers.get(User)}">
                                <tbody>
                                    <tr>
                                        <td>Number ${receipt.getReceiptId()}</td>
                                        <td>
                                            Tables: ${receipt.reservationFee/100000}<br>
                                            Peoples: ${receipt.numOfPeople}<br>
                                            Date: ${receipt.reservationDate}<br>
                                            Reserved Fee: ${receipt.reservationFee}<br>
                                            Total Fee: ${receipt.reservationFee + receipt.foodCost}
                                        </td>
                                        <td>
                                            <select>
                                                <option>Reserved</option>
                                                <option>Unpaid</option>
                                                <option>Paymented</option>
                                                <option>Canceled</option>
                                            </select>
                                        </td>
                                        <td>
                                            <c:forEach var="dish" items="${receipt.dishes}">
                                                <div>${dish.dishName}</div>
                                            </c:forEach>
                                        </td>
                                        <td class="actions">
                                            <button>Change dishes</button>
                                            <button>Canceled</button>
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
    
</body>
</html>
