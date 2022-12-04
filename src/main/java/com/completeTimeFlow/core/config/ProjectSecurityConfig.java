package com.completeTimeFlow.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Collections;


@Configuration
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain web(HttpSecurity http) throws Exception {
        http.cors().configurationSource(new CorsConfigurationSource() {
                    @Override
                    public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                        CorsConfiguration config = new CorsConfiguration();
                        config.setAllowedOrigins(Collections.singletonList("*"));
                        //config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
                        config.setAllowedMethods(Collections.singletonList("*"));
                        //config.setAllowCredentials(true);
                        config.setAllowedHeaders(Collections.singletonList("*"));
                        config.setExposedHeaders(Arrays.asList("Authorization"));
                        //config.setMaxAge(3600L);
                        return config;
                    }
                }).and().authorizeHttpRequests()
                .antMatchers("/welcome").authenticated()
                .antMatchers("/sayHello").permitAll()
                .antMatchers(HttpMethod.GET).permitAll()
                .and().formLogin()
                .and().httpBasic();
        return http.build();

        /**
         * If using @CrossOrigin(origins = "*") in the controller (and not the code above), it's necessary either to allow cors()
         * in some way (like showed below, for example) */
        /*@Bean
        SecurityFilterChain web(HttpSecurity http) throws Exception {
            http.cors().and().authorizeHttpRequests()
                    .antMatchers("/welcome").authenticated()
                    .antMatchers("/sayHello").permitAll()
                    .antMatchers(HttpMethod.GET).permitAll()
                    .and().formLogin()
                    .and().httpBasic();
            return http.build();
        }*/

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
        http.cors().and().authorizeHttpRequests().anyRequest().permitAll()
                .and().formLogin()
                .and().httpBasic();
        return http.build();

    }*/
    }
}
