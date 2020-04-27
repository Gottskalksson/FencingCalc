<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Post List</title>
</head>
<body>
<a href="/admin/post/add">Add new position</a> <br>
<a href="/admin">Back to Admin Panel</a> <br>
<br>
    <c:forEach items="${postList}" var="post">
        <p>Type: ${post.type}</p>
        <p>Price per m<sup>3</sup>: £${post.pricePerM3} </p>
        <p>Price per piece: £${post.pricePerPiece} </p>
        <a href="/admin/post/edit/${post.id}">Edit item</a>
        <a href="/admin/post/delete/${post.id}">Delete item</a>
        <hr/>
    </c:forEach>
</body>
</html>
