<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Extra Form</title>
</head>
<body>
<form:form modelAttribute="another" method="post" action="/admin/another/add">
    <form:label path="type">Type: </form:label>
    <form:input path="type"/><br>
    <form:errors path="type" cssClass="errorMessage"/>

    <form:label path="price">Price: £</form:label>
    <form:input path="price"/><br>
    <form:errors path="price" cssClass="errorMessage"/>

    <form:hidden path="id"/>

    <input type="submit" value="Send">


</form:form>
<a href="${pageContext.request.contextPath}/admin/another/list">Back to the list</a>
</body>
</html>
