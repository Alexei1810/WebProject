<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 11.11.2019
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>StartPage</title>
</head>
<body>
<h2>Добро пожаловать!</h2><br><br>
Сегодня:
<% Date date=new Date(); %>
<%=date.toString()%><br><br>
<%--<form action="/servlet" method="get">--%>
<%--    <input type="submit" value="Войти в БД"/>--%>
<%--</form>--%>
<br><form action="servletRegistration">
    <input type="submit" value="Регистрация"/>
</form><br>
<form action="servletLogin" method="get">
    <input type="submit" value="Войти в учетную запись">
</form>
</body>
</html>
