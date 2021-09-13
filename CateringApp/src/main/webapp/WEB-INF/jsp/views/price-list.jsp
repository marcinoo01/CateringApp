<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: marcinmistela
  Date: 11/09/2021
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Price-list</title>
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
        <c:forEach var="k" begin="1500" step="500" end="3000">
            <th>
                    ${k} <%="kcal"%>
            </th>
        </c:forEach>
        <th>

        </th>
    </tr>
    <c:forEach items="${diets}" var="item">
        <tr>
            <td>
                    ${item.dietName}
            </td>
            <c:forEach var="k" step="2" begin="0" end="6">
                <td>
                        ${item.price + k}
                </td>
            </c:forEach>
            <td>
                <a href="/diets/${item.id}">order</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
