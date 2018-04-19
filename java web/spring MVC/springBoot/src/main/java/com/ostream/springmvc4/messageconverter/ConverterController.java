package com.ostream.springmvc4.messageconverter;

import com.ostream.springmvc4.domain.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Create by ostreamBaba on 18-4-10
 * @描述
 */

@Controller
public class ConverterController {

    @RequestMapping(value = "/convert",produces = {"application/ostreamBaba"})
        public @ResponseBody DemoObj convert(@RequestBody DemoObj obj){
        System.out.println(obj.getId()+","+obj.getName());
        return obj;
    }

}
