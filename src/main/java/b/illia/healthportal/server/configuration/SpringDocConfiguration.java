package b.illia.healthportal.server.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfiguration {

    @Bean(name = "org.openapitools.configuration.SpringDocConfiguration.apiInfo")
    OpenAPI apiInfo() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("b.illia.health-portal - OpenAPI 3.0")
                                .description("API for health portal  Mostly RESTful with addition of long polling endpoints")
                                .version("1.0.0")
                )
                .components(
                        new Components()
                                .addSecuritySchemes("health_portal_auth", new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                )
                )
        ;
    }
}
