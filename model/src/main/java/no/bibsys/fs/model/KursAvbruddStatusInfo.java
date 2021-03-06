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
 * KursAvbruddStatusInfo
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2019-04-25T14:26:52.663+02:00[Europe/Paris]")public class KursAvbruddStatusInfo {

  @JsonProperty("kode")

  private String kode = null;

  @JsonProperty("navn")

  private String navn = null;

  @JsonProperty("felles")

  private Boolean felles = null;

  @JsonProperty("rapporteres")

  private Boolean rapporteres = null;

  @JsonProperty("terminerStudierett")

  private Boolean terminerStudierett = null;

  @JsonProperty("fakturer")

  private Boolean fakturer = null;
  public KursAvbruddStatusInfo kode(String kode) {
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
  public KursAvbruddStatusInfo navn(String navn) {
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
  public KursAvbruddStatusInfo felles(Boolean felles) {
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
  public KursAvbruddStatusInfo rapporteres(Boolean rapporteres) {
    this.rapporteres = rapporteres;
    return this;
  }

  

  /**
  * Get rapporteres
  * @return rapporteres
  **/
  @Schema(description = "")
  public Boolean isRapporteres() {
    return rapporteres;
  }
  public void setRapporteres(Boolean rapporteres) {
    this.rapporteres = rapporteres;
  }
  public KursAvbruddStatusInfo terminerStudierett(Boolean terminerStudierett) {
    this.terminerStudierett = terminerStudierett;
    return this;
  }

  

  /**
  * Get terminerStudierett
  * @return terminerStudierett
  **/
  @Schema(description = "")
  public Boolean isTerminerStudierett() {
    return terminerStudierett;
  }
  public void setTerminerStudierett(Boolean terminerStudierett) {
    this.terminerStudierett = terminerStudierett;
  }
  public KursAvbruddStatusInfo fakturer(Boolean fakturer) {
    this.fakturer = fakturer;
    return this;
  }

  

  /**
  * Get fakturer
  * @return fakturer
  **/
  @Schema(description = "")
  public Boolean isFakturer() {
    return fakturer;
  }
  public void setFakturer(Boolean fakturer) {
    this.fakturer = fakturer;
  }
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    KursAvbruddStatusInfo kursAvbruddStatusInfo = (KursAvbruddStatusInfo) o;
    return Objects.equals(this.kode, kursAvbruddStatusInfo.kode) &&
        Objects.equals(this.navn, kursAvbruddStatusInfo.navn) &&
        Objects.equals(this.felles, kursAvbruddStatusInfo.felles) &&
        Objects.equals(this.rapporteres, kursAvbruddStatusInfo.rapporteres) &&
        Objects.equals(this.terminerStudierett, kursAvbruddStatusInfo.terminerStudierett) &&
        Objects.equals(this.fakturer, kursAvbruddStatusInfo.fakturer);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(kode, navn, felles, rapporteres, terminerStudierett, fakturer);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class KursAvbruddStatusInfo {\n");
    
    sb.append("    kode: ").append(toIndentedString(kode)).append("\n");
    sb.append("    navn: ").append(toIndentedString(navn)).append("\n");
    sb.append("    felles: ").append(toIndentedString(felles)).append("\n");
    sb.append("    rapporteres: ").append(toIndentedString(rapporteres)).append("\n");
    sb.append("    terminerStudierett: ").append(toIndentedString(terminerStudierett)).append("\n");
    sb.append("    fakturer: ").append(toIndentedString(fakturer)).append("\n");
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
