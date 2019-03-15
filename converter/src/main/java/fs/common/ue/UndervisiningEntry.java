package fs.common.ue;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import fs.common.UEmne;
import fs.ua.USemester;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UndervisiningEntry {

    @JsonProperty("href")
    private String href;

    @JsonProperty("emne")
    private UEmne uEmne;

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

    public UEmne getuEmne() {
        return uEmne;
    }

    public void setuEmne(UEmne uEmne) {
        this.uEmne = uEmne;
    }

    public USemester getSemester() {
        return semester;
    }

    public void setSemester(USemester semester) {
        this.semester = semester;
    }

    public String getTerminNummer() {
        return terminNummer;
    }

    public void setTerminNummer(String terminNummer) {
        this.terminNummer = terminNummer;
    }
}
