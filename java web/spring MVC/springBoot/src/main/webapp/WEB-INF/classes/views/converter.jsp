<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ios666
  Date: 18-4-10
  Time: 下午9:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div id="resp"></div>
    <input type="button" value="请求" onclick="req();">
</body>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>

<script src="${basePath}/assets/js/jquery.js" type="text/javascript"></script>
<script>

    /*req();*/
    function req() {
       /* alert("fucklove");*/
        $.ajax({
            url:"convert",
            data:"1-you",
            type:"post",
            contentType:"application/ostreamBaba",
            success:function (data) {
                /*alert(data);*/
                $('#resp').html(data);  
            }
        });
    }
</script>
</html>
