<%@ page import="lv.javaguru.java2.buisnesslogic.trip.get.GetAllTripsResponse" %>
<%@ page import="lv.javaguru.java2.web.dtos.TripDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>Let's Ride</title>
</head>
<body>
<a href="<spring:url value="/index"/>">Let's Ride</a>


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
           <td> <a href="<spring:url value="/trips/${trip.getId()} "/>">View</a></td>
      </tr>
    </c:forEach>



</table>




</body>
</html>