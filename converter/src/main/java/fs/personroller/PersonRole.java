package fs.personroller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import fs.common.Validable;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonRole extends Validable {

  @JsonProperty("person")
  private Person person;

  @JsonProperty("undervisning")
  private UndervisningReference undervisning;

  public Person getPerson() {
    return person;
  }

  public PersonRole setPerson(Person person) {
    this.person = person;
    return this;
  }

  @JsonIgnore
  public String getPersonLopeNummer() {
    return person.getPersonLopeNummer();
  }

  public UndervisningReference getUndervisning() {
    return undervisning;
  }

  public PersonRole setUndervisning(UndervisningReference undervisning) {
    this.undervisning = undervisning;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof PersonRole)) {
      return false;
    }
    PersonRole that = (PersonRole) o;
    return Objects.equals(getPerson(), that.getPerson())
      && Objects.equals(getUndervisning(), that.getUndervisning());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getPerson(), getUndervisning());
  }

  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Person extends Validable {

    @JsonProperty("href")
    private String href;
    @JsonProperty("personlopenummer")
    private String personLopeNummer;

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof Person)) {
        return false;
      }
      Person person = (Person) o;
      return Objects.equals(getHref(), person.getHref())
        && Objects.equals(getPersonLopeNummer(), person.getPersonLopeNummer());
    }

    @Override
    public int hashCode() {
      return Objects.hash(getHref(), getPersonLopeNummer());
    }

    public String getHref() {
      return href;
    }

    public Person setHref(String href) {
      this.href = href;
      return this;
    }

    public String getPersonLopeNummer() {
      return personLopeNummer;
    }

    public Person setPersonLopeNummer(String personLopeNummer) {
      this.personLopeNummer = personLopeNummer;
      return this;
    }
  }
}
