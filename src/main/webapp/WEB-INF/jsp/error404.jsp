<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>404 - Page Not Found</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background: #f8f9fa;
            color: #343a40;
            text-align: center;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }

        h1 {
            font-size: 6rem;
            margin: 0;
            color: #ff6b6b;
        }

        h2 {
            font-size: 2rem;
            margin: 0;
            color: #495057;
        }

        p {
            margin: 20px 0;
            font-size: 1.2rem;
            color: #868e96;
        }

        a {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 20px;
            font-size: 1rem;
            color: #fff;
            background: #007bff;
            text-decoration: none;
            border-radius: 5px;
            transition: background-color 0.3s;
        }

        a:hover {
            background: #0056b3;
        }

        .illustration {
            margin-top: 20px;
        }

        .illustration img {
            max-width: 100%;
            height: auto;
        }
    </style>
</head>
<body>
    <h1>404</h1>
    <h2>Page Not Found</h2>
    <p>Oops! The page you're looking for doesn't exist or has been moved.</p>
    <a href="${pageContext.request.contextPath}/about">Go Back to Home</a>
    <div class="illustration">
        <img src="https://news.khangz.com/wp-content/uploads/2021/10/404-not-found-la-gi-1.jpg" alt="404 Illustration" width="50%">
    </div>
</body>
</html>