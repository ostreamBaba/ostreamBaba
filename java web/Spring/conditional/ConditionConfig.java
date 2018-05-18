package com.viscu.spring.conditional;

import org.springframework.context.annotation.*;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.stereotype.Component;

/**
 * @ Create by ostreamBaba on 18-5-19
 * @ 描述
 */
//判断条件定义

@Component
class WindowsCondition implements Condition{
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        return conditionContext.getEnvironment().getProperty("os.name").contains("Windows");
    }
}
@Configuration
class LinuxCondition implements Condition{
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        return conditionContext.getEnvironment().getProperty("os.name").contains("Linux");
    }
}
interface ListService{
    String showListCmd();
}

class WindowsListService implements ListService{
    public String showListCmd() {
        return "dir";
    }
}
class LinuxListService implements ListService{
    public String showListCmd() {
        return "ls";
    }
}


@Configuration
@ComponentScan("com.viscu.spring.conditional")
public class ConditionConfig {
    //判断该系统符合哪个条件
    @Bean
    @Conditional(WindowsCondition.class)
    public ListService windowListService(){
        return new WindowsListService();
    }
    @Bean
    @Conditional(LinuxCondition.class)
    public ListService linuxListService(){
        return new LinuxListService();
    }
}

class Main{
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(ConditionConfig.class);
        ListService listService=applicationContext.getBean(ListService.class);
        System.out.println(applicationContext.getEnvironment().getProperty("os.name")
                +"系统下的列表命令为： "+
                listService.showListCmd());
    }
}