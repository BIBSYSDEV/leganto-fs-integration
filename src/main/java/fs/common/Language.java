package fs.common;

import java.util.Arrays;
import java.util.List;
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
    private static final String WRONG_STATE_MESSAGE = String.join(",", "Allowed enum values:" + names);

    public static Language fromString(String lang) {
        String lowerCase = lang.toLowerCase();
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

    public static Optional<String> getValueForLanguage(List<LanguageValue> values, List<Language> languageOrder) {
        Map<Language, String> valuesMap = values.stream()
            .collect(Collectors.toMap(langValue -> Language.fromString(langValue.getLang()), LanguageValue::getValue));
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
            case NB:
                return NB_STRING;
            case NN:
                return NN_STRING;
            case EN:
                return EN_STRING;
            default:
                throw new IllegalStateException(WRONG_STATE_MESSAGE);
        }
    }

}
