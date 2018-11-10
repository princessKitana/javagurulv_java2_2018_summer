
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page import = "java.io.*,java.util.*" %>
<%@ page import = "javax.servlet.*,java.text.*" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Add new trip</title>
</head>
<body>
<a href="<spring:url value="/index"/>">Let's Ride</a>

<h1>Add trip</h1>

<%--@elvariable id="trip" type=""--%>
<form:form id="addTripForm" modelAttribute="trip" action="addTripProcess" method="post">
    <table>
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
            <td>  <form:input path="time" id="time" /> </td>
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
            <td><form:input path="driverId" name="driverId" id="driverId" type="hidden" value="${userId}" /></tr>
        </tr>

        <tr>

            <td><form:label path="vehicleId">Car</form:label></td>

            <td>
            <form:select path="vehicleId" id="vehicleId">Car</>
            <c:forEach var="vehicles" items="${vehicles}">
                <option value="${vehicles.id}">${vehicles.model}</option>
            </c:forEach>
            </form:select>
            </td>

        </tr>

    </table>

    <input type="submit" value="Submit" /></form>

</form:form>

<%
    Date dNow = new Date( );
    SimpleDateFormat ft =
            new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
    System.out.print("<p>"+dNow+"</p>");
    System.out.print(ft.format(dNow));

%>


</body>
</html>