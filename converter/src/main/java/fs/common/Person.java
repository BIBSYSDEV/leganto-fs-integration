package fs.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.IOException;
import java.util.Objects;

import static utils.JsonUtils.readValue;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {

  @JsonProperty("personnummer")
  private transient String personnummer;

  public Long getPersonlopenummer() {
    return personlopenummer;
  }

  public Person setPersonlopenummer(Long personlopenummer) {
    this.personlopenummer = personlopenummer;
    return this;
  }

  @JsonProperty("personlopenummer")
  private transient Long personlopenummer;

  public String getPersonnummer() {
    return personnummer;
  }

  public Person setPersonnummer(String personnummer) {
    this.personnummer = personnummer;
    return this;
  }

  public static Person fromJson(String json) throws IOException {
    return readValue(json,Person.class);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Person person = (Person) o;
    return Objects.equals(personnummer, person.personnummer) &&
      Objects.equals(personlopenummer, person.personlopenummer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(personnummer, personlopenummer);
  }
}
