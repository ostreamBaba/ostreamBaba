package access.innerclasses;

/**
 * @Create by ostreamBaba on 18-4-17
 * @描述
 */
public class Parcel {
    class Contents{
        private int i=11;
        public int value(){
            return i;
        }
    }

    public Contents contents(){
        return new Contents();
    }

    public void ship(){
        Contents c=contents();
        System.out.println(c.value());
    }

    public static void main(String[] args) {
        Parcel p=new Parcel();
        p.ship();
        Parcel.Contents c=p.contents();
        System.out.println(c.value());
    }


}
