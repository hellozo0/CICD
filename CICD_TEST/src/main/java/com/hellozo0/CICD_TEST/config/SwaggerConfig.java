package com.hellozo0.CICD_TEST.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI(){
        Info info = new Info()
                .title("API Document")
                .version("v0.1")
                .description("API 명세서입니다.");
        return new OpenAPI()
                .addServersItem(new Server().url("/"))
                .components(new Components())
                .info(info);
    }
}