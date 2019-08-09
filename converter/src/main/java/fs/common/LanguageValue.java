package fs.common;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class LanguageValue {

    @JsonProperty("lang")
    private Language lang;

    @JsonProperty("value")
    private String value;

    public LanguageValue() {
    }

    public LanguageValue(Language lang, String value) {

        this.lang = lang;
        this.value = value;
    }

    public Language getLang() {
        return lang;
    }

    public void setLang(Language lang) {
        this.lang = lang;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LanguageValue)) {
            return false;
        }
        LanguageValue that = (LanguageValue) o;
        return getLang().equals(that.getLang()) && getValue().equals(that.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLang(), getValue());
    }
}
