<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="lv.javaguru.java2.buisnesslogic.trip.get.GetTripResponse" %>
<%@ page import="lv.javaguru.java2.web.dtos.TripDTO" %>
<html>

<style><%@include file="/WEB-INF/jsp/style.css"%></style>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Vehicle Info</title>
</head>
<body>
<a href="<spring:url value="/index"/>">Let's Ride</a>

<%@page session="true"%>

<div class="wrapper">
    <header class="header">
        <h1><a href="<spring:url value="/index"/>">Let's ride</a></h1>
    </header>

    <aside class="sidebar">
        <div id="box-one">
            <a href="<spring:url value="/trips"/>">View All Trips</a>
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
        <h1>Vehicle information</h1>
        <table >
            <tr>
                <th>Model</th>
                <th>Year</th>
                <th>Color</th>
                <th>Registration number</th>
            </tr>

            <tr>
                <td>${car.getModel()}</td>
                <td>${car.getYear()}</td>
                <td>${car.getColor()}</td>
                <td>${car.getRegNumber()}</td>
            </tr>
        </table >
    </article>

    <footer class="footer">My footer</footer>
</div>

</body>
</html>
