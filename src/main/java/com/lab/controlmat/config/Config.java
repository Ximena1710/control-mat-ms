package com.lab.controlmat.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class Config implements WebMvcConfigurer {

	@Bean
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Aplica a todas las rutas
                .allowedOrigins(
                    "http://localhost:3000",
                    "http://localhost",
                    "http://localhost:4200",
                    "https://controlmat-ms.onrender.com"
                )
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Métodos permitidos
                .allowedHeaders("*") // Todos los encabezados permitidos
                .allowCredentials(true); // Permite cookies o credenciales
    }
}