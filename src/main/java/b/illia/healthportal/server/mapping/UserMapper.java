package b.illia.healthportal.server.mapping;

import b.illia.healthportal.server.api.model.SavedUserDto;
import b.illia.healthportal.server.api.model.UserDto;
import b.illia.healthportal.server.data.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "passwordHash", ignore = true)
    User toEntity(UserDto source);

    SavedUserDto toDto(User source);
}
