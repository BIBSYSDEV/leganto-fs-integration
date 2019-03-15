package fs.ua;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import fs.common.UEmne;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UaUndervisning {

    @JsonProperty("href")
    private String href;

    @JsonProperty("emne")
    private UEmne emne;

    @JsonProperty("semester")
    private USemester uSemester;

    @JsonProperty("terminnummer")
    private Integer terminnumer;

    public String getHref() {
        return href;
    }

    public UaUndervisning setHref(String href) {
        this.href = href;
        return this;
    }

    public UEmne getEmne() {
        return emne;
    }

    public UaUndervisning setEmne(UEmne emne) {
        this.emne = emne;
        return this;
    }

    public USemester getuSemester() {
        return uSemester;
    }

    public UaUndervisning setuSemester(USemester uSemester) {
        this.uSemester = uSemester;
        return this;
    }

    public Integer getTerminnumer() {
        return terminnumer;
    }

    public UaUndervisning setTerminnumer(Integer terminnumer) {
        this.terminnumer = terminnumer;
        return this;
    }
}
