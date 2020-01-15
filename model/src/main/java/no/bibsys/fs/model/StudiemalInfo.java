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

/**
 * StudiemalInfo
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2019-04-25T14:26:52.663+02:00[Europe/Paris]")public class StudiemalInfo {

  @JsonProperty("nummer")

  private Integer nummer = null;

  @JsonProperty("navn")

  private String navn = null;

  @JsonProperty("kortnavn")

  private String kortnavn = null;

  @JsonProperty("organisasjonsenhet")

  private Id organisasjonsenhet = null;

  @JsonProperty("aktiv")

  private Boolean aktiv = null;

  @JsonProperty("felles")

  private Boolean felles = null;
  public StudiemalInfo nummer(Integer nummer) {
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
  public StudiemalInfo navn(String navn) {
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
  public StudiemalInfo kortnavn(String kortnavn) {
    this.kortnavn = kortnavn;
    return this;
  }

  

  /**
  * Get kortnavn
  * @return kortnavn
  **/
  @Schema(description = "")
  public String getKortnavn() {
    return kortnavn;
  }
  public void setKortnavn(String kortnavn) {
    this.kortnavn = kortnavn;
  }
  public StudiemalInfo organisasjonsenhet(Id organisasjonsenhet) {
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
  public StudiemalInfo aktiv(Boolean aktiv) {
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
  public StudiemalInfo felles(Boolean felles) {
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
    StudiemalInfo studiemalInfo = (StudiemalInfo) o;
    return Objects.equals(this.nummer, studiemalInfo.nummer) &&
        Objects.equals(this.navn, studiemalInfo.navn) &&
        Objects.equals(this.kortnavn, studiemalInfo.kortnavn) &&
        Objects.equals(this.organisasjonsenhet, studiemalInfo.organisasjonsenhet) &&
        Objects.equals(this.aktiv, studiemalInfo.aktiv) &&
        Objects.equals(this.felles, studiemalInfo.felles);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(nummer, navn, kortnavn, organisasjonsenhet, aktiv, felles);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StudiemalInfo {\n");
    
    sb.append("    nummer: ").append(toIndentedString(nummer)).append("\n");
    sb.append("    navn: ").append(toIndentedString(navn)).append("\n");
    sb.append("    kortnavn: ").append(toIndentedString(kortnavn)).append("\n");
    sb.append("    organisasjonsenhet: ").append(toIndentedString(organisasjonsenhet)).append("\n");
    sb.append("    aktiv: ").append(toIndentedString(aktiv)).append("\n");
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