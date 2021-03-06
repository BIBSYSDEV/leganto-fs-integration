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

/**
 * PersonrolleId
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2019-04-25T14:26:52.663+02:00[Europe/Paris]")public class PersonrolleId {

  @JsonProperty("href")

  private String href = null;
  /**
   * Gets or Sets type
   */
  public enum TypeEnum {
    EMPTY("");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }
    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    @JsonCreator
    public static TypeEnum fromValue(String text) {
      for (TypeEnum b : TypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

  }
  @JsonProperty("type")

  private TypeEnum type = null;

  @JsonProperty("person")

  private Id2 person = null;

  @JsonProperty("rollenummer")

  private Integer rollenummer = null;
  public PersonrolleId href(String href) {
    this.href = href;
    return this;
  }

  

  /**
  * Get href
  * @return href
  **/
  @Schema(example = "https://server/personrolle/id", description = "")
  public String getHref() {
    return href;
  }
  public void setHref(String href) {
    this.href = href;
  }
  public PersonrolleId type(TypeEnum type) {
    this.type = type;
    return this;
  }

  

  /**
  * Get type
  * @return type
  **/
  @Schema(description = "")
  public TypeEnum getType() {
    return type;
  }
  public void setType(TypeEnum type) {
    this.type = type;
  }
  public PersonrolleId person(Id2 person) {
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
  public PersonrolleId rollenummer(Integer rollenummer) {
    this.rollenummer = rollenummer;
    return this;
  }

  

  /**
  * Get rollenummer
  * @return rollenummer
  **/
  @Schema(description = "")
  public Integer getRollenummer() {
    return rollenummer;
  }
  public void setRollenummer(Integer rollenummer) {
    this.rollenummer = rollenummer;
  }
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PersonrolleId personrolleId = (PersonrolleId) o;
    return Objects.equals(this.href, personrolleId.href) &&
        Objects.equals(this.type, personrolleId.type) &&
        Objects.equals(this.person, personrolleId.person) &&
        Objects.equals(this.rollenummer, personrolleId.rollenummer);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(href, type, person, rollenummer);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PersonrolleId {\n");
    
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    person: ").append(toIndentedString(person)).append("\n");
    sb.append("    rollenummer: ").append(toIndentedString(rollenummer)).append("\n");
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
