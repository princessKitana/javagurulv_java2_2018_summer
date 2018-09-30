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
<h1>Trips</h1>
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
    GetAllTripsResponse r = (GetAllTripsResponse) request.getAttribute("model") ;
List<TripDTO> trips = r.getTrips();

 for(int i = 0; i < trips.size(); i+=1) { %>
<tr>
    <td><%=trips.get(i).getOrigin()%></td>
    <td><%=trips.get(i).getDestination()%></td>
    <td><%=trips.get(i).getDate()%></td>
    <td><%=trips.get(i).getTime()%></td>
    <td><%=trips.get(i).getPrice()%></td>
    <td><%=trips.get(i).getStatus()%></td>
    <td><%=trips.get(i).getComment()%></td>
</tr>
<% } %>



</table>


</body>
</html>