package com.example.demo.controller.car;

import com.example.demo.dao.CarUserRepository;
import com.example.demo.domain.CarUser;
import com.example.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @ Create by ostreamBaba on 18-6-25
 * @ √Ë ˆ
 */


@Controller
@RequestMapping("/carUser")
/*@SessionAttributes("username")*/
public class CarUserController {

    @Autowired
    private CarUserRepository carUserRepository;

    @ModelAttribute
    public void User_Model(String email, String username, String password, Model model){
        CarUser carUser=new CarUser();
        carUser.setCarPassword(password);
        carUser.setCarUsername(username);
        carUser.setEmail(email);
        model.addAttribute("carUser",carUser);
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public ModelAndView register(Model model,ModelAndView mv){
        mv.setViewName("car/login");
        CarUser carUser=(CarUser)model.asMap().get("carUser");
        carUserRepository.save(carUser);
        //model.addAttribute("username",carUser.getCarUsername());
        model.addAttribute("registerSuccess",true);
        return mv;
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ModelAndView login(Model model, ModelAndView mv, HttpSession session){
        CarUser carUser=(CarUser)model.asMap().get("carUser");
        CarUser CheckCarUser=carUserRepository.findByCarUsername(carUser.getCarUsername());
        if(CheckCarUser!=null){
            String checkPassword=CheckCarUser.getCarPassword();
            if(checkPassword.equals(carUser.getCarPassword())){
                mv.setViewName("car/first");
                session.setAttribute("id",CheckCarUser.getCarId());
                session.setAttribute("username",CheckCarUser .getCarUsername());
                return mv;
            }
        }
        mv.setViewName("car/login");
        mv.addObject("error","error");
        return mv;
    }

    //–ﬁ∏ƒ√‹¬Î
    @RequestMapping(value = "/reset",method = RequestMethod.POST)
    public ModelAndView reset(String pwd,String pwd1,HttpSession session){
        ModelAndView mv=new ModelAndView();
        String username=(String) session.getAttribute("username");
        CarUser carUser=carUserRepository.findByCarUsername(username);
        if(carUser!=null){
            String checkPassword=carUser.getCarPassword();
            if(pwd.equals(checkPassword)){
                carUserRepository.resetPasswordByName(pwd1,username);
                session.removeAttribute("username");
                session.removeAttribute("id");
                mv.addObject("success","reset");
                mv.setViewName("car/login");
                return mv;
            }
        }
        mv.addObject("error","error");
        mv.addObject("status",3);
        mv.setViewName("car/index");
        return mv;
    }

    @RequestMapping(value = "/layout")
    public ModelAndView layout(HttpSession session){
        ModelAndView mv=new ModelAndView();
        session.removeAttribute("username");
        session.invalidate();
        mv.setViewName("car/login");
        return mv;
    }

    @RequestMapping(value = "/gotoReset")
    public ModelAndView goto_Reset(){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("car/index");
        mv.addObject("status",3);
        return mv;
    }

    @RequestMapping(value = "/gotoChange")
    public ModelAndView goto_Change(HttpSession session){
        ModelAndView mv=new ModelAndView();
        /*String username=(String) session.getAttribute("username");*/
        Integer id=(Integer)session.getAttribute("id");
        CarUser carUser=carUserRepository.findByCarId(id);
        mv.setViewName("car/index");
        mv.addObject("carUser",carUser);
        mv.addObject("status",2);
        return mv;
    }


    @RequestMapping(value = "/change",method = RequestMethod.POST)
    public ModelAndView change(String name,HttpSession session){
        Integer id=(Integer)session.getAttribute("id");
        carUserRepository.changeUsernameByName(name,id);
        session.setAttribute("username",name);
        CarUser carUser=carUserRepository.findByCarId(id);
        ModelAndView mv=new ModelAndView();
        mv.setViewName("car/index");
        mv.addObject("carUser",carUser);
        mv.addObject("status",2);
        mv.addObject("msg","success");
        return mv;
    }


}
