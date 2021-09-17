<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of users</title>
    <link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<a href="/login">Login</a>
<a href="/localizations">Localizations</a>
<a href="/diets">Diets</a>
<a href="/price-list">Price list</a>
<a href="/contact">Contact</a>
<table>
    <tr>
        <th>
            ID
        </th>
        <th>
            username
        </th>
        <th>
            email
        </th>
        <th>
            role
        </th>
        <th>
            created
        </th>
    </tr>
    <c:forEach var="user" items="${users}">
    <tr>
        <td>${user.id}</td>
        <td>${user.username}</td>
        <td>${user.email}</td>
        <td>${user.role}</td>
        <td>${user.createdOn}</td>
        <td><a href="/admin/delete/${user.id}">DELETE USER</a> </td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
