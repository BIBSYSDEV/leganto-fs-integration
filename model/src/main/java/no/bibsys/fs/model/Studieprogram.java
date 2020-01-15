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
import no.bibsys.fs.model.Id;
import no.bibsys.fs.model.Id2;
import no.bibsys.fs.model.SprakFelter;
import no.bibsys.fs.model.StudieprogramId;

/**
 * Studieprogram
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2019-04-25T14:26:52.663+02:00[Europe/Paris]")public class Studieprogram {

  @JsonProperty("id")

  private StudieprogramId id = null;

  @JsonProperty("navn")

  private SprakFelter navn = null;

  @JsonProperty("utgatt")

  private Boolean utgatt = null;

  @JsonProperty("studieniva")

  private Id2 studieniva = null;

  @JsonProperty("organisasjonsenhet")

  private Id organisasjonsenhet = null;
  public Studieprogram id(StudieprogramId id) {
    this.id = id;
    return this;
  }

  

  /**
  * Get id
  * @return id
  **/
  @Schema(description = "")
  public StudieprogramId getId() {
    return id;
  }
  public void setId(StudieprogramId id) {
    this.id = id;
  }
  public Studieprogram navn(SprakFelter navn) {
    this.navn = navn;
    return this;
  }

  

  /**
  * Get navn
  * @return navn
  **/
  @Schema(description = "")
  public SprakFelter getNavn() {
    return navn;
  }
  public void setNavn(SprakFelter navn) {
    this.navn = navn;
  }
  public Studieprogram utgatt(Boolean utgatt) {
    this.utgatt = utgatt;
    return this;
  }

  

  /**
  * Get utgatt
  * @return utgatt
  **/
  @Schema(description = "")
  public Boolean isUtgatt() {
    return utgatt;
  }
  public void setUtgatt(Boolean utgatt) {
    this.utgatt = utgatt;
  }
  public Studieprogram studieniva(Id2 studieniva) {
    this.studieniva = studieniva;
    return this;
  }

  

  /**
  * Get studieniva
  * @return studieniva
  **/
  @Schema(description = "")
  public Id2 getStudieniva() {
    return studieniva;
  }
  public void setStudieniva(Id2 studieniva) {
    this.studieniva = studieniva;
  }
  public Studieprogram organisasjonsenhet(Id organisasjonsenhet) {
    this.organisasjonsenhet = organisasjonsenhet;
    return this;
  }

  

  /**
  * Get organisasjonsenhet
  * @return organisasjonsenhet
  **/
  @Schema(description = "")
  public Id getOrganisasjonsenhet() {
    return organisasjonsenhet;
  }
  public void setOrganisasjonsenhet(Id organisasjonsenhet) {
    this.organisasjonsenhet = organisasjonsenhet;
  }
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Studieprogram studieprogram = (Studieprogram) o;
    return Objects.equals(this.id, studieprogram.id) &&
        Objects.equals(this.navn, studieprogram.navn) &&
        Objects.equals(this.utgatt, studieprogram.utgatt) &&
        Objects.equals(this.studieniva, studieprogram.studieniva) &&
        Objects.equals(this.organisasjonsenhet, studieprogram.organisasjonsenhet);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(id, navn, utgatt, studieniva, organisasjonsenhet);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Studieprogram {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    navn: ").append(toIndentedString(navn)).append("\n");
    sb.append("    utgatt: ").append(toIndentedString(utgatt)).append("\n");
    sb.append("    studieniva: ").append(toIndentedString(studieniva)).append("\n");
    sb.append("    organisasjonsenhet: ").append(toIndentedString(organisasjonsenhet)).append("\n");
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
