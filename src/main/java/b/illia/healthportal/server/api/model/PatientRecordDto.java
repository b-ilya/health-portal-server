package b.illia.healthportal.server.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.NOT_REQUIRED;
import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

/**
 * PatientRecord
 */
@Data
@AllArgsConstructor
public class PatientRecordDto {

    @NotNull
    @Schema(name = "patientId", requiredMode = REQUIRED)
    @JsonProperty("patientId")
    private Long patientId;

    @Schema(name = "summary", requiredMode = NOT_REQUIRED)
    @JsonProperty("summary")
    private String summary;

    @NotNull
    @Schema(name = "content", requiredMode = REQUIRED)
    @JsonProperty("content")
    private String content;

}

