package access.polymorphism;


/**
 * @Create by ostreamBaba on 18-4-17
 * @描述
 */
//继承与清理
class Shared{

    private int refcount=0;
    private static long counter=0;
    private final long id=counter++;

    public int getRefcount() {
        return refcount;
    }

    public void addRef(){
        refcount++;
    }

    protected void dispose(){
        if(--refcount==0){
            System.out.println("Disposing "+this);
        }
    }

    public Shared(){
        System.out.println("creating "+this);
    }

    @Override
    public String toString() {
        return "shared "+id;
    }
}

class Composting{
    private Shared shared;
    private static long counter=0;
    private final long id=counter++;

    public Composting(Shared shared){
        this.shared=shared; //对象引用
        System.out.println("creating "+this);
        this.shared.addRef();
    }
    protected void dispose(){
        System.out.println("disposing "+this);
        shared.dispose(); //ReferenceCounting中的shared实例对象也会执行dispose
    }

    @Override
    public String toString() {
        return "composting "+id;
    }
}

public class ReferenceCounting {
    public static void main(String[] args) {
        Shared shared=new Shared();
        Composting[] compostings=new Composting[]{
                new Composting(shared),
                new Composting(shared),
                new Composting(shared),
                new Composting(shared)
        };
        for(Composting c: compostings){
            c.dispose();
        }
    }


}
