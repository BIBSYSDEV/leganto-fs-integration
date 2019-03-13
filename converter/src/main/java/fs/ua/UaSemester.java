package fs.ua;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UaSemester {

    @JsonProperty("href")
    private String href;

    @JsonProperty("ar")
    private Integer year;

    private SemesterCode semesterCode;

    public SemesterCode getSemesterCode() {
        return semesterCode;
    }

    @JsonProperty("termin")
    public UaSemester setSemesterCode(String code) {
        this.semesterCode = SemesterCode.fromString(code);
        return this;
    }

    public String getHref() {
        return href;
    }

    public UaSemester setHref(String href) {
        this.href = href;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public UaSemester setYear(int year) {
        this.year = year;
        return this;
    }
}