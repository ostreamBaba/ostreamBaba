<%--
  Created by IntelliJ IDEA.
  User: ios666
  Date: 18-4-7
  Time: 下午6:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
</head>
<c:set var="basePath" value="#{pageContext.request.contextPath}"/>
<body>
    <form action="${basePath}/userReadByIdSsh">
        请输入需要查找的id: <input type="text" name="id" maxlength="5">
        <input type="submit" value="查找">
    </form>
</body>
</html>