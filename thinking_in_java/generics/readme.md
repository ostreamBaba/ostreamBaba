# 泛型


## PECS原则(Producer Extends Consumer Super)

* 频繁往外读取内容名 适合上界extends
* 经常往里插入的 适合下界Super

### <? extend T>和<? super T>

* extends 可用于返回类型限定，不能用于参数类型限定
* super 可用于参数类型限定，不能用于返回类型限定
* ?既不能用于方法参数传入，也不能用于方法返回
* 带有super超类型限定的通配符可以向泛型对象中写入，带有extends子类型限定的通配符可以向泛型对象读取
