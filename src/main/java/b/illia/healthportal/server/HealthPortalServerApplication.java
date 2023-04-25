package b.illia.healthportal.server;

import b.illia.healthportal.server.data.UserRepository;
import b.illia.healthportal.server.data.model.User;
import com.fasterxml.jackson.databind.Module;
import org.openapitools.jackson.nullable.JsonNullableModule;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FullyQualifiedAnnotationBeanNameGenerator;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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

    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return args -> {
            var passwordEncoder = new BCryptPasswordEncoder();
            var passHash = passwordEncoder.encode("superSecretPassword");
            var user = new User()
                    .setUsername("superAdmin")
                    .setPasswordHash(passHash)
                    .setFirstName("Super")
                    .setLastName("Admin")
                    .setSuperuser(true)
                    .setEmail("superadmin@healthportal.illia.b");
            userRepository.save(user);
            var otheruser = new User()
                    .setUsername("Adminish")
                    .setPasswordHash(passHash)
                    .setFirstName("Reqular")
                    .setLastName("Admin")
                    .setEmail("admin@healthportal.illia.b");
            userRepository.save(otheruser);
        };
    }
}
