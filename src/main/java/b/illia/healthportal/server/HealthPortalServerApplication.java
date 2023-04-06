package b.illia.healthportal.server;

import com.fasterxml.jackson.databind.Module;
import org.openapitools.jackson.nullable.JsonNullableModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FullyQualifiedAnnotationBeanNameGenerator;

@SpringBootApplication(
        nameGenerator = FullyQualifiedAnnotationBeanNameGenerator.class
)
@ComponentScan(
        basePackages = {"b.illia.healthportal.server"},
        nameGenerator = FullyQualifiedAnnotationBeanNameGenerator.class
)
public class HealthPortalServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HealthPortalServerApplication.class, args);
    }

    @Bean(name = "package b.illia.healthportal.server.HealthPortalServerApplication.jsonNullableModule")
    public Module jsonNullableModule() {
        return new JsonNullableModule();
    }

}
