package com.viscu.spring.AOP;

import java.lang.annotation.*;

/**
 * @ Create by ostreamBaba on 18-5-18
 * @ √Ë ˆ
 */


@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Action {
    String name();
}
