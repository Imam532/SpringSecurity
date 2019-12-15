<%--
  Created by IntelliJ IDEA.
  User: imam5
  Date: 26.11.2019
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
<div align="center">
    <h1>Hello, alcoholic!</h1>

    <form action="/" method="get">
        <table border="1" cellpadding="5">
            <tr>
                <th><input type="button" value="Submit" onclick="window.location.href='/login'"/></th>
                <th><input type="button" value="new user" onclick="window.location.href='/registration'" /></th>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
