package fs.ua;

import static utils.JsonUtils.mapper;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import fs.common.LanguageValue;
import fs.common.UEmne;
import java.io.IOException;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UndervisningsAktivitet {

    @JsonProperty("undervisning")
    private UaUndervisning undervisning;

    @JsonProperty("navn")
    private List<LanguageValue> nanv;

    @JsonProperty("aktivitet")
    private String aktivitet;


    public static UndervisningsAktivitet fromJson(String json) throws IOException {
        return mapper.readValue(json, UndervisningsAktivitet.class);
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

    public List<LanguageValue> getNanv() {
        return nanv;
    }

    public UndervisningsAktivitet setNanv(List<LanguageValue> nanv) {
        this.nanv = nanv;
        return this;
    }

    public String getAktivitet() {
        return aktivitet;
    }

    public void setAktivitet(String aktivitet) {
        this.aktivitet = aktivitet;
    }

    @JsonIgnore
    public UEmne getEmne() {
        return this.undervisning.getEmne();
    }

    @JsonIgnore
    public USemester getSemester() {
        return this.getUndervisning().getUaSemester();
    }
}
