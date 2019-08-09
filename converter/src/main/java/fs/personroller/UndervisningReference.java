package fs.personroller;

import com.fasterxml.jackson.annotation.JsonProperty;
import fs.common.Validable;

import java.util.Objects;

public class UndervisningReference extends Validable {

    @JsonProperty("href")
    private String href;

    //for json
    public UndervisningReference() {
        super();
    }

    public UndervisningReference(String href) {
        super();
        this.href = href;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UndervisningReference)) {
            return false;
        }
        UndervisningReference that = (UndervisningReference) o;
        return Objects.equals(getHref(), that.getHref());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHref());
    }
}
