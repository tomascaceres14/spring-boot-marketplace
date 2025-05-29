package com.tomasdev.akhanta.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.security.SecuritySchemes;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Tomas Alegria",
                        email = "tomialegriacaceres@gmail.com"
                ),
                title = "Cambalache API",
                description = "OpenApi documentation for Cambalache Marketplace.",
                version = "1.0.0"
        ),
        servers = {
                @Server(
                        description = "Local test ENV",
                        url = "http://localhost:8080"
                )
        }
)
@SecuritySchemes(
    value = {
            @SecurityScheme(
            name = "User Auth",
            description = "Authorization token for user actions",
            scheme = "bearer",
            bearerFormat = "JWT",
            type = SecuritySchemeType.HTTP,
            in = SecuritySchemeIn.HEADER
            ),
            @SecurityScheme(
                    name = "Admin Auth",
                    description = "Admin only server actions",
                    scheme = "bearer",
                    bearerFormat = "JWT",
                    type = SecuritySchemeType.HTTP,
                    in = SecuritySchemeIn.HEADER
            )
    }
)
public class OpenApiConfig {
}
