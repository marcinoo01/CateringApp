<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>payment</title>
</head>
<body>
<a href="/login">Login</a>
<a href="/localizations">Localizations</a>
<a href="/diets">Diets</a>
<a href="/price-list">Price list</a>
<a href="/contact">Contact</a>
<h1>
    Payment type
</h1>
<table>
    <form method="post">
        <tr>
            <th>Method of payment</th>
        </tr>
        <tr>
            <td><input type="radio" name="typeOfPayment" value="BLIK" checked/>BLIK</td>
        </tr>
        <tr>
            <td><input type="radio" name="typeOfPayment" value="PAYPAL"/>PAYPAL</td>
        </tr>
        <tr>
            <td><input type="radio" name="typeOfPayment" value="BANK TRANSFER"/>BANK TRANSFER</td>
        </tr>
        <tr>
            <td><input type="radio" name="typeOfPayment" value="APPLE PAY"/>APPLE PAY</td>
        </tr>
        <tr>
            <td><input type="radio" name="typeOfPayment" value="CRYPTOCURRENCY"/>CRYPTO-CURRENCY</td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="confirm"/>
            </td>
        </tr>
    </form>
</table>
</body>
</html>
