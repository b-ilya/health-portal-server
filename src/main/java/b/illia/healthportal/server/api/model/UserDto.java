package b.illia.healthportal.server.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * User
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    @NotNull
    @Schema(name = "username", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("username")
    protected String username;

    @NotNull
    @Schema(name = "firstName", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("firstName")
    protected String firstName;

    @NotNull
    @Schema(name = "lastName", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("lastName")
    protected String lastName;

    @NotNull
    @Schema(name = "email", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("email")
    protected String email;

    @Schema(name = "superuser", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("superuser")
    protected Boolean superuser = false;
}

