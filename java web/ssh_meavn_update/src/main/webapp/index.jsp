<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<c:set var="basePath" value="${pageContext.request.ContextPath}"/>--%>
<html>
<head>
    <title><s:text name="loginPage" /></title>
</head>
<body>
<form action="userLogin.action" method="post">
    <input type="text" name="user.name" placeholder="输入用户名" />
    <br/>
    <input type="password" name="user.password" placeholder="输入密码" />
    <br />
    <input type="submit" value="登录">
    <input type="reset" value="重置">
</form>
</body>
</html>
