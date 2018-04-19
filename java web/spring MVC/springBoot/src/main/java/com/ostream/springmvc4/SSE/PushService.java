package com.ostream.springmvc4.SSE;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * @Create by ostreamBaba on 18-4-11
 * @描述
 */


@Service
public class PushService {
    private DeferredResult<String> deferredResult;

    public DeferredResult<String> getUpdate(){
        deferredResult=new DeferredResult<String>();
        return deferredResult;
    }

    @Scheduled(fixedDelay = 1000)
    public void refresh(){
        if(deferredResult!=null) {
            deferredResult.setResult( new Long( System.currentTimeMillis() ).toString() );
        }
    }

}
