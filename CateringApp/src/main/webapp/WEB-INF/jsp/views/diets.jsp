<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of Diets</title>
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
        ${diet.name}
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
