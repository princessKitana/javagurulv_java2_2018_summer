<%@ page import="lv.javaguru.java2.buisnesslogic.trip.addtrip.AddTripResponse" %>
<%@ page import="lv.javaguru.java2.buisnesslogic.ApplicationError" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Apply For trip - to be removed</title>
</head>
<body>
<a href="<spring:url value="/index"/>">Let's Ride</a>

<h1>Apply for trip</h1>

<%--@elvariable id="tpDTO" type=""--%>
<form:form id="applyForTripForm" modelAttribute="tpDTO" action="applyForTripProcess" method="post">
    <table >
        <tr>
            <td><form:label path="trip">Trip ID</form:label></td>
            <td><form:input path="trip" name="trip" id="trip" type="number" /></td>
        </tr>
        <tr>
            <td><form:input path="passanger" name="passanger" id="passanger" type="hidden" value="${userId}"  /></td>
        </tr>
    </table >
    <input type="submit" value="Submit" /></form>

</form:form>

${tpDTO.id == null ? "not applied yet" : "You are succesflly applied!"+tpDTO.id}

<p>${tpDTO.getId()}</p>



</body>
</html>