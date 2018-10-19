<%@ page import="lv.javaguru.java2.buisnesslogic.trip.addtrip.AddTripResponse" %>
<%@ page import="lv.javaguru.java2.buisnesslogic.ApplicationError" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Add new trip</title>
</head>
<body>
<h1>Add trip</h1>

<%--@elvariable id="trip" type=""--%>
<form:form id="addTripForm" modelAttribute="trip" action="addTripProcess" method="post">
    <table style="with: 50%">
        <tr>
            <td><form:label path="origin">Origin</form:label></td>
            <td><form:input path="origin" name="origin" id="origin" type="text" autocomplete = "on"/></td>
        </tr>
        <tr>
            <td><form:label path="destination">Destination</form:label></td>
            <td><form:input path="destination" name="destination" id="destination" type="text" /></td>
        </tr>
        <tr>
            <td><form:label path="date">Date</form:label></td>
            <td><form:input path="date" name="date" id="date" type="date" /></td>
        </tr>
        <tr>
            <td><form:label path="time">Time</form:label></td>
            <td><form:input path="time" name="time" id="time" type="time" value="17:00:00"/></td>
        </tr>

        <tr>
            <td><form:label path="price">Price</form:label></td>
            <td><form:input path="price" name="price" id="price" type="number" /></td>
        </tr>

        <tr>
            <td><form:label path="passangerCount">Passanger Count</form:label></td>
            <td><form:input path="passangerCount" name="passangerCount" id="passangerCount" type="number" /></td>
        </tr>

        <tr>
            <td><form:label path="comment">Meeting place</form:label></td>
            <td><form:input path="comment" name="comment" id="comment" type="text" /></td>
        </tr>

        <tr>
            <td><form:label path="driverId">DriverId</form:label></td>
            <td><form:input path="driverId" name="driverId" id="driverId" type="number" /></td>
        </tr>
        <tr>
            <td><form:label path="vehicleId">VehicleId</form:label></td>
            <td><form:input path="vehicleId" name="vehicleId" id="vehicleId" type="number" /></td>
        </tr>
    </table>
    <input type="submit" value="Submit" /></form>

</form:form>

<p>${resp.isSuccess()}</p>
</body>
</html>