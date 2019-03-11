package fs.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import fs.common.Language;
import java.util.List;
import java.util.stream.Collectors;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserInput {

    private List<Language> languageOrder;

    public List<String> getLanguageOrder() {
        return languageOrder.stream()
            .map(Language::toString).collect(Collectors.toList());
    }

    @JsonProperty("language_order")
    public void setLanguageOrder(List<String> languageOrder) {
        this.languageOrder = languageOrder.stream()
            .map(Language::fromString)
            .collect(Collectors.toList());
    }

    @JsonIgnore
    public List<Language> getLanguages() {
        return languageOrder;
    }
}
