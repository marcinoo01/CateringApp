<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Payment type</title>
</head>
<body>
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
