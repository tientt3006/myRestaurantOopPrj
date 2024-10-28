<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
    
<c:set var="title" value="OOP Dinner - Log in" scope="page"/>
<%@ include file="head.jspf" %>

<body>
    <div class="wrapper">
        <!-- Header Section -->
        <c:set var="currentPage" value="change_password" scope="page"/>
        <%@ include file="cus_header.jspf" %>

        <!-- Main Content Section -->
        <div class="main-container">
            <div class="login-container">
                <div class="login-box">
                    <h2>Change password</h2>
                    <% if ("true".equals(request.getAttribute("err"))) { %>
                        <div class="error-message" style="color: red; text-align: center; margin-bottom: 10px;">
                            Invalid old password.
                        </div>
                    <% } %>
                    <form id="changePasswordForm" action="${pageContext.request.contextPath}/account/change_password" method="post"  onsubmit="return validatePasswords()">
                        <p class="email-text"> Old password </p>
                        <input type="password" name="oldPassword" placeholder="Old password" required>
                        
                        <p class="password-text"> New password </p>
                        <input type="password" name="newPassword" id="newPassword" placeholder="New password" required>
                        
                        <p class="password-text"> Re-enter new password </p>
                        <input type="password" name="confirmNewPassword" id="confirmNewPassword" placeholder="New password" required>
                        
                        <div id="passwordError" style="color: red; text-align: center; margin-bottom: 10px; display: none;">
                            New passwords do not match.
                        </div>
                        <button type="submit">Change password</button>
                    </form>
                </div>
            </div>
        </div>

        <!-- Footer Section -->
        <%@ include file="cus_footer.jspf" %>
    </div>
    <script>
        function validatePasswords() {
            const newPassword = document.getElementById("newPassword").value;
            const confirmNewPassword = document.getElementById("confirmNewPassword").value;
            const passwordError = document.getElementById("passwordError");

            if (newPassword !== confirmNewPassword) {
                passwordError.style.display = "block";  // Hiển thị thông báo lỗi
                return false;  // Ngăn gửi form nếu mật khẩu không khớp
            } else {
                passwordError.style.display = "none";  // Ẩn thông báo lỗi nếu mật khẩu khớp
                return true;  // Cho phép gửi form
            }
        }
    </script>
</body>

</html>
