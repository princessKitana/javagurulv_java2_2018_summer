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
    <title>Errorrs in request</title>
</head>
<body>
<%
    AddTripResponse r = (AddTripResponse) request.getAttribute("model") ;
    if (!r.isSuccess()){
        List<ApplicationError> errors = r.getApplicationErrors();

        for(int i = 0; i < errors.size(); i+=1) { %>
<p><%=errors.get(i).getField()%></p>
<p><%=errors.get(i).getDescription()%></p>
<%}%>
}else{
%><p>Trip registered!</p>
<%}%>

</body>
</html>
