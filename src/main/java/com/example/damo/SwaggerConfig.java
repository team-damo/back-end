package com.example.damo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;


@Configuration
@EnableWebMvc
public class SwaggerConfig {
    @Bean
    public InternalResourceViewResolver defaultViewResolver() {
        return new InternalResourceViewResolver();
    }

    private ApiInfo swaggerInfo() {
        return new ApiInfoBuilder()
                .title("DAMO API")
                .version("v1")
                .description("DAMO API Docs")
                .build();
    }
}