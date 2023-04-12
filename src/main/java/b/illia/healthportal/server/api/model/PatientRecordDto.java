package b.illia.healthportal.server.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.validation.constraints.NotNull;

import java.util.Objects;

/**
 * PatientRecord
 */

public class PatientRecordDto {

  private Long patientId;

  private String summary;

  private String content;

  /**
   * Default constructor
   * @deprecated Use {@link PatientRecordDto#PatientRecordDto(Long, String)}
   */
  @Deprecated
  public PatientRecordDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public PatientRecordDto(Long patientId, String content) {
    this.patientId = patientId;
    this.content = content;
  }

  public PatientRecordDto patientId(Long patientId) {
    this.patientId = patientId;
    return this;
  }

  /**
   * Get patientId
   * @return patientId
  */
  @NotNull
  @Schema(name = "patientId", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("patientId")
  public Long getPatientId() {
    return patientId;
  }

  public void setPatientId(Long patientId) {
    this.patientId = patientId;
  }

  public PatientRecordDto summary(String summary) {
    this.summary = summary;
    return this;
  }

  /**
   * Get summary
   * @return summary
  */
  
  @Schema(name = "summary", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("summary")
  public String getSummary() {
    return summary;
  }

  public void setSummary(String summary) {
    this.summary = summary;
  }

  public PatientRecordDto content(String content) {
    this.content = content;
    return this;
  }

  /**
   * Get content
   * @return content
  */
  @NotNull 
  @Schema(name = "content", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("content")
  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PatientRecordDto patientRecord = (PatientRecordDto) o;
    return Objects.equals(this.patientId, patientRecord.patientId) &&
        Objects.equals(this.summary, patientRecord.summary) &&
        Objects.equals(this.content, patientRecord.content);
  }

  @Override
  public int hashCode() {
    return Objects.hash(patientId, summary, content);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PatientRecord {\n");
    sb.append("    patientId: ").append(toIndentedString(patientId)).append("\n");
    sb.append("    summary: ").append(toIndentedString(summary)).append("\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

