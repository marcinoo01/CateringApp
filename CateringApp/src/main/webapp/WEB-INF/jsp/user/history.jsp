<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>History</title>
</head>
<body>
<h1>History</h1>
<table>
    <th>
        Diet name
    </th>
    <th>
        Start date
    </th>
    <th>
        Expire date
    </th>
    <th>
        Kcal
    </th>
    <th>
        Price
    </th>
    <c:forEach items="${history}" var="item">
        <tr>
            <td>
                    ${item.diet.name}
            </td>
            <td>
                    ${item.startDate}
            </td>
            <td>
                    ${item.expireDate}

            </td>
            <td>
                    ${item.kcal}
            </td>
            <td>
                    ${item.totalPrice}
            </td>
        </tr>
    </c:forEach>
</table>
<a href="/user">Go to homepage</a>
</body>
</html>
