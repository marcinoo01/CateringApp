<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: marcinmistela
  Date: 08/09/2021
  Time: 12:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
      Diet Name
    </th>
    <th>
      Description
    </th>
    <th>

    </th>
  </tr>
  <c:forEach items="${diets}" var="diet">
    <tr>
      <td>
        ${diet.dietName}
      </td>
      <td>
        ${diet.description}
      </td>
      <td>
        <a href="/diets/${diet.id}">Order</a>
      </td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
