package com.viscu.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @Create by ostreamBaba on 18-3-30
 * @描述
 */

//指定文件下载
public class DownloadAction extends ActionSupport{
    public InputStream getDownloadFile()throws Exception{

        /*String path=ServletActionContext.getServletContext().getResourceAsStream("/upload/struts.txt").toString();
        System.out.println(path);*/
        /*String path=new String("/home/ios666/workspace/SSH_meavn/src/main/webapp/upload/全栈懂吗.txt");
        File file = new File(new String(path.getBytes("GBK"),"UTF-8"));
        InputStream is = new FileInputStream(file);
        return is;*/
        return new FileInputStream(ServletActionContext.
                getServletContext().getRealPath("/upload")+"/struts.txt");
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }


    /*public static void main(String[] args) {
        String path=ServletActionContext.getServletContext().getResourceAsStream("/upload/struts.txt").toString();
        System.out.println(path);
    }*/
}
