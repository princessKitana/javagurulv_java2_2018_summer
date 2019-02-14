
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>

<head>
    <title>Let's ride</title>
    <style><%@include file="/WEB-INF/jsp/style.css"%></style>
</head>

<body>
<%@page session="true"%>

    <div class="wrapper">
        <header class="header">
            <h1><a href="<spring:url value="/index"/>">Let's ride</a></h1>
        </header>

        <aside class="sidebar">
            <div id="box-one">
                <a href="trips">View All Trips</a>
            </div>
            <div id="box-one">
                <a href="<spring:url value="/vehicles/addVehicle"/>">Add Vehicle</a>
            </div>

            <div id="box-one">
                <a href="<spring:url value="/trips/addTrip"/>">Add trip</a>
            </div>

            <div id="box-one">
                <a href="<spring:url value="/logout"/>">Logout</a>
            </div>

        </aside>

        <article class="content">
            <h1>2 column, header and footer</h1>
            <p>This example uses line-based positioning, to position the header and footer, stretching them across the grid.</p>
        </article>

        <footer class="footer">My footer</footer>
    </div>

<p> user:</p>
<p>${userId}</p>
<c:set var="now" value="<%= new java.util.Date()%>"/>


</body>
</html>
