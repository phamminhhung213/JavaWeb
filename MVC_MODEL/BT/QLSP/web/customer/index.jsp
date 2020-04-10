<%--
  Created by IntelliJ IDEA.
  User: Techcare
  Date: 4/8/2020
  Time: 2:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Customer Management Application</title>
</head>
<body>
<h1 style="text-align: center">Customer Management</h1>
<h2 style="text-align: center">
  <a href="new">Add new customer</a>
  <a href="list">List all customer</a>
</h2>
<div style="padding-left: 442px">
  <table border="1" cellpadding="5">
    <caption>List of customer</caption>
    <tr>
      <th>ID</th>
      <th>Name</th>
      <th>Phone</th>
      <th>Email</th>
      <th>Action</th>
    </tr>
    <tr>
      <c:forEach var="customer" items="${listCustomer}">
    <tr>
      <td><c:out value="${customer.getId()}"></c:out></td>
      <td><c:out value="${customer.getName()}"></c:out></td>
      <td><c:out value="${customer.getPhone()}"></c:out></td>
      <td><c:out value="${customer.getEmail()}"></c:out></td>
      <td>
        <a href="edit?id=<c:out value='${customer.getId()}'/>">Edit</a>
        <a href="delete?id=<c:out value='${customer.getId()}'/> ">Delete</a>
      </td>

    </tr>
    </c:forEach>
    </tr>

  </table>
</div>
</body>
</html>