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
import java.math.BigDecimal;
import no.bibsys.fs.model.BetalingsFormInfo;
import no.bibsys.fs.model.Id2;
import no.bibsys.fs.model.Links;
import no.bibsys.fs.model.Links2;
import no.bibsys.fs.model.NormalProgStatInfo;
import no.bibsys.fs.model.RegFormInfo;
import no.bibsys.fs.model.SemesterRegistreringId;
import no.bibsys.fs.model.StudentkategoriInfo;
import no.bibsys.fs.model.Studentkort;
import no.bibsys.fs.model.StudiemalInfo;
import no.bibsys.fs.model.StudieoppleggInfo;
import no.bibsys.fs.model.UndTilhorighetInfo;
import org.threeten.bp.LocalDate;

/**
 * SemesterRegistrering
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2019-04-25T14:26:52.663+02:00[Europe/Paris]")public class SemesterRegistrering {

  @JsonProperty("id")

  private SemesterRegistreringId id = null;

  @JsonProperty("studieprogram")

  private Id2 studieprogram = null;

  @JsonProperty("kull")

  private Id2 kull = null;

  @JsonProperty("kullklasse")

  private Id2 kullklasse = null;

  @JsonProperty("semestre")

  private Links2 semestre = null;

  @JsonProperty("organisasjonsenheter")

  private Links organisasjonsenheter = null;

  @JsonProperty("campus")

  private Id2 campus = null;

  @JsonProperty("fag")

  private Id2 fag = null;

  @JsonProperty("studiemaal")

  private StudiemalInfo studiemaal = null;

  @JsonProperty("studentkort")

  private Studentkort studentkort = null;

  @JsonProperty("studieopplegg")

  private StudieoppleggInfo studieopplegg = null;

  @JsonProperty("registreringsform")

  private RegFormInfo registreringsform = null;

  @JsonProperty("betalingsform")

  private BetalingsFormInfo betalingsform = null;

  @JsonProperty("studentkategori")

  private StudentkategoriInfo studentkategori = null;

  @JsonProperty("undervisningstilhorighet")

  private UndTilhorighetInfo undervisningstilhorighet = null;

  @JsonProperty("normalprogresjonStatus")

  private NormalProgStatInfo normalprogresjonStatus = null;

  @JsonProperty("funksjonshemming")

  private Boolean funksjonshemming = null;

  @JsonProperty("eksamenDetteSemester")

  private Boolean eksamenDetteSemester = null;

  @JsonProperty("eksamenNesteSemester")

  private Boolean eksamenNesteSemester = null;

  @JsonProperty("kvitteringSkrevet")

  private Boolean kvitteringSkrevet = null;

  @JsonProperty("betalingOk")

  private Boolean betalingOk = null;

  @JsonProperty("registreringOk")

  private Boolean registreringOk = null;

  @JsonProperty("ugyldig")

  private Boolean ugyldig = null;

  @JsonProperty("belopBetalt")

  private BigDecimal belopBetalt = null;

  @JsonProperty("datoRefundert")

  private LocalDate datoRefundert = null;

  @JsonProperty("datoBetalt")

  private LocalDate datoBetalt = null;

  @JsonProperty("datoRegistreringsformEndret")

  private LocalDate datoRegistreringsformEndret = null;

  @JsonProperty("datoInnkalt")

  private LocalDate datoInnkalt = null;

  @JsonProperty("datoKvittering")

  private LocalDate datoKvittering = null;

  @JsonProperty("annetStudiemaal")

  private String annetStudiemaal = null;

  @JsonProperty("transaksjonsIdSemesterkort")

  private Integer transaksjonsIdSemesterkort = null;
  public SemesterRegistrering id(SemesterRegistreringId id) {
    this.id = id;
    return this;
  }

  

  /**
  * Get id
  * @return id
  **/
  @Schema(description = "")
  public SemesterRegistreringId getId() {
    return id;
  }
  public void setId(SemesterRegistreringId id) {
    this.id = id;
  }
  public SemesterRegistrering studieprogram(Id2 studieprogram) {
    this.studieprogram = studieprogram;
    return this;
  }

  

  /**
  * Get studieprogram
  * @return studieprogram
  **/
  @Schema(description = "")
  public Id2 getStudieprogram() {
    return studieprogram;
  }
  public void setStudieprogram(Id2 studieprogram) {
    this.studieprogram = studieprogram;
  }
  public SemesterRegistrering kull(Id2 kull) {
    this.kull = kull;
    return this;
  }

  

  /**
  * Get kull
  * @return kull
  **/
  @Schema(description = "")
  public Id2 getKull() {
    return kull;
  }
  public void setKull(Id2 kull) {
    this.kull = kull;
  }
  public SemesterRegistrering kullklasse(Id2 kullklasse) {
    this.kullklasse = kullklasse;
    return this;
  }

  

  /**
  * Get kullklasse
  * @return kullklasse
  **/
  @Schema(description = "")
  public Id2 getKullklasse() {
    return kullklasse;
  }
  public void setKullklasse(Id2 kullklasse) {
    this.kullklasse = kullklasse;
  }
  public SemesterRegistrering semestre(Links2 semestre) {
    this.semestre = semestre;
    return this;
  }

  

  /**
  * Get semestre
  * @return semestre
  **/
  @Schema(description = "")
  public Links2 getSemestre() {
    return semestre;
  }
  public void setSemestre(Links2 semestre) {
    this.semestre = semestre;
  }
  public SemesterRegistrering organisasjonsenheter(Links organisasjonsenheter) {
    this.organisasjonsenheter = organisasjonsenheter;
    return this;
  }

  

  /**
  * Get organisasjonsenheter
  * @return organisasjonsenheter
  **/
  @Schema(description = "")
  public Links getOrganisasjonsenheter() {
    return organisasjonsenheter;
  }
  public void setOrganisasjonsenheter(Links organisasjonsenheter) {
    this.organisasjonsenheter = organisasjonsenheter;
  }
  public SemesterRegistrering campus(Id2 campus) {
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
  public SemesterRegistrering fag(Id2 fag) {
    this.fag = fag;
    return this;
  }

  

  /**
  * Get fag
  * @return fag
  **/
  @Schema(description = "")
  public Id2 getFag() {
    return fag;
  }
  public void setFag(Id2 fag) {
    this.fag = fag;
  }
  public SemesterRegistrering studiemaal(StudiemalInfo studiemaal) {
    this.studiemaal = studiemaal;
    return this;
  }

  

  /**
  * Get studiemaal
  * @return studiemaal
  **/
  @Schema(description = "")
  public StudiemalInfo getStudiemaal() {
    return studiemaal;
  }
  public void setStudiemaal(StudiemalInfo studiemaal) {
    this.studiemaal = studiemaal;
  }
  public SemesterRegistrering studentkort(Studentkort studentkort) {
    this.studentkort = studentkort;
    return this;
  }

  

  /**
  * Get studentkort
  * @return studentkort
  **/
  @Schema(description = "")
  public Studentkort getStudentkort() {
    return studentkort;
  }
  public void setStudentkort(Studentkort studentkort) {
    this.studentkort = studentkort;
  }
  public SemesterRegistrering studieopplegg(StudieoppleggInfo studieopplegg) {
    this.studieopplegg = studieopplegg;
    return this;
  }

  

  /**
  * Get studieopplegg
  * @return studieopplegg
  **/
  @Schema(description = "")
  public StudieoppleggInfo getStudieopplegg() {
    return studieopplegg;
  }
  public void setStudieopplegg(StudieoppleggInfo studieopplegg) {
    this.studieopplegg = studieopplegg;
  }
  public SemesterRegistrering registreringsform(RegFormInfo registreringsform) {
    this.registreringsform = registreringsform;
    return this;
  }

  

  /**
  * Get registreringsform
  * @return registreringsform
  **/
  @Schema(description = "")
  public RegFormInfo getRegistreringsform() {
    return registreringsform;
  }
  public void setRegistreringsform(RegFormInfo registreringsform) {
    this.registreringsform = registreringsform;
  }
  public SemesterRegistrering betalingsform(BetalingsFormInfo betalingsform) {
    this.betalingsform = betalingsform;
    return this;
  }

  

  /**
  * Get betalingsform
  * @return betalingsform
  **/
  @Schema(description = "")
  public BetalingsFormInfo getBetalingsform() {
    return betalingsform;
  }
  public void setBetalingsform(BetalingsFormInfo betalingsform) {
    this.betalingsform = betalingsform;
  }
  public SemesterRegistrering studentkategori(StudentkategoriInfo studentkategori) {
    this.studentkategori = studentkategori;
    return this;
  }

  

  /**
  * Get studentkategori
  * @return studentkategori
  **/
  @Schema(description = "")
  public StudentkategoriInfo getStudentkategori() {
    return studentkategori;
  }
  public void setStudentkategori(StudentkategoriInfo studentkategori) {
    this.studentkategori = studentkategori;
  }
  public SemesterRegistrering undervisningstilhorighet(UndTilhorighetInfo undervisningstilhorighet) {
    this.undervisningstilhorighet = undervisningstilhorighet;
    return this;
  }

  

  /**
  * Get undervisningstilhorighet
  * @return undervisningstilhorighet
  **/
  @Schema(description = "")
  public UndTilhorighetInfo getUndervisningstilhorighet() {
    return undervisningstilhorighet;
  }
  public void setUndervisningstilhorighet(UndTilhorighetInfo undervisningstilhorighet) {
    this.undervisningstilhorighet = undervisningstilhorighet;
  }
  public SemesterRegistrering normalprogresjonStatus(NormalProgStatInfo normalprogresjonStatus) {
    this.normalprogresjonStatus = normalprogresjonStatus;
    return this;
  }

  

  /**
  * Get normalprogresjonStatus
  * @return normalprogresjonStatus
  **/
  @Schema(description = "")
  public NormalProgStatInfo getNormalprogresjonStatus() {
    return normalprogresjonStatus;
  }
  public void setNormalprogresjonStatus(NormalProgStatInfo normalprogresjonStatus) {
    this.normalprogresjonStatus = normalprogresjonStatus;
  }
  public SemesterRegistrering funksjonshemming(Boolean funksjonshemming) {
    this.funksjonshemming = funksjonshemming;
    return this;
  }

  

  /**
  * Get funksjonshemming
  * @return funksjonshemming
  **/
  @Schema(description = "")
  public Boolean isFunksjonshemming() {
    return funksjonshemming;
  }
  public void setFunksjonshemming(Boolean funksjonshemming) {
    this.funksjonshemming = funksjonshemming;
  }
  public SemesterRegistrering eksamenDetteSemester(Boolean eksamenDetteSemester) {
    this.eksamenDetteSemester = eksamenDetteSemester;
    return this;
  }

  

  /**
  * Get eksamenDetteSemester
  * @return eksamenDetteSemester
  **/
  @Schema(description = "")
  public Boolean isEksamenDetteSemester() {
    return eksamenDetteSemester;
  }
  public void setEksamenDetteSemester(Boolean eksamenDetteSemester) {
    this.eksamenDetteSemester = eksamenDetteSemester;
  }
  public SemesterRegistrering eksamenNesteSemester(Boolean eksamenNesteSemester) {
    this.eksamenNesteSemester = eksamenNesteSemester;
    return this;
  }

  

  /**
  * Get eksamenNesteSemester
  * @return eksamenNesteSemester
  **/
  @Schema(description = "")
  public Boolean isEksamenNesteSemester() {
    return eksamenNesteSemester;
  }
  public void setEksamenNesteSemester(Boolean eksamenNesteSemester) {
    this.eksamenNesteSemester = eksamenNesteSemester;
  }
  public SemesterRegistrering kvitteringSkrevet(Boolean kvitteringSkrevet) {
    this.kvitteringSkrevet = kvitteringSkrevet;
    return this;
  }

  

  /**
  * Get kvitteringSkrevet
  * @return kvitteringSkrevet
  **/
  @Schema(description = "")
  public Boolean isKvitteringSkrevet() {
    return kvitteringSkrevet;
  }
  public void setKvitteringSkrevet(Boolean kvitteringSkrevet) {
    this.kvitteringSkrevet = kvitteringSkrevet;
  }
  public SemesterRegistrering betalingOk(Boolean betalingOk) {
    this.betalingOk = betalingOk;
    return this;
  }

  

  /**
  * Get betalingOk
  * @return betalingOk
  **/
  @Schema(description = "")
  public Boolean isBetalingOk() {
    return betalingOk;
  }
  public void setBetalingOk(Boolean betalingOk) {
    this.betalingOk = betalingOk;
  }
  public SemesterRegistrering registreringOk(Boolean registreringOk) {
    this.registreringOk = registreringOk;
    return this;
  }

  

  /**
  * Get registreringOk
  * @return registreringOk
  **/
  @Schema(description = "")
  public Boolean isRegistreringOk() {
    return registreringOk;
  }
  public void setRegistreringOk(Boolean registreringOk) {
    this.registreringOk = registreringOk;
  }
  public SemesterRegistrering ugyldig(Boolean ugyldig) {
    this.ugyldig = ugyldig;
    return this;
  }

  

  /**
  * Get ugyldig
  * @return ugyldig
  **/
  @Schema(description = "")
  public Boolean isUgyldig() {
    return ugyldig;
  }
  public void setUgyldig(Boolean ugyldig) {
    this.ugyldig = ugyldig;
  }
  public SemesterRegistrering belopBetalt(BigDecimal belopBetalt) {
    this.belopBetalt = belopBetalt;
    return this;
  }

  

  /**
  * Get belopBetalt
  * @return belopBetalt
  **/
  @Schema(description = "")
  public BigDecimal getBelopBetalt() {
    return belopBetalt;
  }
  public void setBelopBetalt(BigDecimal belopBetalt) {
    this.belopBetalt = belopBetalt;
  }
  public SemesterRegistrering datoRefundert(LocalDate datoRefundert) {
    this.datoRefundert = datoRefundert;
    return this;
  }

  

  /**
  * Get datoRefundert
  * @return datoRefundert
  **/
  @Schema(description = "")
  public LocalDate getDatoRefundert() {
    return datoRefundert;
  }
  public void setDatoRefundert(LocalDate datoRefundert) {
    this.datoRefundert = datoRefundert;
  }
  public SemesterRegistrering datoBetalt(LocalDate datoBetalt) {
    this.datoBetalt = datoBetalt;
    return this;
  }

  

  /**
  * Get datoBetalt
  * @return datoBetalt
  **/
  @Schema(description = "")
  public LocalDate getDatoBetalt() {
    return datoBetalt;
  }
  public void setDatoBetalt(LocalDate datoBetalt) {
    this.datoBetalt = datoBetalt;
  }
  public SemesterRegistrering datoRegistreringsformEndret(LocalDate datoRegistreringsformEndret) {
    this.datoRegistreringsformEndret = datoRegistreringsformEndret;
    return this;
  }

  

  /**
  * Get datoRegistreringsformEndret
  * @return datoRegistreringsformEndret
  **/
  @Schema(description = "")
  public LocalDate getDatoRegistreringsformEndret() {
    return datoRegistreringsformEndret;
  }
  public void setDatoRegistreringsformEndret(LocalDate datoRegistreringsformEndret) {
    this.datoRegistreringsformEndret = datoRegistreringsformEndret;
  }
  public SemesterRegistrering datoInnkalt(LocalDate datoInnkalt) {
    this.datoInnkalt = datoInnkalt;
    return this;
  }

  

  /**
  * Get datoInnkalt
  * @return datoInnkalt
  **/
  @Schema(description = "")
  public LocalDate getDatoInnkalt() {
    return datoInnkalt;
  }
  public void setDatoInnkalt(LocalDate datoInnkalt) {
    this.datoInnkalt = datoInnkalt;
  }
  public SemesterRegistrering datoKvittering(LocalDate datoKvittering) {
    this.datoKvittering = datoKvittering;
    return this;
  }

  

  /**
  * Get datoKvittering
  * @return datoKvittering
  **/
  @Schema(description = "")
  public LocalDate getDatoKvittering() {
    return datoKvittering;
  }
  public void setDatoKvittering(LocalDate datoKvittering) {
    this.datoKvittering = datoKvittering;
  }
  public SemesterRegistrering annetStudiemaal(String annetStudiemaal) {
    this.annetStudiemaal = annetStudiemaal;
    return this;
  }

  

  /**
  * Get annetStudiemaal
  * @return annetStudiemaal
  **/
  @Schema(description = "")
  public String getAnnetStudiemaal() {
    return annetStudiemaal;
  }
  public void setAnnetStudiemaal(String annetStudiemaal) {
    this.annetStudiemaal = annetStudiemaal;
  }
  public SemesterRegistrering transaksjonsIdSemesterkort(Integer transaksjonsIdSemesterkort) {
    this.transaksjonsIdSemesterkort = transaksjonsIdSemesterkort;
    return this;
  }

  

  /**
  * Get transaksjonsIdSemesterkort
  * @return transaksjonsIdSemesterkort
  **/
  @Schema(description = "")
  public Integer getTransaksjonsIdSemesterkort() {
    return transaksjonsIdSemesterkort;
  }
  public void setTransaksjonsIdSemesterkort(Integer transaksjonsIdSemesterkort) {
    this.transaksjonsIdSemesterkort = transaksjonsIdSemesterkort;
  }
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SemesterRegistrering semesterRegistrering = (SemesterRegistrering) o;
    return Objects.equals(this.id, semesterRegistrering.id) &&
        Objects.equals(this.studieprogram, semesterRegistrering.studieprogram) &&
        Objects.equals(this.kull, semesterRegistrering.kull) &&
        Objects.equals(this.kullklasse, semesterRegistrering.kullklasse) &&
        Objects.equals(this.semestre, semesterRegistrering.semestre) &&
        Objects.equals(this.organisasjonsenheter, semesterRegistrering.organisasjonsenheter) &&
        Objects.equals(this.campus, semesterRegistrering.campus) &&
        Objects.equals(this.fag, semesterRegistrering.fag) &&
        Objects.equals(this.studiemaal, semesterRegistrering.studiemaal) &&
        Objects.equals(this.studentkort, semesterRegistrering.studentkort) &&
        Objects.equals(this.studieopplegg, semesterRegistrering.studieopplegg) &&
        Objects.equals(this.registreringsform, semesterRegistrering.registreringsform) &&
        Objects.equals(this.betalingsform, semesterRegistrering.betalingsform) &&
        Objects.equals(this.studentkategori, semesterRegistrering.studentkategori) &&
        Objects.equals(this.undervisningstilhorighet, semesterRegistrering.undervisningstilhorighet) &&
        Objects.equals(this.normalprogresjonStatus, semesterRegistrering.normalprogresjonStatus) &&
        Objects.equals(this.funksjonshemming, semesterRegistrering.funksjonshemming) &&
        Objects.equals(this.eksamenDetteSemester, semesterRegistrering.eksamenDetteSemester) &&
        Objects.equals(this.eksamenNesteSemester, semesterRegistrering.eksamenNesteSemester) &&
        Objects.equals(this.kvitteringSkrevet, semesterRegistrering.kvitteringSkrevet) &&
        Objects.equals(this.betalingOk, semesterRegistrering.betalingOk) &&
        Objects.equals(this.registreringOk, semesterRegistrering.registreringOk) &&
        Objects.equals(this.ugyldig, semesterRegistrering.ugyldig) &&
        Objects.equals(this.belopBetalt, semesterRegistrering.belopBetalt) &&
        Objects.equals(this.datoRefundert, semesterRegistrering.datoRefundert) &&
        Objects.equals(this.datoBetalt, semesterRegistrering.datoBetalt) &&
        Objects.equals(this.datoRegistreringsformEndret, semesterRegistrering.datoRegistreringsformEndret) &&
        Objects.equals(this.datoInnkalt, semesterRegistrering.datoInnkalt) &&
        Objects.equals(this.datoKvittering, semesterRegistrering.datoKvittering) &&
        Objects.equals(this.annetStudiemaal, semesterRegistrering.annetStudiemaal) &&
        Objects.equals(this.transaksjonsIdSemesterkort, semesterRegistrering.transaksjonsIdSemesterkort);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(id, studieprogram, kull, kullklasse, semestre, organisasjonsenheter, campus, fag, studiemaal, studentkort, studieopplegg, registreringsform, betalingsform, studentkategori, undervisningstilhorighet, normalprogresjonStatus, funksjonshemming, eksamenDetteSemester, eksamenNesteSemester, kvitteringSkrevet, betalingOk, registreringOk, ugyldig, belopBetalt, datoRefundert, datoBetalt, datoRegistreringsformEndret, datoInnkalt, datoKvittering, annetStudiemaal, transaksjonsIdSemesterkort);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SemesterRegistrering {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    studieprogram: ").append(toIndentedString(studieprogram)).append("\n");
    sb.append("    kull: ").append(toIndentedString(kull)).append("\n");
    sb.append("    kullklasse: ").append(toIndentedString(kullklasse)).append("\n");
    sb.append("    semestre: ").append(toIndentedString(semestre)).append("\n");
    sb.append("    organisasjonsenheter: ").append(toIndentedString(organisasjonsenheter)).append("\n");
    sb.append("    campus: ").append(toIndentedString(campus)).append("\n");
    sb.append("    fag: ").append(toIndentedString(fag)).append("\n");
    sb.append("    studiemaal: ").append(toIndentedString(studiemaal)).append("\n");
    sb.append("    studentkort: ").append(toIndentedString(studentkort)).append("\n");
    sb.append("    studieopplegg: ").append(toIndentedString(studieopplegg)).append("\n");
    sb.append("    registreringsform: ").append(toIndentedString(registreringsform)).append("\n");
    sb.append("    betalingsform: ").append(toIndentedString(betalingsform)).append("\n");
    sb.append("    studentkategori: ").append(toIndentedString(studentkategori)).append("\n");
    sb.append("    undervisningstilhorighet: ").append(toIndentedString(undervisningstilhorighet)).append("\n");
    sb.append("    normalprogresjonStatus: ").append(toIndentedString(normalprogresjonStatus)).append("\n");
    sb.append("    funksjonshemming: ").append(toIndentedString(funksjonshemming)).append("\n");
    sb.append("    eksamenDetteSemester: ").append(toIndentedString(eksamenDetteSemester)).append("\n");
    sb.append("    eksamenNesteSemester: ").append(toIndentedString(eksamenNesteSemester)).append("\n");
    sb.append("    kvitteringSkrevet: ").append(toIndentedString(kvitteringSkrevet)).append("\n");
    sb.append("    betalingOk: ").append(toIndentedString(betalingOk)).append("\n");
    sb.append("    registreringOk: ").append(toIndentedString(registreringOk)).append("\n");
    sb.append("    ugyldig: ").append(toIndentedString(ugyldig)).append("\n");
    sb.append("    belopBetalt: ").append(toIndentedString(belopBetalt)).append("\n");
    sb.append("    datoRefundert: ").append(toIndentedString(datoRefundert)).append("\n");
    sb.append("    datoBetalt: ").append(toIndentedString(datoBetalt)).append("\n");
    sb.append("    datoRegistreringsformEndret: ").append(toIndentedString(datoRegistreringsformEndret)).append("\n");
    sb.append("    datoInnkalt: ").append(toIndentedString(datoInnkalt)).append("\n");
    sb.append("    datoKvittering: ").append(toIndentedString(datoKvittering)).append("\n");
    sb.append("    annetStudiemaal: ").append(toIndentedString(annetStudiemaal)).append("\n");
    sb.append("    transaksjonsIdSemesterkort: ").append(toIndentedString(transaksjonsIdSemesterkort)).append("\n");
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