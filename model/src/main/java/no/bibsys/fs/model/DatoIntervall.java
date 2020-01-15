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
import org.threeten.bp.LocalDate;

/**
 * DatoIntervall
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2019-04-25T14:26:52.663+02:00[Europe/Paris]")public class DatoIntervall {

  @JsonProperty("type")

  private String type = null;

  @JsonProperty("fraDato")

  private LocalDate fraDato = null;

  @JsonProperty("tilDato")

  private LocalDate tilDato = null;
  public DatoIntervall type(String type) {
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
  public DatoIntervall fraDato(LocalDate fraDato) {
    this.fraDato = fraDato;
    return this;
  }

  

  /**
  * Get fraDato
  * @return fraDato
  **/
  @Schema(description = "")
  public LocalDate getFraDato() {
    return fraDato;
  }
  public void setFraDato(LocalDate fraDato) {
    this.fraDato = fraDato;
  }
  public DatoIntervall tilDato(LocalDate tilDato) {
    this.tilDato = tilDato;
    return this;
  }

  

  /**
  * Get tilDato
  * @return tilDato
  **/
  @Schema(description = "")
  public LocalDate getTilDato() {
    return tilDato;
  }
  public void setTilDato(LocalDate tilDato) {
    this.tilDato = tilDato;
  }
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DatoIntervall datoIntervall = (DatoIntervall) o;
    return Objects.equals(this.type, datoIntervall.type) &&
        Objects.equals(this.fraDato, datoIntervall.fraDato) &&
        Objects.equals(this.tilDato, datoIntervall.tilDato);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(type, fraDato, tilDato);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DatoIntervall {\n");
    
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    fraDato: ").append(toIndentedString(fraDato)).append("\n");
    sb.append("    tilDato: ").append(toIndentedString(tilDato)).append("\n");
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