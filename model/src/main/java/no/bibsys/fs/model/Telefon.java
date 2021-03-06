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
 * Telefon
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2019-04-25T14:26:52.663+02:00[Europe/Paris]")public class Telefon {

  @JsonProperty("type")

  private String type = null;

  @JsonProperty("landnummer")

  private String landnummer = null;

  @JsonProperty("nummer")

  private String nummer = null;

  @JsonProperty("merknad")

  private String merknad = null;
  public Telefon type(String type) {
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
  public Telefon landnummer(String landnummer) {
    this.landnummer = landnummer;
    return this;
  }

  

  /**
  * Get landnummer
  * @return landnummer
  **/
  @Schema(description = "")
  public String getLandnummer() {
    return landnummer;
  }
  public void setLandnummer(String landnummer) {
    this.landnummer = landnummer;
  }
  public Telefon nummer(String nummer) {
    this.nummer = nummer;
    return this;
  }

  

  /**
  * Get nummer
  * @return nummer
  **/
  @Schema(description = "")
  public String getNummer() {
    return nummer;
  }
  public void setNummer(String nummer) {
    this.nummer = nummer;
  }
  public Telefon merknad(String merknad) {
    this.merknad = merknad;
    return this;
  }

  

  /**
  * Get merknad
  * @return merknad
  **/
  @Schema(description = "")
  public String getMerknad() {
    return merknad;
  }
  public void setMerknad(String merknad) {
    this.merknad = merknad;
  }
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Telefon telefon = (Telefon) o;
    return Objects.equals(this.type, telefon.type) &&
        Objects.equals(this.landnummer, telefon.landnummer) &&
        Objects.equals(this.nummer, telefon.nummer) &&
        Objects.equals(this.merknad, telefon.merknad);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(type, landnummer, nummer, merknad);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Telefon {\n");
    
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    landnummer: ").append(toIndentedString(landnummer)).append("\n");
    sb.append("    nummer: ").append(toIndentedString(nummer)).append("\n");
    sb.append("    merknad: ").append(toIndentedString(merknad)).append("\n");
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
