package com.ostream.springmvc4.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Create by ostreamBaba on 18-4-10
 * @描述
 */

@ControllerAdvice
public class ExceptionHandlerAdvices {

    @ExceptionHandler(value = Exception.class) //设置拦截条件
    public ModelAndView exception(Exception e, WebRequest request){
        ModelAndView modelAndView=new ModelAndView("error"); //error界面
        modelAndView.addObject("errorMessage",e.getMessage());
        return modelAndView;
    }

    @ModelAttribute  //将键值对添加到全局 使得所有注解的@RequestMapping的方法可获得此键值对
    public void addAttributes(Model model){
        model.addAttribute("msg","额外信息");
    }

    @InitBinder  //忽略request的id
    public void initBinder(WebDataBinder webDataBinder){
        /*webDataBinder.setDisallowedFields("id");*/
    }


}

