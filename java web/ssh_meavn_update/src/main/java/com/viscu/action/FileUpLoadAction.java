package com.viscu.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.io.*;

/**
 * @Create by ostreamBaba on 18-3-29
 * @√Ë ˆ
 */
public class FileUpLoadAction extends ActionSupport{

    private static final long serialVersionUID=1L;

    private File file;

    private String fileFileName;

    private String fileContentType;

    public File getFile() {
        return file;
    }

    public String getFileFileName() {
        return fileFileName;
    }

    public String getFileContentType() {
        return fileContentType;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }

    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }

    @Override
    public String execute() throws Exception {
        InputStream is=new FileInputStream(file);
        String uploadPath= ServletActionContext.getServletContext().getRealPath("/upload");
        File toFile=new File(uploadPath,this.getFileFileName());
        OutputStream os=new FileOutputStream(toFile);
        byte[] buffer=new byte[1024];
        int length=0;
        while(-1!=(length=is.read(buffer,0,buffer.length))){
            os.write(buffer);
        }
        is.close();
        os.close();
        return SUCCESS;
    }
}
