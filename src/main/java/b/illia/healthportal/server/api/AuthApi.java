package b.illia.healthportal.server.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

import java.util.UUID;

@Validated
@Tag(name = "auth", description = "the auth API")
public interface AuthApi {

    /**
     * POST /auth/token : Logs user into the system
     *
     * @param username The user name for login (required)
     * @param password hash of the password (required)
     * @return successful operation (status code 200)
     *         or Bad Request (status code 400)
     *         or No user found with provided username/password (status code 404)
     */
    @Operation(
        operationId = "authenticate",
        summary = "Logs user into the system",
        tags = { "auth" },
        responses = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))
            }),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "404", description = "No user found with provided username/password")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/auth/token",
        produces = { "application/json" }
    )
    default ResponseEntity<UUID> authenticate(
        @NotNull @Parameter(name = "username", description = "The user name for login", required = true, in = ParameterIn.QUERY) @Valid @RequestParam(value = "username", required = true) String username,
        @NotNull @Parameter(name = "password", description = "hash of the password", required = true, in = ParameterIn.QUERY) @Valid @RequestParam(value = "password", required = true) String password
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /auth/logout : Logs out current logged in user session
     *
     * @return Operation was successful (status code 200)
     *         or Bad Request (status code 400)
     *         or Unauthorized (status code 401)
     */
    @Operation(
        operationId = "revoke",
        summary = "Logs out current logged in user session",
        tags = { "auth" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Operation was successful"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized")
        },
        security = {
            @SecurityRequirement(name = "health_portal_auth")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/auth/logout"
    )
    default ResponseEntity<Void> revoke(
        
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
