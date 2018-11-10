<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Errors:</title>
</head>
<body>
<a href="<spring:url value="/index"/>">Let's Ride</a>
<table>
<c:forEach items="${exception.getErrors()}" var="appExDTO">
    <tr>
        <td>${appExDTO.getField()}</td>
        <td>${appExDTO.getDescription()}</td>

    </tr>
</c:forEach>
<table>

</body>
</html>
