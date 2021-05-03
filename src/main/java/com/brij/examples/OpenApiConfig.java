package com.brij.examples;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.examples.Example;
import io.swagger.v3.oas.models.headers.Header;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openAPiConfig() {
        ArrayList<Server> servers = new ArrayList<>();
        servers.add(new Server().url("http://localhost:8080").description("Local environment"));
        servers.add(new Server().url("http://example.uat.com:8080").description("UAT environment"));
        servers.add(new Server().url("http://example.com:8080").description("PROD environment"));
        return new OpenAPI().info(new Info().title("User service").description("API server for accessing user information")
                .license(new License().url("http://example.com").name("domain info")).contact(new Contact()
                        .name("domain").email("domain@gmail.com").url("http://example.com")).version("1.0.0")).servers(servers);
    }

    private Server getServerDetails(String description, String url) {
        Server qa = new Server();
        qa.description(description);
        qa.url(url);
        return qa;
    }
}
