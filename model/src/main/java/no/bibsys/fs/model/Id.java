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

/**
 * Id
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2019-04-25T14:26:52.663+02:00[Europe/Paris]")public class Id {

  @JsonProperty("href")

  private String href = null;
  /**
   * Gets or Sets type
   */
  public enum TypeEnum {
    GODKJENT_GSK("GODKJENT_GSK"),
    ANSATT("ANSATT"),
    OVERORDNET("OVERORDNET"),
    ERSTATTES_AV("ERSTATTES_AV"),
    GEOGRAFISK("GEOGRAFISK");

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

  @JsonProperty("institusjon")

  private Integer institusjon = null;

  @JsonProperty("fakultet")

  private Integer fakultet = null;

  @JsonProperty("institutt")

  private Integer institutt = null;

  @JsonProperty("gruppe")

  private Integer gruppe = null;
  public Id href(String href) {
    this.href = href;
    return this;
  }

  

  /**
  * Get href
  * @return href
  **/
  @Schema(example = "https://server/organisasjonsenheter/id", description = "")
  public String getHref() {
    return href;
  }
  public void setHref(String href) {
    this.href = href;
  }
  public Id type(TypeEnum type) {
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
  public Id institusjon(Integer institusjon) {
    this.institusjon = institusjon;
    return this;
  }

  

  /**
  * Get institusjon
  * @return institusjon
  **/
  @Schema(description = "")
  public Integer getInstitusjon() {
    return institusjon;
  }
  public void setInstitusjon(Integer institusjon) {
    this.institusjon = institusjon;
  }
  public Id fakultet(Integer fakultet) {
    this.fakultet = fakultet;
    return this;
  }

  

  /**
  * Get fakultet
  * @return fakultet
  **/
  @Schema(description = "")
  public Integer getFakultet() {
    return fakultet;
  }
  public void setFakultet(Integer fakultet) {
    this.fakultet = fakultet;
  }
  public Id institutt(Integer institutt) {
    this.institutt = institutt;
    return this;
  }

  

  /**
  * Get institutt
  * @return institutt
  **/
  @Schema(description = "")
  public Integer getInstitutt() {
    return institutt;
  }
  public void setInstitutt(Integer institutt) {
    this.institutt = institutt;
  }
  public Id gruppe(Integer gruppe) {
    this.gruppe = gruppe;
    return this;
  }

  

  /**
  * Get gruppe
  * @return gruppe
  **/
  @Schema(description = "")
  public Integer getGruppe() {
    return gruppe;
  }
  public void setGruppe(Integer gruppe) {
    this.gruppe = gruppe;
  }
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Id id = (Id) o;
    return Objects.equals(this.href, id.href) &&
        Objects.equals(this.type, id.type) &&
        Objects.equals(this.institusjon, id.institusjon) &&
        Objects.equals(this.fakultet, id.fakultet) &&
        Objects.equals(this.institutt, id.institutt) &&
        Objects.equals(this.gruppe, id.gruppe);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(href, type, institusjon, fakultet, institutt, gruppe);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Id {\n");
    
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    institusjon: ").append(toIndentedString(institusjon)).append("\n");
    sb.append("    fakultet: ").append(toIndentedString(fakultet)).append("\n");
    sb.append("    institutt: ").append(toIndentedString(institutt)).append("\n");
    sb.append("    gruppe: ").append(toIndentedString(gruppe)).append("\n");
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
