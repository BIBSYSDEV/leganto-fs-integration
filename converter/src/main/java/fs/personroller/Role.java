package fs.personroller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import fs.common.Validable;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Role extends Validable {

  @JsonProperty("kode")
  private String code;

  public String getCode() {
    return code;
  }

  public Role setCode(String code) {
    this.code = code;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Role)) {
      return false;
    }
    Role role = (Role) o;
    return Objects.equals(getCode(), role.getCode());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getCode());
  }
}
