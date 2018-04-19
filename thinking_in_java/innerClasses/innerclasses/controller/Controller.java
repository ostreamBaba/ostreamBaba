package access.innerclasses.controller;

import java.util.ArrayList;
import java.util.List;

/**
 * @Create by ostreamBaba on 18-4-19
 * @描述
 */
public class Controller {
    private List<Event> list=new ArrayList<>();
    public void addEvent(Event e){
        list.add(e);
    }
    public void run(){
        while (list.size()>0){
            for(Event e:new ArrayList<Event>(list)){
                if(e.ready()){
                    System.out.println(e);
                    e.action();
                    list.remove(e);
                }
            }
        }
    }
}
