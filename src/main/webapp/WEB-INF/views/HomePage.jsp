<%--
  Created by IntelliJ IDEA.
  User: imam5
  Date: 15.12.2019
  Time: 17:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>User Management Screen</title>
</head>
<body>
<div align="center">
    <h1>User List</h1>

    <table border="1" cellpadding="3">

        <th>Id</th>
        <th>Name</th>
        <th>Role</th>
        <th>Action</th>

        <c:forEach var="user" items="${listUsers}">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td><c:forEach var="role" items="${user.userRoles}">
                    ${role.role}
                </c:forEach></td>
                <td><input type="button" value="edit" onclick="window.location.href='/admin/update?id=${user.id}'"/>
                    <input type="button" value="delete" onclick="window.location.href='/admin/delete?id=${user.id}'"/>
                </td>

            </tr>
        </c:forEach>
        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td><input type="button" value="new user" onclick="window.location.href='/admin/newUser'"/></td>
        </tr>
    </table>
    <input type="button" value="logout" onclick="window.location.href='/logout'"/>
</div>
</body>
</html>