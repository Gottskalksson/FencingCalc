<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Extra List</title>
</head>
<body>
<%--<a href="/admin/another/add">Add new position</a> <br>--%>
<a href="/admin">Back to Admin Panel</a> <br>
<br>
    <c:forEach items="${anotherList}" var="another">
        <p>Type: ${another.type}</p>
        <p>Price: £${another.price} </p>
        <a href="/admin/another/edit/${another.id}">Edit item</a>
<%--        <a href="/admin/another/delete/${another.id}">Delete item</a>--%>
        <hr/>
    </c:forEach>
</body>
</html>
