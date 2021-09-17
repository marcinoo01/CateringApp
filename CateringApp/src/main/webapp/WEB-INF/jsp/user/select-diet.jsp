<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: marcinmistela
  Date: 14/09/2021
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Diet</title>
</head>
<body>
<table>
    <c:forEach items="${diets}" var="diet">
        <tr>
            <td>
                    ${diet.name}
            </td>
            <td>
                    ${diet.description}
            </td>
            <td>
                <a href="diets/${idUser}/${diet.id}">Order</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
