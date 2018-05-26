# 注意项目(使用redis)

*  在连接redis数据库时突然报错：MISCONF Redis is configured to save RDB snapshots, but it is currently not able to persist on disk. Commands that may modify the data set are disabled, because this instance is configured to report errors during writes if RDB snapshotting fails (stop-writes-on-bgsave-error option). Please check the Redis logs for details about the RDB error.

```java
究其原因是因为强制把redis快照关闭了导致不能持久化的问题，在网上查了一些相关解决方案，通过stop-writes-on-bgsave-error值设置为no即可避免这种问题。
有两种修改方法，一种是通过redis命令行修改，另一种是直接修改redis.conf配置文件
命令行修改方式示例：
127.0.0.1:6379> config set stop-writes-on-bgsave-error no
修改redis.conf文件：vi打开redis-server配置的redis.conf文件，然后使用快捷匹配模式：/stop-writes-on-bgsave-error定位到stop-writes-on-bgsave-error字符串所在位置，接着把后面的yes设置为no即可。
```
