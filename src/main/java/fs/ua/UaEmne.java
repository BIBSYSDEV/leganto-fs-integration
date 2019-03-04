package fs.ua;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UaEmne {

    @JsonProperty("href")
    private String href;

    @JsonProperty("institusjon")
    private String institution;

    @JsonProperty("kode")
    private String code;

    @JsonProperty("versjon")
    private String version;


    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
