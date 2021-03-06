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
import no.bibsys.fs.model.KullklasserId;
import no.bibsys.fs.model.LmsInfo;

/**
 * Kullklasser
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2019-04-25T14:26:52.663+02:00[Europe/Paris]")public class Kullklasser {

  @JsonProperty("id")

  private KullklasserId id = null;

  @JsonProperty("navn")

  private String navn = null;

  @JsonProperty("studieretning")

  private Id2 studieretning = null;

  @JsonProperty("organisasjonsenhet")

  private Id organisasjonsenhet = null;

  @JsonProperty("campus")

  private Id2 campus = null;

  @JsonProperty("aktiv")

  private Boolean aktiv = null;

  @JsonProperty("lms")

  private LmsInfo lms = null;
  public Kullklasser id(KullklasserId id) {
    this.id = id;
    return this;
  }

  

  /**
  * Get id
  * @return id
  **/
  @Schema(description = "")
  public KullklasserId getId() {
    return id;
  }
  public void setId(KullklasserId id) {
    this.id = id;
  }
  public Kullklasser navn(String navn) {
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
  public Kullklasser studieretning(Id2 studieretning) {
    this.studieretning = studieretning;
    return this;
  }

  

  /**
  * Get studieretning
  * @return studieretning
  **/
  @Schema(description = "")
  public Id2 getStudieretning() {
    return studieretning;
  }
  public void setStudieretning(Id2 studieretning) {
    this.studieretning = studieretning;
  }
  public Kullklasser organisasjonsenhet(Id organisasjonsenhet) {
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
  public Kullklasser campus(Id2 campus) {
    this.campus = campus;
    return this;
  }

  

  /**
  * Get campus
  * @return campus
  **/
  @Schema(description = "")
  public Id2 getCampus() {
    return campus;
  }
  public void setCampus(Id2 campus) {
    this.campus = campus;
  }
  public Kullklasser aktiv(Boolean aktiv) {
    this.aktiv = aktiv;
    return this;
  }

  

  /**
  * Get aktiv
  * @return aktiv
  **/
  @Schema(description = "")
  public Boolean isAktiv() {
    return aktiv;
  }
  public void setAktiv(Boolean aktiv) {
    this.aktiv = aktiv;
  }
  public Kullklasser lms(LmsInfo lms) {
    this.lms = lms;
    return this;
  }

  

  /**
  * Get lms
  * @return lms
  **/
  @Schema(description = "")
  public LmsInfo getLms() {
    return lms;
  }
  public void setLms(LmsInfo lms) {
    this.lms = lms;
  }
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Kullklasser kullklasser = (Kullklasser) o;
    return Objects.equals(this.id, kullklasser.id) &&
        Objects.equals(this.navn, kullklasser.navn) &&
        Objects.equals(this.studieretning, kullklasser.studieretning) &&
        Objects.equals(this.organisasjonsenhet, kullklasser.organisasjonsenhet) &&
        Objects.equals(this.campus, kullklasser.campus) &&
        Objects.equals(this.aktiv, kullklasser.aktiv) &&
        Objects.equals(this.lms, kullklasser.lms);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(id, navn, studieretning, organisasjonsenhet, campus, aktiv, lms);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Kullklasser {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    navn: ").append(toIndentedString(navn)).append("\n");
    sb.append("    studieretning: ").append(toIndentedString(studieretning)).append("\n");
    sb.append("    organisasjonsenhet: ").append(toIndentedString(organisasjonsenhet)).append("\n");
    sb.append("    campus: ").append(toIndentedString(campus)).append("\n");
    sb.append("    aktiv: ").append(toIndentedString(aktiv)).append("\n");
    sb.append("    lms: ").append(toIndentedString(lms)).append("\n");
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
