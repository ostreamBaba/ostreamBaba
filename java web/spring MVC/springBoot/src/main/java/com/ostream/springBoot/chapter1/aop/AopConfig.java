package com.ostream.springBoot.chapter1.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Create by ostreamBaba on 18-4-8
 * @描述
 */

@Configuration
@ComponentScan("com.ostream.springBoot.chapter1.aop")
@EnableAspectJAutoProxy //开启spring对aspectj的支持
public class AopConfig {
}
