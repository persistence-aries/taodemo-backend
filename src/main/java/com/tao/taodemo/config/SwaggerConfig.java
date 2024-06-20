package com.tao.taodemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
	
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                	.info(new Info()
                    .title("TAO Demo Spring Boot 3 API")
                    .version("1.0")
                    .description("Sample Spring Boot 3 project with Swagger/OpenAPI integration")
                    .contact(new Contact()
                    .name("Aries Chang")
                    .email("chang.persistence@gmail.com")
                    .url("https://example.com")));
    }
}
