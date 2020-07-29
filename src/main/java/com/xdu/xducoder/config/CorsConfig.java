package com.xdu.xducoder.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

    @Configuration
    public class CorsConfig implements WebMvcConfigurer {

        @Bean
        public WebMvcConfigurer corsConfigurer()
        {
            WebMvcConfigurer webMvcConfigurer = new WebMvcConfigurer() {
                @Override
                public void addCorsMappings(CorsRegistry registry) {
                    registry.addMapping("/**").
                            allowedOrigins("*").
                            allowedMethods("*").
                            allowedHeaders("*").
                            allowCredentials(true).
                            exposedHeaders(HttpHeaders.SET_COOKIE).maxAge(3600L);
                }
            };
            System.out.println("VIKI");
            return webMvcConfigurer;
        }
    }

