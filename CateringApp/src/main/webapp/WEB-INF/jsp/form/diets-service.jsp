<%@ page import="java.time.LocalDate" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Diet type3</title>
</head>
<body>
<a href="/login">Login</a>
<a href="/localizations">Localizations</a>
<a href="/diets">Diets</a>
<a href="/price-list">Price list</a>
<a href="/contact">Contact</a>
<br>
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
