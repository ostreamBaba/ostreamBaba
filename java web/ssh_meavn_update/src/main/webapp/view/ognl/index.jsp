<%--
  Created by IntelliJ IDEA.
  User: ios666
  Date: 18-3-29
  Time: 下午6:33
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <s:property value="@com.viscu.ognl.TestOgnl01@staticValue"/>
    <s:property value="@com.viscu.ognl.TestOgnl01@testMethod()"/>
</body>
</html>
