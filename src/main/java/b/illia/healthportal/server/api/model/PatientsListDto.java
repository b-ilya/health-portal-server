package b.illia.healthportal.server.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * PatientsList
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PatientsListDto extends ListDto {

    @Valid
    @Schema(name = "patients", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("patients")
    private List<@Valid SavedPatientDto> patients;

}

