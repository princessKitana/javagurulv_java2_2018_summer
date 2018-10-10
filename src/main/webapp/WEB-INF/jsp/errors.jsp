<%--
  Created by IntelliJ IDEA.
  User: daindrez
  Date: 30.09.2018
  Time: 12:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Errors in request</title>
</head>
<body>
<c:forEach items="${exception}" var="error">
    <tr>
        <td>${error.getField()}</td>
        <td>${error.getDescription()}</td>

    </tr>
</c:forEach>

</body>
</html>
