<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 11.11.2019
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AllUsers</title>
</head>
<body>
<h3>Таблица пользователей:</h3>
<table border="1">
    <tr>
        <td>ID</td>
        <td>Имя</td>
        <td>Пароль</td>
    </tr>
<c:forEach items="${users}" var="user">
    <tr>
        <td>${user.id}</td>
        <td>${user.name}</td>
        <td>${user.password}</td>
        <td>
            <form action="/getAllDelete" method="post">
                <input type="hidden" name="name" value="${name}">
                <input type="hidden" name="password" value="${password}">
                <input type="hidden" name="id" value="${user.id}"/>
                <input type="submit" value="Удалить"/>
            </form>
        </td>
    </tr>
</c:forEach>
</table>
<br>
<form action="/servletGetAllCreate" method="get">
    <input type="hidden" name="name" value="${name}">
    <input type="hidden" name="password" value="${password}">
    <input type="submit" value="Добавить нового пользователя"/>
</form>

<form action="servletLogin" method="post">
    <input type="hidden" name="name" value="${name}">
    <input type="hidden" name="password" value="${password}">
    <input type="submit" value="Назад"/>
</form>
</body>
</html>
