
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>

<head>
    <title>Let's ride</title>
    <style><%@include file="/WEB-INF/jsp/style.css"%></style>
    <%@page session="false"%>
</head>

<body>

<div class="wrapper">
    <header class="header">
        <h1><a href="<spring:url value="/"/>">Let's ride</a></h1>
    </header>

    <aside class="sidebar">
        <a href="<spring:url value="/register"/>">Register</a> <br>
        <a href="<spring:url value="/login"/>">Login</a>
    </aside>

    <article class="content">
        <h1>Sampe header</h1>
        <p>This example uses line-based positioning, to position the header and footer, stretching them across the grid.</p>
    </article>

    <footer class="footer">My footer</footer>
</div>

</body>
</html>
