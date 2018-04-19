<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: ios666
  Date: 18-3-29
  Time: 下午11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
    <s:form action="fileUpload" method="POST" enctype="multipart/form-data">
        <s:file name="file" label="上传文件"/>
        <s:submit value="提交" />
        <s:reset value="重置" />
    </s:form>
</body>
</html>
