package com.lab.controlmat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Config implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
	    registry.addMapping("/**")
	            .allowedOrigins(
	                "https://ximena1710.github.io",
	                "http://localhost:4200", 
	                "http://localhost:3000", 
	                "https://controlmat-ms.onrender.com"
	            )
	            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
	            .allowedHeaders("*")
	            .allowCredentials(false);
	}
}
