<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Let's ride</title>

    <h1><a href="<spring:url value="/index"/>">Let's ride</a> </h1>
    <table>
        <tr>
            <th> <a href="trips">View All Trips</a>  </th>
        </tr>
        <tr>
            <th> <a href="<spring:url value="/vehicles/addVehicle"/>">Add Vehicle</a> </th>
        </tr>
        <tr>
            <th> <a href="<spring:url value="/trips/addTrip"/>">Add trip</a> </th>
        </tr>
        <tr>
            <th> <a href="<spring:url value="/trips/applyForTrip"/>">Apply For Trip</a> </th>
        </tr>

        <tr>
            <th> <a href="<spring:url value="/register"/>">Register</a> </th>
        </tr>

        <tr>
            <th> <a href="<spring:url value="/login"/>">Login</a> </th>
        </tr>
        <tr>
            <th> <a href="<spring:url value="/logout"/>">Logout</a> </th>
        </tr>

</table>


<p>Welcome user:</p>
<p>${userId}</p>



</head>
<body>

</body>
</html>
