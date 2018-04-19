package access.innerclasses;

/**
 * @Create by ostreamBaba on 18-4-18
 * @描述
 */

public class TestPDestination {

    public static void main(String[] args) {
        Parcel2 p=new Parcel2();
        Parcel2.PDestination q=p.getPDestination("viscu");
        System.out.println(q.readLabel());
        Parcel2.PDestination q1=p.new PDestination("ostreambaba");
        System.out.println(q1.readLabel());
    }

}
