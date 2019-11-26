<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 25.11.2019
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h3>Войти в учетную запись:</h3><br>
<form action="servletLogin" method="post">
    Ваш логин:
    <input type="text" name="name" placeholder="${message}"/><br><br>
    Ваш пароль:<input type="password" name="password" placeholder="${message}"/><br><br>
    <input type="submit" value="Войти">
</form>
<form action="enter.jsp">
    <input type="submit" value="Назад">
</form>
</body>
</html>
