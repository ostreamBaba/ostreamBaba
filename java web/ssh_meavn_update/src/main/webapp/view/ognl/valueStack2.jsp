<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: ios666
  Date: 18-3-29
  Time: 下午10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <s:debug>
        商品名称：<s:property value="p3.name" /><br/>
        商品价格：<s:property value="p3.price" />
    </s:debug>
    <s:debug>
        商品名称：<s:property value="model.name" /><br/>
        商品价格：<s:property value="model.price" />
    </s:debug>

    //el
    商品名称：${model.name}<br/>
    商品价格：${model.price}
</body>
</html>
