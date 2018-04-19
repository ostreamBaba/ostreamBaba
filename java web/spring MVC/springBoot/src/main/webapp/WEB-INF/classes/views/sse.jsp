<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ios666
  Date: 18-4-11
  Time: 下午4:27
  To change this template use File | Settings | File Templates.
--%>

//????
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>SSE DOMO</title>
</head>
<body>
    <div id="msgFrompPush"></div>
    <div>fuck</div>
</body>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<script type="text/javascript" src="${basePath}/assets/js/jquery.js"></script>
<script type="text/javascript">

    console.log("fuck you");
    if(!window.EventSource){
        alert("fuck");
        var source=new EventSource('push');
        s='';
        source.addEventListener('message',function (e) {
            s+=e.data+"<br/>";
            ${'#msgFrompPush'}.html(s);
        });

        source.addEventListener('open',function (e) {
            console.log("链接打开");
        },false);

        source.addEventListener('error',function (e) {
            if(e.readyState == EventSource.CLOSED){
                console.log("连接关闭");
            }else{
                console.log(e.readyState);
            }
        },false);
    }else {
        alert("fuck love");
        console.log("浏览器不支持sse");
    }

</script>
</html>
