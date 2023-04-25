package b.illia.healthportal.server.services;

import b.illia.healthportal.server.data.AuthTokenRepository;
import b.illia.healthportal.server.data.model.AuthToken;
import b.illia.healthportal.server.data.model.User;
import b.illia.healthportal.server.security.TokenAuthentication;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TokenService {
    private final AuthTokenRepository repository;

    public Optional<Authentication> getAuthentication(UUID token) {
        return repository.findById(token)
                .map(AuthToken::getUser)
                .map(user -> TokenAuthentication.of(user, token));
    }


}
