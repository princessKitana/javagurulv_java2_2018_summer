<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<style><%@include file="/WEB-INF/jsp/style.css"%></style>

<html>
<head>
    <title>Let's Ride</title>
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
            <h1>Trips</h1>
            <table>
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
        </article>
        <footer class="footer">My footer</footer>
    </div>






</body>
</html>