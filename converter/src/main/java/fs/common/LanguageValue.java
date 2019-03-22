package fs.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.NonNull;

public class LanguageValue {

    @JsonProperty("lang")
    @NonNull
    private String lang;

    @JsonProperty("value")
    @NonNull
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
