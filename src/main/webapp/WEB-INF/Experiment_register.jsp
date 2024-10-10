<%-- 
    Document   : Experiment_regiter
    Created on : Oct 11, 2024, 12:11:35 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register User</title>
</head>
<body>
    <h2>Register New User</h2>
    <form action="register" method="post">
        Username: <input type="text" name="username"><br>
        Password: <input type="password" name="password"><br>
        Email: <input type="text" name="email"><br>
        <input type="submit" value="Register">
    </form>
</body>
</html>
