<%--
  Created by IntelliJ IDEA.
  User: Techcare
  Date: 4/14/2020
  Time: 2:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/result" method="get">
    <input type="text" name="number_one" >
    <input type="text" name="number_two"><br>
    <input type="submit"  value="+" name="operator">
    <input type="submit" value="-" name="operator">
    <input type="submit" value="x" name="operator">
    <input type="submit" value="/" name="operator"><br>
    <h1>Kết quả : ${result}</h1>
    <h1 style="color: red">${error}</h1>

</form>
</body>
</html>
