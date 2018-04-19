package com.ostream.springmvc4.upload;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @Create by ostreamBaba on 18-4-10
 * @描述
 */

@RestController
public class UploadController {

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String upload(MultipartFile file){
        try {
            String fileName=new String(file.getOriginalFilename().getBytes("ISO-8859-1"),"utf-8");//中文乱码
            File filePath=new File("/home/ios666/workspace/springBoot/src/main/resources/upload/"+fileName);
            FileUtils.writeByteArrayToFile(filePath,file.getBytes());//快速写文件到磁盘
            System.out.println(filePath.getAbsolutePath());
            return "ok";
        }catch (IOException e){
            e.printStackTrace();
            return "wrong";
        }
    }

}
