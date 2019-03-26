package fs.personroller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import fs.common.Validable;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Person extends Validable {

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

    public void setHref(String href) {
        this.href = href;
    }

    public String getPersonLopeNummer() {
        return personLopeNummer;
    }

    public void setPersonLopeNummer(String personLopeNummer) {
        this.personLopeNummer = personLopeNummer;
    }
}
