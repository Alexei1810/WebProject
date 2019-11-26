<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 12.11.2019
  Time: 19:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Information</title>
</head>
<body>
<h3>Изменить информацию о пользователе:</h3><br>
<form action="/servletUpdate" method="post">
    <input type="hidden" name="id" value="${id}">
    Логин:
    <input type="text" name="name" value="${name}"><br><br>
    Пароль:
    <input type="text" name="password" value="${password}"><br><br>
    <input type="submit" value="Изменить"><br>
</form>
<form action="/servletLogin" method="post" >
    <input type="hidden" name="name" value="${name}">
    <input type="hidden" name="password" value="${password}">
    <input type="submit" value="Назад">
</form>
</body>
</html>
