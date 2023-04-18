package b.illia.healthportal.server.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import b.illia.healthportal.server.api.model.SavedUserDto;
import b.illia.healthportal.server.api.model.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.validation.Valid;

@Validated
@Tag(name = "users", description = "the users API")
public interface UsersApi extends Api {

    /**
     * POST /users : Add new user
     * Only super users can perform this operation.
     *
     * @param user  (required)
     * @return A user successfully added, check email for generated password (status code 200)
     *         or Bad Request (status code 400)
     *         or Unauthorized (status code 401)
     */
    @Operation(
        operationId = "addUser",
        summary = "Add new user",
        description = "Only super users can perform this operation.",
        tags = { "users" },
        responses = {
            @ApiResponse(responseCode = "200", description = "A user successfully added, check email for generated password", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = SavedUserDto.class))
            }),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized")
        },
        security = {
            @SecurityRequirement(name = "health_portal_auth")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/users",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<SavedUserDto> addUser(
        @Parameter(name = "User", description = "", required = true) @Valid @RequestBody UserDto user
    ) {
        setExampleResponse("application/json", "null");
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /users/{userId} : Get user by ID
     *
     * @param userId  (required)
     * @return Success (status code 200)
     *         or Bad Request (status code 400)
     *         or Unauthorized (status code 401)
     *         or Requested resource is not found or unaccessible (status code 404)
     */
    @Operation(
        operationId = "getUser",
        summary = "Get user by ID",
        tags = { "users" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Success", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = SavedUserDto.class))
            }),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "404", description = "Requested resource is not found or unaccessible")
        },
        security = {
            @SecurityRequirement(name = "health_portal_auth")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/users/{userId}",
        produces = { "application/json" }
    )
    default ResponseEntity<SavedUserDto> getUser(
        @Parameter(name = "userId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("userId") String userId
    ) {
        setExampleResponse("application/json", "null");
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
