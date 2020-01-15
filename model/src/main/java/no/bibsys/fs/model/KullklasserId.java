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
 * KullklasserId
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2019-04-25T14:26:52.663+02:00[Europe/Paris]")public class KullklasserId {

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

  @JsonProperty("kull")

  private Id2 kull = null;

  @JsonProperty("kode")

  private String kode = null;
  public KullklasserId href(String href) {
    this.href = href;
    return this;
  }

  

  /**
  * Get href
  * @return href
  **/
  @Schema(example = "https://server/kullklasser/id", description = "")
  public String getHref() {
    return href;
  }
  public void setHref(String href) {
    this.href = href;
  }
  public KullklasserId type(TypeEnum type) {
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
  public KullklasserId kull(Id2 kull) {
    this.kull = kull;
    return this;
  }

  

  /**
  * Get kull
  * @return kull
  **/
  @Schema(description = "")
  public Id2 getKull() {
    return kull;
  }
  public void setKull(Id2 kull) {
    this.kull = kull;
  }
  public KullklasserId kode(String kode) {
    this.kode = kode;
    return this;
  }

  

  /**
  * Get kode
  * @return kode
  **/
  @Schema(description = "")
  public String getKode() {
    return kode;
  }
  public void setKode(String kode) {
    this.kode = kode;
  }
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    KullklasserId kullklasserId = (KullklasserId) o;
    return Objects.equals(this.href, kullklasserId.href) &&
        Objects.equals(this.type, kullklasserId.type) &&
        Objects.equals(this.kull, kullklasserId.kull) &&
        Objects.equals(this.kode, kullklasserId.kode);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(href, type, kull, kode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class KullklasserId {\n");
    
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    kull: ").append(toIndentedString(kull)).append("\n");
    sb.append("    kode: ").append(toIndentedString(kode)).append("\n");
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
