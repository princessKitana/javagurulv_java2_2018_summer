<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="lv.javaguru.java2.buisnesslogic.trip.get.GetTripResponse" %>
<%@ page import="lv.javaguru.java2.web.dtos.TripDTO" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Vehicle Info</title>
</head>
<body>
<a href="<spring:url value="/index"/>">Let's Ride</a>


<h1>Vehicle information</h1>
<table >
    <tr>
        <th>ID</th>
        <th>Model</th>
        <th>Year</th>
        <th>Color</th>
        <th>Registration number</th>
    </tr>

    <tr>
        <td>${car.getId()}</td>
        <td>${car.getModel()}</td>
        <td>${car.getYear()}</td>
        <td>${car.getColor()}</td>
        <td>${car.getRegNumber()}</td>
    </tr>
    </table >
</body>
</html>
