package umc6th.spring6th.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.security.SecurityScheme.Type;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class SwaggerConfig {
    public SwaggerConfig() {
    }

    @Bean
    public OpenAPI UMCstudyAPI() {
        Info info = (new Info()).title("UMC Server WorkBook API").description("UMC Server WorkBook API 명세서").version("1.0.0");
        String jwtSchemeName = "JWT TOKEN";
        SecurityRequirement securityRequirement = (new SecurityRequirement()).addList(jwtSchemeName);
        Components components = (new Components()).addSecuritySchemes(jwtSchemeName, (new SecurityScheme()).name(jwtSchemeName).type(Type.HTTP).scheme("bearer").bearerFormat("JWT"));
        return (new OpenAPI()).addServersItem((new Server()).url("/")).info(info).addSecurityItem(securityRequirement).components(components);
    }
}
