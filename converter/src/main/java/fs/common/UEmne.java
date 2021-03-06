package fs.common;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class UEmne extends Validable {

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

    public UEmne setHref(String href) {
        this.href = href;
        return this;
    }

    @IgnoreValidable
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UEmne)) {
            return false;
        }
        UEmne uemne = (UEmne) o;
        return Objects.equals(getHref(), uemne.getHref())
            && Objects.equals(getInstitution(), uemne.getInstitution())
            && Objects.equals(getCode(), uemne.getCode())
            && Objects.equals(getVersion(), uemne.getVersion());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHref(), getInstitution(), getCode(), getVersion());
    }
}
