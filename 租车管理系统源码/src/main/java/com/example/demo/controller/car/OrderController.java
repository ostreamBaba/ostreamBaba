package com.example.demo.controller.car;

/*import com.example.demo.dao.OrderRepository;*/
import com.example.demo.dao.CarRepository;
import com.example.demo.dao.OrderRepository;
import com.example.demo.domain.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * @ Create by ostreamBaba on 18-6-27
 * @ √Ë ˆ
 */

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CarRepository carRepository;

    @ModelAttribute
    public void order_Model(Model model,String username,String phoneNum,String personId,
                            Integer day,Integer price,Integer carId){
        Orders order=new Orders();
        String carName=carRepository.getCarNameByCarId(carId);
        order.setAdopt(0);
        order.setDay(day);
        order.setOrderCarId(carId);
        order.setPersonId(personId);
        order.setPhoneNum(phoneNum);
        order.setPrice(price);
        order.setOrderCarName(carName);
        order.setUsername(username);
        model.addAttribute("order",order);

    }

    @RequestMapping(value = "/new",method = RequestMethod.POST)
    public ModelAndView newOrder(Model model, HttpSession session){
        ModelAndView mv=new ModelAndView();
        Orders order=(Orders)model.asMap().get("order");
        Integer id=(Integer)session.getAttribute("id");
        order.setOrderUserId(id);
        carRepository.updateIsRentById(1,order.getOrderCarId());
        orderRepository.save(order);

        mv.addObject("order",order);
        mv.setViewName("redirect:/car/index");
        return mv;
    }

    @RequestMapping(value = "/gotoDetails",method = RequestMethod.GET)
    public ModelAndView details(Integer orderId,HttpSession session){
        ModelAndView mv=new ModelAndView();
        Orders orderOne=orderRepository.findByOrderId(orderId);
        mv.addObject("orderOne",orderOne);
        mv.setViewName("car/details");
        String username=(String)session.getAttribute("username");
        if("admin".equals(username)){
            Integer isRent=carRepository.findIsRentById(orderOne.getOrderCarId());
            if(isRent==1){
                mv.addObject("no",true);
            }
            mv.addObject("admin",1);
        }
        return mv;
    }



}
