<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <style>
        .error {
            color: #ff4672;
        }
    </style>
</head>
<body>
<a href="/login">Login</a>
<a href="/localizations">Localizations</a>
<a href="/diets">Diets</a>
<a href="/price-list">Price list</a>
<a href="/contact">Contact</a>
<h1>Register</h1>
<table>
    <form:form method="post" modelAttribute="user">
        <tr>
            <div class="input-group mb-3">
                <span class="input-group-text" id="basic-addon1"></span>
                <form:input path="username" type="text" class="form-control" placeholder="Username"
                            aria-label="Username" aria-describedby="basic-addon1"/>
            </div>
            <td><form:errors path="username" cssClass="error"/></td>
        </tr>
        <tr>
            <div class="input-group mb-3">
                <span class="input-group-text" id="basic-addon1"></span>
                <form:input path="email" type="text" class="form-control" placeholder="Email" aria-label="Email"
                            aria-describedby="basic-addon1"/>
            </div>
            <td><form:errors path="email" cssClass="error"/></td>
        </tr>
        <tr>
            <div class="input-group mb-3">
                <span class="input-group-text" id="basic-addon1"></span>
                <form:input path="password" type="password" class="form-control" placeholder="Password"
                            aria-label="Password" aria-describedby="basic-addon1"/>
            </div>
            <td><form:errors path="password" cssClass="error"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="register"/></td>
        </tr>
    </form:form>
</table>
</body>
</html>