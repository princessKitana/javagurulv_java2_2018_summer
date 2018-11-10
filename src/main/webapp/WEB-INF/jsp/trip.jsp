<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>
<a href="<spring:url value="/index"/>">Let's Ride</a>
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

    <tr>
        <td>${trip.getOrigin()}</td>
        <td>${trip.getDestination()}</td>
        <td>${trip.getDate()}</td>
        <td>${trip.getTime()}</td>
        <td>${trip.getPrice()}</td>
        <td>${trip.getStatus()}</td>
        <td>${trip.getComment()}</td>
    </tr>
</table>

    <%--@elvariable id="tpDTO" type=""--%>
    <form:form id="applyForTripForm" modelAttribute="tpDTO" action="applyForTripProcess" method="post">
    <table >
        <tr>
            <td><form:input path="trip" name="trip" id="trip" type="hidden" value="${trip.getId()}" /></td>
        </tr>
        <tr>
            <td><form:input path="passanger" name="passanger" id="passanger" type="hidden" value="${userId}"  /></td>
        </tr>
    </table >
    <input type="submit" value="Apply" /></form>
    </form:form>

    ${tpDTO.id == null ? "not applied yet" : "You are succesflly applied!"}


</body>
</html>
