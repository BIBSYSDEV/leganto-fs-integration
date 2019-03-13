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

    @JsonProperty("campus_participants")
    private List<String> campuses;

    public List<String> getLanguageOrder() {
        return languageOrder.stream()
            .map(Language::toString).collect(Collectors.toList());
    }

    @JsonProperty("language_order")
    public UserInput setLanguageOrder(List<String> languageOrder) {
        this.languageOrder = languageOrder.stream()
            .map(Language::fromString)
            .collect(Collectors.toList());
        return this;
    }

    @JsonIgnore
    public List<Language> getLanguages() {
        return languageOrder;
    }

    public List<String> getCampuses() {
        return campuses;
    }

    public UserInput setCampuses(List<String> campuses) {
        this.campuses = campuses;
        return this;
    }
}
