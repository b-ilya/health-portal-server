package b.illia.healthportal.server.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.Valid;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Patient
 */

public class Patient {

  private String firstName;

  private String lastName;

  private SexEnum sex;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate birthDate;

  private Address address;

  /**
   * Default constructor
   * @deprecated Use {@link Patient#Patient(String, String, SexEnum, LocalDate, Address)}
   */
  @Deprecated
  public Patient() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Patient(String firstName, String lastName, SexEnum sex, LocalDate birthDate, Address address) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.sex = sex;
    this.birthDate = birthDate;
    this.address = address;
  }

  public Patient firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * Get firstName
   * @return firstName
  */
  @NotNull 
  @Schema(name = "firstName", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("firstName")
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public Patient lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * Get lastName
   * @return lastName
  */
  @NotNull
  @Schema(name = "lastName", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("lastName")
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Patient sex(SexEnum sex) {
    this.sex = sex;
    return this;
  }

  /**
   * Get sex
   * @return sex
  */
  @NotNull 
  @Schema(name = "sex", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("sex")
  public SexEnum getSex() {
    return sex;
  }

  public void setSex(SexEnum sex) {
    this.sex = sex;
  }

  public Patient birthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
    return this;
  }

  /**
   * Get birthDate
   * @return birthDate
  */
  @NotNull @Valid 
  @Schema(name = "birthDate", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("birthDate")
  public LocalDate getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
  }

  public Patient address(Address address) {
    this.address = address;
    return this;
  }

  /**
   * Get address
   * @return address
  */
  @NotNull @Valid 
  @Schema(name = "address", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("address")
  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Patient patient = (Patient) o;
    return Objects.equals(this.firstName, patient.firstName) &&
        Objects.equals(this.lastName, patient.lastName) &&
        Objects.equals(this.sex, patient.sex) &&
        Objects.equals(this.birthDate, patient.birthDate) &&
        Objects.equals(this.address, patient.address);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName, sex, birthDate, address);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Patient {\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    sex: ").append(toIndentedString(sex)).append("\n");
    sb.append("    birthDate: ").append(toIndentedString(birthDate)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
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

