package com.viscu.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * @ Create by ostreamBaba on 18-5-19
 * @ 异步方法处理
 */

@Controller //通过控制器从另外一个线程返回DeferredResult
class AysncController{
    @Autowired
    private PushService pushService;
    @RequestMapping("/defer")
    @ResponseBody
    public DeferredResult<String> deferredCall(){
        System.out.println("web处理器: "+pushService.getDeferredResult());
        return pushService.getDeferredResult();
    }
}

@Service
public class PushService {
    private DeferredResult<String> deferredResult;
    public DeferredResult<String> getDeferredResult() {
        deferredResult = new DeferredResult<String>();
        return deferredResult;
    }
    @Scheduled(fixedDelay = 5000)
    public void refresh(){
        System.out.println("后台处理器:"+deferredResult);
        if(deferredResult!=null){
            deferredResult.setResult(Long.toString(System.currentTimeMillis()));
            /*System.out.println(deferredResult.getResult());
            System.out.println(Thread.currentThread().getId());*/
        }
    }
}

//在特定情况下异步对吞吐量的提高并无帮助，如你说的，假如我们的web服务器和后端处理都在同一电脑上，
//且每个请求都需要占据cpu一秒钟的时间，那压榨完这台电脑的全部性能，一分钟最多也只能处理60个请求。
//但实际的情况往往是处理时间长的请求少，而处理时间短的请求多，并且长时间处理的后端程序并不和web服务程序在同一台电脑上，异
//步要做的就是不要让需要长时间处理的请求阻塞了过多的web服务工作线程，使得一些短时间处理的请求一直得不到响应。
