<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="resources/style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <p></p>
        <table class="table table-dark">
        <thead class="text-uppercase font-weight-bold"><tr><td>Name</td>
        <td>Surname</td><td>Age</td><td>Country</td><td>Teams</td></tr></thead>
        <tbody>
        <c:forEach items="${players}" var="player">
        <tr>
        
        <c:set var="rowspanValue" value="-1"></c:set>
        <c:if test="${player.teams.size() > 1}" >
        <c:set var="rowspanValue" value="${player.teams.size()+1}"></c:set>
        </c:if>
        <td rowspan="${rowspanValue}" class="align-middle">${player.name}</td>
        <td rowspan="${rowspanValue}" class="align-middle">${player.surname}</td>
        <td rowspan="${rowspanValue}" class="align-middle">${player.age}</td>
        <td rowspan="${rowspanValue}" class="align-middle">${player.nationality.country}</td>
        <c:choose>
        <c:when test="${player.teams.size() == 0 }"><td>---</td>
        </c:when>
        <c:when test="${player.teams.size() == 1 && rowspanValue == -1 }"><td><c:out value="${player.teams.toArray()[0].name }"></c:out>
        <span class='badge ${player.teams.toArray()[0].score < 700 ? "badge-primary" : "badge-warning"}'>${player.teams.toArray()[0].score}</span>
        </td>
        </c:when>
        <c:otherwise>
        <c:forEach var="team" items="${player.teams}">
        	<tr><td><c:out value="${team.name}"></c:out><span class='badge ${player.teams.toArray()[0].score < 700 ? "badge-primary" : "badge-warning"}'>${team.score}</span></td></tr>
        </c:forEach>
        </c:otherwise>
        </c:choose>
        </tr>
        </c:forEach>
        
        </tbody>
        </table>
    </body>
</html>
