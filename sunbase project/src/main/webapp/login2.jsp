<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login and Sign up page</title>
    <link rel="stylesheet" href="style3.css">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <style>
        .message {
            font-size: 18px;
            font-weight: bold;
            color: red;
            text-align: center;
        }
    </style>
</head>
<body>
<div class="con">
    <div class="message">
        <p><span class="red-text"><%= request.getAttribute("message") %></span> Attempts are left</p>
    </div>
    <div class="wrapper">
        <form action="Login1" method="post">
            <h1>Login</h1>
            <div class="input-box">
                <input type="text" placeholder="username" name="name" required>
                <i class='bx bxs-user'></i>
            </div>
            <div class="input-box">
                <input type="password" placeholder="password" name="password" required>
                <i class='bx bxs-lock-alt'></i>
            </div>
            <button type="submit" class="btn">Login</button>
        </form>
    </div>
    </div>
</body>
</html>