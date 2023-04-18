package b.illia.healthportal.server.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * PatientRecordsList
 */
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PatientRecordsListDto extends ListDto {

    @Valid
    @Schema(name = "records", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("records")
    private List<@Valid SavedPatientRecordDto> records;

}

