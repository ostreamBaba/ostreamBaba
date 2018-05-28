package com.springboot.security.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @ Create by ostreamBaba on 18-5-28
 * @ 描述
 */
public class PasswordEncoderTest {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        System.out.println(encoder.encode("admin"));
        System.out.println(encoder.encode("admin"));

        if(encoder.matches("admin","$2a$10$I2UAoY.R0VhWP.f9l7uUneTCVC5Oh30Et83sbneb/NzR6gGwk8DVm")){
            System.out.println("true");
        }
        if(encoder.matches("admin","$2a$10$iLNPWcHw1phoIgTqje60w.X.AzHKE7IvINwIREOKISGH3woIkBWmC")){
            System.out.println("true");
        }


        if(encoder.matches("admin","$2a$10$NLSIjrCoNvAArdS4skGxr.cwh/UhbAn.JcGdV1Y9JhUnbwuX8bpqa")){
            System.out.println("true");
        }else {
            System.out.println("false");
        }


        String Md5password=MD5Util.encode("admin");
        System.out.println(Md5password);
        System.out.println(encoder.encode(Md5password));
        if(encoder.matches(Md5password,"$2a$10$NLSIjrCoNvAArdS4skGxr.cwh/UhbAn.JcGdV1Y9JhUnbwuX8bpqa")){
            System.out.println("true");
        }

    }
}
