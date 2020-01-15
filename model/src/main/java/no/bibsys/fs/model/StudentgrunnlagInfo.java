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
 * StudentgrunnlagInfo
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2019-04-25T14:26:52.663+02:00[Europe/Paris]")public class StudentgrunnlagInfo {

  @JsonProperty("kode")

  private String kode = null;

  @JsonProperty("navn")

  private String navn = null;

  @JsonProperty("aktiv")

  private Boolean aktiv = null;

  @JsonProperty("girGrad")

  private Boolean girGrad = null;

  @JsonProperty("semesteravgiftsFritak")

  private Boolean semesteravgiftsFritak = null;

  @JsonProperty("kanBenytteStudentWeb")

  private Boolean kanBenytteStudentWeb = null;

  @JsonProperty("skalHaStudentkort")

  private Boolean skalHaStudentkort = null;

  @JsonProperty("skalHaKarakterutskrift")

  private Boolean skalHaKarakterutskrift = null;

  @JsonProperty("rapporteresLanekassen")

  private Boolean rapporteresLanekassen = null;

  @JsonProperty("felles")

  private Boolean felles = null;
  public StudentgrunnlagInfo kode(String kode) {
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
  public StudentgrunnlagInfo navn(String navn) {
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
  public StudentgrunnlagInfo aktiv(Boolean aktiv) {
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
  public StudentgrunnlagInfo girGrad(Boolean girGrad) {
    this.girGrad = girGrad;
    return this;
  }

  

  /**
  * Get girGrad
  * @return girGrad
  **/
  @Schema(description = "")
  public Boolean isGirGrad() {
    return girGrad;
  }
  public void setGirGrad(Boolean girGrad) {
    this.girGrad = girGrad;
  }
  public StudentgrunnlagInfo semesteravgiftsFritak(Boolean semesteravgiftsFritak) {
    this.semesteravgiftsFritak = semesteravgiftsFritak;
    return this;
  }

  

  /**
  * Get semesteravgiftsFritak
  * @return semesteravgiftsFritak
  **/
  @Schema(description = "")
  public Boolean isSemesteravgiftsFritak() {
    return semesteravgiftsFritak;
  }
  public void setSemesteravgiftsFritak(Boolean semesteravgiftsFritak) {
    this.semesteravgiftsFritak = semesteravgiftsFritak;
  }
  public StudentgrunnlagInfo kanBenytteStudentWeb(Boolean kanBenytteStudentWeb) {
    this.kanBenytteStudentWeb = kanBenytteStudentWeb;
    return this;
  }

  

  /**
  * Get kanBenytteStudentWeb
  * @return kanBenytteStudentWeb
  **/
  @Schema(description = "")
  public Boolean isKanBenytteStudentWeb() {
    return kanBenytteStudentWeb;
  }
  public void setKanBenytteStudentWeb(Boolean kanBenytteStudentWeb) {
    this.kanBenytteStudentWeb = kanBenytteStudentWeb;
  }
  public StudentgrunnlagInfo skalHaStudentkort(Boolean skalHaStudentkort) {
    this.skalHaStudentkort = skalHaStudentkort;
    return this;
  }

  

  /**
  * Get skalHaStudentkort
  * @return skalHaStudentkort
  **/
  @Schema(description = "")
  public Boolean isSkalHaStudentkort() {
    return skalHaStudentkort;
  }
  public void setSkalHaStudentkort(Boolean skalHaStudentkort) {
    this.skalHaStudentkort = skalHaStudentkort;
  }
  public StudentgrunnlagInfo skalHaKarakterutskrift(Boolean skalHaKarakterutskrift) {
    this.skalHaKarakterutskrift = skalHaKarakterutskrift;
    return this;
  }

  

  /**
  * Get skalHaKarakterutskrift
  * @return skalHaKarakterutskrift
  **/
  @Schema(description = "")
  public Boolean isSkalHaKarakterutskrift() {
    return skalHaKarakterutskrift;
  }
  public void setSkalHaKarakterutskrift(Boolean skalHaKarakterutskrift) {
    this.skalHaKarakterutskrift = skalHaKarakterutskrift;
  }
  public StudentgrunnlagInfo rapporteresLanekassen(Boolean rapporteresLanekassen) {
    this.rapporteresLanekassen = rapporteresLanekassen;
    return this;
  }

  

  /**
  * Get rapporteresLanekassen
  * @return rapporteresLanekassen
  **/
  @Schema(description = "")
  public Boolean isRapporteresLanekassen() {
    return rapporteresLanekassen;
  }
  public void setRapporteresLanekassen(Boolean rapporteresLanekassen) {
    this.rapporteresLanekassen = rapporteresLanekassen;
  }
  public StudentgrunnlagInfo felles(Boolean felles) {
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
    StudentgrunnlagInfo studentgrunnlagInfo = (StudentgrunnlagInfo) o;
    return Objects.equals(this.kode, studentgrunnlagInfo.kode) &&
        Objects.equals(this.navn, studentgrunnlagInfo.navn) &&
        Objects.equals(this.aktiv, studentgrunnlagInfo.aktiv) &&
        Objects.equals(this.girGrad, studentgrunnlagInfo.girGrad) &&
        Objects.equals(this.semesteravgiftsFritak, studentgrunnlagInfo.semesteravgiftsFritak) &&
        Objects.equals(this.kanBenytteStudentWeb, studentgrunnlagInfo.kanBenytteStudentWeb) &&
        Objects.equals(this.skalHaStudentkort, studentgrunnlagInfo.skalHaStudentkort) &&
        Objects.equals(this.skalHaKarakterutskrift, studentgrunnlagInfo.skalHaKarakterutskrift) &&
        Objects.equals(this.rapporteresLanekassen, studentgrunnlagInfo.rapporteresLanekassen) &&
        Objects.equals(this.felles, studentgrunnlagInfo.felles);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(kode, navn, aktiv, girGrad, semesteravgiftsFritak, kanBenytteStudentWeb, skalHaStudentkort, skalHaKarakterutskrift, rapporteresLanekassen, felles);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StudentgrunnlagInfo {\n");
    
    sb.append("    kode: ").append(toIndentedString(kode)).append("\n");
    sb.append("    navn: ").append(toIndentedString(navn)).append("\n");
    sb.append("    aktiv: ").append(toIndentedString(aktiv)).append("\n");
    sb.append("    girGrad: ").append(toIndentedString(girGrad)).append("\n");
    sb.append("    semesteravgiftsFritak: ").append(toIndentedString(semesteravgiftsFritak)).append("\n");
    sb.append("    kanBenytteStudentWeb: ").append(toIndentedString(kanBenytteStudentWeb)).append("\n");
    sb.append("    skalHaStudentkort: ").append(toIndentedString(skalHaStudentkort)).append("\n");
    sb.append("    skalHaKarakterutskrift: ").append(toIndentedString(skalHaKarakterutskrift)).append("\n");
    sb.append("    rapporteresLanekassen: ").append(toIndentedString(rapporteresLanekassen)).append("\n");
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
