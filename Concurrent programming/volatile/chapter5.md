## 独立观察（independent observation）
* 安全使用 volatile 的另一种简单模式是：定期 “发布” 观察结果供程序内部使用。例如，假设有一种环境传感器能够感觉环境温度。一个后台线程可能会每隔几秒读取一次该传感器，并更新包含当前文档的 volatile 变量。然后，其他线程可以读取这个变量，从而随时能够看到最新的温度值。
* 使用该模式的另一种应用程序就是收集程序的统计信息。下面展示了身份验证机制如何记忆最近一次登录的用户的名字。将反复使用 lastUser 引用来发布值，以供程序的其他部分使用。


```
class userManager{
    public volatile String lastUser;
    public boolean authenticate(String user,String password){
        boolean valid=passwordIsVaild(user,password);
        if(valid){
            //User u=new User();
            //UserSet.add(u);
            lastUser=user;
        }
        return valid;
    }
    private boolean passwordIsVaild(String user, String password) {
        return true;
    }
}
```
