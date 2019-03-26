package fs.ua;

import fs.common.Validable;
import java.util.Objects;

public class PersonRolleRequest extends Validable {

    private SemesterCode semesterCode;
    private Integer year;
    private String rolleKode;
    private String emneKode;

    public SemesterCode getSemesterCode() {
        return semesterCode;
    }

    public PersonRolleRequest setSemesterCode(SemesterCode semesterCode) {
        this.semesterCode = semesterCode;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public PersonRolleRequest setYear(Integer year) {
        this.year = year;
        return this;
    }

    public String getRolleKode() {
        return rolleKode;
    }

    public PersonRolleRequest setRolleKode(String rolleKode) {
        this.rolleKode = rolleKode;
        return this;
    }

    public String getEmneKode() {
        return emneKode;
    }

    public PersonRolleRequest setEmneKode(String emneKode) {
        this.emneKode = emneKode;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PersonRolleRequest)) {
            return false;
        }
        PersonRolleRequest that = (PersonRolleRequest) o;
        return getSemesterCode() == that.getSemesterCode() &&
            Objects.equals(getYear(), that.getYear()) &&
            Objects.equals(getRolleKode(), that.getRolleKode()) &&
            Objects.equals(getEmneKode(), that.getEmneKode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSemesterCode(), getYear(), getRolleKode(), getEmneKode());
    }
}
