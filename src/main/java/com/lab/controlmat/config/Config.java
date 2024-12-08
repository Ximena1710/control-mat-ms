package com.lab.controlmat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Config implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Aplica a todas las rutas
                .allowedOrigins(
                    "http://localhost:3000", // React o el front en desarrollo
                    "http://localhost", // Agregar localhost si es necesario
                    "http://localhost:4200", // Angular
                    "https://controlmat-ms.onrender.com" // Dominio de producción
                )
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Métodos permitidos
                .allowedHeaders("*") // Todos los encabezados permitidos
                .allowCredentials(true); // Permite cookies o credenciales
    }
}
