package com.viscu.springmvc.domain;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Vector;

/**
 * @ Create by ostreamBaba on 18-5-19
 * @
 */

//为了方便 若测试要将新建DemoObj.java置为public
class DemoObj{
    private Long id;
    private String name;
    public DemoObj() {
        super();
    } //jackson对对象和json做转换时一定需要此空构造器
    public DemoObj(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
}

@Controller
@RequestMapping("/anno")
public class DemoAnnoController {
    //produces可定制返回的response的媒体类型和字符级
    //演示接受HttpServletRequest作为参数 HttpServletResp也可以作为参数
    @RequestMapping(produces = "text/plain;charset=utf-8")
    public @ResponseBody String index(HttpServletRequest request){
        //throw new RuntimeException("TEST"); //test ControllerAdvice
        return "urk:"+request.getRequestURI()+" can access";
    }
    //接受路径参数
    @RequestMapping(value = "/pathvar/{str}",produces = "text/plain;charset=utf-8")
    public @ResponseBody String demoPathVar(@PathVariable String str,HttpServletRequest request){
        return "utl:"+request.getRequestURI()+" can access,str: "+str;
    }
    //常规request参数获取 /anno/requestParam?id=1
    @RequestMapping(value = "/requestParam",produces = "text/plain;charset=utf-8")
    public @ResponseBody String passRequestParam(Long id,HttpServletRequest request){
        return "url:"+request.getRequestURI()+" can access,id: "+id;
    }
    //参数到对象 /anno/requestParam?id=1?name=xx
    @RequestMapping(value = "/obj",produces = "application/json;charset-set")
    @ResponseBody
    public String passObj(DemoObj obj,HttpServletRequest request){
        return "url:"+request.getRequestURI()+" can access, obj id: "+obj.getId()+" obj name:"+obj.getName();
    }
    //映射到不同路径到相同方法
    @RequestMapping(value = {"/name1","/name2"},produces = "text/plain;charset=utf-8")
    public @ResponseBody String remove(HttpServletRequest request){
        return "url:"+request.getRequestURI()+" can access";
    }
}
