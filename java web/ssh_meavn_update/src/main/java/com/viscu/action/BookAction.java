package com.viscu.action;

import com.opensymphony.xwork2.ActionSupport;
import org.springframework.stereotype.Controller;

/**
 * @Create by ostreamBaba on 18-3-29
 * @√Ë ˆ
 */

@Controller("bookAction")
public class BookAction extends ActionSupport {

    public String add(){
        System.out.println("add");
        return SUCCESS;
    }

    public String del(){
        System.out.println("delete");
        return SUCCESS;
    }


    public String update(){
        System.out.println("update");
        return SUCCESS;
    }

    public String find(){
        System.out.println("find");
        return SUCCESS;
    }


}
