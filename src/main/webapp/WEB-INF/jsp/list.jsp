<%--
  Created by IntelliJ IDEA.
  User: liuxg
  Date: 2019/3/2
  Time: 23:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>list</title>
</head>
<body>
<table border="1" align="center" width="50%">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Age</th>
    </tr>
    <c:forEach items="${users }" var="user">
        <tr>
            <td>${user.id }</td>
            <td>${user.name }</td>
            <td>${user.age }</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
