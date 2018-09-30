
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="lv.javaguru.java2.buisnesslogic.trip.get.GetTripResponse" %>
<%@ page import="lv.javaguru.java2.web.dtos.TripDTO" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Trip Info</title>
</head>
<body>
<h1>View information about trip</h1>
<table style="width:100%" >
    <tr>
        <th>From</th>
        <th>To</th>
        <th>Date</th>
        <th>Time</th>
        <th>Price</th>
        <th>Status</th>
        <th>Comment</th>
    </tr>

<%
    GetTripResponse r = (GetTripResponse) request.getAttribute("model") ;
    TripDTO trip = r.getTrip();

 %>

    <tr>
        <td><%=trip.getOrigin()%></td>
        <td><%=trip.getDestination()%></td>
        <td><%=trip.getDate()%></td>
        <td><%=trip.getTime()%></td>
        <td><%=trip.getPrice()%></td>
        <td><%=trip.getStatus()%></td>
        <td><%=trip.getComment()%></td>
    </tr>

</body>
</html>
