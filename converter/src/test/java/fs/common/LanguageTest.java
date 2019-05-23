package fs.common;

import static fs.common.Language.EN;
import static fs.common.Language.EN_STRING;
import static fs.common.Language.NB;
import static fs.common.Language.NB_STRING;
import static fs.common.Language.NN;
import static fs.common.Language.NN_STRING;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.junit.Test;

public class LanguageTest {

  private static final String NB_TEXT = "BokmalText";
  private static final String NN_TEXT = "NynorskText";
  private static final String EN_TEXT = "EnglishText";
  private static final String INVALID_STRING = "gr";

  @Test
  public void fromStringShouldReturnNBforNBString() {
    assertThat(Language.fromString(Language.NB_STRING.toLowerCase(Locale.getDefault())), is(equalTo(NB)));
    assertThat(Language.fromString(Language.NB_STRING.toUpperCase(Locale.getDefault())), is(equalTo(NB)));
  }

  @Test
  public void fromStringShouldReturnNNforNNString() {
    assertThat(Language.fromString(NN_STRING.toLowerCase(Locale.getDefault())), is(equalTo(NN)));
    assertThat(Language.fromString(NN_STRING.toUpperCase(Locale.getDefault())), is(equalTo(NN)));
  }

  @Test
  public void fromStringShouldReturnENforENString() {
    assertThat(Language.fromString(EN_STRING.toLowerCase(Locale.getDefault())), is(equalTo(EN)));
    assertThat(Language.fromString(EN_STRING.toUpperCase(Locale.getDefault())), is(equalTo(EN)));
  }

  @Test(expected = IllegalArgumentException.class)
  public void fromStringShouldThrowExceptionForInvalidStrings() {
    Language.fromString(INVALID_STRING);
  }

  @Test
  public void getValueForLanguageShouldReturnTheMostFavorableLanguageValueAvailable() {
    List<LanguageValue> values = new ArrayList<>();
    values.add(new LanguageValue(NB, NB_TEXT));
    values.add(new LanguageValue(NN, NN_TEXT));
    values.add(new LanguageValue(EN, EN_TEXT));
    List<Language> preferences = new ArrayList<>();
    preferences.add(EN);
    preferences.add(NB);
    String expected = EN_TEXT;

    Optional<String> actual = Language.getValueForLanguagePref(values, preferences);
    assertThat(actual.isPresent(), is(equalTo(true)));
    assertThat(actual.get(), is(equalTo(expected)));
  }

  @Test
  public void getValueForLanguagesShouldReturnEmptyIfNoSuitableValueIsFound() {
    List<LanguageValue> values = new ArrayList<>();
    values.add(new LanguageValue(NN, NN_TEXT));

    List<Language> preferences = new ArrayList<>();
    preferences.add(EN);
    preferences.add(NB);
    Optional<String> actual = Language.getValueForLanguagePref(values, preferences);
    assertThat(actual.isPresent(), is(equalTo(false)));
  }

  @Test
  public void toStringShouldReturnTheCorrectStrings() {
    assertThat(NB.toString(), is(equalTo(NB_STRING)));
    assertThat(NN.toString(), is(equalTo(NN_STRING)));
    assertThat(EN.toString(), is(equalTo(EN_STRING)));
  }
}
