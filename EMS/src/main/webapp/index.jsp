<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Expense Management System</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        text-align: center;
        margin: 50px;
    }
    .container {
        background: white;
        padding: 20px;
        width: 300px;
        margin: auto;
        border-radius: 10px;
        box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.2);
    }
    h2, h3 {
        color: #333;
    }
    input[type="text"], input[type="password"] {
        width: 90%;
        padding: 10px;
        margin: 10px 0;
        border: 1px solid #ccc;
        border-radius: 5px;
    }
    button {
        background-color: #007BFF;
        color: white;
        padding: 10px 15px;
        border: none;
        cursor: pointer;
        border-radius: 5px;
        width: 100%;
    }
    button:hover {
        background-color: #0056b3;
    }
    a {
        display: block;
        margin-top: 10px;
        color: #007BFF;
        text-decoration: none;
    }
    a:hover {
        text-decoration: underline;
    }
</style>
</head>
<body>
<h2>Expense Management System</h2>
<div class="container">
    
    <form action="login" method="post">
        <h3>Login</h3>
        <label>Enter Username:</label>
        <input type="text" name="username" required><br>
        <label>Enter Password:</label>
        <input type="password" name="password" required><br>
        <button type="submit">Submit</button>
        <a href="register.jsp">Register User</a>
    </form>
</div>
</body>
</html>