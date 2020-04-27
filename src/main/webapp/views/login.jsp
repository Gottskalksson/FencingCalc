<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <form method="post" action="/login">
        Username: <input type="text" name="username" value="Username">
        Password: <input type="password" name="password" value="Password">
        <input type="submit" value="Send">
    </form>
</body>
</html>
