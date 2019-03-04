package fs.ua;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UndervisningsAktivitet {

    @JsonProperty("undervisning")
    private UaUndervisning undervisning;



    public UaUndervisning getUndervisning() {
        return undervisning;
    }

    public UndervisningsAktivitet setUndervisning(UaUndervisning undervisning) {
        this.undervisning = undervisning;
        return this;
    }

    public UaUndervisning getUndervising() {
        return this.undervisning;
    }

    public UndervisningsAktivitet setUndervising(UaUndervisning undervisning){
        this.undervisning=undervisning;
        return this;
    }

    @JsonIgnore
    public UaEmne getEmne() {
        return this.undervisning.getEmne();
    }

    @JsonIgnore
    public UaSemester getSemester() {
        return this.getUndervisning().getUaSemester();
    }
}
