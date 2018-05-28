# md5 加盐

```java
MD5自身是不可逆的 但是目前网路上有很多数据库支持反查询
如果用户密码数据库不小心被泄露黑客就可以通过反查询方式获得用户密码或者对于数据库中出现频率较高的hash码(即很多人使用的)进行暴力破解(因为它通常都是弱口令)
盐值就是在密码hash过程中添加的额外的随机值
比如我的id是癫ω倒④ゞ 密码是123456 存在数据库中的时候就可以对字符串123456/癫ω倒④ゞ 进行hash，而验证密码的时候也以字符串(要验证的密码)/癫ω倒④ゞ 进行验证
这样有另外一个笨蛋密码是123456的时候 依然能构造出不同的hash值 并且能成功的验证
这时候我的id就作为盐值 为密码进行复杂hash了
所以么。。盐值的作用是减少数据库泄露带来的损失
如果你RP非常好 猜中了我的密码是123456 我也阻止不了你啊
一般情况下，系统的用户密码都会经过一系列的加密才会存储到数据库或者别的资源文件。
盐值加密：把你原来密码，加上一些盐然后再进行一些列的加密算法。
比如你的密码是：899312 用户名是：gaobing
在security 中盐值加密可以是这样加盐的899312{gaobing} 然后 ，在进行一些列的加密。
上一篇日志中介绍了三种登陆设置，这边用数据库的那种作为例子：
<authentication-manager
<authentication-provider user-service-ref='myUserDetailsService'
<password-encoder hash=md5<salt-source user-property=username/</password-encoder
</authentication-provider
</authentication-manager
<b:bean id=myUserDetailsService
class=org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl
<b:property name=dataSource ref=dataS /
</b:bean说明:
<salt-source user-property=username/ 这一句即声明了所加的盐值，即数据库中的username字段。
<password-encoder hash=md5 在他的属性中指明了加盐之后的加密算法 即MD5(应该是32位 我测试是32位的)
这样设置后你的数据库中的密码也应该是经过盐值加密的。
比如username:gaobing 在数据库中的password应该是899312{gaobing}经过MD5加密后的 4daf885e05ff45a72ada6652a3727b6a。

```


* 32位bit密码是否安全? --多轮加盐？
