package fs.common;

import static java.util.Objects.nonNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UEmne extends Validable {

    @JsonProperty("href")
    private String href;

    @JsonProperty("institusjon")
    private String institution;

    @JsonProperty("kode")
    private String code;

    @JsonProperty("versjon")
    private String version;

    public boolean isValid() {
        return nonNull(href) && nonNull(institution) && nonNull(code) && nonNull(version);
    }

    public String getHref() {
        return href;
    }

    public UEmne setHref(String href) {
        this.href = href;
        return this;
    }

    public String getInstitution() {
        return institution;
    }

    public UEmne setInstitution(String institution) {
        this.institution = institution;
        return this;
    }

    public String getCode() {
        return code;
    }

    public UEmne setCode(String code) {
        this.code = code;
        return this;
    }

    public String getVersion() {
        return version;
    }

    public UEmne setVersion(String version) {
        this.version = version;
        return this;
    }
}
