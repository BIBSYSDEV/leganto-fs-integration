package fs.emne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import fs.common.LanguageValue;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Emne  {

    @JsonProperty("navn")
    private List<LanguageValue> navn;





    public List<LanguageValue> getNavn() {
        return navn;
    }

    public Emne setNavn(List<LanguageValue> navn) {
        this.navn = navn;
        return this;
    }
}
