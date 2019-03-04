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


    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public UaEmne getEmne() {
        return emne;
    }

    public void setEmne(UaEmne emne) {
        this.emne = emne;
    }

    public UaSemester getUaSemester() {
        return uaSemester;
    }

    public void setUaSemester(UaSemester uaSemester) {
        this.uaSemester = uaSemester;
    }
}
