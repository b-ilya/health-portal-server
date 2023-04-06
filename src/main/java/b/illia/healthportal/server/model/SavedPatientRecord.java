package b.illia.healthportal.server.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * SavedPatientRecord
 */

public class SavedPatientRecord {

  private Long id;

  private String author;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime created;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime modified;

  private Boolean editEnabled;

  private Long patientId;

  private String summary;

  private String content;

  /**
   * Default constructor
   * @deprecated Use {@link SavedPatientRecord#SavedPatientRecord(Long, String, OffsetDateTime, OffsetDateTime, Boolean, Long, String)}
   */
  @Deprecated
  public SavedPatientRecord() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public SavedPatientRecord(Long id, String author, OffsetDateTime created, OffsetDateTime modified, Boolean editEnabled, Long patientId, String content) {
    this.id = id;
    this.author = author;
    this.created = created;
    this.modified = modified;
    this.editEnabled = editEnabled;
    this.patientId = patientId;
    this.content = content;
  }

  public SavedPatientRecord id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @NotNull
  @Schema(name = "id", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public SavedPatientRecord author(String author) {
    this.author = author;
    return this;
  }

  /**
   * Get author
   * @return author
  */
  @NotNull 
  @Schema(name = "author", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("author")
  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public SavedPatientRecord created(OffsetDateTime created) {
    this.created = created;
    return this;
  }

  /**
   * Get created
   * @return created
  */
  @NotNull @Valid 
  @Schema(name = "created", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("created")
  public OffsetDateTime getCreated() {
    return created;
  }

  public void setCreated(OffsetDateTime created) {
    this.created = created;
  }

  public SavedPatientRecord modified(OffsetDateTime modified) {
    this.modified = modified;
    return this;
  }

  /**
   * Get modified
   * @return modified
  */
  @NotNull @Valid 
  @Schema(name = "modified", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("modified")
  public OffsetDateTime getModified() {
    return modified;
  }

  public void setModified(OffsetDateTime modified) {
    this.modified = modified;
  }

  public SavedPatientRecord editEnabled(Boolean editEnabled) {
    this.editEnabled = editEnabled;
    return this;
  }

  /**
   * Get editEnabled
   * @return editEnabled
  */
  @NotNull 
  @Schema(name = "editEnabled", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("editEnabled")
  public Boolean getEditEnabled() {
    return editEnabled;
  }

  public void setEditEnabled(Boolean editEnabled) {
    this.editEnabled = editEnabled;
  }

  public SavedPatientRecord patientId(Long patientId) {
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

  public SavedPatientRecord summary(String summary) {
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

  public SavedPatientRecord content(String content) {
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
    SavedPatientRecord savedPatientRecord = (SavedPatientRecord) o;
    return Objects.equals(this.id, savedPatientRecord.id) &&
        Objects.equals(this.author, savedPatientRecord.author) &&
        Objects.equals(this.created, savedPatientRecord.created) &&
        Objects.equals(this.modified, savedPatientRecord.modified) &&
        Objects.equals(this.editEnabled, savedPatientRecord.editEnabled) &&
        Objects.equals(this.patientId, savedPatientRecord.patientId) &&
        Objects.equals(this.summary, savedPatientRecord.summary) &&
        Objects.equals(this.content, savedPatientRecord.content);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, author, created, modified, editEnabled, patientId, summary, content);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SavedPatientRecord {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    author: ").append(toIndentedString(author)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    modified: ").append(toIndentedString(modified)).append("\n");
    sb.append("    editEnabled: ").append(toIndentedString(editEnabled)).append("\n");
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

