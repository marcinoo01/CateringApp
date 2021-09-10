<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        .error {
            color: #ff4672;
        }
    </style>
    <title>Title</title>
</head>
<body>
<a href="/login">Login</a>
<a href="/localizations">Localizations</a>
<a href="/diets">Diets</a>
<a href="/price-list">Price list</a>
<a href="/contact">Contact</a>
<h1>Login</h1>
<table>
    <form:form method="post" modelAttribute="user">
        <tr>
            <td><form:label path="username">username</form:label></td>
            <td><form:input path="username"/></td>
        </tr>
        <tr>
            <td><form:label path="password">password</form:label></td>
            <td><form:password path="password"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="login"></td>
        </tr>
        <tr>
            <td>
                <div class="error"><c:if test="${param.error != null}">
                    <p>Invalid username or password</p>
                </c:if>
                </div>
            </td>
        </tr>
        <td>
            <p>If you don't have an account register
                <a href="/register">here.</a></p>
        </td>
    </form:form>
</table>
</body>
</html>
