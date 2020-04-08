<%--
  Created by IntelliJ IDEA.
  User: Techcare
  Date: 4/8/2020
  Time: 8:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Discount Calculator</title>
</head>
<body>
<h2>Discount Calculator</h2>
<form action="/discount" method="post">

    <label>Product Description: </label><br/>
    <input type="text" name="description" placeholder="Product Description"/><br/>
    <label>List Price: </label><br/>
    <input type="text" name="price" placeholder="List Price"/><br/>
    <label>Discount Percent: </label><br/>
    <input type="text" name="percent" placeholder="Discount Percent"/><br/>
    <input type = "submit" id = "submit" value = "Calculate Discount"/>


</form>

</body>
</html>
