<%@ page import="java.time.LocalDate" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: marcinmistela
  Date: 12/09/2021
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <form method="post">
        <form:form method="post" modelAttribute="order">
            <tr><label>Start Date</label></tr>
            <tr><input name="startDate" type="date" min="<%=LocalDate.now().plusDays(1L)%>"
                       max="<%=LocalDate.now().plusMonths(1L)%>"/></tr>
            <tr><label>Expire Date</label></tr>
            <tr><input name="expireDate" type="date" min="<%=LocalDate.now().plusDays(2L)%>"
                       max="<%=LocalDate.now().plusMonths(2L)%>"/></tr>
            <tr>
                <td><form:label path="kcal">Kcal </form:label></td>
                <td><form:select path="kcal" items="${kcal}"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="order"/></td>
            </tr>
        </form:form>
    </form>
</table>
</body>
</html>
