<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 12.11.2019
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete User</title>
</head>
<body>
Вы действительно хотите удалить этого пользователя?<br><br><br>
<form action="/servletDelete" method="post">
    <input type="hidden" name="id" value=${id}>
    <input type="submit" value="Да"/>
</form>

<form action="/servletLogin" method="post">
    <input type="hidden" name="name" value="${name}"/>
    <input type="hidden" name="password" value="${password}"/>
    <input type="submit" value="Нет"/>
</form>

</body>
</html>
