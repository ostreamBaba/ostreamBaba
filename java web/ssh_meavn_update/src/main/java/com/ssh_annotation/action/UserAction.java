package com.ssh_annotation.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ssh_annotation.entity.User;
import com.ssh_annotation.service.UserService;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.print.attribute.standard.MediaSize;
import java.util.List;
import java.util.Map;

/**
 * @Create by ostreamBaba on 18-4-6
 * @√Ë ˆ
 */

//struts2∫Õspring’˚∫œ
@Namespace("/")
@ParentPackage("struts-default")
@Controller
public class UserAction extends ActionSupport implements ModelDriven<User>{

    private User user=new User();
    private Integer id;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public User getModel() {
        return this.user;
    }

    @Autowired
    private UserService userService;

    @Action(value = "userAddSsh",results =
            {@Result(name="success",location = "/ssh/success.jsp")})
    public String add(){
        this.userService.saveUser(user);
        return SUCCESS;
    }

    @Action(value = "userLoginSsh",results =
            {@Result(name="success",location = "/ssh/annotation/domain.jsp"),
             @Result(name="error",location = "/ssh/annotation/error.jsp")})
    public String login(){
        boolean flag=this.userService.checkLogin(user);
        if(flag){
            return SUCCESS;
        }else{
            return ERROR;
        }
    }

    @Action(value = "userReadAllSsh",results =
            {@Result(name="success",location = "/ssh/annotation/readAllUser.jsp")})
    public String readAllUser(){
        Map session= ActionContext.getContext().getSession();
        List<User> list=this.userService.findAll();
        session.put("list",list);
        return SUCCESS;
    }

    @Action(value = "userReadByIdSsh",results =
            { @Result(name="success",location = "/ssh/annotation/readAllUser.jsp"),
                    @Result(name="error",location = "/ssh/annotation/error.jsp")}
            )
    public String readById(){
        System.out.println(this.id);
        Map session= ActionContext.getContext().getSession();
        User user=this.userService.findById(this.id);
        if(user==null){
            session.put("msg","failed to find");
            System.out.println("error");
            return ERROR;
        }
        session.put("user",user);
        return SUCCESS;

    }


}
