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
import no.bibsys.fs.model.StudentInfo;
import no.bibsys.fs.model.Studentgrunnlagkode;
import no.bibsys.fs.model.Telefoner;

/**
 * Person
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2019-04-25T14:26:52.663+02:00[Europe/Paris]")public class Person {

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

  @JsonProperty("epost")

  private Epost epost = null;

  @JsonProperty("telefoner")

  private Telefoner telefoner = null;

  @JsonProperty("adresser")

  private Adresser adresser = null;

  @JsonProperty("kvalifikasjonsgrunnlag")

  private Id2 kvalifikasjonsgrunnlag = null;

  @JsonProperty("studentgrunnlag")

  private Studentgrunnlagkode studentgrunnlag = null;

  @JsonProperty("organisasjonsenheter")

  private Links organisasjonsenheter = null;

  @JsonProperty("ansattnummer")

  private String ansattnummer = null;

  @JsonProperty("student")

  private StudentInfo student = null;

  @JsonProperty("fagperson")

  private FagpersonInfo fagperson = null;
  public Person fodselsdato(Integer fodselsdato) {
    this.fodselsdato = fodselsdato;
    return this;
  }

  

  /**
  * Get fodselsdato
  * maximum: 999999
  * @return fodselsdato
  **/
  @Schema(required = true, description = "")
  public Integer getFodselsdato() {
    return fodselsdato;
  }
  public void setFodselsdato(Integer fodselsdato) {
    this.fodselsdato = fodselsdato;
  }
  public Person personnummer(Integer personnummer) {
    this.personnummer = personnummer;
    return this;
  }

  

  /**
  * Get personnummer
  * maximum: 99999
  * @return personnummer
  **/
  @Schema(required = true, description = "")
  public Integer getPersonnummer() {
    return personnummer;
  }
  public void setPersonnummer(Integer personnummer) {
    this.personnummer = personnummer;
  }
  public Person brukernavn(String brukernavn) {
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
  public Person fornavn(String fornavn) {
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
  public Person etternavn(String etternavn) {
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
  public Person epost(Epost epost) {
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
  public Person telefoner(Telefoner telefoner) {
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
  public Person adresser(Adresser adresser) {
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
  public Person kvalifikasjonsgrunnlag(Id2 kvalifikasjonsgrunnlag) {
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
  public Person studentgrunnlag(Studentgrunnlagkode studentgrunnlag) {
    this.studentgrunnlag = studentgrunnlag;
    return this;
  }

  

  /**
  * Get studentgrunnlag
  * @return studentgrunnlag
  **/
  @Schema(description = "")
  public Studentgrunnlagkode getStudentgrunnlag() {
    return studentgrunnlag;
  }
  public void setStudentgrunnlag(Studentgrunnlagkode studentgrunnlag) {
    this.studentgrunnlag = studentgrunnlag;
  }
  public Person organisasjonsenheter(Links organisasjonsenheter) {
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
  public Person ansattnummer(String ansattnummer) {
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
  public Person student(StudentInfo student) {
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
  public Person fagperson(FagpersonInfo fagperson) {
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
    Person person = (Person) o;
    return Objects.equals(this.fodselsdato, person.fodselsdato) &&
        Objects.equals(this.personnummer, person.personnummer) &&
        Objects.equals(this.brukernavn, person.brukernavn) &&
        Objects.equals(this.fornavn, person.fornavn) &&
        Objects.equals(this.etternavn, person.etternavn) &&
        Objects.equals(this.epost, person.epost) &&
        Objects.equals(this.telefoner, person.telefoner) &&
        Objects.equals(this.adresser, person.adresser) &&
        Objects.equals(this.kvalifikasjonsgrunnlag, person.kvalifikasjonsgrunnlag) &&
        Objects.equals(this.studentgrunnlag, person.studentgrunnlag) &&
        Objects.equals(this.organisasjonsenheter, person.organisasjonsenheter) &&
        Objects.equals(this.ansattnummer, person.ansattnummer) &&
        Objects.equals(this.student, person.student) &&
        Objects.equals(this.fagperson, person.fagperson);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(fodselsdato, personnummer, brukernavn, fornavn, etternavn, epost, telefoner, adresser, kvalifikasjonsgrunnlag, studentgrunnlag, organisasjonsenheter, ansattnummer, student, fagperson);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Person {\n");
    
    sb.append("    fodselsdato: ").append(toIndentedString(fodselsdato)).append("\n");
    sb.append("    personnummer: ").append(toIndentedString(personnummer)).append("\n");
    sb.append("    brukernavn: ").append(toIndentedString(brukernavn)).append("\n");
    sb.append("    fornavn: ").append(toIndentedString(fornavn)).append("\n");
    sb.append("    etternavn: ").append(toIndentedString(etternavn)).append("\n");
    sb.append("    epost: ").append(toIndentedString(epost)).append("\n");
    sb.append("    telefoner: ").append(toIndentedString(telefoner)).append("\n");
    sb.append("    adresser: ").append(toIndentedString(adresser)).append("\n");
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
