<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login Success</title>
</head>
<body>
    <h2>Login Successful</h2>
    <p>Welcome, <%= request.getAttribute("username") %>!</p>
</body>
</html>
