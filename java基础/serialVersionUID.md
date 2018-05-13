### serialVersionUID的作用

* 序列化的作用是能转化成Byte流，然后又能反序列化成原始的类。能在网络进行传输，也可以保存在磁盘中，有了SUID之后，那么如果序列化的类已经保存了在本地中，中途你更改了类后，SUID变了，那么反序列化的时候就不会变成原始的类了，还会抛异常，主要就是用于版本控制。

* SerialVersionUID is an ID which is stamped on object when it get serialized usually hashcode of object, you can use tool serialver to see serialVersionUID of a serialized object . SerialVersionUID is used for version control of object. you can specify serialVersionUID in your class file also. Consequence of not specifying serialVersionUID is that when you add or modify any field in class then already serialized class will not be able to recover because serialVersionUID generated for new class and for old serialized object will be different. Java serialization process relies on correct serialVersionUID for recovering state of serialized object and throws java.io.InvalidClassException in case of serialVersionUID mismatch.

* SerialVersionUID，后面简称SUID，是当对象序列化的时候对象的一个标识，SUID的值常为该对象的hascode。你可以使用工具serialver查看一个序列化对象的SUID。SUID用于控制对象的版本。你也可以在类文件中指定SUID。不指定SUID的结果就是当你添加或者更改类的域并已经序列化类的时候，类是不能再恢复了，因为新的SUID和之前的SUID不同了。Java的序列化过程依赖于正确的SUID来反序列化已经序列化的对象，如果SUID不匹配，那么就会抛 java.io.InvalidClassException 异常了。

* SUID不是一个对象的哈希值，是源类的哈希值。如果类更新，例如域的改变，SUID会变化，这里有4个步骤：
    *  1.忽略SUID,相当于运行期间类的版本上的序列化和反序列上面没有差异。
    *  2.写一个默认的SUID,这就好像线程头部。告诉JVM所有版本中有着同样SUID的都是同一个版本。
    *  3.复制之前版本类的SUID。运行期间这个版本和之前版本是一样的版本。
    *  4.使用类每个版本生成的SUID。如果SUID与新版本的类不同，那么运行期间两个版本是不同的，并且老版本类序列化后的实例并不可以反序列成新的类的实例。
