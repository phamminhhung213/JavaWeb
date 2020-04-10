<%--
  Created by IntelliJ IDEA.
  User: Techcare
  Date: 4/9/2020
  Time: 8:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 style="text-align: center"><a href="list">List all customer</a></h1>
<div align="center">
    <form action="update" method="post">
        <table border="1" cellpadding="5">
            <caption>
                Add new customer
            </caption>
            <tr>
                <th>Customer ID</th>
                <td>
                    <input type="hidden" name="id" size="45" value="${customerEdit.getId()}">
                </td>
            </tr>
            <tr>
                <th>Customer Name</th>
                <td>
                    <input type="text" name="name" size="45" value="${customerEdit.getName()}">
                </td>
            </tr>
            <tr>
                <th>Customer phone</th>
                <td>
                    <input type="text" name="phone" size="45" value="${customerEdit.getPhone()}">
                </td>
            </tr>
            <tr>
                <th>Customer Email</th>
                <td>
                    <input type="text" name="email" size="45" value="${customerEdit.getEmail()}">
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" size="45">
                </td>
            </tr>

        </table>
    </form>

</div>
</body>
</html>
