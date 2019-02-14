
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<style><%@include file="/WEB-INF/jsp/style.css"%></style>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <%@page session="true"%>
</head>
<body>


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
        <h1>Apply for trip</h1>

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
            <%--@elvariable id="tripDTO" type=""--%>
            <tr>
                <td>${tripDTO.getOrigin()}</td>
                <td>${tripDTO.getDestination()}</td>
                <td>${tripDTO.getDate()}</td>
                <td>${tripDTO.getTime()}</td>
                <td>${tripDTO.getPrice()}</td>
                <td>${tripDTO.getStatus()}</td>
                <td>${tripDTO.getComment()}</td>
            </tr>
        </table>

        <%--@elvariable id="tpDTO" type=""--%>
        <form:form id="applyForTripForm" modelAttribute="tpDTO" action="applyForTripProcess" method="post">
            <table >
                <tr>
                    <td><form:input path="trip" name="trip" id="trip" type="hidden" value="${tripDTO.getId()}" /></td>
                </tr>
                <tr>
                    <td><form:input path="passanger" name="passanger" id="passanger" type="hidden" value="${userId}"  /></td>
                </tr>
            </table >
            <input type="submit" value="Apply" /></form>
        </form:form>
        ${tpDTO.id == null ? "" : "You are succesflly applied!"}

    </article>

    <footer class="footer">My footer


    </footer>
</div>

</body>
</html>
