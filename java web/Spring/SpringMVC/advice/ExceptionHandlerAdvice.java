package com.viscu.springmvc.advice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ Create by ostreamBaba on 18-5-19
 * @ 描述
 */

@ControllerAdvice  //组合了@Component注解 注册Spring的Bean
public class ExceptionHandlerAdvice {
    @ExceptionHandler(value = Exception.class)//设置拦截条件 拦截了所有的Exception
    //@ExceptionHandler用于全局处理控制器里的异常
    public ModelAndView exception(Exception exception, WebRequest webRequest){
        ModelAndView modelAndView=new ModelAndView("error");//error页面
        modelAndView.addObject("errorMessage",exception.getMessage());
        return modelAndView;
    }
    @ModelAttribute //将键值对添加到全局 所有注解@RequestMapping的方法可获得此键值对(本来的作用是绑定键值对到Model里)
    public void addAttributes(Model model){
        model.addAttribute("msg","额外信息");
    }
    @InitBinder //定制WebDataBinder(自动绑定前台请求参数到Model中)
    public void initBinder(WebDataBinder webDataBinder){
        webDataBinder.setDisallowedFields("id"); //忽略request参数的id
    }
}


@Controller
class AdviceController{
    @RequestMapping("/advice")
    public String getSomething(@ModelAttribute("msg")String msg,DemoObj demoObj){
        throw new IllegalArgumentException("非常抱歉，参数有误/"+"来自@ModelAttribute:"+msg);
    }
}


class DemoObj{
    private Long id;
    private String name;
    public DemoObj() {
        super();
    }
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
