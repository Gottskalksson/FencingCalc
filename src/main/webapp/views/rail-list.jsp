<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Rail List</title>
</head>
<body>
<a href="/admin/rail/add">Add new position</a> <br>
<a href="/admin">Back to Admin Panel</a> <br>
<br>
    <c:forEach items="${railList}" var="rail">
        <p>Type: ${rail.type}</p>
        <p>Price per m<sup>3</sup>: £${rail.pricePerM3} </p>
        <p>Price per piece: £${rail.pricePerPiece} </p>
        <a href="/admin/rail/edit/${rail.id}">Edit item</a>
        <a href="/admin/rail/delete/${rail.id}">Delete item</a>
        <hr/>
    </c:forEach>
</body>
</html>
