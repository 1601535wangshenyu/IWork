package com.nchu.ruanko.iwork;

import com.nchu.ruanko.iwork.domain.constant.CrossConstant;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class IworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(IworkApplication.class, args);
    }
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/greeting-javaconfig").allowedOrigins("http://"+ CrossConstant.ALLOW_IP+":8081");
            }
        };
    }

}
