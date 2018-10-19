
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Add new trip</title>
</head>
<body>
<h1>Add Vehicle</h1>

<%--@elvariable id="car" type=""--%>
<form:form id="addVehicleForm" modelAttribute="car" action="addVehicleProcess" method="post">
    <table>
        <tr>
            <td><form:label path="driverId">DriverId</form:label></td>
            <td><form:input path="driverId" name="driverId" id="driverId" type="number" autocomplete = "on"/></td>
        </tr>
        <tr>
            <td><form:label path="model">Model</form:label></td>
            <td><form:input path="model" name="model" id="model" type="text" autocomplete = "on"/></td>
        </tr>
        <tr>
            <td><form:label path="year">Year</form:label></td>
            <td><form:input path="year" name="year" id="year" type="number" autocomplete = "on" /></td>
        </tr>
        <tr>
            <td><form:label path="color">Color</form:label></td>
            <td><form:input path="color" name="color" id="color" type="text" /></td>
        </tr>
        <tr>
            <td><form:label path="regNumber">Registration number</form:label></td>
            <td><form:input path="regNumber" name="regNumber" id="regNumber" type="text"/></td>
        </tr>
    </table>
    <input type="submit" value="Add" /></form>

</form:form>

</body>
</html>