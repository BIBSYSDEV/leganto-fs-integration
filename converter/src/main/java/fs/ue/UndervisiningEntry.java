package fs.ue;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import fs.common.UEmne;
import fs.common.Validable;
import fs.ua.USemester;

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

    public void setHref(String href) {
        this.href = href;
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
}
