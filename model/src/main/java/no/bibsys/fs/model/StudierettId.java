/*
 * FS-API
 * FS-API'et er et generelt grensesnitt mot Felles Studentsystem (FS)
 *
 * OpenAPI spec version: 1.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package no.bibsys.fs.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import no.bibsys.fs.model.Id2;

/**
 * StudierettId
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2019-04-25T14:26:52.663+02:00[Europe/Paris]")public class StudierettId {

  @JsonProperty("href")

  private String href = null;
  /**
   * Gets or Sets type
   */
  public enum TypeEnum {
    EMPTY("");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }
    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    @JsonCreator
    public static TypeEnum fromValue(String text) {
      for (TypeEnum b : TypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

  }
  @JsonProperty("type")

  private TypeEnum type = null;

  @JsonProperty("person")

  private Id2 person = null;

  @JsonProperty("studieprogram")

  private Id2 studieprogram = null;

  @JsonProperty("termin")

  private Id2 termin = null;
  public StudierettId href(String href) {
    this.href = href;
    return this;
  }

  

  /**
  * Get href
  * @return href
  **/
  @Schema(example = "https://server/studierett/id", description = "")
  public String getHref() {
    return href;
  }
  public void setHref(String href) {
    this.href = href;
  }
  public StudierettId type(TypeEnum type) {
    this.type = type;
    return this;
  }

  

  /**
  * Get type
  * @return type
  **/
  @Schema(description = "")
  public TypeEnum getType() {
    return type;
  }
  public void setType(TypeEnum type) {
    this.type = type;
  }
  public StudierettId person(Id2 person) {
    this.person = person;
    return this;
  }

  

  /**
  * Get person
  * @return person
  **/
  @Schema(description = "")
  public Id2 getPerson() {
    return person;
  }
  public void setPerson(Id2 person) {
    this.person = person;
  }
  public StudierettId studieprogram(Id2 studieprogram) {
    this.studieprogram = studieprogram;
    return this;
  }

  

  /**
  * Get studieprogram
  * @return studieprogram
  **/
  @Schema(description = "")
  public Id2 getStudieprogram() {
    return studieprogram;
  }
  public void setStudieprogram(Id2 studieprogram) {
    this.studieprogram = studieprogram;
  }
  public StudierettId termin(Id2 termin) {
    this.termin = termin;
    return this;
  }

  

  /**
  * Get termin
  * @return termin
  **/
  @Schema(description = "")
  public Id2 getTermin() {
    return termin;
  }
  public void setTermin(Id2 termin) {
    this.termin = termin;
  }
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StudierettId studierettId = (StudierettId) o;
    return Objects.equals(this.href, studierettId.href) &&
        Objects.equals(this.type, studierettId.type) &&
        Objects.equals(this.person, studierettId.person) &&
        Objects.equals(this.studieprogram, studierettId.studieprogram) &&
        Objects.equals(this.termin, studierettId.termin);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(href, type, person, studieprogram, termin);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StudierettId {\n");
    
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    person: ").append(toIndentedString(person)).append("\n");
    sb.append("    studieprogram: ").append(toIndentedString(studieprogram)).append("\n");
    sb.append("    termin: ").append(toIndentedString(termin)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
