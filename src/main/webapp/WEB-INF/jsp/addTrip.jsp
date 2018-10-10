<%@ page import="lv.javaguru.java2.buisnesslogic.trip.addtrip.AddTripResponse" %>
<%@ page import="lv.javaguru.java2.buisnesslogic.ApplicationError" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Add new trip</title>
</head>
<body>
<h1>Add trip</h1>

<form:form id="addTripForm" modelAttribute="trip" action="addTripProcess" method="post">
    <table style="with: 50%">
        <tr>
            <td>Origin</td>
            <td><input type="text" name="origin" /></td>
        </tr>
        <tr>
            <td>Destination</td>
            <td><input type="text" name="destination" /></td>
        </tr>
        <tr>
            <td>Date</td>
            <td><input type="date" name="date" /></td>
        </tr>
        <tr>
            <td>Time</td>
            <td><input type="time" name="time" /></td>
        </tr>

        <tr>
        <td>Price</td>
        <td><input type="number" name="price" /></td>
        </tr>

        <tr>
            <td>Comment</td>
            <td><input type="text" name="comment" /></td>
        </tr>


        <tr>
            <td>DriverId</td>
            <td><input type="number" name="driverId" /></td>
        </tr>
        <tr>
            <td>VehicleId</td>
            <td><input type="number" name="vehicleId" /></td>
        </tr>


    </table>
    <input type="submit" value="Submit" /></form>
</form:form>

</body>
</html>