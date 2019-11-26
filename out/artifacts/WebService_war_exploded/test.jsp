<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 19.11.2019
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Test</title>
</head>
<body>
<c:out value="output"/>
<c:set var="out" value="smth"/>
<c:out value="${login}"/>
<c:out value="${password}"/>

</body>
</html>
