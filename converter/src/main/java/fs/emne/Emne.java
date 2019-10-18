package fs.emne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import fs.common.LanguageValue;
import fs.common.Validable;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.List;

import utils.JsonUtils;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Emne extends Validable {

    @JsonProperty("navn")
    private List<LanguageValue> navn;

    @JsonProperty("organisasjonsenheter")
    private List<OrganizationEntityEmneEntry> organizationEntities;

    public static Emne fromJson(String emneJson) throws IOException {
        return JsonUtils.mapper.readValue(emneJson, Emne.class);
    }

    public List<LanguageValue> getNavn() {
        return navn;
    }

    public Emne setNavn(List<LanguageValue> navn) {
        this.navn = navn;
        for (LanguageValue v: navn) {
            v.setValue(URLDecoder.decode(v.getValue()));
        }
        return this;
    }

    public List<OrganizationEntityEmneEntry> getOrganizationEntities() {
        return organizationEntities;
    }

    public void setOrganizationEntities(List<OrganizationEntityEmneEntry> organizationEntities) {
        this.organizationEntities = organizationEntities;
    }
}
