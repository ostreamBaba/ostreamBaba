package com.ostream.springmvc4.SSE;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

/**
 * @Create by ostreamBaba on 18-4-11
 * @描述
 */

@Controller
public class SseController {

    @RequestMapping(value = "/push",produces = {"text/event-stream"})
    public @ResponseBody String push(){
        Random r=new Random();
        try{
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "data:Testing 1,2,3"+r.nextInt()+"\n\n";
    }
}
