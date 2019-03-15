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
            <td>
                <select name="company">
                    <c:forEach items="${allCompanies}" var="company">
                        <option value="${company.id}" selected>${company.companyName}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>Product Name</td>
            <td><input type="text" name="productName"></td>
        </tr>
        <tr>
            <td>Cpu</td>
            <td>
                <select name="cpu">
                    <c:forEach items="${allCpu}" var="cpu">
                        <option value="${cpu.id}" selected>${cpu.cpuName}</option>
                    </c:forEach>
                </select>
        </tr>
        <tr>
            <td>Gpu</td>
            <td>
                <select name="gpu">
                    <c:forEach items="${allGpu}" var="gpu">
                        <option value="${gpu.id}" selected>${gpu.gpuName}</option>
                    </c:forEach>
                </select>
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
