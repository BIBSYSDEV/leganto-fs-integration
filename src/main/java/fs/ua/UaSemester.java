package fs.ua;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import cucumber.api.java.eo.Se;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UaSemester {

    @JsonProperty("href")
    private String href;

    @JsonProperty("ar")
    private int year;


    private SemesterCode semesterCode;


    @JsonProperty("termin")
    public UaSemester setSemesterCode(String code){
        this.semesterCode= SemesterCode.fromString(code);
        return this;
    }


    public SemesterCode getSemesterCode(){
        return semesterCode;
    }

    public String getHref() {
        return href;
    }

    public UaSemester setHref(String href) {
        this.href = href;
        return this;
    }

    public int getYear() {
        return year;
    }

    public UaSemester setYear(int year) {
        this.year = year;
        return this;
    }
}
