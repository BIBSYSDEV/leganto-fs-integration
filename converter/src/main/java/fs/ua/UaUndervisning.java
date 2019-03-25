package fs.ua;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import fs.common.IgnoreValidable;
import fs.common.UEmne;
import fs.common.Validable;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UaUndervisning extends Validable {

    @JsonProperty("href")
    private String href;

    @JsonProperty("emne")
    private UEmne emne;

    @JsonProperty("semester")
    private USemester uaSemester;

    @JsonProperty("terminnummer")
    private Integer terminnumer;

    @IgnoreValidable
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

    public USemester getUaSemester() {
        return uaSemester;
    }

    public UaUndervisning setUaSemester(USemester uaSemester) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UaUndervisning)) {
            return false;
        }
        UaUndervisning that = (UaUndervisning) o;
        return getHref().equals(that.getHref())
            && getEmne().equals(that.getEmne())
            && getUaSemester().equals(that.getUaSemester())
            && getTerminnumer().equals(that.getTerminnumer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHref(), getEmne(), getUaSemester(), getTerminnumer());
    }
}
