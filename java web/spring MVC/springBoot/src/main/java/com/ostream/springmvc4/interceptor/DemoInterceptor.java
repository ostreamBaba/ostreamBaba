package com.ostream.springmvc4.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Create by ostreamBaba on 18-4-10
 * @描述
 */
public class DemoInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long startTime=System.currentTimeMillis();
        request.setAttribute("startTime",startTime);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        long startTime=(Long)request.getAttribute("startTime");
        request.removeAttribute("startTime");
        long endTime=System.currentTimeMillis();
        System.out.println("本次请求的时间为: "+new Long(endTime-startTime)+"ms");
        request.setAttribute("handlingTime",endTime-startTime);
    }
}
