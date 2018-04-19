<%--
  Created by IntelliJ IDEA.
  User: ios666
  Date: 18-3-29
  Time: 下午3:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<c:set var="base" value="#{pageContext.request.getcontextPath}"/>

<head>
    <title>Title</title>
</head>
<body>
    <a href="book_del">del</a><br/>
    <a href="book_add">add</a><br />
    <a href="book_update">update</a><br />
    <a href="book_find">find</a>
</body>
</html>
