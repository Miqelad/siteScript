package com.pmikeladze.siteScript.config;

import com.pmikeladze.siteScript.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserServices userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                /*для вот этого пути разрешаем полный доступ*/
                .antMatchers(  "/h2/**").permitAll()
                /*Другие запросы по авторизации*/
                .anyRequest().authenticated()
                .and()
                /*включаем форму логин и разрешаем пользоваться всем*/
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                /*Логаут так же */
                .logout()
                .permitAll()
                .and()
                .csrf().ignoringAntMatchers("/h2/**")//игнорит csrf
                .and()
                .headers().frameOptions().sameOrigin();//игнорит для h2
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(NoOpPasswordEncoder.getInstance());
    }
}
