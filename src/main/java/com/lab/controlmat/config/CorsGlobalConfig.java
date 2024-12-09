package com.lab.controlmat.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsGlobalConfig {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfig = new CorsConfiguration();
        corsConfig.addAllowedOrigin("https://ximena1710.github.io"); // Dominio de producción del frontend
        corsConfig.addAllowedOrigin("https://controlmat-ms.onrender.com"); // Dominio del backend
        corsConfig.addAllowedOrigin("http://localhost:4200"); // Desarrollo en Angular
        corsConfig.addAllowedMethod("*"); // Permitir todos los métodos HTTP
        corsConfig.addAllowedHeader("*"); // Permitir todos los encabezados
        corsConfig.setAllowCredentials(true); // Permitir cookies/credenciales

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig);

        return new CorsFilter(source);
    }
}

