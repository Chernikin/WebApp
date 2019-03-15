<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Vlad
  Date: 08.02.2019
  Time: 20:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Product Page</title>
</head>
<body>
<h3>Updating product with id: ${product.id}</h3>


<form action="updateProduct" method="post">
    <table>
        <tr>
            <td>ID</td>
            <td><input type="text" name="id" value="${product.id}"></td>
        </tr>
        <tr>
            <td>Company</td>
            <td><input type="text" name="company" value="${product.company}"></td>
        </tr>
        <tr>
            <td>Product Name</td>
            <td><input type="text" name="productName" value="${product.productName}"></td>
        </tr>
        <tr>
            <td>Specification</td>
            <td><input type="text" name="specification" value="${product.specification}"></td>
        </tr>
        <tr>
            <td>Price</td>
            <td><input type="text" name="price" value="${product.price}"></td>
        </tr>
        <tr>
            <td><input type="submit" name="submit" value="Update"></td>
        </tr>
    </table>
</form>
</body>
</html>
