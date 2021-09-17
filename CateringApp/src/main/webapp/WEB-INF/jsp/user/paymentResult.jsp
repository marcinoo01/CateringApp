<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Details</title>
</head>
<body>
<h1>Order Details</h1>
<table>
    <tr>
        <td>name: ${name}
        </td>
    </tr>
    <tr>
        <td>surname: ${surname}
        </td>
    </tr>
    <tr>
        <td>email: ${email}
        </td>
    </tr>
    <tr>
        <td>city: ${city}
        </td>
    </tr>
    <tr>
        <td>address: ${address}
        </td>
    </tr>
    <tr>
        <td>zip: ${zip}
        </td>
    </tr>
    <tr>
        <td>phone number: ${phoneNumber}
        </td>
    </tr>
    <tr>
        <td>Start date: ${startDate}
        </td>
    </tr>
    <tr>
        <td>Expire date: ${expireDate}
        </td>
    </tr>
    <tr>/
        <td>Diet name: ${diet.name}
        </td>
    </tr>
    <tr>
        <td>Kcal: ${kcal}
        </td>
    </tr>
    <tr>
        <td>prize: ${prize}
        </td>
    </tr>
    <tr>
        <td>
            description: ${description}
        </td>
    </tr>
    <tr>
        <td>Type of payment: ${typeOfPayment}</td>
    </tr>
</table>
<a href="/user">Back to homepage</a>
</body>
</html>
