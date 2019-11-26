<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 25.11.2019
  Time: 18:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Page</title>
</head>
<body>
<h3>Моя страница:</h3><br><br>
Логин:${user.name}<br><br>
Пароль:${user.password}<br><br>
Статус:${user.role}<br><br><br>
<form action="/servletUpdate" method="get">
    <input type="hidden" name="id" value="${user.id}"/>
    <input type="hidden" name="name" value="${user.name}"/>
    <input type="hidden" name="password" value="${user.password}"/>
    <input type="submit" value="Изменить информацию"/>
</form>
<form action="/servletDelete" method="get">
    <input type="hidden" name="id" value="${user.id}"/>
    <input type="hidden" name="name" value="${user.name}"/>
    <input type="hidden" name="password" value="${user.password}"/>
    <input type="submit" value="Удалить аккаунт"/>
</form>
<form action="login.jsp">
    <input type="submit"value="Выйти"/>
</form><br>
<c:set var="valid" value="admin"/>
<c:if test="${user.role eq valid}">
    <form action="servletGetAll" method="get">
        <input type="hidden" name="name" value="${user.name}">
        <input type="hidden" name="password" value="${user.password}">
        <input type="submit" value="Таблица пользователей">
    </form>
</c:if>
</body>
</html>
