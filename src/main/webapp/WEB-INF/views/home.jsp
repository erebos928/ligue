<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <p></p>
        <table>
        <thead><tr><td>Name</td><td>Surname</td><td>Country</td><td>Teams</td></tr></thead>
        <tbody>
        <c:forEach items="${players}" var="player">
        <tr><td>${player.name}</td><td>${player.surname}</td><td>${player.nationality.country}</td></tr>
        </c:forEach>
        </tbody>
        </table>
    </body>
</html>
