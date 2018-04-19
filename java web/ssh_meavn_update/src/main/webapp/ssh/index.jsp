<%--
  Created by IntelliJ IDEA.
  User: ios666
  Date: 18-4-6
  Time: 下午6:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>ssh框架</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/userAction_add.action" method="post">
        用户名:<input type="text" name="username"><br/>
        密码：<input type="password" name="password"><br/>
        <input type="submit" value="添加">
    </form>
</body>
</html>
