package access.innerclasses;

/**
 * @Create by ostreamBaba on 18-4-19
 * @描述
 */
public class test {
    public static void main(String[] args) {
        Parcel6.ParcelDestination.AnotherLevel.f();
        Parcel6.ParcelDestination p= (Parcel6.ParcelDestination) Parcel6.destination("fuck");//downcasting 嵌套类的创建不需要外围类的对象

    }
}
