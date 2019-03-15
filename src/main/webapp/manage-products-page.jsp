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
    <title>Manage products page</title>
</head>
<body>

<div>
    <button><a href="manage-products-page">Manage product</a></button>
    <button><a href="manage-users-page">Manage users</a></button>
    <button><a href="logout">Logout</a></button>
</div>

<h1>Hi admin ${message}!</h1>
<h3>${activeMessage}</h3>
<h3>${successMessage}</h3>
<h3>${errorMessage}</h3>

<table cellpadding="5" cellspacing="5" border="1">
    <tr>
        <td colspan="7" align="center"><b>All Products</b></td>
    </tr>
    <tr>
        <td colspan="7"><button><a href="create-product-page"><b>Create Product</b></a></button></td>
    </tr>
    <tr>
        <td><b>id</b></td>
        <td><b>company</b></td>
        <td><b>productName</b></td>
        <td><b>specification</b></td>
        <td><b>price</b></td>
        <td><b>delete product</b></td>
        <td><b>update product</b></td>
    </tr>
    <c:forEach items="${allProducts}" var="product">
        <tr>
            <td>${product.id}</td>
            <td>${product.company}</td>
            <td>${product.productName}</td>
            <td>${product.specification}</td>
            <td>${product.price}</td>
            <td>
                <form action="deleteProduct" method="post">
                    <button type="submit">delete product</button>
                    <input type="hidden" value="${product.id}" name="id">
                </form>
            </td>
            <td>
                <form action="link-to-update-product" method="post">
                    <button type="submit">update product</button>
                    <input type="hidden" value="${product.id}" name="id">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
