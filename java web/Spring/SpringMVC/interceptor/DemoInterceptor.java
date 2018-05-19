package com.viscu.springmvc.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ Create by ostreamBaba on 18-5-19
 * @ 拦截器
 */
public class DemoInterceptor extends HandlerInterceptorAdapter{
    //在请求发生前执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long startTime=System.currentTimeMillis();
        request.setAttribute("startTime",startTime);
        return true;
    }
    //在请求发生后执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        long startTime=(Long)request.getAttribute("startTime");
        request.removeAttribute("startTime");
        long endTime=System.currentTimeMillis();
        double handlingTime=(double)(endTime-startTime)/1000;
        System.out.println("本次请求的处理时间为："+handlingTime+"s");
        request.setAttribute("handlingTime",endTime-startTime);
    }
}
