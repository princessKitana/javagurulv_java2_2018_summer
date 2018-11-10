<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Log in</title>
</head>
<body>
<%@page session="false"%>
<%--@elvariable id="userDTO" type=""--%>
<form:form id="loginForm" modelAttribute="userDTO" action="loginProcess" method="post">
    <table align="center">
        <tr>
            <td>
                <form:label path="login">Username</form:label>
            </td>
            <td>
                <form:input path="login" name="login" id="login" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="password">Password</form:label>
            </td>
            <td>
                <form:password path="password" name="password" id="password" />
            </td>
        </tr>

    </table>
    <input type="submit" value="Login" /></form>


</form:form>

</body>
</html>