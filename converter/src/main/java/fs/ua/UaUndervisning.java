package fs.ua;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UaUndervisning {

    @JsonProperty("href")
    private String href;

    @JsonProperty("emne")
    private UaEmne emne;

    @JsonProperty("semester")
    private UaSemester uaSemester;

    @JsonProperty("terminnummer")
    private Integer terminnumer;

    public String getHref() {
        return href;
    }

    public UaUndervisning setHref(String href) {
        this.href = href;
        return this;
    }

    public UaEmne getEmne() {
        return emne;
    }

    public UaUndervisning setEmne(UaEmne emne) {
        this.emne = emne;
        return this;
    }

    public UaSemester getUaSemester() {
        return uaSemester;
    }

    public UaUndervisning setUaSemester(UaSemester uaSemester) {
        this.uaSemester = uaSemester;
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
