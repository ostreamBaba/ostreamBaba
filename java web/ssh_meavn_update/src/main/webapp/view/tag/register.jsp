<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: ios666
  Date: 18-3-29
  Time: 下午5:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <s:form>
        <s:hidden name="user" value="username" />
        <s:textfield label="用户名" name="username"/>
        <s:password label="密码" name="pwd1"/>
        <s:password label="确认密码" name="pwd2"/>
        <s:radio name="sex" label="性别" list="#{'0':'男','1':'女'}" value="1"/>
        <s:checkboxlist list="{'足球','篮球','排球','羽毛球'}" label="爱好" name="interesters" />
        <s:select list="#{'beijing':'北京','guangzhou':'广州','shanghai','上海'}" label="所在城市" name="city"
            listKey="key" listValue="value"/>
        <s:textarea label="个性签名" name="description" rows="5" cols="15"/>
        <s:file name="upLoadFild" label="头像"/>
        <s:submit value="提交"/>
        <s:reset value="重置"/>
    </s:form>
</body>
</html>
