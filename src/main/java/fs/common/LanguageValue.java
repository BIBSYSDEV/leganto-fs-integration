package fs.common;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LanguageValue {

    @JsonProperty("lang")
    private String lang;
    @JsonProperty("value")
    private String value;

    public LanguageValue() {
    }

    public LanguageValue(String lang, String value) {
        this.lang = lang;
        this.value = value;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
