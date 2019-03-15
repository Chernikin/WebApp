<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Vlad
  Date: 22.01.2019
  Time: 21:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My E-Shop</title>
</head>
<body>
<h1>We welcome you ${message}!</h1>
<h3>${activeMessage}</h3>
<h3>${successMessage}</h3>
<h3>${errorMessage}</h3>

<div>
    <c:choose>
        <c:when test="${currentUser.role eq 'admin' || user.role eq 'moderator'}">
            <button><a href="manage-products-page">Manage product</a></button>
            <button><a href="manage-users-page">Manage users</a></button>
        </c:when>
        <c:when test="${currentUser.role eq 'user'}">
            <button><a href="cart">My cart</a></button>
        </c:when>
    </c:choose>
    <button><a href="logout">Logout</a></button>
</div>

<div>
    <table cellpadding="5" cellspacing="5" border="1">
    <c:forEach items="${allProducts}" var="product">
        <tr>
            <td>${product.id}</td>
            <td>${product.company}</td>
            <td>${product.productName}</td>
            <td>${product.specification}</td>
            <td>${product.price}</td>

            <c:if test="${currentUser.role eq 'user'}">
                <td>
                    <form action="addToCart" method="post">
                        <button type="submit">add to basket</button>
                        <input type="hidden" value="${product.id}" name="id">
                    </form>
                </td>
            </c:if>
        </tr>
    </c:forEach>
    </table>
</div>
</body>
</html>
