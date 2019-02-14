<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<html>

<%
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String date = sdf.format(new Date());

    Date d = new Date();

    SimpleDateFormat tf = new SimpleDateFormat("HH:mm:ss");
    String time = tf.format(new Date());
%>
<p>The time now is: <%=time%></p>

<style><%@include file="/WEB-INF/jsp/style.css"%></style>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>

<%@page session="true"%>


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
        <h1>Add trip</h1>
        <%--@elvariable id="trip" type=""--%>
        <form:form id="addTripForm" modelAttribute="trip" action="addTripProcess" method="post">
            <table>
                <tr>
                    <td><form:label path="origin">From*</form:label></td>
                    <td><form:input path="origin" name="origin" id="origin" type="text" autocomplete = "on"/></td>
                </tr>
                <tr>
                    <td><form:label path="destination">To*</form:label></td>
                    <td><form:input path="destination" name="destination" id="destination" type="text" /></td>
                </tr>
                <tr>
                    <td><form:label path="date">Date*</form:label></td>
                    <td><form:input path="date" name="date" id="date" type="date" /></td>
                </tr>
                <tr>
                    <td><form:label path="time">Time*</form:label></td>
                    <td><form:input path="time" id="time" name="time" placeholder="18:00:00" type="text" /> <p>Current time: <%=time%></p></td>

                </tr>

                <tr>
                    <td><form:label path="price">Price EUR</form:label></td>
                    <td><form:input path="price" name="price" id="price" type="number" /></td>
                </tr>

                <tr>
                    <td><form:label path="passangerCount">Passanger Count*</form:label></td>
                    <td><form:input path="passangerCount" name="passangerCount" id="passangerCount" type="number" /></td>
                </tr>

                <tr>
                    <td><form:label path="comment">Meeting place</form:label></td>
                    <td><form:input path="comment" name="comment" id="comment" type="text" /></td>
                </tr>

                <tr>
                    <td><form:input path="driverId" name="driverId" id="driverId" type="hidden" value="${userId}" /></td>
                </tr>

                <tr>

                    <td><form:label path="vehicleId">Car</form:label></td>
                    <td>
                        <form:select path="vehicleId" id="vehicleId">Car
                            <c:forEach var="vehicles" items="${vehicles}">
                                <option value="${vehicles.id}">${vehicles.model}</option>
                            </c:forEach>
                        </form:select>
                    </td>


                    <td> <a href="<spring:url value="/vehicles/addVehicle"/>">Add different vehicle</a> </td>

                </tr>

            </table>

            <input type="submit" value="Submit" />

        </form:form>
    </article>

    <footer class="footer">My footer</footer>
</div>



</body>
</html>