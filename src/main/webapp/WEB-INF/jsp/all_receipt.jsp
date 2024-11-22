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
                    <button>Lọc</button>
                </div>

                
                <div class="content-receipt">
                    <p><strong>Hiển thị thông tin user:</strong> Tên, Email, SĐT, ...</p>
                    <table>
                        <thead>
                            <tr>
                                <th>Hóa đơn</th>
                                <th>Thông tin bàn</th>
                                <th>Trạng thái</th>
                                <th>Danh sách món</th>
                                <th>Hành động</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- Hóa đơn 01 -->
                            <tr>
                                <td>Hóa đơn 01</td>
                                <td>
                                    Số bàn: 5<br>
                                    Số người: 4<br>
                                    Ngày giờ: 2024-11-22<br>
                                    Số tiền đặt bàn: 200,000<br>
                                    Tổng số tiền: 1,000,000
                                </td>
                                <td>
                                    <select>
                                        <option>Đã đặt</option>
                                        <option>Chưa thanh toán</option>
                                        <option>Đã thanh toán</option>
                                        <option>Đã hủy</option>
                                    </select>
                                </td>
                                <td>
                                    <ul>
                                        <li>Món 1</li>
                                        <li>Món 2</li>
                                        <li>Món 3</li>
                                    </ul>
                                </td>
                                <td class="actions">
                                    <button>Thay đổi món</button>
                                    <button>Hủy đặt bàn</button>
                                </td>
                            </tr>

                            <!-- Hóa đơn 02 -->
                            <tr>
                                <td>Hóa đơn 02</td>
                                <td>
                                    Số bàn: 3<br>
                                    Số người: 2<br>
                                    Ngày giờ: 2024-11-23<br>
                                    Số tiền đặt bàn: 100,000<br>
                                    Tổng số tiền: 500,000
                                </td>
                                <td>
                                    <select>
                                        <option>Đã đặt</option>
                                        <option>Chưa thanh toán</option>
                                        <option>Đã thanh toán</option>
                                        <option>Đã hủy</option>
                                    </select>
                                </td>
                                <td>
                                    <ul>
                                        <li>Món A</li>
                                        <li>Món B</li>
                                    </ul>
                                </td>
                                <td class="actions">
                                    <button>Thay đổi món</button>
                                    <button>Hủy đặt bàn</button>
                                </td>
                            </tr>
                        </tbody>
                    </table>                     
                </div>
                                    
                
            </div>     
        </div>              

        <!-- Footer -->
        <%@ include file="cus_footer.jspf" %>
    </div>
    
</body>
</html>
