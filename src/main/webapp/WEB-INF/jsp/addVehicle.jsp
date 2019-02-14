
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>

<style><%@include file="/WEB-INF/jsp/style.css"%></style>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Add new trip</title>
</head>

<body>

<%@page session="true"%>

<a href="<spring:url value="/index"/>">Let's Ride</a>

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
        <h1>Add Vehicle</h1>
        <%--@elvariable id="car" type=""--%>
        <form:form id="addVehicleForm" modelAttribute="car" action="addVehicleProcess" method="post">

            <table>
                <form:input path="driverId" name="driverId" id="driverId" type="hidden" value="${userId}"/>
                <tr>
                    <td><form:label path="model">Model*</form:label></td>
                    <td><form:input path="model" name="model" id="model" type="text" autocomplete = "on"/></td>
                </tr>
                <tr>
                    <td><form:label path="year">Year*</form:label></td>
                    <td><form:input path="year" name="year" id="year" type="text" autocomplete = "on" /></td>
                </tr>
                <tr>
                    <td><form:label path="color">Color*</form:label></td>
                    <td><form:input path="color" name="color" id="color" type="text" /></td>
                </tr>
                <tr>
                    <td><form:label path="regNumber">Registration number</form:label></td>
                    <td><form:input path="regNumber" name="regNumber" id="regNumber" type="text"/></td>
                </tr>
            </table>
            <input type="submit" value="Add" /></form>

        </form:form>
    </article>

    <footer class="footer">My footer</footer>
</div>


</body>
</html>