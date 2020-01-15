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
 * StudienivaStudienivaIntervall
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2019-04-25T14:26:52.663+02:00[Europe/Paris]")public class StudienivaStudienivaIntervall {

  @JsonProperty("kode")

  private String kode = null;

  @JsonProperty("navn")

  private String navn = null;

  @JsonProperty("erasmusNiva")

  private String erasmusNiva = null;

  @JsonProperty("utvekslingsavtale")

  private Boolean utvekslingsavtale = null;

  @JsonProperty("nkrSyklus")

  private String nkrSyklus = null;
  public StudienivaStudienivaIntervall kode(String kode) {
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
  public StudienivaStudienivaIntervall navn(String navn) {
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
  public StudienivaStudienivaIntervall erasmusNiva(String erasmusNiva) {
    this.erasmusNiva = erasmusNiva;
    return this;
  }

  

  /**
  * Get erasmusNiva
  * @return erasmusNiva
  **/
  @Schema(description = "")
  public String getErasmusNiva() {
    return erasmusNiva;
  }
  public void setErasmusNiva(String erasmusNiva) {
    this.erasmusNiva = erasmusNiva;
  }
  public StudienivaStudienivaIntervall utvekslingsavtale(Boolean utvekslingsavtale) {
    this.utvekslingsavtale = utvekslingsavtale;
    return this;
  }

  

  /**
  * Get utvekslingsavtale
  * @return utvekslingsavtale
  **/
  @Schema(description = "")
  public Boolean isUtvekslingsavtale() {
    return utvekslingsavtale;
  }
  public void setUtvekslingsavtale(Boolean utvekslingsavtale) {
    this.utvekslingsavtale = utvekslingsavtale;
  }
  public StudienivaStudienivaIntervall nkrSyklus(String nkrSyklus) {
    this.nkrSyklus = nkrSyklus;
    return this;
  }

  

  /**
  * Get nkrSyklus
  * @return nkrSyklus
  **/
  @Schema(description = "")
  public String getNkrSyklus() {
    return nkrSyklus;
  }
  public void setNkrSyklus(String nkrSyklus) {
    this.nkrSyklus = nkrSyklus;
  }
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StudienivaStudienivaIntervall studienivaStudienivaIntervall = (StudienivaStudienivaIntervall) o;
    return Objects.equals(this.kode, studienivaStudienivaIntervall.kode) &&
        Objects.equals(this.navn, studienivaStudienivaIntervall.navn) &&
        Objects.equals(this.erasmusNiva, studienivaStudienivaIntervall.erasmusNiva) &&
        Objects.equals(this.utvekslingsavtale, studienivaStudienivaIntervall.utvekslingsavtale) &&
        Objects.equals(this.nkrSyklus, studienivaStudienivaIntervall.nkrSyklus);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(kode, navn, erasmusNiva, utvekslingsavtale, nkrSyklus);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StudienivaStudienivaIntervall {\n");
    
    sb.append("    kode: ").append(toIndentedString(kode)).append("\n");
    sb.append("    navn: ").append(toIndentedString(navn)).append("\n");
    sb.append("    erasmusNiva: ").append(toIndentedString(erasmusNiva)).append("\n");
    sb.append("    utvekslingsavtale: ").append(toIndentedString(utvekslingsavtale)).append("\n");
    sb.append("    nkrSyklus: ").append(toIndentedString(nkrSyklus)).append("\n");
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