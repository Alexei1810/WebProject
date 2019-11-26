<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 12.11.2019
  Time: 19:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create User</title>
</head>
<body>
<form action="/servletGetAll" method="post" >
    <h3>Создание нового пользователя:</h3>
    Введите логин:
    <input type="text" name="login" placeholder="${message}" ><br><br>
    Введите пароль:
    <input type="password" name="pass" ><br><br>
    <input type="hidden" name="name" value="${name}">
    <input type="hidden" name="password" value="${password}">
    <input type="submit" value="Создать">
</form>
<form action="/servletGetAll" method="get">
    <input type="hidden" name="name" value="${name}">
    <input type="hidden" name="password" value="${password}">
    <input type="submit" value="Назад">
</form>
</body>
</html>
