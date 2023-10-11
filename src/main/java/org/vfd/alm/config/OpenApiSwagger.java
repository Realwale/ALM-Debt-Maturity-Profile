package org.vfd.alm.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @io.swagger.v3.oas.annotations.info.Info(
                description = "Open API documentation for ALM Web Application API",
                title = "ALM Web Application",
                version = "1.0",
                license = @License(name = "Apache License", url = "https://www.apache.org/licenses/LICENSE-2"),
                termsOfService = "Terms of Service"
        ),

        security = {
                @io.swagger.v3.oas.annotations.security.SecurityRequirement(name = "Bearer Authorization")
        }

)

//@ApiResponse(description="Bad Request", responseCode = "400", content = @Content)
//@ApiResponse(description="Unauthorized", responseCode = "401", content = @Content)
//@ApiResponse(description="Internal Server Error", responseCode = "501", content = @Content)

@io.swagger.v3.oas.annotations.security.SecurityScheme(
        name = "Bearer Authorization",
        description = "OpenAI Authentication",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        in = SecuritySchemeIn.HEADER

)
public class OpenApiSwagger {


}