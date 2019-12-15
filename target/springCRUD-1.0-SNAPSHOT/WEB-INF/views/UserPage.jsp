<%--
  Created by IntelliJ IDEA.
  User: imam5
  Date: 15.12.2019
  Time: 17:44
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="text-align-last: center">
<h1>Hello User !</h1>
    <form>
        <a href="<c:url value="/logout" />">Logout</a>
    </form>
</div>
</body>

</html>
