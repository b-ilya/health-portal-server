package b.illia.healthportal.server.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * PatientRecordsList
 */

public class PatientRecordsListDto {

  private Integer totalCount;

  private Integer count;

  private Integer offset;

  private Boolean hasMore;

  @Valid
  private List<@Valid SavedPatientRecordDto> records;

  /**
   * Default constructor
   * @deprecated Use {@link PatientRecordsListDto#PatientRecordsListDto(Integer, Integer, Integer, Boolean)}
   */
  @Deprecated
  public PatientRecordsListDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public PatientRecordsListDto(Integer totalCount, Integer count, Integer offset, Boolean hasMore) {
    this.totalCount = totalCount;
    this.count = count;
    this.offset = offset;
    this.hasMore = hasMore;
  }

  public PatientRecordsListDto totalCount(Integer totalCount) {
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

  public PatientRecordsListDto count(Integer count) {
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

  public PatientRecordsListDto offset(Integer offset) {
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

  public PatientRecordsListDto hasMore(Boolean hasMore) {
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

  public PatientRecordsListDto records(List<@Valid SavedPatientRecordDto> records) {
    this.records = records;
    return this;
  }

  public PatientRecordsListDto addRecordsItem(SavedPatientRecordDto recordsItem) {
    if (this.records == null) {
      this.records = new ArrayList<>();
    }
    this.records.add(recordsItem);
    return this;
  }

  /**
   * Get records
   * @return records
  */
  @Valid 
  @Schema(name = "records", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("records")
  public List<@Valid SavedPatientRecordDto> getRecords() {
    return records;
  }

  public void setRecords(List<@Valid SavedPatientRecordDto> records) {
    this.records = records;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PatientRecordsListDto patientRecordsList = (PatientRecordsListDto) o;
    return Objects.equals(this.totalCount, patientRecordsList.totalCount) &&
        Objects.equals(this.count, patientRecordsList.count) &&
        Objects.equals(this.offset, patientRecordsList.offset) &&
        Objects.equals(this.hasMore, patientRecordsList.hasMore) &&
        Objects.equals(this.records, patientRecordsList.records);
  }

  @Override
  public int hashCode() {
    return Objects.hash(totalCount, count, offset, hasMore, records);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PatientRecordsList {\n");
    sb.append("    totalCount: ").append(toIndentedString(totalCount)).append("\n");
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
    sb.append("    offset: ").append(toIndentedString(offset)).append("\n");
    sb.append("    hasMore: ").append(toIndentedString(hasMore)).append("\n");
    sb.append("    records: ").append(toIndentedString(records)).append("\n");
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

