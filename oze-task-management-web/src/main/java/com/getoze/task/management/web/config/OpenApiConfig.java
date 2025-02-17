package com.getoze.task.management.web.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openApi() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("Oze Task Management").description(
                                "Oze Task Management").version("1.0.0-SNAPSHOT")
                        .contact(new Contact().name("Ivan Guambe")
                                .url("https://github.com/guambino/oze-task-management.git")));
    }
}
