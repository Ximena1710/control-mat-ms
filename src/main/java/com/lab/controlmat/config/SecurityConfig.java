package com.lab.controlmat.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    	   http.cors().and() // Habilita CORS
           .csrf().disable()
           .authorizeHttpRequests(auth -> auth
               .requestMatchers("/public/**").permitAll()
               .anyRequest().authenticated()
           )
           .httpBasic();
           return http.build();
    }
}
