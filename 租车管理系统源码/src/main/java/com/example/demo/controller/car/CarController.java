package com.example.demo.controller.car;

import com.example.demo.dao.CarRepository;
import com.example.demo.dao.OrderRepository;
import com.example.demo.domain.Car;
import com.example.demo.domain.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.*;

/**
 * @ Create by ostreamBaba on 18-6-27
 * @ √Ë ˆ
 */

@Controller
@RequestMapping("/Car")
public class CarController {

    private final static Integer INF=1000000000;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private OrderRepository orderRepository;

    @ModelAttribute
    public void car_model(String carType, String carBrand, Integer price, String carName, Model model){
        Car car=new Car();
        car.setCarBrand(carBrand);
        car.setCarName(carName);
        car.setCarIsRent(0);
        car.setCarPrice(price);
        car.setCarType(carType);
        model.addAttribute("car",car);
    }

    @RequestMapping(value = "/newCar",method = RequestMethod.POST)
    public ModelAndView newCar(Model model){
        ModelAndView mv=new ModelAndView();
        Car car=(Car)model.asMap().get("car");
        carRepository.save(car);
        mv.setViewName("car/adminMain");
        mv.addObject("success",true);
        mv.addObject("status",1);
        return mv;
    }


    @RequestMapping("/toCarMain")
    public ModelAndView carMain(HttpSession session,ModelAndView mv){
        mv.setViewName("car/CarMain");
        List<Car> carList=carRepository.getAll();
        Set<String> type=new HashSet<String>();
        Set<String> brand=new HashSet<String>();
        Iterator<Car> it=carList.iterator();
        while (it.hasNext()){
            Car car=it.next();
            type.add(car.getCarType());
            brand.add(car.getCarBrand());
        }

        List<Car> list=carRepository.getAll();
        mv.addObject("list",list);
        session.setAttribute("type",type);
        session.setAttribute("brand",brand);
        return mv;
    }

    @RequestMapping(value = "/findCar",method = RequestMethod.GET)
    public ModelAndView findCar(String carType,String carBrand,Integer price){
        Integer isRent=0;
        System.out.println(INF);
        ModelAndView mv=new ModelAndView();
        mv.setViewName("car/CarMain");
        List<Car> list;

        if(price==0&&carType.equals("0")&&carBrand.equals("0")){
            list=carRepository.getAll();
            mv.addObject("list",list);
            return mv;
        }else{
            if(price==0){
                if(carType.equals("0")){
                    list=carRepository.findByCarBrandAndCarIsRent(carBrand,isRent);
                }else if(carBrand.equals("0")){
                    list=carRepository.findByCarTypeAndCarIsRent(carType,isRent);
                }else{
                    list=carRepository.findByCarTypeAndCarBrandAndCarIsRent(carType,carBrand,isRent);
                }
                mv.addObject("list",list);
                    return mv;
            }
        }

        Integer start;
        Integer end;
        if(price==1){
            start=1;
            end=199;
        }else{
            start=price*100;
            if(price==5){
                end=INF;
            }else{
                end=start+99;
            }
        }

        if(carType.equals("0")&&carBrand.equals("0")){
            list=carRepository.findByCarPriceBetweenAndCarIsRent(start,end,isRent);
        }else if(carType.equals("0")){
            list=carRepository.findByCarPriceBetweenAndCarBrandAndCarIsRent(start,end,carBrand,isRent);
        }else if(carBrand.equals("0")){
            list=carRepository.findByCarTypeAndCarPriceBetweenAndCarIsRent(carType,start,end,isRent);
        }else{
            list=carRepository.findByCarTypeAndCarBrandAndCarPriceBetweenAndCarIsRent(carBrand,carType,start,end,isRent);
        }

        mv.setViewName("car/CarMain");
        mv.addObject("size",list.size());
        mv.addObject("list",list);
        return mv;

    }


    @RequestMapping(value = "/doOrder",method = RequestMethod.GET)
    public ModelAndView doOrder(Integer carId,HttpSession session){
        ModelAndView mv=new ModelAndView();
        Integer id=(Integer)session.getAttribute("id");
        Orders orders=orderRepository.findByAdoptAndOrderUserId(0,id);
        if(orders!=null){
            mv.setViewName("car/CarMain");
            List<Car> list=carRepository.getAll();
            mv.addObject("list",list);
            mv.addObject("has",true);
            return mv;
        }

        Car car=carRepository.findByCarId(carId);

        mv.setViewName("car/order");
        Timestamp time=new Timestamp(System.currentTimeMillis());
        mv.addObject("time",time);
        mv.addObject("car",car);
        return mv;
    }
}
