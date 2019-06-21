package fs.common;

import static utils.JsonUtils.readValue;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.IOException;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {

  @JsonProperty("personnummer")
  private transient String personnummer;

  @JsonProperty("brukernavn")
  private transient String brukernavn;

  @JsonProperty("personlopenummer")
  private transient Long personlopenummer;

  public String getBrukernavn() {
    return brukernavn;
  }

  public Person setBrukernavn(String personnummer) {
    this.brukernavn = personnummer;
    return this;
  }

  public String getPersonnummer() {
    return personnummer;
  }

  public Person setPersonnummer(String personnummer) {
    this.personnummer = personnummer;
    return this;
  }

  public static Person fromJson(String json) throws IOException {
    return readValue(json, Person.class);
  }

  public Long getPersonlopenummer() {
    return personlopenummer;
  }

  public Person setPersonlopenummer(Long personlopenummer) {
    this.personlopenummer = personlopenummer;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Person person = (Person) o;
    return Objects.equals(personnummer, person.personnummer) &&
      Objects.equals(personlopenummer, person.personlopenummer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(personnummer, personlopenummer);
  }
}
