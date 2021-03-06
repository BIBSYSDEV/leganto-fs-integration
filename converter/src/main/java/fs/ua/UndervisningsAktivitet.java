package fs.ua;

import static utils.JsonUtils.mapper;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import fs.common.IgnoreValidable;
import fs.common.LanguageValue;
import fs.common.UEmne;
import fs.common.Validable;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UndervisningsAktivitet extends Validable {

    @JsonProperty("undervisning")
    private UaUndervisning undervisning;

    @JsonProperty("navn")
    private List<LanguageValue> navn;

    @JsonProperty("aktivitet")
    private String aktivitet;

    @JsonProperty("href")
    private String href;

    @JsonProperty("campus")
    private String campus = "";

    public static UndervisningsAktivitet fromJson(String json) throws IOException {
        return mapper.readValue(json, UndervisningsAktivitet.class);
    }

    public String getCampus(){return campus;}

    public UndervisningsAktivitet setCampus(String camp){
        campus = camp;
        return this;
    }

    public UaUndervisning getUndervisning() {
        return undervisning;
    }

    public UndervisningsAktivitet setUndervisning(UaUndervisning undervisning) {
        this.undervisning = undervisning;
        return this;
    }

    public UndervisningsAktivitet setUndervising(UaUndervisning undervisning) {
        this.undervisning = undervisning;
        return this;
    }

    public List<LanguageValue> getNavn() {
        return navn;
    }

    public UndervisningsAktivitet setNavn(List<LanguageValue> navn) {
        this.navn = navn;
        return this;
    }

    public String getAktivitet() {
        return aktivitet;
    }

    public UndervisningsAktivitet setAktivitet(String aktivitet) {
        this.aktivitet = aktivitet;
        return this;
    }

    @JsonIgnore
    public UEmne getEmne() {
        return this.undervisning.getEmne();
    }

    @JsonIgnore
    public USemester getSemester() {
        return this.getUndervisning()
            .getUaSemester();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UndervisningsAktivitet)) {
            return false;
        }
        UndervisningsAktivitet that = (UndervisningsAktivitet) o;
        return Objects.equals(getUndervisning(), that.getUndervisning())
            && Objects.equals(getNavn(), that.getNavn())
            && Objects.equals(getAktivitet(), that.getAktivitet());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUndervisning(), getNavn(), getAktivitet());
    }

    @IgnoreValidable
    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}
