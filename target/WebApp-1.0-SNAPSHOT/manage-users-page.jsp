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
    <title>Admin Page</title>
</head>
<body>
<div>
    <button><a href="">Manage product</a></button>
    <button><a href="">Manage users</a></button>
    <button><a href="">Logout</a></button>
</div>

<h1>Hi admin ${message}!</h1>
<h3>${activeMessage}</h3>
<h3>${successMessage}</h3>
<h3>${errorMessage}</h3>


<table cellpadding="5" cellspacing="5" border="1">
    <tr>
        <td colspan="9" align="center"><b>All Users</b></td>
    </tr>
    <tr>
        <td><b>id</b></td>
        <td><b>role</b></td>
        <td><b>login</b></td>
        <td><b>password</b></td>
        <td><b>firstName</b></td>
        <td><b>lastName</b></td>
        <td><b>active</b></td>
        <td><b>change active</b></td>
        <td><b>change role</b></td>
    </tr>
    <c:forEach items="${allUsers}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.role}</td>
            <td>${user.login}</td>
            <td>${user.password}</td>
            <td>${user.userDetails.firstName}</td>
            <td>${user.userDetails.lastName}</td>
            <td>${user.active}</td>
            <td>
                <form action="changeAccountActive" method="post">
                    <button type="submit">unblock/block</button>
                    <input type="hidden" value="${user.login}" name="login">
                </form>
            </td>
            <c:if test="${currentUser.role eq 'admin'}">
                <td>
                    <form action="changeAccountRole" method="post">
                        <button type="submit">Moderator/User</button>
                        <input type="hidden" value="${user.login}" name="login">
                    </form>
                </td>
            </c:if>
        </tr>
    </c:forEach>
</table>
</body>
</html>
