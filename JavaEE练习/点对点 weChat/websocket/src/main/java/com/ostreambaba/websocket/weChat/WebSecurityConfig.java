package com.ostreambaba.websocket.weChat;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @ Create by ostreamBaba on 18-5-22
 * @ Spring Security
 */

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/*","/login").permitAll() //对/和/login路径不拦截
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login") //设置Spring Security的登录页面访问的路径为/login
                .defaultSuccessUrl("/chat") //登录成功后装向/chat
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    //在内存中配置两个用户 角色是USER
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .passwordEncoder(new passwordEncoder())
                .withUser("admin").password("111").roles("USER")
                .and()
                .withUser("user").password("222").roles("USER");
    }

    /// resources/static下的静态资源 Spring Security不拦截
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/static/**");
    }
}
