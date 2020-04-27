<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Calculator</title>
    <link href="<c:url value="/css/style.css" />" rel="stylesheet">
</head>
<body>
<div id="image">
    <img id="img" src="<c:url value="/css/breschBrothersLogo.png"/>">
</div>

<div id="app">
    <div id="panel"></div>
    <div id="fencyForm">
        <h1>Fencing Calculator</h1>
        <form method="post">
            <table>
                <tr>
                    <td>
                        <form:label path="fencyList">Fence Type: </form:label>
                    </td>
                    <td>
                        <form:select name="fencyList" path="fencyList" items="${fencyList}" itemLabel="type"
                                     itemValue="id"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="fenceLength">Fence Length: </label>
                    </td>
                    <td>
                        <input name="fenceLength" id="fenceLength" type="number" value="1" min="1" max="500" step="0.1"> meter
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" id="button" value="Check">
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>

</body>
</html>
