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
import no.bibsys.fs.model.Id2;
import no.bibsys.fs.model.LandId;
import no.bibsys.fs.model.SprakFelter;

/**
 * Land
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2019-04-25T14:26:52.663+02:00[Europe/Paris]")public class Land {

  @JsonProperty("id")

  private LandId id = null;

  @JsonProperty("navn")

  private SprakFelter navn = null;

  @JsonProperty("kode")

  private String kode = null;

  @JsonProperty("landtypekode")

  private String landtypekode = null;

  @JsonProperty("landtypenavn")

  private String landtypenavn = null;

  @JsonProperty("land")

  private Id2 land = null;

  @JsonProperty("uland")

  private Boolean uland = null;

  @JsonProperty("euEllerEosLand")

  private Boolean euEllerEosLand = null;

  @JsonProperty("osteuropeiskLand")

  private Boolean osteuropeiskLand = null;

  @JsonProperty("aktiv")

  private Boolean aktiv = null;

  @JsonProperty("oppholdstillatelseKreves")

  private Boolean oppholdstillatelseKreves = null;

  @JsonProperty("kvote")

  private Boolean kvote = null;

  @JsonProperty("felles")

  private Boolean felles = null;

  @JsonProperty("utdanningssystem")

  private String utdanningssystem = null;
  public Land id(LandId id) {
    this.id = id;
    return this;
  }

  

  /**
  * Get id
  * @return id
  **/
  @Schema(description = "")
  public LandId getId() {
    return id;
  }
  public void setId(LandId id) {
    this.id = id;
  }
  public Land navn(SprakFelter navn) {
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
  public Land kode(String kode) {
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
  public Land landtypekode(String landtypekode) {
    this.landtypekode = landtypekode;
    return this;
  }

  

  /**
  * Get landtypekode
  * @return landtypekode
  **/
  @Schema(description = "")
  public String getLandtypekode() {
    return landtypekode;
  }
  public void setLandtypekode(String landtypekode) {
    this.landtypekode = landtypekode;
  }
  public Land landtypenavn(String landtypenavn) {
    this.landtypenavn = landtypenavn;
    return this;
  }

  

  /**
  * Get landtypenavn
  * @return landtypenavn
  **/
  @Schema(description = "")
  public String getLandtypenavn() {
    return landtypenavn;
  }
  public void setLandtypenavn(String landtypenavn) {
    this.landtypenavn = landtypenavn;
  }
  public Land land(Id2 land) {
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
  public Land uland(Boolean uland) {
    this.uland = uland;
    return this;
  }

  

  /**
  * Get uland
  * @return uland
  **/
  @Schema(description = "")
  public Boolean isUland() {
    return uland;
  }
  public void setUland(Boolean uland) {
    this.uland = uland;
  }
  public Land euEllerEosLand(Boolean euEllerEosLand) {
    this.euEllerEosLand = euEllerEosLand;
    return this;
  }

  

  /**
  * Get euEllerEosLand
  * @return euEllerEosLand
  **/
  @Schema(description = "")
  public Boolean isEuEllerEosLand() {
    return euEllerEosLand;
  }
  public void setEuEllerEosLand(Boolean euEllerEosLand) {
    this.euEllerEosLand = euEllerEosLand;
  }
  public Land osteuropeiskLand(Boolean osteuropeiskLand) {
    this.osteuropeiskLand = osteuropeiskLand;
    return this;
  }

  

  /**
  * Get osteuropeiskLand
  * @return osteuropeiskLand
  **/
  @Schema(description = "")
  public Boolean isOsteuropeiskLand() {
    return osteuropeiskLand;
  }
  public void setOsteuropeiskLand(Boolean osteuropeiskLand) {
    this.osteuropeiskLand = osteuropeiskLand;
  }
  public Land aktiv(Boolean aktiv) {
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
  public Land oppholdstillatelseKreves(Boolean oppholdstillatelseKreves) {
    this.oppholdstillatelseKreves = oppholdstillatelseKreves;
    return this;
  }

  

  /**
  * Get oppholdstillatelseKreves
  * @return oppholdstillatelseKreves
  **/
  @Schema(description = "")
  public Boolean isOppholdstillatelseKreves() {
    return oppholdstillatelseKreves;
  }
  public void setOppholdstillatelseKreves(Boolean oppholdstillatelseKreves) {
    this.oppholdstillatelseKreves = oppholdstillatelseKreves;
  }
  public Land kvote(Boolean kvote) {
    this.kvote = kvote;
    return this;
  }

  

  /**
  * Get kvote
  * @return kvote
  **/
  @Schema(description = "")
  public Boolean isKvote() {
    return kvote;
  }
  public void setKvote(Boolean kvote) {
    this.kvote = kvote;
  }
  public Land felles(Boolean felles) {
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
  public Land utdanningssystem(String utdanningssystem) {
    this.utdanningssystem = utdanningssystem;
    return this;
  }

  

  /**
  * Get utdanningssystem
  * @return utdanningssystem
  **/
  @Schema(description = "")
  public String getUtdanningssystem() {
    return utdanningssystem;
  }
  public void setUtdanningssystem(String utdanningssystem) {
    this.utdanningssystem = utdanningssystem;
  }
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Land land = (Land) o;
    return Objects.equals(this.id, land.id) &&
        Objects.equals(this.navn, land.navn) &&
        Objects.equals(this.kode, land.kode) &&
        Objects.equals(this.landtypekode, land.landtypekode) &&
        Objects.equals(this.landtypenavn, land.landtypenavn) &&
        Objects.equals(this.land, land.land) &&
        Objects.equals(this.uland, land.uland) &&
        Objects.equals(this.euEllerEosLand, land.euEllerEosLand) &&
        Objects.equals(this.osteuropeiskLand, land.osteuropeiskLand) &&
        Objects.equals(this.aktiv, land.aktiv) &&
        Objects.equals(this.oppholdstillatelseKreves, land.oppholdstillatelseKreves) &&
        Objects.equals(this.kvote, land.kvote) &&
        Objects.equals(this.felles, land.felles) &&
        Objects.equals(this.utdanningssystem, land.utdanningssystem);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(id, navn, kode, landtypekode, landtypenavn, land, uland, euEllerEosLand, osteuropeiskLand, aktiv, oppholdstillatelseKreves, kvote, felles, utdanningssystem);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Land {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    navn: ").append(toIndentedString(navn)).append("\n");
    sb.append("    kode: ").append(toIndentedString(kode)).append("\n");
    sb.append("    landtypekode: ").append(toIndentedString(landtypekode)).append("\n");
    sb.append("    landtypenavn: ").append(toIndentedString(landtypenavn)).append("\n");
    sb.append("    land: ").append(toIndentedString(land)).append("\n");
    sb.append("    uland: ").append(toIndentedString(uland)).append("\n");
    sb.append("    euEllerEosLand: ").append(toIndentedString(euEllerEosLand)).append("\n");
    sb.append("    osteuropeiskLand: ").append(toIndentedString(osteuropeiskLand)).append("\n");
    sb.append("    aktiv: ").append(toIndentedString(aktiv)).append("\n");
    sb.append("    oppholdstillatelseKreves: ").append(toIndentedString(oppholdstillatelseKreves)).append("\n");
    sb.append("    kvote: ").append(toIndentedString(kvote)).append("\n");
    sb.append("    felles: ").append(toIndentedString(felles)).append("\n");
    sb.append("    utdanningssystem: ").append(toIndentedString(utdanningssystem)).append("\n");
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
