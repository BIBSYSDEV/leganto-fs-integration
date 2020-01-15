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
import no.bibsys.fs.model.SprakFelter;

/**
 * SvarStatusInfo
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2019-04-25T14:26:52.663+02:00[Europe/Paris]")public class SvarStatusInfo {

  @JsonProperty("kode")

  private String kode = null;

  @JsonProperty("navn")

  private SprakFelter navn = null;

  @JsonProperty("felles")

  private Boolean felles = null;

  @JsonProperty("nasjonalOpptaksmodell")

  private Boolean nasjonalOpptaksmodell = null;
  public SvarStatusInfo kode(String kode) {
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
  public SvarStatusInfo navn(SprakFelter navn) {
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
  public SvarStatusInfo felles(Boolean felles) {
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
  public SvarStatusInfo nasjonalOpptaksmodell(Boolean nasjonalOpptaksmodell) {
    this.nasjonalOpptaksmodell = nasjonalOpptaksmodell;
    return this;
  }

  

  /**
  * Get nasjonalOpptaksmodell
  * @return nasjonalOpptaksmodell
  **/
  @Schema(description = "")
  public Boolean isNasjonalOpptaksmodell() {
    return nasjonalOpptaksmodell;
  }
  public void setNasjonalOpptaksmodell(Boolean nasjonalOpptaksmodell) {
    this.nasjonalOpptaksmodell = nasjonalOpptaksmodell;
  }
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SvarStatusInfo svarStatusInfo = (SvarStatusInfo) o;
    return Objects.equals(this.kode, svarStatusInfo.kode) &&
        Objects.equals(this.navn, svarStatusInfo.navn) &&
        Objects.equals(this.felles, svarStatusInfo.felles) &&
        Objects.equals(this.nasjonalOpptaksmodell, svarStatusInfo.nasjonalOpptaksmodell);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(kode, navn, felles, nasjonalOpptaksmodell);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SvarStatusInfo {\n");
    
    sb.append("    kode: ").append(toIndentedString(kode)).append("\n");
    sb.append("    navn: ").append(toIndentedString(navn)).append("\n");
    sb.append("    felles: ").append(toIndentedString(felles)).append("\n");
    sb.append("    nasjonalOpptaksmodell: ").append(toIndentedString(nasjonalOpptaksmodell)).append("\n");
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
