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
 * DeltakerId
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2019-04-25T14:26:52.663+02:00[Europe/Paris]")public class DeltakerId {

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

  @JsonProperty("nummer")

  private Integer nummer = null;
  public DeltakerId href(String href) {
    this.href = href;
    return this;
  }

  

  /**
  * Get href
  * @return href
  **/
  @Schema(example = "https://server/deltakere/id", description = "")
  public String getHref() {
    return href;
  }
  public void setHref(String href) {
    this.href = href;
  }
  public DeltakerId type(TypeEnum type) {
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
  public DeltakerId nummer(Integer nummer) {
    this.nummer = nummer;
    return this;
  }

  

  /**
  * Get nummer
  * @return nummer
  **/
  @Schema(description = "")
  public Integer getNummer() {
    return nummer;
  }
  public void setNummer(Integer nummer) {
    this.nummer = nummer;
  }
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeltakerId deltakerId = (DeltakerId) o;
    return Objects.equals(this.href, deltakerId.href) &&
        Objects.equals(this.type, deltakerId.type) &&
        Objects.equals(this.nummer, deltakerId.nummer);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(href, type, nummer);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeltakerId {\n");
    
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    nummer: ").append(toIndentedString(nummer)).append("\n");
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