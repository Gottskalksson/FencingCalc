<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Fency List</title>
</head>
<body>

<a href="/admin/fency/add">Add new position</a> <br>
<a href="/admin">Back to Admin Panel</a> <br>
<br>
    <c:forEach items="${fencyList}" var="fency">
        <p>Type: ${fency.type}</p>
        <p>Price per m<sup>3</sup>: £${fency.pricePerM3} </p>
        <p>Price per piece: £${fency.pricePerPiece} </p>
        <p>Post type: ${fency.post.type} </p>
        <a href="/admin/fency/edit/${fency.id}">Edit item</a>
        <a href="/admin/fency/delete/${fency.id}">Delete item</a>
        <hr/>
    </c:forEach>
</body>
</html>
