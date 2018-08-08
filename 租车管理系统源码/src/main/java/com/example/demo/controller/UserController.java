package com.example.demo.controller;

import com.example.demo.dao.UserRepository;
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

@Controller
@RequestMapping("/user")
@SessionAttributes("username")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @ModelAttribute
    public void user_model(String name,String password,String email,Model model){
        User user=new User();
        user.setEmail(email);
        user.setName(name);
        user.setPassword(password);
        model.addAttribute("user",user);
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public ModelAndView register(Model model){
        User user=(User)model.asMap().get("user");
        userRepository.save(user);
        ModelAndView mv=new ModelAndView();
        mv.setViewName("login");
        mv.addObject("success","Success");
        mv.addObject("user",user);
        return mv;
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(String name,String password,Model model){
        User user=userRepository.findByName(name);
        if(user!=null){
            String checkPassword=user.getPassword();
            if(checkPassword.equals(password)){
                model.addAttribute("username",name);
                return "index";
            }
        }
        model.addAttribute("error","error");
        return "login";
    }

    @RequestMapping("/layout")
    public ModelAndView layout(HttpServletRequest request){
        request.getSession().removeAttribute("username");
        ModelAndView mv=new ModelAndView();
        mv.setViewName("first");
        return mv;
    }

    @RequestMapping(value = "/reset",method = RequestMethod.GET)
    public ModelAndView reset(String password,String newpassword,Model model){
        String username=(String)model.asMap().get("username");
        User user=userRepository.findByName(username);
        ModelAndView mv=new ModelAndView();
        if(user.getPassword().equals(password)){
            userRepository.updatePassword(newpassword,user.getUserId());
            mv.setViewName("login");
            mv.addObject("reset","reset");
            return mv;
        }
        mv.setViewName("reset");
        mv.addObject("error","error");
        return mv;
    }



}
