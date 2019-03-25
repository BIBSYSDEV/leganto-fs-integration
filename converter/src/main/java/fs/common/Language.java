package fs.common;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public enum Language {
    NB, NN, EN;

    protected static final String NB_STRING = "nb";
    protected static final String NN_STRING = "nn";
    protected static final String EN_STRING = "en";

    private static final String WRONG_INPUT_MESSAGE =
        "Allowed languages:" + String.join(",", NB_STRING, NN_STRING, EN_STRING);
    private static final List<String> names = Arrays.stream(Language.values()).map(Enum::name)
        .collect(Collectors.toList());

    @JsonCreator
    public static Language fromString(String lang) {
        String lowerCase = lang.toLowerCase(Locale.getDefault());
        switch (lowerCase) {
            case NB_STRING:
                return NB;
            case NN_STRING:
                return NN;
            case EN_STRING:
                return EN;
            default:
                throw new IllegalArgumentException(WRONG_INPUT_MESSAGE);
        }
    }

    /**
     * Selects a value among a list of {@link LanguageValue} elements bases on a sorted preference list.
     *
     * @param values A set of values to select from
     * @param languageOrder A list of languages ordered from the most preferable to the least preferable.
     * @return An {@link Optional} containing the value of the most preferable available {@link LanguageValue} element
     *         or an empty {@link Optional} if no element is found for one of the preferred languages
     */
    public static Optional<String> getValueForLanguagePref(List<LanguageValue> values, List<Language> languageOrder) {
        Map<Language, String> valuesMap = values.stream()
            .collect(Collectors.toMap(LanguageValue::getLang, LanguageValue::getValue));
        for (Language language : languageOrder) {
            if (valuesMap.containsKey(language)) {
                return Optional.ofNullable(valuesMap.get(language));
            }
        }
        return Optional.empty();
    }

    @Override
    public String toString() {
        switch (this) {
            case NN:
                return NN_STRING;
            case EN:
                return EN_STRING;
            case NB:
            default:
                return NB_STRING;
        }
    }

    @JsonValue
    public String toValue() {
        return toString();
    }

}
