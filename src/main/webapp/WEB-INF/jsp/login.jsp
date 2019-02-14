<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<html>

<style><%@include file="/WEB-INF/jsp/style.css"%></style>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Log in</title>
</head>
<body>
<%@page session="false"%>

<div class="wrapper">
    <header class="header">
        <h1><a href="<spring:url value="/"/>">Let's ride</a></h1>
    </header>

    <aside class="sidebar">
        <%--@elvariable id="userDTO" type=""--%>
        <form:form id="loginForm" modelAttribute="userDTO" action="loginProcess" method="post">
            <table>
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
                <tr>
                    <td>

                    </td>
                    <td>
                        <input align="right" type="submit" value="Login" /></form>
                    </td>
                </tr>
            </table>

        </form:form>
    </aside>

    <article class="content">
        <h1>Sampe header</h1>
        <p>This example uses line-based positioning, to position the header and footer, stretching them across the grid.</p>
    </article>

    <footer class="footer">My footer</footer>
</div>

</body>
</html>