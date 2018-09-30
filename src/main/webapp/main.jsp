<%@ page import="lv.javaguru.java2.buisnesslogic.trip.get.GetAllTripsResponse" %>
<%@ page import="lv.javaguru.java2.web.dtos.TripDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<style>
    body {background-color: powderblue;}
    h1   {color: blue;}
    p    {color: red;}

    table {
        width: 100%;
    }

    th {
        height: 50px;
        text-align: left;
    }

    table, th, td {
        border: 1px solid black;
    }

</style>

<html>
<head>
    <title>Let's Ride</title>
</head>
<body>
<h1>Let's Ride</h1>

<h1>View all trips</h1>
<form action="trips.jsp" method="get">
    <input type="submit">
</form>

<h1>Register</h1>
<form action="register.jsp">
    <input type="submit">
</form>

<h1>addTrip</h1>
<form action="addTrip.jsp">
    <input type="submit">
</form>


</body>
</html>