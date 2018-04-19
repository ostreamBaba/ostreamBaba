package com.viscu.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @Create by ostreamBaba on 18-3-30
 * @√Ë ˆ
 */
public class FileDownloadtoAction extends ActionSupport{

    private static final long serialVersionUID=1L;
    private String file;
    private String contentType;

    public String getFile() throws IOException{
        return encodeDownloadFilename(file, ServletActionContext.getRequest().getHeader("User-Agent"));
    }

    private String encodeDownloadFilename(String file, String header) throws IOException{

        if(header.contains("Firefox")){
            file="=?UTF-8?B?"+new BASE64Encoder().encode(file.getBytes("utf-8"))+"?=";
        }else {
            file= URLEncoder.encode(file,"utf-8");
        }
        return file;
    }

    public String getContentType() {
        return contentType;
    }

    public void setFile(String file) throws UnsupportedEncodingException{
        file=new String(file.getBytes("ISO-8859-1"),"utf-8");
        this.file = file;
    }

    public InputStream getDownload()throws IOException{
        String filePath="/upload/"+file;
        return ServletActionContext.getServletContext().getResourceAsStream(filePath);
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
}
