<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Short summary</title>
</head>
<body>
<h1>Your order</h1>
<p>Type of diet: ${dietName.name}
</p>
<p>Start order: ${startDate}</p>
<p>Expire order: ${expireDate}</p>
<p>Amount of daily kcal: ${kcal}
</p>
<p>Total cost: ${price}</p>
</p><a href='/user/order/${idUser}'>click to enter your data</a>
</body>
</html>
