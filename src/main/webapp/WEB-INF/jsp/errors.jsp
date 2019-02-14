<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Let's ride</title>
    <style><%@include file="/WEB-INF/jsp/style.css"%></style>
</head>

<body>

<%@page session="false"%>
<div class="wrapper">
    <header class="header">
        <h1><a href="<spring:url value="/index"/>">Let's ride</a></h1>
    </header>
    <aside class="sidebar">
    </aside>

    <article class="content">
    <table>
        <c:forEach items="${exception.getErrors()}" var="appExDTO">
        <tr>
            <td>${appExDTO.getField()}</td>
            <td>${appExDTO.getDescription()}</td>
        </tr>
        </c:forEach>
    </table>
    </article>
</div>





</body>
</html>
