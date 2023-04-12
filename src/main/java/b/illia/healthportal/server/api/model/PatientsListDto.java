package b.illia.healthportal.server.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * PatientsList
 */

public class PatientsListDto {

  private Integer totalCount;

  private Integer count;

  private Integer offset;

  private Boolean hasMore;

  @Valid
  private List<@Valid SavedPatientDto> patients;

  /**
   * Default constructor
   * @deprecated Use {@link PatientsListDto#PatientsListDto(Integer, Integer, Integer, Boolean)}
   */
  @Deprecated
  public PatientsListDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public PatientsListDto(Integer totalCount, Integer count, Integer offset, Boolean hasMore) {
    this.totalCount = totalCount;
    this.count = count;
    this.offset = offset;
    this.hasMore = hasMore;
  }

  public PatientsListDto totalCount(Integer totalCount) {
    this.totalCount = totalCount;
    return this;
  }

  /**
   * Get totalCount
   * @return totalCount
  */
  @NotNull
  @Schema(name = "totalCount", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("totalCount")
  public Integer getTotalCount() {
    return totalCount;
  }

  public void setTotalCount(Integer totalCount) {
    this.totalCount = totalCount;
  }

  public PatientsListDto count(Integer count) {
    this.count = count;
    return this;
  }

  /**
   * Get count
   * @return count
  */
  @NotNull 
  @Schema(name = "count", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("count")
  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }

  public PatientsListDto offset(Integer offset) {
    this.offset = offset;
    return this;
  }

  /**
   * Get offset
   * @return offset
  */
  @NotNull 
  @Schema(name = "offset", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("offset")
  public Integer getOffset() {
    return offset;
  }

  public void setOffset(Integer offset) {
    this.offset = offset;
  }

  public PatientsListDto hasMore(Boolean hasMore) {
    this.hasMore = hasMore;
    return this;
  }

  /**
   * Get hasMore
   * @return hasMore
  */
  @NotNull 
  @Schema(name = "hasMore", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("hasMore")
  public Boolean getHasMore() {
    return hasMore;
  }

  public void setHasMore(Boolean hasMore) {
    this.hasMore = hasMore;
  }

  public PatientsListDto patients(List<@Valid SavedPatientDto> patients) {
    this.patients = patients;
    return this;
  }

  public PatientsListDto addPatientsItem(SavedPatientDto patientsItem) {
    if (this.patients == null) {
      this.patients = new ArrayList<>();
    }
    this.patients.add(patientsItem);
    return this;
  }

  /**
   * Get patients
   * @return patients
  */
  @Valid 
  @Schema(name = "patients", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("patients")
  public List<@Valid SavedPatientDto> getPatients() {
    return patients;
  }

  public void setPatients(List<@Valid SavedPatientDto> patients) {
    this.patients = patients;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PatientsListDto patientsList = (PatientsListDto) o;
    return Objects.equals(this.totalCount, patientsList.totalCount) &&
        Objects.equals(this.count, patientsList.count) &&
        Objects.equals(this.offset, patientsList.offset) &&
        Objects.equals(this.hasMore, patientsList.hasMore) &&
        Objects.equals(this.patients, patientsList.patients);
  }

  @Override
  public int hashCode() {
    return Objects.hash(totalCount, count, offset, hasMore, patients);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PatientsList {\n");
    sb.append("    totalCount: ").append(toIndentedString(totalCount)).append("\n");
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
    sb.append("    offset: ").append(toIndentedString(offset)).append("\n");
    sb.append("    hasMore: ").append(toIndentedString(hasMore)).append("\n");
    sb.append("    patients: ").append(toIndentedString(patients)).append("\n");
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

