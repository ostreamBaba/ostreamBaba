package com.ostream.springmvc4.domain;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Create by ostreamBaba on 18-4-9
 * @描述
 */


@RestController
@RequestMapping("/rest")
public class DemoRestController {
    @RequestMapping(value = "/getjson",produces = {"application/json;charset=utf-8"})
    public DemoObj getJson(DemoObj obj){
        System.out.println(obj.getId()+obj.getName());
        return new DemoObj(obj.getId()+1,obj.getName()+"yy");
    }
    @RequestMapping(value = "/getxml",produces = {"application/xml;charset=utf-8"})
    public DemoObj getXml(DemoObj obj){
        return new DemoObj(obj.getId()+1,obj.getName()+"yy");
    }

}
