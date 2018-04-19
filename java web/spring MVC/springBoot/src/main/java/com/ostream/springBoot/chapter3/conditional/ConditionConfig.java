package com.ostream.springBoot.chapter3.conditional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @Create by ostreamBaba on 18-4-9
 * @描述
 */
@Configuration
public class ConditionConfig {

    @Bean
    @Conditional(WindowsCondition.class)
    public ListService windowsListService(){
        return new WindowsListService();
    }
    /*<beans>
        <bean id="windowsListService" class="xxx"/>
    </beans>*/

    @Bean
    @Conditional(LinuxCondition.class)
    public ListService LinuxListService(){
        return new LinuxListService();
    }
}
