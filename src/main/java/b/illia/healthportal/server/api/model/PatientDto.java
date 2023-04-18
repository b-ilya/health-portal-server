package b.illia.healthportal.server.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.Valid;
import java.time.LocalDate;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

/**
 * Patient
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto {

    @NotNull
    @Schema(name = "firstName", requiredMode = REQUIRED)
    @JsonProperty("firstName")
    protected String firstName;

    @NotNull
    @Schema(name = "lastName", requiredMode = REQUIRED)
    @JsonProperty("lastName")
    protected String lastName;

    @NotNull
    @Schema(name = "sex", requiredMode = REQUIRED)
    @JsonProperty("sex")
    protected SexEnum sex;

    @NotNull @Valid
    @Schema(name = "birthDate", requiredMode = REQUIRED)
    @JsonProperty("birthDate")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    protected LocalDate birthDate;

    @NotNull @Valid
    @Schema(name = "address", requiredMode = REQUIRED)
    @JsonProperty("address")
    protected AddressDto address;

}

