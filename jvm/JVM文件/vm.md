## 虚拟机工作模式(Client和Server)

```(java)
(JIT编译阈值和最大堆)
java -XX:+PrintFlagsFinal -server -version | grep -E ' CompileThreshold | MaxHeapSize'
Picked up _JAVA_OPTIONS:   -Dawt.useSystemAAFontSettings=gasp
     intx CompileThreshold                          = 10000                               {pd product}
    uintx MaxHeapSize                              := 2065694720                          {product}
openjdk version "1.8.0_141"(java8)

10000 表示函数被调用10000次会进行JIT编译
2065694720约等于2G(系统最大堆)


Server模式(后台长期运行的系统)
Client模式(用户界面程序)
```

