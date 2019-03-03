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
    <script src="/static/js/jquery/jquery-3.0.0.js"></script>
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
<button id="button_show">显示/隐藏</button>
<table id="showTable" border="1" align="center" width="50%" style="display: none">
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
<script>
$(function () {

    $('#showTable').hide();

    $("#button_show").click(function () {
        $('#showTable').show()
        $.ajax({
            type:"POST",
            dataType:'json',
            url:'${pageContext.servletContext.contextPath}/jsp/json',
            success:function(res) {
                var users = res;
                var tr_td="";
                for (var i=0;i<users.length;i++){
                    var tr = users[i];
                    tr_td +="<tr>"+"<td>"+tr.id+"</td>"+"<td>"+tr.name+"</td>"+"<td>"+tr.age+"</td>"+"</tr>";
                }
                $('#showTable').append(tr_td);
            }
        })
    });
});

</script>
</body>
</html>
