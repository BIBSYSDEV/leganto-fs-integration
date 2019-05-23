package fs.user;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import leganto.LegantoEntry;

public enum Operation {
  ROLLOVER, DELETE, NORMAL;

  public static final String DEFAULT_VALUE = NORMAL.name();

  @JsonCreator
  public static Operation fromString(String input) {
    if (ROLLOVER.name()
      .equalsIgnoreCase(input)) {
      return ROLLOVER;
    } else if (DELETE.name()
      .equalsIgnoreCase(input)) {
      return DELETE;
    } else {
      return NORMAL;
    }
  }

  @JsonValue
  public String toValue() {
    return this.name();
  }

  @Override
  public String toString() {
    if (this.equals(NORMAL)) {
      return LegantoEntry.EMPTY_STRING;
    } else {
      return toValue();
    }
  }

}
