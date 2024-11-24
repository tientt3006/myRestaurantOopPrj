<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Something Went Wrong</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
            background-color: #f7f8fc;
            color: #333;
        }
        .container {
            text-align: center;
            max-width: 500px;
            padding: 20px;
            background: white;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        .container h1 {
            font-size: 2.5em;
            color: #e74c3c;
            margin-bottom: 10px;
        }
        .container p {
            font-size: 1.2em;
            margin-bottom: 20px;
            color: #555;
        }
        .container a {
            display: inline-block;
            padding: 10px 20px;
            font-size: 1em;
            color: white;
            background-color: #3498db;
            text-decoration: none;
            border-radius: 5px;
            transition: background-color 0.3s ease;
        }
        .container a:hover {
            background-color: #2980b9;
        }
        .container img {
            max-width: 100px;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <img src="https://img.icons8.com/clouds/100/error.png" alt="Error">
        <h1>Oops!</h1>
        <p>Something went wrong. Please try again later.</p>
        <a href="${pageContext.request.contextPath}/home">Go to Homepage</a>
    </div>
</body>
</html>
