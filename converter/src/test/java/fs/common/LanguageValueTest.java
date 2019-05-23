package fs.common;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class LanguageValueTest {

  private static final String VALUE = "NorwegianText";
  private static final String DIFFERENT_CLASS_OBJECT = "anotherOBject";
  LanguageValue languageValue = new LanguageValue(Language.NB, VALUE);

  @Test
  public void getLangShouldNotReturnNull() {
    assertThat(languageValue.getLang(), is(equalTo(Language.NB)));
  }

  @Test
  public void setLang() {
    LanguageValue languageValue = new LanguageValue();
    languageValue.setLang(Language.EN);
    assertThat(languageValue.getLang(), is(equalTo(Language.EN)));
  }

  @Test
  public void getValue() {
    assertThat(languageValue.getValue(), is(equalTo(VALUE)));
  }

  @Test
  public void setValue() {
    LanguageValue languageValue = new LanguageValue();
    languageValue.setValue(VALUE);
    assertThat(languageValue.getValue(), is(equalTo(VALUE)));
  }

  @Test
  public void equalsShouldReturnTrueForObjectsWithSameValues() {
    LanguageValue newLanguageValue = new LanguageValue(Language.NB, VALUE);
    assertThat(newLanguageValue.equals(languageValue), is(equalTo(true)));
    assertThat(languageValue.equals(languageValue), is(equalTo(true)));
    assertThat(languageValue.equals(DIFFERENT_CLASS_OBJECT), is(equalTo(false)));
  }

  @Test
  public void hashCodeForEqualObjectsShouldBeEqual() {
    LanguageValue newLanguageValue = new LanguageValue(Language.NB, VALUE);
    assertThat(languageValue.hashCode(), is(equalTo(newLanguageValue.hashCode())));
  }
}
