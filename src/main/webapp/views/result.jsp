<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Result</title>
    <link href="<c:url value="/css/style.css" />" rel="stylesheet">
</head>
<body>
<div id="image">
    <img id="img" src="<c:url value="/css/breschBrothersLogo.png"/>">
</div>
<div id="app">
    <table id="tabApp">
        <tbody>
        <tr class="title">
            <td>Product</td>
            <td>Type</td>
            <td>Quantity</td>
            <td>Price Each</td>
            <td>Total Price</td>
        </tr>
        <c:forEach items="${itemList}" var="item">
        <tr>
            <td>${item.description}</td>
            <td>${item.type}</td>
            <td>${item.quantity}</td>
            <td>£ ${item.priceForEach}</td>
            <td class="itemPrice">${item.totalPrice}</td>
        </tr>
        </c:forEach>
        <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td colspan="2">&nbsp;</td>
        </tr>

        <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>Total exVAT</td>
            <td id="exVat" class="price">£ exVAT</td>
        </tr>
        <tr>
            <td><button onclick="window.location.href ='/calculator';">Calculate again</button> </td>
            <td> </td>
            <td>&nbsp;</td>
            <td>VAT</td>
            <td id="vat" class="price">£ VAT</td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td class="title">TOTAL PRICE: </td>
            <td id="sum" class="price">£ SUM</td>
        </tr>

        </tbody>

    </table>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="<c:url value="/resources/app.js" />"></script>

</body>
</html>
