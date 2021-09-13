<%--
  Created by IntelliJ IDEA.
  User: marcinmistela
  Date: 06/09/2021
  Time: 17:37
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
<h1>HELLO ${username}</h1>
<a href="/history">History</a>
<a href="/favourite">Favourite</a>
<a href="/user/diets/${id}">Order</a>
<a href="/logout">Logout</a>
</body>
</html>
