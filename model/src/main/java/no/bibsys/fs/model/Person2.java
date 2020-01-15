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
import no.bibsys.fs.model.Adresser;
import no.bibsys.fs.model.Epost;
import no.bibsys.fs.model.FagpersonInfo;
import no.bibsys.fs.model.Id2;
import no.bibsys.fs.model.Links;
import no.bibsys.fs.model.Person2Id;
import no.bibsys.fs.model.StudentInfo;
import no.bibsys.fs.model.StudentgrunnlagInfo;
import no.bibsys.fs.model.Telefoner;

/**
 * Person2
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2019-04-25T14:26:52.663+02:00[Europe/Paris]")public class Person2 {

  @JsonProperty("id")

  private Person2Id id = null;

  @JsonProperty("fodselsdato")

  private Integer fodselsdato = null;

  @JsonProperty("personnummer")

  private Integer personnummer = null;

  @JsonProperty("brukernavn")

  private String brukernavn = null;

  @JsonProperty("fornavn")

  private String fornavn = null;

  @JsonProperty("etternavn")

  private String etternavn = null;

  @JsonProperty("kjonn")

  private String kjonn = null;

  @JsonProperty("epost")

  private Epost epost = null;

  @JsonProperty("telefoner")

  private Telefoner telefoner = null;

  @JsonProperty("adresser")

  private Adresser adresser = null;

  @JsonProperty("harBilde")

  private Boolean harBilde = null;

  @JsonProperty("kvalifikasjonsgrunnlag")

  private Id2 kvalifikasjonsgrunnlag = null;

  @JsonProperty("studentgrunnlag")

  private StudentgrunnlagInfo studentgrunnlag = null;

  @JsonProperty("organisasjonsenheter")

  private Links organisasjonsenheter = null;

  @JsonProperty("ansattnummer")

  private String ansattnummer = null;

  @JsonProperty("student")

  private StudentInfo student = null;

  @JsonProperty("fagperson")

  private FagpersonInfo fagperson = null;
  public Person2 id(Person2Id id) {
    this.id = id;
    return this;
  }

  

  /**
  * Get id
  * @return id
  **/
  @Schema(description = "")
  public Person2Id getId() {
    return id;
  }
  public void setId(Person2Id id) {
    this.id = id;
  }
  public Person2 fodselsdato(Integer fodselsdato) {
    this.fodselsdato = fodselsdato;
    return this;
  }

  

  /**
  * Get fodselsdato
  * maximum: 999999
  * @return fodselsdato
  **/
  @Schema(description = "")
  public Integer getFodselsdato() {
    return fodselsdato;
  }
  public void setFodselsdato(Integer fodselsdato) {
    this.fodselsdato = fodselsdato;
  }
  public Person2 personnummer(Integer personnummer) {
    this.personnummer = personnummer;
    return this;
  }

  

  /**
  * Get personnummer
  * maximum: 99999
  * @return personnummer
  **/
  @Schema(description = "")
  public Integer getPersonnummer() {
    return personnummer;
  }
  public void setPersonnummer(Integer personnummer) {
    this.personnummer = personnummer;
  }
  public Person2 brukernavn(String brukernavn) {
    this.brukernavn = brukernavn;
    return this;
  }

  

  /**
  * Get brukernavn
  * @return brukernavn
  **/
  @Schema(description = "")
  public String getBrukernavn() {
    return brukernavn;
  }
  public void setBrukernavn(String brukernavn) {
    this.brukernavn = brukernavn;
  }
  public Person2 fornavn(String fornavn) {
    this.fornavn = fornavn;
    return this;
  }

  

  /**
  * Get fornavn
  * @return fornavn
  **/
  @Schema(description = "")
  public String getFornavn() {
    return fornavn;
  }
  public void setFornavn(String fornavn) {
    this.fornavn = fornavn;
  }
  public Person2 etternavn(String etternavn) {
    this.etternavn = etternavn;
    return this;
  }

  

  /**
  * Get etternavn
  * @return etternavn
  **/
  @Schema(description = "")
  public String getEtternavn() {
    return etternavn;
  }
  public void setEtternavn(String etternavn) {
    this.etternavn = etternavn;
  }
  public Person2 kjonn(String kjonn) {
    this.kjonn = kjonn;
    return this;
  }

  

  /**
  * Kjønnet M/K
  * @return kjonn
  **/
  @Schema(description = "Kjønnet M/K")
  public String getKjonn() {
    return kjonn;
  }
  public void setKjonn(String kjonn) {
    this.kjonn = kjonn;
  }
  public Person2 epost(Epost epost) {
    this.epost = epost;
    return this;
  }

  

  /**
  * Get epost
  * @return epost
  **/
  @Schema(description = "")
  public Epost getEpost() {
    return epost;
  }
  public void setEpost(Epost epost) {
    this.epost = epost;
  }
  public Person2 telefoner(Telefoner telefoner) {
    this.telefoner = telefoner;
    return this;
  }

  

  /**
  * Get telefoner
  * @return telefoner
  **/
  @Schema(description = "")
  public Telefoner getTelefoner() {
    return telefoner;
  }
  public void setTelefoner(Telefoner telefoner) {
    this.telefoner = telefoner;
  }
  public Person2 adresser(Adresser adresser) {
    this.adresser = adresser;
    return this;
  }

  

  /**
  * Get adresser
  * @return adresser
  **/
  @Schema(description = "")
  public Adresser getAdresser() {
    return adresser;
  }
  public void setAdresser(Adresser adresser) {
    this.adresser = adresser;
  }
  public Person2 harBilde(Boolean harBilde) {
    this.harBilde = harBilde;
    return this;
  }

  

  /**
  * om personen har bildet
  * @return harBilde
  **/
  @Schema(description = "om personen har bildet")
  public Boolean isHarBilde() {
    return harBilde;
  }
  public void setHarBilde(Boolean harBilde) {
    this.harBilde = harBilde;
  }
  public Person2 kvalifikasjonsgrunnlag(Id2 kvalifikasjonsgrunnlag) {
    this.kvalifikasjonsgrunnlag = kvalifikasjonsgrunnlag;
    return this;
  }

  

  /**
  * Get kvalifikasjonsgrunnlag
  * @return kvalifikasjonsgrunnlag
  **/
  @Schema(description = "")
  public Id2 getKvalifikasjonsgrunnlag() {
    return kvalifikasjonsgrunnlag;
  }
  public void setKvalifikasjonsgrunnlag(Id2 kvalifikasjonsgrunnlag) {
    this.kvalifikasjonsgrunnlag = kvalifikasjonsgrunnlag;
  }
  public Person2 studentgrunnlag(StudentgrunnlagInfo studentgrunnlag) {
    this.studentgrunnlag = studentgrunnlag;
    return this;
  }

  

  /**
  * Get studentgrunnlag
  * @return studentgrunnlag
  **/
  @Schema(description = "")
  public StudentgrunnlagInfo getStudentgrunnlag() {
    return studentgrunnlag;
  }
  public void setStudentgrunnlag(StudentgrunnlagInfo studentgrunnlag) {
    this.studentgrunnlag = studentgrunnlag;
  }
  public Person2 organisasjonsenheter(Links organisasjonsenheter) {
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
  public Person2 ansattnummer(String ansattnummer) {
    this.ansattnummer = ansattnummer;
    return this;
  }

  

  /**
  * Ansattnummer
  * @return ansattnummer
  **/
  @Schema(description = "Ansattnummer")
  public String getAnsattnummer() {
    return ansattnummer;
  }
  public void setAnsattnummer(String ansattnummer) {
    this.ansattnummer = ansattnummer;
  }
  public Person2 student(StudentInfo student) {
    this.student = student;
    return this;
  }

  

  /**
  * Get student
  * @return student
  **/
  @Schema(description = "")
  public StudentInfo getStudent() {
    return student;
  }
  public void setStudent(StudentInfo student) {
    this.student = student;
  }
  public Person2 fagperson(FagpersonInfo fagperson) {
    this.fagperson = fagperson;
    return this;
  }

  

  /**
  * Get fagperson
  * @return fagperson
  **/
  @Schema(description = "")
  public FagpersonInfo getFagperson() {
    return fagperson;
  }
  public void setFagperson(FagpersonInfo fagperson) {
    this.fagperson = fagperson;
  }
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Person2 person2 = (Person2) o;
    return Objects.equals(this.id, person2.id) &&
        Objects.equals(this.fodselsdato, person2.fodselsdato) &&
        Objects.equals(this.personnummer, person2.personnummer) &&
        Objects.equals(this.brukernavn, person2.brukernavn) &&
        Objects.equals(this.fornavn, person2.fornavn) &&
        Objects.equals(this.etternavn, person2.etternavn) &&
        Objects.equals(this.kjonn, person2.kjonn) &&
        Objects.equals(this.epost, person2.epost) &&
        Objects.equals(this.telefoner, person2.telefoner) &&
        Objects.equals(this.adresser, person2.adresser) &&
        Objects.equals(this.harBilde, person2.harBilde) &&
        Objects.equals(this.kvalifikasjonsgrunnlag, person2.kvalifikasjonsgrunnlag) &&
        Objects.equals(this.studentgrunnlag, person2.studentgrunnlag) &&
        Objects.equals(this.organisasjonsenheter, person2.organisasjonsenheter) &&
        Objects.equals(this.ansattnummer, person2.ansattnummer) &&
        Objects.equals(this.student, person2.student) &&
        Objects.equals(this.fagperson, person2.fagperson);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(id, fodselsdato, personnummer, brukernavn, fornavn, etternavn, kjonn, epost, telefoner, adresser, harBilde, kvalifikasjonsgrunnlag, studentgrunnlag, organisasjonsenheter, ansattnummer, student, fagperson);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Person2 {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    fodselsdato: ").append(toIndentedString(fodselsdato)).append("\n");
    sb.append("    personnummer: ").append(toIndentedString(personnummer)).append("\n");
    sb.append("    brukernavn: ").append(toIndentedString(brukernavn)).append("\n");
    sb.append("    fornavn: ").append(toIndentedString(fornavn)).append("\n");
    sb.append("    etternavn: ").append(toIndentedString(etternavn)).append("\n");
    sb.append("    kjonn: ").append(toIndentedString(kjonn)).append("\n");
    sb.append("    epost: ").append(toIndentedString(epost)).append("\n");
    sb.append("    telefoner: ").append(toIndentedString(telefoner)).append("\n");
    sb.append("    adresser: ").append(toIndentedString(adresser)).append("\n");
    sb.append("    harBilde: ").append(toIndentedString(harBilde)).append("\n");
    sb.append("    kvalifikasjonsgrunnlag: ").append(toIndentedString(kvalifikasjonsgrunnlag)).append("\n");
    sb.append("    studentgrunnlag: ").append(toIndentedString(studentgrunnlag)).append("\n");
    sb.append("    organisasjonsenheter: ").append(toIndentedString(organisasjonsenheter)).append("\n");
    sb.append("    ansattnummer: ").append(toIndentedString(ansattnummer)).append("\n");
    sb.append("    student: ").append(toIndentedString(student)).append("\n");
    sb.append("    fagperson: ").append(toIndentedString(fagperson)).append("\n");
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