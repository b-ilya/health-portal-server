package b.illia.healthportal.server.data;

import b.illia.healthportal.server.data.model.AuthToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthTokenRepository extends JpaRepository<AuthToken, UUID> {
}
