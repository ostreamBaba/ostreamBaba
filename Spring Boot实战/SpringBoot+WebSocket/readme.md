# WebSocket

*  WebSocket为浏览器和服务端提供了双工异步通信的功能，即浏览器可以向服务端发送消息
*  服务端也可以向浏览器发送消息

```java
WebSocket是通过一个socket来实现双工异步通信的
直接使用WebSocket（或者SockJS(WebSocket协议的模拟),
会增加当浏览器不支持WebSocket的时候的兼容支持)协议开发程序显得特别繁琐，
我们会使用他的子协议STOMP(更高级别的协议,使用一个基于帧(frame)的格式来定义消息，
与HTTP的request和response类似)。
```



```java
sendTo(/topic/getResponse)
多注意'/'
<link th:src="xxx"> 放的位置
```
