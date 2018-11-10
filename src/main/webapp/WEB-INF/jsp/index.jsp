
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>Let's ride</title>
</head>
    <%@page session="true"%>

<h1>Let's ride</h1>

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
            <th> <a href="<spring:url value="/logout"/>">Logout</a> </th>
        </tr>

</table>



    <c:set var="now" value="<%= new java.util.Date()%>"/>


<p>Welcome user:</p>
<p>${userId}</p>


<body>

</body>
</html>
