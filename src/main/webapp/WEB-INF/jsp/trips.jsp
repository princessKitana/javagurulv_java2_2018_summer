<%@ page import="lv.javaguru.java2.buisnesslogic.trip.get.GetAllTripsResponse" %>
<%@ page import="lv.javaguru.java2.web.dtos.TripDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

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
<a href="index">Main</a>
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


   <c:forEach items="${trips}" var="trip">
       <tr>
           <td>${trip.getOrigin()}</td>
          <td>${trip.getDestination()}</td>
         <td>${trip.getDate()}</td>
        <td>${trip.getTime()}</td>
          <td>${trip.getPrice()}</td>
          <td>${trip.getStatus()}</td>
        <td>${trip.getComment()}</td>
      </tr>
    </c:forEach>



</table>




</body>
</html>