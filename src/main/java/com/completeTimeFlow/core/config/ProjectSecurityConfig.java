package com.completeTimeFlow.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain web(HttpSecurity http) throws Exception {
            http.authorizeHttpRequests()
                      .antMatchers("/welcome").authenticated()
                      .antMatchers("/sayHello").permitAll()
                      .and().formLogin()
                      .and().httpBasic();
        return http.build();

        /**
         *  Configuration to deny all the requests
         */
        /*http.authorizeHttpRequests().anyRequest().denyAll()
                .and().formLogin()
                .and().httpBasic();
        return http.build();*/

        /**
         *  Configuration to permit all the requests
         */
/*
        http.authorizeHttpRequests().anyRequest().permitAll()
                .and().formLogin()
                .and().httpBasic();
        return http.build();
*/

    }
}
