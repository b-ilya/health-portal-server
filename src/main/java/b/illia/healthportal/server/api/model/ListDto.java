package b.illia.healthportal.server.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public abstract class ListDto {

    @NotNull
    @Schema(name = "totalCount", requiredMode = REQUIRED)
    @JsonProperty("totalCount")
    protected Integer totalCount;

    @NotNull
    @Schema(name = "count", requiredMode = REQUIRED)
    @JsonProperty("count")
    protected Integer count;

    @NotNull
    @Schema(name = "offset", requiredMode = REQUIRED)
    @JsonProperty("offset")
    protected Integer offset;

    @NotNull
    @Schema(name = "hasMore", requiredMode = REQUIRED)
    @JsonProperty("hasMore")
    protected Boolean hasMore;

}
