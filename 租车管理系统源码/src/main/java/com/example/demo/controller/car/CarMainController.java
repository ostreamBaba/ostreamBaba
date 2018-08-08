package com.example.demo.controller.car;

import com.example.demo.dao.OrderRepository;
import com.example.demo.domain.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ Create by ostreamBaba on 18-6-25
 * @ 描述
 */

@Controller
@RequestMapping("/car")
public class CarMainController {

    @Autowired
    private OrderRepository orderRepository;

    @RequestMapping("/sent")
    public String sent(){
        return "car/sent";
    }

    @RequestMapping("/register")
    public String register(){
        return "car/register";
    }

    @RequestMapping("/login")
    public String login(){
        return "car/login";
    }

    @RequestMapping("/index")
    public String index(HttpServletRequest request){
        request.setAttribute("status",1);
        request.setAttribute("block",1);
        /*request.setAttribute("orderStatus",1);*/
        Integer id=(Integer)request.getSession().getAttribute("id");
        Integer adopt=0;
        Orders orders=orderRepository.findByAdoptAndOrderUserId(adopt,id);
        request.getSession().setAttribute("orders",orders);
        return "car/index";
    }

    //查找全部完成的订单
    @RequestMapping("/all")
    public String AllOrder(HttpServletRequest request){
        request.setAttribute("status",1);
        request.setAttribute("block",2);
        /*request.setAttribute("orderStatus",1);*/
        Integer id=(Integer)request.getSession().getAttribute("id");
        Integer adopt=1;
        List<Orders> orders=orderRepository.findAllByAdoptAndOrderUserId(adopt,id);
        request.setAttribute("orderList",orders);
        return "car/index";
    }

    @RequestMapping("/carMain")
    public String carMain(){
        return "car/CarMain";
    }

    @RequestMapping(value = "/order")
    public String carOrder(){
        return "car/order";
    }

    @RequestMapping(value = "/first")
    public String first(){
        return "car/first";
    }

    @RequestMapping(value = "/details")
    public String details(){
        return "car/details";
    }

    @RequestMapping(value = "/admin")
    public String admin(){
        return "car/admin";
    }


}
