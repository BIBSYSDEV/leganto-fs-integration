package fs.user;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Operation {
    ROLLOVER, DELETE, OTHER;

    public static final String DEFAULT_VALUE = OTHER.name();

    @JsonCreator
    public static Operation fromString(String input) {
        if (ROLLOVER.name().equalsIgnoreCase(input)) {
            return ROLLOVER;
        } else if (DELETE.name().equalsIgnoreCase(input)) {
            return DELETE;
        } else {
            return OTHER;
        }
    }

    @JsonValue
    public String toValue() {
        return this.name();
    }

}
