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
import no.bibsys.fs.model.DeltakerId;
import no.bibsys.fs.model.Eposter;
import no.bibsys.fs.model.Foretak;
import no.bibsys.fs.model.Id2;
import no.bibsys.fs.model.Telefoner;
import org.threeten.bp.LocalDate;

/**
 * Deltaker
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2019-04-25T14:26:52.663+02:00[Europe/Paris]")public class Deltaker {

  @JsonProperty("id")

  private DeltakerId id = null;

  @JsonProperty("person")

  private Id2 person = null;

  @JsonProperty("foretak")

  private Foretak foretak = null;

  @JsonProperty("adresser")

  private Adresser adresser = null;

  @JsonProperty("eposter")

  private Eposter eposter = null;

  @JsonProperty("telefoner")

  private Telefoner telefoner = null;

  @JsonProperty("land")

  private Id2 land = null;

  @JsonProperty("fornavn")

  private String fornavn = null;

  @JsonProperty("etternavn")

  private String etternavn = null;

  @JsonProperty("kjonn")

  private String kjonn = null;

  @JsonProperty("maalform")

  private String maalform = null;

  @JsonProperty("dod")

  private Boolean dod = null;

  @JsonProperty("fodselsdato")

  private LocalDate fodselsdato = null;

  @JsonProperty("stillingstittel")

  private String stillingstittel = null;

  @JsonProperty("kontonummer")

  private Integer kontonummer = null;

  @JsonProperty("merknad")

  private String merknad = null;
  public Deltaker id(DeltakerId id) {
    this.id = id;
    return this;
  }

  

  /**
  * Get id
  * @return id
  **/
  @Schema(description = "")
  public DeltakerId getId() {
    return id;
  }
  public void setId(DeltakerId id) {
    this.id = id;
  }
  public Deltaker person(Id2 person) {
    this.person = person;
    return this;
  }

  

  /**
  * Get person
  * @return person
  **/
  @Schema(description = "")
  public Id2 getPerson() {
    return person;
  }
  public void setPerson(Id2 person) {
    this.person = person;
  }
  public Deltaker foretak(Foretak foretak) {
    this.foretak = foretak;
    return this;
  }

  

  /**
  * Get foretak
  * @return foretak
  **/
  @Schema(description = "")
  public Foretak getForetak() {
    return foretak;
  }
  public void setForetak(Foretak foretak) {
    this.foretak = foretak;
  }
  public Deltaker adresser(Adresser adresser) {
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
  public Deltaker eposter(Eposter eposter) {
    this.eposter = eposter;
    return this;
  }

  

  /**
  * Get eposter
  * @return eposter
  **/
  @Schema(description = "")
  public Eposter getEposter() {
    return eposter;
  }
  public void setEposter(Eposter eposter) {
    this.eposter = eposter;
  }
  public Deltaker telefoner(Telefoner telefoner) {
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
  public Deltaker land(Id2 land) {
    this.land = land;
    return this;
  }

  

  /**
  * Get land
  * @return land
  **/
  @Schema(description = "")
  public Id2 getLand() {
    return land;
  }
  public void setLand(Id2 land) {
    this.land = land;
  }
  public Deltaker fornavn(String fornavn) {
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
  public Deltaker etternavn(String etternavn) {
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
  public Deltaker kjonn(String kjonn) {
    this.kjonn = kjonn;
    return this;
  }

  

  /**
  * Get kjonn
  * @return kjonn
  **/
  @Schema(description = "")
  public String getKjonn() {
    return kjonn;
  }
  public void setKjonn(String kjonn) {
    this.kjonn = kjonn;
  }
  public Deltaker maalform(String maalform) {
    this.maalform = maalform;
    return this;
  }

  

  /**
  * Get maalform
  * @return maalform
  **/
  @Schema(description = "")
  public String getMaalform() {
    return maalform;
  }
  public void setMaalform(String maalform) {
    this.maalform = maalform;
  }
  public Deltaker dod(Boolean dod) {
    this.dod = dod;
    return this;
  }

  

  /**
  * Get dod
  * @return dod
  **/
  @Schema(description = "")
  public Boolean isDod() {
    return dod;
  }
  public void setDod(Boolean dod) {
    this.dod = dod;
  }
  public Deltaker fodselsdato(LocalDate fodselsdato) {
    this.fodselsdato = fodselsdato;
    return this;
  }

  

  /**
  * Get fodselsdato
  * @return fodselsdato
  **/
  @Schema(description = "")
  public LocalDate getFodselsdato() {
    return fodselsdato;
  }
  public void setFodselsdato(LocalDate fodselsdato) {
    this.fodselsdato = fodselsdato;
  }
  public Deltaker stillingstittel(String stillingstittel) {
    this.stillingstittel = stillingstittel;
    return this;
  }

  

  /**
  * Get stillingstittel
  * @return stillingstittel
  **/
  @Schema(description = "")
  public String getStillingstittel() {
    return stillingstittel;
  }
  public void setStillingstittel(String stillingstittel) {
    this.stillingstittel = stillingstittel;
  }
  public Deltaker kontonummer(Integer kontonummer) {
    this.kontonummer = kontonummer;
    return this;
  }

  

  /**
  * Get kontonummer
  * @return kontonummer
  **/
  @Schema(description = "")
  public Integer getKontonummer() {
    return kontonummer;
  }
  public void setKontonummer(Integer kontonummer) {
    this.kontonummer = kontonummer;
  }
  public Deltaker merknad(String merknad) {
    this.merknad = merknad;
    return this;
  }

  

  /**
  * Get merknad
  * @return merknad
  **/
  @Schema(description = "")
  public String getMerknad() {
    return merknad;
  }
  public void setMerknad(String merknad) {
    this.merknad = merknad;
  }
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Deltaker deltaker = (Deltaker) o;
    return Objects.equals(this.id, deltaker.id) &&
        Objects.equals(this.person, deltaker.person) &&
        Objects.equals(this.foretak, deltaker.foretak) &&
        Objects.equals(this.adresser, deltaker.adresser) &&
        Objects.equals(this.eposter, deltaker.eposter) &&
        Objects.equals(this.telefoner, deltaker.telefoner) &&
        Objects.equals(this.land, deltaker.land) &&
        Objects.equals(this.fornavn, deltaker.fornavn) &&
        Objects.equals(this.etternavn, deltaker.etternavn) &&
        Objects.equals(this.kjonn, deltaker.kjonn) &&
        Objects.equals(this.maalform, deltaker.maalform) &&
        Objects.equals(this.dod, deltaker.dod) &&
        Objects.equals(this.fodselsdato, deltaker.fodselsdato) &&
        Objects.equals(this.stillingstittel, deltaker.stillingstittel) &&
        Objects.equals(this.kontonummer, deltaker.kontonummer) &&
        Objects.equals(this.merknad, deltaker.merknad);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(id, person, foretak, adresser, eposter, telefoner, land, fornavn, etternavn, kjonn, maalform, dod, fodselsdato, stillingstittel, kontonummer, merknad);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Deltaker {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    person: ").append(toIndentedString(person)).append("\n");
    sb.append("    foretak: ").append(toIndentedString(foretak)).append("\n");
    sb.append("    adresser: ").append(toIndentedString(adresser)).append("\n");
    sb.append("    eposter: ").append(toIndentedString(eposter)).append("\n");
    sb.append("    telefoner: ").append(toIndentedString(telefoner)).append("\n");
    sb.append("    land: ").append(toIndentedString(land)).append("\n");
    sb.append("    fornavn: ").append(toIndentedString(fornavn)).append("\n");
    sb.append("    etternavn: ").append(toIndentedString(etternavn)).append("\n");
    sb.append("    kjonn: ").append(toIndentedString(kjonn)).append("\n");
    sb.append("    maalform: ").append(toIndentedString(maalform)).append("\n");
    sb.append("    dod: ").append(toIndentedString(dod)).append("\n");
    sb.append("    fodselsdato: ").append(toIndentedString(fodselsdato)).append("\n");
    sb.append("    stillingstittel: ").append(toIndentedString(stillingstittel)).append("\n");
    sb.append("    kontonummer: ").append(toIndentedString(kontonummer)).append("\n");
    sb.append("    merknad: ").append(toIndentedString(merknad)).append("\n");
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