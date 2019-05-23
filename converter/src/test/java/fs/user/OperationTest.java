package fs.user;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Locale;

import org.junit.Test;

public class OperationTest {

  public static final String ARBITRARY_STRING = "arbitrary";
  private static final String ROLLOVER_OPERATION_STRING = "rollover";
  private static final String DELETE_OPERATION_STRING = "delete";

  @Test
  public void fromStringShouldParseOperationRollover() {
    assertThat(Operation.fromString(ROLLOVER_OPERATION_STRING.toUpperCase(Locale.getDefault())),
      is(equalTo(Operation.ROLLOVER)));
    assertThat(Operation.fromString(ROLLOVER_OPERATION_STRING.toLowerCase(Locale.getDefault())),
      is(equalTo(Operation.ROLLOVER)));
  }

  @Test
  public void fromStringShouldParseOperationDelete() {
    assertThat(Operation.fromString(DELETE_OPERATION_STRING.toUpperCase(Locale.getDefault())),
      is(equalTo(Operation.DELETE)));
    assertThat(Operation.fromString(DELETE_OPERATION_STRING.toLowerCase(Locale.getDefault())),
      is(equalTo(Operation.DELETE)));
  }

  @Test
  public void fromStringShouldReturnOtherForNullStringParseOperationDelete() {
    assertThat(Operation.fromString(null), is(equalTo(Operation.NORMAL)));

  }

  @Test
  public void fromStringShouldReturnOtherForArbitraryStringParseOperationDelete() {
    assertThat(Operation.fromString(ARBITRARY_STRING), is(equalTo(Operation.NORMAL)));

  }
}
