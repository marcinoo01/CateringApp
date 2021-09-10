<%@ page import="java.time.LocalDate" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: marcinmistela
  Date: 08/09/2021
  Time: 13:57
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
<br>
<table>
    <form method="post">
        <form:form method="post" modelAttribute="order">
            <tr><label>Start Date</label></tr>
            <tr><input name="startDate" type="date" min="<%=LocalDate.now().plusDays(1L)%>" max="<%=LocalDate.now().plusMonths(1L)%>"></tr>
            <tr><label>Expire Date</label></tr>
            <tr><input name="expireDate" type="date" min="<%=LocalDate.now().plusDays(2L)%>" max="<%=LocalDate.now().plusMonths(2L)%>"/></tr>
            <tr>
                <td><form:label path="kcal">Kcal </form:label></td>
                <td><form:select path="kcal" items="${kcal}"/></td>
            </tr>
            <tr><td><input type="submit" name="order"/> </td></tr>
        </form:form>
    </form>
</table>
<%--<table>--%>
<%--<form:form method="post" modelAttribute="order">--%>
<%--    <tr>--%>
<%--        <td><form:label path="startDate">Start date</form:label></td>--%>
<%--        <td><form:input path="startDate" cssClass="form-control"></form:input></td>--%>
<%--&lt;%&ndash;        <td><fmt:formatDate type="time" value="$P">&ndash;%&gt;--%>
<%--    </tr>--%>
<%--    <tr>--%>
<%--        <td><form:label path="expireDate">Expire date</form:label></td>--%>
<%--        <td><form:input path="expireDate" cssClass="form-control"></form:input></td>--%>
<%--    </tr>--%>
<%--    <tr>--%>
<%--        <td><form:label path="kcal">Kcal </form:label></td>--%>
<%--        <td><form:radiobuttons path="kcal" items="${kcal}"></form:radiobuttons></td>--%>
<%--    </tr>--%>
<%--    <tr>--%>
<%--        <td><input type="submit" value="confirm"></td>--%>
<%--    </tr>--%>
<%--</form:form>--%>
<%--</table>--%>
</body>
</html>
