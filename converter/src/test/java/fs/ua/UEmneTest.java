package fs.ua;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

import fs.common.UEmne;
import org.junit.Test;

public class UEmneTest {

  private static final String VERSION = "version";
  private static final String INSTITUTION = "institution";
  private static final String HREF = "href";
  private static final String CODE = "code";
  private final transient UEmne emne;

  public UEmneTest() {
    emne = new UEmne();
    emne.setCode(CODE);
    emne.setHref(HREF);
    emne.setInstitution(INSTITUTION);
    emne.setVersion(VERSION);
  }

  @Test
  public void getHrefShouldReturnTheCorrectVale() {
    assertThat(emne.getHref(), is(equalTo(HREF)));
  }

  @Test
  public void getInstitutionReturnsTheCorrectValue() {
    assertThat(emne.getInstitution(), is(equalTo(INSTITUTION)));
  }

  @Test
  public void getCodenReturnsTheCorrectrValue() {
    assertThat(emne.getCode(), is(equalTo(CODE)));
  }

  @Test
  public void getVersionReturnsTheCorrectrValue() {
    assertThat(emne.getVersion(), is(equalTo(VERSION)));
  }
}
