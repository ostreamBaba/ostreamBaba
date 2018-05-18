# 元注解
* Retention(保留)
    *  Retention.RUNTIME  //注解会在class字节码文件中存在，在运行时可以通过反射获取到
    *  Retention.CLASS  // 默认的保留策略，注解会在class字节码文件中存在，但运行时无法获得
    *  Retention.SOURCE //注解仅存在于源码中，在class字节码文件中不包含

* Target 表示该注解用于什么地方，可能的值在枚举类 ElemenetType 中  
    *      ElemenetType.CONSTRUCTOR----------------------------构造器声明
    *      ElemenetType.FIELD --------------------------------------域声明（包括 enum 实例）
    *      ElemenetType.LOCAL_VARIABLE------------------------- 局部变量声明
    *      ElemenetType.METHOD ----------------------------------方法声明
    *      ElemenetType.PACKAGE --------------------------------- 包声明 
    *      ElemenetType.PARAMETER ------------------------------参数声明
    *      ElemenetType.TYPE--------------------------------------- 类，接口（包括注解类型）或enum声明
