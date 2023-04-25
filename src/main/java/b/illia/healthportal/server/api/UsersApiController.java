package b.illia.healthportal.server.api;

import b.illia.healthportal.server.api.model.SavedUserDto;
import b.illia.healthportal.server.data.UserRepository;
import b.illia.healthportal.server.mapping.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("${openapi.bIlliaHealthPortalOpenAPI30.base-path:}")
public class UsersApiController implements UsersApi {

    private final UserMapper mapper;
    private final UserRepository repository;
    private final NativeWebRequest request;

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<SavedUserDto> getUser(UUID userId) {
        return repository.findById(userId)
                .map(mapper::toDto).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
