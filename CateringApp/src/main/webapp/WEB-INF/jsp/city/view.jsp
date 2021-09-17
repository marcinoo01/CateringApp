<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of Cities</title>
</head>
<body>
<h1>Here are the locations of Delivery</h1>
<table>
    <c:forEach items="${cities}" var="item">
        <tr>
            <td>
                    ${item.cityName}
            </td>
        </tr>
    </c:forEach>
</table>
<a href="/diets">Click to make an order</a>
or
<a href="/price-list">here to see a price</a>
</body>
</html>
