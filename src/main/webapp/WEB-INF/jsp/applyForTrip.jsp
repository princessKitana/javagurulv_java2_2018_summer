<%@ page import="lv.javaguru.java2.buisnesslogic.trip.addtrip.AddTripResponse" %>
<%@ page import="lv.javaguru.java2.buisnesslogic.ApplicationError" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Apply For trip</title>
</head>
<body>
<h1>Apply for trip</h1>

<%--@elvariable id="tpDTO" type=""--%>
<form:form id="applyForTripForm" modelAttribute="tpDTO" action="applyForTripProcess" method="post">
    <table >
        <tr>
            <td><form:label path="trip">Trip ID</form:label></td>
            <td><form:input path="trip" name="trip" id="trip" type="number" /></td>
        </tr>
        <tr>
            <td><form:label path="passanger">Passanger ID</form:label></td>
            <td><form:input path="passanger" name="passanger" id="passanger" type="number" /></td>
        </tr>
    </table >
    <input type="submit" value="Submit" /></form>

</form:form>

if (tpDTO.getId()=!null) <p>Success!</p>
${tpDTO.id == null ? "I have nothing to say" : "You are succesflly applied!"+tpDTO.id}

<p>${tpDTO.getId()}</p>

</body>
</html>