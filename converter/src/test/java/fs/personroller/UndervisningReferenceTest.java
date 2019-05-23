package fs.personroller;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class UndervisningReferenceTest {

  public static final String ARBITRARY_HREF = "someRef";

  @Test
  public void setRefAndHrefShouldEditHref() {
    UndervisningReference und = new UndervisningReference();
    assertThat(und.getHref(), is(equalTo(null)));
    und.setHref(ARBITRARY_HREF);
    assertThat(und.getHref(), is(equalTo(ARBITRARY_HREF)));
  }

  @Test
  public void equalsShouldBeDeepEqual() {
    UndervisningReference und1 = new UndervisningReference(ARBITRARY_HREF);
    UndervisningReference und2 = new UndervisningReference(ARBITRARY_HREF);
    assertThat(und1, is(equalTo(und2)));
  }

  @Test
  public void hashCodeShouldBeAHashCodeOfTheFields() {
    UndervisningReference und1 = new UndervisningReference(ARBITRARY_HREF);
    UndervisningReference und2 = new UndervisningReference(ARBITRARY_HREF);
    assertThat(und1.hashCode(), is(equalTo(und2.hashCode())));
  }
}
