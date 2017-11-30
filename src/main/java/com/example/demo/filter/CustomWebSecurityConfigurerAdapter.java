//package com.example.demo.filter;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
//
//
//@Configuration
//@EnableWebSecurity
//public class CustomWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private RestAuthenticationEntryPoint authenticationEntryPoint;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/securityNone")
//                .permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .httpBasic()
//                .authenticationEntryPoint(authenticationEntryPoint);
//        http.addFilterAfter(new CustomFilter(), BasicAuthenticationFilter.class);
//    }
//}
