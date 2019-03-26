package fs.emne;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Objects;

public class OrganizationEntityEmneEntry {

    @JsonProperty
    private String href;

    @JsonProperty
    private Type type;

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof OrganizationEntityEmneEntry)) {
            return false;
        }
        OrganizationEntityEmneEntry that = (OrganizationEntityEmneEntry) o;

        return
            Objects.equals(getHref(), that.getHref())
                && getType() == that.getType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHref(), getType());
    }

    private enum Type {
        STUDIE, ADMINISTRATIV;

        @JsonCreator
        public static Type fromString(String input) {

            if (STUDIE.name().equalsIgnoreCase(input)) {
                return STUDIE;
            } else {
                return ADMINISTRATIV;
            }
        }

        @JsonValue
        public String toString() {
            return this.name();
        }

    }
}
