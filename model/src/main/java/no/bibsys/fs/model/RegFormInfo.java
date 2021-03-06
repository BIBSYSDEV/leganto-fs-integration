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
 * RegFormInfo
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2019-04-25T14:26:52.663+02:00[Europe/Paris]")public class RegFormInfo {

  @JsonProperty("kode")

  private String kode = null;

  @JsonProperty("navn")

  private String navn = null;

  @JsonProperty("aktiv")

  private Boolean aktiv = null;

  @JsonProperty("semesterkvittering")

  private Boolean semesterkvittering = null;

  @JsonProperty("felles")

  private Boolean felles = null;
  public RegFormInfo kode(String kode) {
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
  public RegFormInfo navn(String navn) {
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
  public RegFormInfo aktiv(Boolean aktiv) {
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
  public RegFormInfo semesterkvittering(Boolean semesterkvittering) {
    this.semesterkvittering = semesterkvittering;
    return this;
  }

  

  /**
  * Get semesterkvittering
  * @return semesterkvittering
  **/
  @Schema(description = "")
  public Boolean isSemesterkvittering() {
    return semesterkvittering;
  }
  public void setSemesterkvittering(Boolean semesterkvittering) {
    this.semesterkvittering = semesterkvittering;
  }
  public RegFormInfo felles(Boolean felles) {
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
    RegFormInfo regFormInfo = (RegFormInfo) o;
    return Objects.equals(this.kode, regFormInfo.kode) &&
        Objects.equals(this.navn, regFormInfo.navn) &&
        Objects.equals(this.aktiv, regFormInfo.aktiv) &&
        Objects.equals(this.semesterkvittering, regFormInfo.semesterkvittering) &&
        Objects.equals(this.felles, regFormInfo.felles);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(kode, navn, aktiv, semesterkvittering, felles);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RegFormInfo {\n");
    
    sb.append("    kode: ").append(toIndentedString(kode)).append("\n");
    sb.append("    navn: ").append(toIndentedString(navn)).append("\n");
    sb.append("    aktiv: ").append(toIndentedString(aktiv)).append("\n");
    sb.append("    semesterkvittering: ").append(toIndentedString(semesterkvittering)).append("\n");
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
