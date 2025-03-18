<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register User</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        text-align: center;
        padding: 50px;
    }
    form {
        background: white;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        display: inline-block;
        text-align: left;
    }
    input[type="text"], input[type="password"] {
        width: 100%;
        padding: 8px;
        margin: 5px 0;
        border: 1px solid #ccc;
        border-radius: 4px;
    }
    button {
        background: #007BFF;
        color: white;
        padding: 10px;
        border: none;
        cursor: pointer;
        width: 100%;
        border-radius: 5px;
        margin-top: 10px;
    }
    button:hover {
        background: #0056b3;
    }
</style>
</head>
<body>
<form action="register" method="post">
    <h2>Register User</h2>
    <label>UserName:</label>
    <input type="text" name="username" required><br>
    <label>Full Name:</label>
    <input type="text" name="fullname" required><br>
    <label>Email:</label>
    <input type="text" name="email" required><br>
    <label>Password:</label>
    <input type="password" name="password" required><br>
    <button type="submit">Submit</button>
</form>
</body>
</html>
