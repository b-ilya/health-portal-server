package b.illia.healthportal.server.api;

import b.illia.healthportal.server.data.AuthTokenRepository;
import b.illia.healthportal.server.data.UserRepository;
import b.illia.healthportal.server.data.model.AuthToken;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@AllArgsConstructor
@RequestMapping("${openapi.bIlliaHealthPortalOpenAPI30.base-path:}")
public class AuthApiController implements AuthApi {

    private final BCryptPasswordEncoder passwordEncoder;
    private final AuthTokenRepository tokenRepository;
    private final UserRepository userRepository;

    @Override
    public ResponseEntity<UUID> authenticate(String username, String password) {
        return userRepository.findByUsername(username)
                .filter(user -> passwordEncoder.matches(password, user.getPasswordHash()))
                .map(user -> {
                    var token = new AuthToken();
                    token.setUser(user);
                    return tokenRepository.save(token).getToken();
                })
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
