<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: marcinmistela
  Date: 07/09/2021
  Time: 19:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<table>
    <tr>
        <th>
            Delete
        </th>
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
        <td><a href="/delete/${user.id}">Delete</a></td>
        <td>${user.id}</td>
        <td>${user.username}</td>
        <td>${user.email}</td>
        <td>${user.role}</td>
        <td>${user.createdOn}</td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
