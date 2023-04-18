package b.illia.healthportal.server.data;

import b.illia.healthportal.server.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {



}
