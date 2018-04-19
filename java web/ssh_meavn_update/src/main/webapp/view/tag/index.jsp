<%--
  Created by IntelliJ IDEA.
  User: ios666
  Date: 18-3-29
  Time: 下午5:10
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>struts标签库</title>
</head>
<body>
    <table border="1px" cellpadding="0px" cellspacing="0px">
        <s:iterator var="name"
            value="{'java','java web','oracle','mysql'}"
            status="st">
            <s:if test="#st.odd">
                <tr style="background-color: white;">
                    <td><s:property value="name" /></td>
                </tr>
            </s:if>
            <s:else>
                <tr style="background-color: gray">
                    <td><s:property value="name" /> </td>
                </tr>
            </s:else>
        </s:iterator>
    </table>


</body>
</html>
