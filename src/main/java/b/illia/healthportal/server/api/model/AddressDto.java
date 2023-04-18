package b.illia.healthportal.server.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.NOT_REQUIRED;
import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

/**
 * Address
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {

    @NotNull
    @Schema(name = "streetAddress", requiredMode = REQUIRED)
    @JsonProperty("streetAddress")
    private String streetAddress;

    @NotNull
    @Schema(name = "city", requiredMode = REQUIRED)
    @JsonProperty("city")
    private String city;

    @Schema(name = "state", requiredMode = NOT_REQUIRED)
    @JsonProperty("state")
    private String state;

    @NotNull
    @Schema(name = "country", requiredMode = REQUIRED)
    @JsonProperty("country")
    private String country;

    @Schema(name = "zip", requiredMode = NOT_REQUIRED)
    @JsonProperty("zip")
    private String zip;
}

