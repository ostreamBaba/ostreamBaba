package com.springboot.security;

import com.springboot.security.service.CustomService;
import com.springboot.security.util.passwordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @ Create by ostreamBaba on 18-5-26
 * @ 描述
 */

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    @Bean
    UserDetailsService customerService(){
        return new CustomService();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customerService()).passwordEncoder(new passwordEncoder());
        //添加我们自定义的user detail service认证
    }

    //请求授权  定制登录行为
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()  //通过authorizeRequests()方法来开始请求权限配置
                .antMatchers("/login","/css/**","/js/**")
                .permitAll()  //需要这个才可以在登录之前访问静态资源
                .anyRequest().authenticated() //所有请求需要在登录后才能访问
                .and()
                .formLogin()   //定制登录行为 登录页面可以任意访问
                    .loginPage("/login")
                    .failureUrl("/login?error")
                    .permitAll()
                .and()
                .logout().permitAll(); //定制注销行为 注销请求可以任意访问
    }


    //默认对 /resources/static 下的静态资源不拦截
    /*@Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/static/**");
    }*/
}
