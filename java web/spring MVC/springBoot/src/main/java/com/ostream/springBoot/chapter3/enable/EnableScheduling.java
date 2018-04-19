package com.ostream.springBoot.chapter3.enable;

import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.SchedulingConfiguration;

import java.lang.annotation.*;

/**
 * @Create by ostreamBaba on 18-4-9
 * @描述
 */
//直接导入配置类
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(SchedulingConfiguration.class)
public @interface EnableScheduling {
}
