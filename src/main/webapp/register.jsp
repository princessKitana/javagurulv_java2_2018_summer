<%@ page import="lv.javaguru.java2.buisnesslogic.user.register.RegisterUserResponse" %>
<%@ page import="lv.javaguru.java2.buisnesslogic.ApplicationError" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Registration</title>
</head>
<body>
<h1>Registration</h1>
<form action="register" method="post">
    <table style="with: 50%">
        <tr>
            <td>First Name</td>
            <td><input type="text" name="first_name" /></td>
        </tr>
        <tr>
            <td>Last Name</td>
            <td><input type="text" name="last_name" /></td>
        </tr>
        <tr>
            <td>UserName</td>
            <td><input type="text" name="username" /></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="password" /></td>
        </tr>
 </table>
    <input type="submit" value="Submit" /></form>

<%
    Object o = request.getAttribute("model");
    o.getClass()
    List<ApplicationError> errors = (List<ApplicationError>) request.getAttribute("model");


    for(int i = 0; i < errors.size(); i+=1) { %>
<tr>
    <td><%=errors.get(i).getField()%></td>
    <td><%=errors.get(i).getDescription()%></td>

</tr>
<% } %>

</body>
</html>