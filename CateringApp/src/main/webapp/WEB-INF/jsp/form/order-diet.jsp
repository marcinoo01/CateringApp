<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>order-diet</title>
    <style>
        .error {
            color: maroon;
        }
    </style>
</head>
<body>
<h1></h1>
<a href="/login">Login</a>
<a href="/localizations">Localizations</a>
<a href="/diets">Diets</a>
<a href="/price-list">Price list</a>
<a href="/contact">Contact</a>
<table>
    <form:form modelAttribute="client" method="post">
        <tr>
            <td><form:label path="name">Name</form:label></td>
            <td><form:input path="name"/></td>
            <td><form:errors path="name" cssClass="error"/></td>
        </tr>
        <tr>
            <td><form:label path="surname">Surname</form:label></td>
            <td><form:input path="surname"/></td>
            <td><form:errors path="surname" cssClass="error"/></td>
        </tr>
        <tr>
            <td><form:label path="email">Email</form:label></td>
            <td><form:input path="email"/></td>
            <td><form:errors path="email" cssClass="error"/></td>
        </tr>
        <tr>
            <td><form:label path="city">City</form:label></td>
            <td><form:select path="city" items="${cities}" itemLabel="cityName" itemValue="id"/></td>
        </tr>
        <tr>
            <td><form:label path="phoneNumber">Phone Number</form:label></td>
            <td><form:input path="phoneNumber"/></td>
            <td><form:errors path="phoneNumber" cssClass="error"/></td>
        </tr>
        <tr>
            <td><form:label path="zip">Zip Code</form:label></td>
            <td><form:input path="zip"/></td>
            <td><form:errors path="zip" cssClass="error"/></td>
        </tr>
        <tr>
            <td><form:label path="address">Adres</form:label></td>
            <td><form:input path="address"/></td>
            <td><form:errors path="address" cssClass="error"/></td>
        </tr>
        <tr>
            <td><form:label path="description">Description</form:label></td>
            <td><form:textarea path="description"></form:textarea></td>
        </tr>
        <tr>
            <td>
                <form:hidden path="diet"/>
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="confirm"></td>
        </tr>
    </form:form>
</table>
</body>
</html>

