package com.ostream.springmvc4.messageconverter;

import com.ostream.springmvc4.domain.DemoObj;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * @Create by ostreamBaba on 18-4-10
 * @描述
 */
public class MyMessageConverter extends AbstractHttpMessageConverter<DemoObj> {

    public MyMessageConverter() {
        super(new MediaType("application","ostreamBaba", Charset.forName("UTF-8")));//定义一个新媒体类型application/ostreamBaba
    }

    @Override
    protected DemoObj readInternal(Class<? extends DemoObj> aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        String tmp= StreamUtils.copyToString(httpInputMessage.getBody(),Charset.forName("utf-8"));
        System.out.println("readInternal:" +tmp);
        String[] tmpArr=tmp.split("-");
        return new DemoObj(new Long(tmpArr[0]),tmpArr[1]); //处理由-隔开的数据，并转换成DemoObj的对象
    }

    @Override
    protected boolean supports(Class<?> aClass) {
        return DemoObj.class.isAssignableFrom(aClass);//表明仅仅处理DemoObj这个类
    }

    @Override
    protected void writeInternal(DemoObj obj, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
        String out="stream: "+obj.getId()+"-"+obj.getName();
        httpOutputMessage.getBody().write(out.getBytes());
    }
}
