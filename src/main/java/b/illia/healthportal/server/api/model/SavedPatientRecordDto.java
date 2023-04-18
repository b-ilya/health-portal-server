package b.illia.healthportal.server.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.Valid;
import java.time.OffsetDateTime;

/**
 * SavedPatientRecord
 */

public class SavedPatientRecordDto {

    @NotNull
    @Schema(name = "id", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("id")
    private String id;

    @NotNull
    @Schema(name = "author", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("author")
    private String author;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @NotNull @Valid
    @Schema(name = "created", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("created")
    private OffsetDateTime created;

    @NotNull @Valid
    @Schema(name = "modified", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("modified")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime modified;

    @NotNull
    @Schema(name = "editEnabled", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("editEnabled")
    private Boolean editEnabled;

}

