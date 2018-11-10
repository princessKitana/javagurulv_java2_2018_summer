
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>Let's ride</title>
</head>

<body>
<%@page session="false"%>

<H1>Let's ride</H1>
<table>


    <tr>
        <th> <a href="<spring:url value="/register"/>">Register</a> </th>
    </tr>

    <tr>
        <th> <a href="<spring:url value="/login"/>">Login</a> </th>
    </tr>

</table>


</body>
</html>
