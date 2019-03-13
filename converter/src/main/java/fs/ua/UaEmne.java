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

    public UaEmne setHref(String href) {
        this.href = href;
        return this;
    }

    public String getInstitution() {
        return institution;
    }

    public UaEmne setInstitution(String institution) {
        this.institution = institution;
        return this;
    }

    public String getCode() {
        return code;
    }

    public UaEmne setCode(String code) {
        this.code = code;
        return this;
    }

    public String getVersion() {
        return version;
    }

    public UaEmne setVersion(String version) {
        this.version = version;
        return this;
    }
}
