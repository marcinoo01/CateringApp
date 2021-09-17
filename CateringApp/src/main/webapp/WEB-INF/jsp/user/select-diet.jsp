<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
