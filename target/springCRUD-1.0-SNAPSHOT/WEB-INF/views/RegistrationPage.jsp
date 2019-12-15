<%--
  Created by IntelliJ IDEA.
  User: imam5
  Date: 15.12.2019
  Time: 17:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title> Registration </title>
</head>
<body>
<div style="text-align: center;">
    <h1>Welcome!</h1>
</div>
<div align="center">
    <h4>User</h4>
    <form method="post" action="/registration" modelAttribute="user">
        <table style="with: 80%">
            <tr>
                <td>Name</td>
                <td><input type="text" name="name"  placeholder="name" required/></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password"  placeholder="password" required/></td>
            </tr>
            <tr>
                <td>Role</td>
                <td><input type="text" READONLY name="role" value="USER"/></td>
            </tr>
        </table>
        <input type="submit" value="JOIN"/>
    </form>
</div>
<div align="center">
    <td><input type="button" value="CANCEL" onclick="window.location.href='../..'" /></td>
</div>
</body>
</html>
