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

    public void setUndervisning(UaUndervisning undervisning) {
        this.undervisning = undervisning;
    }

    public UaUndervisning getUndervising() {
        return this.undervisning;
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
