package fs.ue;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import fs.common.UEmne;
import fs.common.Validable;
import fs.ua.USemester;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UndervisiningEntry extends Validable {

    @JsonProperty("href")
    private String href;

    @JsonProperty("emne")
    private UEmne emne;

    @JsonProperty("semester")
    private USemester semester;

    @JsonProperty("terminnummer")
    private String terminNummer;

    public String getHref() {
        return href;
    }

    public UndervisiningEntry setHref(String href) {
        this.href = href;
        return this;
    }

    public UEmne getEmne() {
        return emne;
    }

    public UndervisiningEntry setEmne(UEmne emne) {
        this.emne = emne;
        return this;
    }

    public USemester getSemester() {
        return semester;
    }

    public UndervisiningEntry setSemester(USemester semester) {
        this.semester = semester;
        return this;

    }

    public String getTerminNummer() {
        return terminNummer;
    }

    public UndervisiningEntry setTerminNummer(String terminNummer) {
        this.terminNummer = terminNummer;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UndervisiningEntry)) {
            return false;
        }
        UndervisiningEntry that = (UndervisiningEntry) o;
        return getHref().equals(that.getHref())
            && getEmne().equals(that.getEmne())
            && getSemester().equals(that.getSemester())
            && getTerminNummer().equals(that.getTerminNummer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHref(), getEmne(), getSemester(), getTerminNummer());
    }
}
