package com.ostream.springBoot.chapter3.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


import java.lang.annotation.*;

/**
 * @Create by ostreamBaba on 18-4-9
 * @描述
 */


@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented//说明该注解将被包含在javadoc中
@Configuration
@ComponentScan
public @interface OstreamConfiguration {
    String[] value() default{};  //覆盖value参数

    /*String[] value() default {};
    RequestMethod[] method() default {};
    String[] params() default {};
    String[] headers() default {};
    String[] consumes() default {};
    String[] produces() default {};*/

   /* value:  指定请求的实际地址， 比如 /action/info之类。
    method：  指定请求的method类型， GET、POST、PUT、DELETE等
    consumes： 指定处理请求的提交内容类型（Content-Type），例如application/json, text/html;
    produces:    指定返回的内容类型，仅当request请求头中的(Accept)类型中包含该指定类型才返回
    params： 指定request中必须包含某些参数值是，才让该方法处理
    headers： 指定request中必须包含某些指定的header值，才能让该方法处理请求
    其中，consumes， produces使用content-typ信息进行过滤信息；headers中可以使用content-type进行过滤和判断。*/
}
