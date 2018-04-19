<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ios666
  Date: 18-4-11
  Time: 下午9:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<script src="${basePath}/assets/js/jquery.js" type="text/javascript"></script>
<html>
<head>
    <title>Title</title>
</head>

<body>
<script>
    deferred();
    function deferred() {
        $.get("defer",function (data) {
            console.log(data);
            deferred();
        })
    }
</script>
</body>