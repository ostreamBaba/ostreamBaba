package access.innerclasses;

/**
 * @Create by ostreamBaba on 18-4-18
 * @描述
 */
//innerclass upcasting

class Parcel2{
    private class PContent implements Contents{
        private int i=11;
        @Override
        public int value() {
            return i;
        }
        @Override
        public String toString() {
            return "pContent"+i;
        }
    }
    protected class PDestination implements Destination{
        private String label;
        public PDestination(String label) {
            this.label = label;
        }
        @Override
        public String readLabel() {
            return label;
        }
    }
    public PContent getPContent(){ //实现了某类型的接口 可以创建并返回对其的引用
        return new PContent();
    }
    public PDestination getPDestination(String label){
        return new PDestination(label);
    }
}
public class TestParcel {
    public static void main(String[] args){
        Parcel2 p=new Parcel2();
        Destination d=p.getPDestination("ostreamBaba"); //upcasting 不知道确切接口或者基类的类型
        Contents c=p.getPContent();
        System.out.println(c);
        System.out.println(d.readLabel());
    }
}
//private 内部类完全阻止了任何依赖类型的编码 完全隐藏实现的细节

// 一个定义在方法内的类
class Parcel3{
    public Destination destination(String s){
        class PDestination implements Destination{
            //只能在方法内使用
            private String label;
            public PDestination(String label) {
                this.label = label;
            }
            @Override
            public String readLabel() {
                return label;
            }
        }
        return new PDestination(s); //upcasting
    }

    public static void main(String[] args) {
        Parcel3 p=new Parcel3();
        Destination d=p.destination("viscu");
        System.out.println(d.readLabel());
    }
}

//任意作用域嵌入内部类
class Parcel4{
    public void internalTracking(boolean b){
        if(b){
            class TrackingSlip{
                private String id;

                public TrackingSlip(String id) {
                    this.id = id;
                }

                String getSlip(){
                    return id;
                }
            }
            TrackingSlip ts=new TrackingSlip("ostreamBaba");
            System.out.println(ts.getSlip());
        }
    }
    public void track(){
        internalTracking(true);
    }

    public static void main(String[] args) {
        Parcel4 p=new Parcel4();
        p.track();
    }
}
//匿名内部类
class Parcel5{
    //不带参数
    public Contents contents(){
        return new Contents() {  //匿名类并且upcasting
            private int i=11;
            @Override
            public int value() {
                return i;
            }
        };
    }
    //带参数
    public Wrapping wrapping(int x){
        return new Wrapping(x){
            @Override
            public int value() {
                return super.value()*47;
            }
        };
    }
    //定义字段 传参
    public Destination destination(final String dest){ //在内部被使用 需要家final
        return new Destination() {
            private String label=dest;
            @Override
            public String readLabel() {
                return label;
            }
        };
    }
    public static void main(String[] args) {
        Parcel5 p=new Parcel5();
        Contents q=p.contents();
        System.out.println(q.value());
        Wrapping w=p.wrapping(5);
        System.out.println(w.value());
        Destination d=p.destination("fuck");
        System.out.println(d.readLabel());
    }
}

class Parcel6{
    //嵌套类 普通类内部不能有static字段和static数据 也不能包含嵌套类
    private static class ParcelContents implements Contents{
        private int i=11;
        @Override
        public int value() {
            return i;
        }
    }
    protected static class ParcelDestination implements Destination{
        private String label;
        private ParcelDestination(String label) {
            this.label = label;
        }
        @Override
        public String readLabel() {
            return label;
        }
        public static void f(){
            System.out.println("pd f()");
        }
        static int x=10;
        //嵌套类 可以包含static字段数据 和非static字段数据
        static class AnotherLevel{ //与外围类对象之间没有联系
            public static void f(){
                System.out.println("another f()");
            }
            static int x=10;
            int y=20;
        }
    }
    public static Destination destination(String s){
        return new ParcelDestination(s);
    }
    public static Contents contents(){
        return new ParcelContents();
    }

    public static void main(String[] args) {
        Contents c=contents();
        Destination d=destination("ostreamBaba");
        System.out.println(c.value());
        System.out.println(d.readLabel());
        /*Destination dd=destination("viscu");
        System.out.println(dd.readLabel());*/
        ParcelDestination.f();
        ParcelDestination.AnotherLevel.f();
        System.out.println(ParcelDestination.x);
        System.out.println(ParcelDestination.AnotherLevel.x);

        ParcelDestination.AnotherLevel pa=new ParcelDestination.AnotherLevel();
        System.out.println(pa.y);
    }
}

