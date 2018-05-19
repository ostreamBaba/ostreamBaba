package com.viscu.springmvc.upload;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @ Create by ostreamBaba on 18-5-19
 * @ √Ë ˆ
 */
@Controller
public class UploadController {
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @ResponseBody
    public String upload(MultipartFile file){
        try {
            //String filename=new String(file.getOriginalFilename().getBytes("ISO-8859-1"),"utf-8");
            FileUtils.writeByteArrayToFile(new File("/home/ios666/workspace/SSM/src/main/resources/upload/"+file.getOriginalFilename()),file.getBytes());
            return "ok";
        }catch (IOException e){
            e.printStackTrace();
            return "wrong";
        }
    }
}
