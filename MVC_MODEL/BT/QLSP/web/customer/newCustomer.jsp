<%--
  Created by IntelliJ IDEA.
  User: Techcare
  Date: 4/9/2020
  Time: 8:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 style="text-align: center"><a href="list">List all customer</a></h1>
<div align="center">
    <form action="create" method="post">
        <table border="1" cellpadding="5">
            <caption>
                Add new customer
            </caption>
            <tr>
                <th>Customer ID</th>
                <td>
                    <c:if test="${message!=null}">
                        <p style="color:red"><c:out value="${message}" /></p>
                    </c:if>
                    <input type="text" name="id" size="45">
                </td>
            </tr>
            <tr>
                <th>Customer Name</th>
                <td>
                    <input type="text" name="name" size="45" value="${customer.getName()}">
                </td>
            </tr>
            <tr>
                <th>Customer phone</th>
                <td>
                    <input type="text" name="phone" size="45" value="${customer.getPhone()}">
                </td>
            </tr>
            <tr>
                <th>Customer Email</th>
                <td>
                    <input type="text" name="email" size="45" value="${customer.getEmail()}">
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
