<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Insert Product</title>
</head>
<body>
<h3>Insert Product Page</h3>

<form action="create-product-action" method="post">
    <table>
        <tr>
            <td>Company</td>
            <td><c:forEach items="${allProducts}" var="company">
                <select>
                    <option value="${company.id}">${company.name}</option>
                </select>
            </c:forEach>
            </td>
        </tr>
        <tr>
            <td>Product Name</td>
            <td><input type="text" name="productName"></td>
        </tr>
        <tr>
            <td>Cpu</td>
            <td>
                <c:forEach items="${allCpu}" var="cpu">
                <select>
                    <option value="${cpu.id}">${cpu.name}</option>
                </select>
                </c:forEach>
        </tr>
        <tr>
            <td>Gpu</td>
            <td>
                <c:forEach items="${allGpu}" var="gpu">
                <select>
                    <option value="${gpu.id}">${gpu.name}</option>
                </select>
                </c:forEach>
        </tr>
        <tr>
            <td>Specification</td>
            <td><input type="text" name="specification"></td>
        </tr>
        <tr>
            <td>Price</td>
            <td><input type="text" name="price"></td>
        </tr>
        <tr>
            <td><input type="submit" name="submit" value="Insert"></td>
        </tr>
    </table>
</form>
</body>
</html>
