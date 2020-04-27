<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Fency Form</title>
</head>
<body>
<form:form modelAttribute="fency" method="post" action="/admin/fency/add">
    <form:label path="type">Type (description on website): </form:label>
    <form:input path="type"/><br>
    <form:errors path="type" cssClass="errorMessage"/>

    <form:label path="pricePerM3">Price (per m<sup>3</sup>): </form:label>
    <form:input path="pricePerM3"/><br>
    <form:errors path="pricePerM3" cssClass="errorMessage"/>

    <form:label path="post">Post type: </form:label>
    <form:select path="post" items="${posts}" itemLabel="type" itemValue="id" /><br>
<%--    <form:errors path="posts" cssClass="errorMessage"/>--%>


    <form:label path="length">Length (in mm): </form:label>
    <form:input path="length"/><br>
    <form:errors path="length" cssClass="errorMessage"/>

    <form:label path="width">Width (in mm): </form:label>
    <form:input path="width"/><br>
    <form:errors path="width" cssClass="errorMessage"/>

    <form:label path="thickness">Thickness (in mm): </form:label>
    <form:input path="thickness"/><br>
    <form:errors path="thickness" cssClass="errorMessage"/>

    <form:hidden path="id"/>


    <input type="submit" value="Send">


</form:form>
<a href="${pageContext.request.contextPath}/admin/fency/list">Back to the list</a>
</body>
</html>
