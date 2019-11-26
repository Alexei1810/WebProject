<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 25.11.2019
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<h3>Регистрация:</h3><br>
<form action="servletRegistration" method="post">
    Введите ваш логин:
    <input type="text" name="name" placeholder="${message}"/><br><br>
    Введите ваш пароль:
    <input type="text" name="password" placeholder=""/><br><br>
    <input type="submit" value="Зарегистрироваться">
</form>
<form action="enter.jsp">
    <input type="submit" value="Назад"/>
</form>
</body>
</html>
