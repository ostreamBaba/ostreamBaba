package access.innerclasses;

/**
 * @Create by ostreamBaba on 18-4-19
 * @描述
 */

//接口内部的类
public interface ClassInInnerface {
    void howdy();
    //public static 嵌套类
    class Test implements ClassInInnerface{
        @Override
        public void howdy() {
            System.out.println("f**k");
        }
        public static void main(String[] args) {
            new Test().howdy();
        }
    }
}
