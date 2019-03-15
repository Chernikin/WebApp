<%--
  Created by IntelliJ IDEA.
  User: Vlad
  Date: 16.01.2019
  Time: 23:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
<h3>Login Page</h3>
<form action="login" method="post">
    <table>
        <tr>
            <td>
                <h3>${message}</h3>
                <h3>${successMessage}</h3>
                <h3>${errorMessage}</h3>
                <h3>${activeMessage}</h3>

            </td>
        </tr>
        <tr>
            <td>Login</td>
            <td><input type="text" name="login"></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td><input type="submit" name="submit" value="Login"></td>
            <td><a href="registration-page.jsp">Registration</a></td>
        </tr>
    </table>
</form>
</body>
</html>
