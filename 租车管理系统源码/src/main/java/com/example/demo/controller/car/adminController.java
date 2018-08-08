package com.example.demo.controller.car;

import com.example.demo.dao.CarRepository;
import com.example.demo.dao.OrderRepository;
import com.example.demo.domain.Car;
import com.example.demo.domain.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @ Create by ostreamBaba on 18-6-28
 * @ √Ë ˆ
 */

@Controller
@RequestMapping("/admin")
public class adminController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CarRepository carRepository;


    @RequestMapping("/login")
    public String login(
            String username, String password, HttpSession session, HttpServletRequest request){
        if("admin".equals(username)&&"admin".equals(password)){
            request.setAttribute("status",1);
            session.setAttribute("username",username);
            return "car/adminMain";
        }
        return "car/login";
    }

    @RequestMapping("/add")
    public String add(HttpServletRequest request){
        request.setAttribute("status",1);
        return "car/adminMain";
    }

    @RequestMapping("/order")
    public String order(HttpServletRequest request){
        request.setAttribute("status",2);
        List<Orders> ordersList=orderRepository.findAll();
        request.setAttribute("ordersList",ordersList);
        return "car/adminMain";
    }

    @RequestMapping("/rent")
    public String rent(Integer orderId,HttpServletRequest request){
        request.setAttribute("status",2);
        orderRepository.updateAdoptById(1,orderId);
        List<Orders> ordersList=orderRepository.findAll();
        request.setAttribute("ordersList",ordersList);
        return "car/adminMain";
    }

    @RequestMapping("/return")
    public String returnCar(Integer orderId,HttpServletRequest request){
        request.setAttribute("status",2);
        Orders orders=orderRepository.findByOrderId(orderId);
        carRepository.updateIsRentById(0,orders.getOrderCarId());
        List<Orders> ordersList=orderRepository.findAll();
        request.setAttribute("ordersList",ordersList);
        return "car/adminMain";
    }


}
