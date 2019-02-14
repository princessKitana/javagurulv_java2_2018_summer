<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<html>

<style><%@include file="/WEB-INF/jsp/style.css"%></style>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Registration</title>
</head>
<body>
<%@page session="false"%>

<div class="wrapper">
    <header class="header">
        <h1><a href="<spring:url value="/index"/>">Let's ride</a></h1>
    </header>

    <aside class="sidebar">
        <a href="<spring:url value="/register"/>">Register</a> <br>
        <a href="<spring:url value="/login"/>">Login</a>
    </aside>

    <article class="content">
        <h1>Register</h1>
        <%--@elvariable id="user" type=""--%>
        <form:form id="regForm" modelAttribute="user" action="registerProcess" method="post">
            <table align="center">
                <tr>
                    <td>
                        <form:label path="login">Username*</form:label>
                    </td>
                    <td>
                        <form:input path="login" name="login" id="login" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="password">Password*</form:label>
                    </td>
                    <td>
                        <form:password path="password" name="password" id="password" />
                    </td>
                </tr>

                <tr>
                    <td>
                        <form:label path="email">Email*</form:label>
                    </td>
                    <td>
                        <form:input path="email" name="email" id="email" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="phone">Phone*</form:label>
                    </td>
                    <td>
                        <form:input path="phone" name="phone" id="phone" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="firstName">FirstName</form:label>
                    </td>
                    <td>
                        <form:input path="firstName" name="firstName" id="firstName" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="lastName">LastName</form:label>
                    </td>
                    <td>
                        <form:input path="lastName" name="lastName" id="lastName" />
                    </td>
                </tr>

                <tr>
                    <td></td>
                    <td>
                        <form:button id="register" name="register">Register</form:button>
                    </td>
                </tr>

            </table>
        </form:form>    </article>

    <footer class="footer">My footer</footer>
</div>

</body>
</html>