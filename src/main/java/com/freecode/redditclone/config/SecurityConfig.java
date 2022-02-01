package com.freecode.redditclone.config;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.core.userdetails.UserDetailsService;



@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.csrf().disable()
        .authorizeRequests()
        .antMatchers("/api/auth/**").permitAll()
        .antMatchers("/api/citas/**").permitAll()
        .antMatchers("/api/pagos/**").permitAll()
        .antMatchers("/api/historial/**").permitAll()
        .anyRequest()
        .authenticated();
        
    }
}
