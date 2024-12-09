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
            .csrf().disable() // Deshabilita CSRF (si es necesario)
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/public/**").permitAll() // Permitir rutas públicas
                .anyRequest().authenticated() // Requiere autenticación para todo lo demás
            )
            .httpBasic(); // Habilita autenticación básica
        return http.build();
    }
}
