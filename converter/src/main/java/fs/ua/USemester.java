package fs.ua;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import fs.common.Validable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class USemester extends Validable {

    @JsonProperty("href")
    private String href;

    @JsonProperty("ar")
    private Integer year;

    private SemesterCode semesterCode;

    public SemesterCode getSemesterCode() {
        return semesterCode;
    }

    @JsonProperty("termin")
    public USemester setSemesterCode(String code) {
        this.semesterCode = SemesterCode.fromString(code);
        return this;
    }

    public String getHref() {
        return href;
    }

    public USemester setHref(String href) {
        this.href = href;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public USemester setYear(int year) {
        this.year = year;
        return this;
    }
}
