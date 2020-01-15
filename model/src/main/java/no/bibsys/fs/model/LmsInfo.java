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
 * LmsInfo
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2019-04-25T14:26:52.663+02:00[Europe/Paris]")public class LmsInfo {

  @JsonProperty("eksport")

  private Boolean eksport = null;

  @JsonProperty("romMal")

  private String romMal = null;

  @JsonProperty("lopenummer")

  private Integer lopenummer = null;
  public LmsInfo eksport(Boolean eksport) {
    this.eksport = eksport;
    return this;
  }

  

  /**
  * Get eksport
  * @return eksport
  **/
  @Schema(description = "")
  public Boolean isEksport() {
    return eksport;
  }
  public void setEksport(Boolean eksport) {
    this.eksport = eksport;
  }
  public LmsInfo romMal(String romMal) {
    this.romMal = romMal;
    return this;
  }

  

  /**
  * Get romMal
  * @return romMal
  **/
  @Schema(description = "")
  public String getRomMal() {
    return romMal;
  }
  public void setRomMal(String romMal) {
    this.romMal = romMal;
  }
  public LmsInfo lopenummer(Integer lopenummer) {
    this.lopenummer = lopenummer;
    return this;
  }

  

  /**
  * Get lopenummer
  * @return lopenummer
  **/
  @Schema(description = "")
  public Integer getLopenummer() {
    return lopenummer;
  }
  public void setLopenummer(Integer lopenummer) {
    this.lopenummer = lopenummer;
  }
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LmsInfo lmsInfo = (LmsInfo) o;
    return Objects.equals(this.eksport, lmsInfo.eksport) &&
        Objects.equals(this.romMal, lmsInfo.romMal) &&
        Objects.equals(this.lopenummer, lmsInfo.lopenummer);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(eksport, romMal, lopenummer);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LmsInfo {\n");
    
    sb.append("    eksport: ").append(toIndentedString(eksport)).append("\n");
    sb.append("    romMal: ").append(toIndentedString(romMal)).append("\n");
    sb.append("    lopenummer: ").append(toIndentedString(lopenummer)).append("\n");
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
