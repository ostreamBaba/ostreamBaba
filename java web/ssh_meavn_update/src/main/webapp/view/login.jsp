<%--
  Created by IntelliJ IDEA.
  User: ios666
  Date: 18-3-29
  Time: 下午4:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>

<body>
<center>
${requestScope.msg}<br/>
    <form action="login.action" method="post">
        <table>
            <tr>
                <td><label  style="text-align: right;">用户名:</label></td>
                <td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td><label style="text-align: right;">密码:</label></td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td align="right" colspan="2">
                    <input type="submit" value="登录">
                </td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>
