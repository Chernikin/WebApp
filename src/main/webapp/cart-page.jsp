<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Vlad
  Date: 12.02.2019
  Time: 18:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Buy Product</title>
</head>
<body>
<h1>You want to buy:</h1>

<table cellpadding="5" cellspacing="5" border="1">
    <tr>

        <td><b>id</b></td>
        <td><b>company</b></td>
        <td><b>product name</b></td>
        <td><b>specification</b></td>
        <td><b>price</b></td>
    </tr>
    <c:forEach items="${cart}" var="cartPosition">
    <tr>
        <td>${cartPosition.id}</td>
        <td>${cartPosition.company}</td>
        <td>${cartPosition.productName}</td>
        <td>${cartPosition.specification}</td>
        <td>${cartPosition.price}</td>
    </tr>
   </c:forEach>
</table>

<form action="cart" method="post">
    <table>
        <tr>
            <td>First Name</td>
            <td><input type="text" name="fName"></td>
        </tr>
        <tr>
            <td>Last Name</td>
            <td><input type="text" name="lName"></td>
        </tr>
        <tr>
            <td>City</td>
            <td><input type="text" name="city"></td>
        </tr>
        <tr>
            <td>Post number</td>
            <td><input type="text" name="postNumber"></td>
        </tr>
        <tr>
            <td>Card number</td>
            <td><input type="text" name="cardNumber"></td>
        </tr>
        <tr>
            <td>Month/Year</td>
            <td><input type="text" name="month"></td>
            <td><input type="text" name="year"></td>
        </tr>
        <tr>
            <td>CVV</td>
            <td><input type="text" name="cvv"></td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="confirm">
            </td>
        </tr>
    </table>
</form>

</body>
</html>
