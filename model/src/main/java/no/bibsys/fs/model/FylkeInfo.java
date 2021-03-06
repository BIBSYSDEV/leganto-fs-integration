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
 * FylkeInfo
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2019-04-25T14:26:52.663+02:00[Europe/Paris]")public class FylkeInfo {

  @JsonProperty("type")

  private String type = null;

  @JsonProperty("nummer")

  private Integer nummer = null;

  @JsonProperty("navn")

  private String navn = null;

  @JsonProperty("region")

  private Integer region = null;

  @JsonProperty("felles")

  private Boolean felles = null;
  public FylkeInfo type(String type) {
    this.type = type;
    return this;
  }

  

  /**
  * Get type
  * @return type
  **/
  @Schema(description = "")
  public String getType() {
    return type;
  }
  public void setType(String type) {
    this.type = type;
  }
  public FylkeInfo nummer(Integer nummer) {
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
  public FylkeInfo navn(String navn) {
    this.navn = navn;
    return this;
  }

  

  /**
  * Get navn
  * @return navn
  **/
  @Schema(description = "")
  public String getNavn() {
    return navn;
  }
  public void setNavn(String navn) {
    this.navn = navn;
  }
  public FylkeInfo region(Integer region) {
    this.region = region;
    return this;
  }

  

  /**
  * Get region
  * @return region
  **/
  @Schema(description = "")
  public Integer getRegion() {
    return region;
  }
  public void setRegion(Integer region) {
    this.region = region;
  }
  public FylkeInfo felles(Boolean felles) {
    this.felles = felles;
    return this;
  }

  

  /**
  * Get felles
  * @return felles
  **/
  @Schema(description = "")
  public Boolean isFelles() {
    return felles;
  }
  public void setFelles(Boolean felles) {
    this.felles = felles;
  }
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FylkeInfo fylkeInfo = (FylkeInfo) o;
    return Objects.equals(this.type, fylkeInfo.type) &&
        Objects.equals(this.nummer, fylkeInfo.nummer) &&
        Objects.equals(this.navn, fylkeInfo.navn) &&
        Objects.equals(this.region, fylkeInfo.region) &&
        Objects.equals(this.felles, fylkeInfo.felles);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(type, nummer, navn, region, felles);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FylkeInfo {\n");
    
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    nummer: ").append(toIndentedString(nummer)).append("\n");
    sb.append("    navn: ").append(toIndentedString(navn)).append("\n");
    sb.append("    region: ").append(toIndentedString(region)).append("\n");
    sb.append("    felles: ").append(toIndentedString(felles)).append("\n");
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
