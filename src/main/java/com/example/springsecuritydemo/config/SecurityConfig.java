package com.example.springsecuritydemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

//@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
//重写 WebSecurityConfigurerAdapter 的方法，实现自定义的 Spring Security 的配置。


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        // <X> 使用内存中的 InMemoryUserDetailsManager
        auth
                .inMemoryAuthentication()
                // <Y> 不使用 PasswordEncoder 密码编码器
                .passwordEncoder(NoOpPasswordEncoder.getInstance())
                // <Z> 配置 admin 用户
                .withUser("admin").password("admin").roles("ADMIN")
                // <Z> 配置 normal 用户
                .and().withUser("normal").password("normal").roles("NORMAL");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // <X> 配置请求地址的权限
        http.authorizeRequests().antMatchers("/test/echo").permitAll() // 所有用户可访问
                .antMatchers("/test/admin").hasRole("ADMIN") // 需要 ADMIN 角色
                .antMatchers("/test/normal").access("hasRole('ROLE_NORMAL')")// 需要 NORMAL 角色
                // 任何请求，访问的用户都需要经过认证
                .anyRequest().authenticated()
                .and()
                // <Y> 设置 Form 表单登录
                .formLogin()
//                .loginPage("/login") // 登录 URL 地址
                .permitAll() // 所有用户可访问
                .and()
                // 配置退出相关
                .logout()
//                    .logoutUrl("/logout") // 退出 URL 地址
                .permitAll(); // 所有用户可访问

    }
}
