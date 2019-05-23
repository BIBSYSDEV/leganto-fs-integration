package fs.personroller;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

import org.junit.Test;

public class RoleTest {

  public static final String ARBITRARY_CODE = "code";

  @Test
  public void setAndGetShouldTargetTheRightFields() {
    Role role = new Role();
    assertThat(role.getCode(), is(equalTo(null)));
    role.setCode(ARBITRARY_CODE);
    assertThat(role.getCode(), is(equalTo(ARBITRARY_CODE)));
  }

  @Test
  public void equalsShouldBeDeepEqual() {
    Role role = new Role().setCode(ARBITRARY_CODE);
    Role anotherRole = new Role().setCode(ARBITRARY_CODE);
    assertThat(role, is(equalTo(anotherRole)));
  }

  @Test
  public void hashCodeShouldBeAHashCodeOfThefields() {
    Role role = new Role().setCode(ARBITRARY_CODE);
    Role anotherRole = new Role().setCode(ARBITRARY_CODE);
    assertThat(role.hashCode(), is(equalTo(anotherRole.hashCode())));
  }
}
