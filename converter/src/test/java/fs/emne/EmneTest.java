package fs.emne;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

import fs.common.Language;
import fs.common.LanguageValue;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import utils.IoUtils;

public class EmneTest {

  public static final String EMNE_JSON = "Emne.json";
  public static final String RESOURCES_FOLDER = "ua";
  private final Emne emne;

  public EmneTest() throws IOException {

    String emneJson = IoUtils.resourceAsString(Paths.get(RESOURCES_FOLDER, EMNE_JSON));
    emne = Emne.fromJson(emneJson);
  }

  @Test
  public void fromJsonShouldGenerateAValidObject() {
    assertThat(emne.isValid(), is(equalTo(true)));
  }

  @Test
  public void getAndSetNavnShouldHandleNavn() {
    List<LanguageValue> navn = Collections.singletonList(new LanguageValue(Language.NB, "something"));
    emne.setNavn(navn);
    assertThat(emne.getNavn(), is(equalTo(navn)));
  }
}
