<%-- 
    Document   : Experiment_login_success
    Created on : Oct 11, 2024, 10:46:26 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Successful</title>
</head>
<body>
    <h2>Login Successful</h2>
    <p>Welcome back, <%= request.getAttribute("username") %>!</p>
    <a href="home.jsp">Go to Home</a>
</body>
</html>

