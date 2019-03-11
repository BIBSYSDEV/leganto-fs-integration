package fs.common;

import static fs.common.Language.EN;
import static fs.common.Language.EN_STRING;
import static fs.common.Language.NB;
import static fs.common.Language.NB_STRING;
import static fs.common.Language.NN;
import static fs.common.Language.NN_STRING;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

import org.junit.jupiter.api.Test;

class PreferredLanguageTest {

    @Test
    public void fromStringShouldReturnRightEnumforStrings() {
        assertThat(Language.fromString(NB_STRING.toLowerCase()), is(equalTo(Language.NB)));
        assertThat(Language.fromString(NN_STRING.toLowerCase()), is(equalTo(NN)));
        assertThat(Language.fromString(EN_STRING.toLowerCase()), is(equalTo(EN)));
    }

    @Test
    public void fromStringShouldReturnRightEnumforUpperCaseStrings() {
        assertThat(Language.fromString(NB_STRING.toUpperCase()), is(equalTo(Language.NB)));
        assertThat(Language.fromString(NN_STRING.toUpperCase()), is(equalTo(NN)));
        assertThat(Language.fromString(EN_STRING.toUpperCase()), is(equalTo(EN)));
    }

    @Test
    public void toStringShouldReturnTheCorrectValues() {
        assertThat(NB.toString(), is(equalTo(NB_STRING)));
        assertThat(NN.toString(), is(equalTo(NN_STRING)));
        assertThat(EN.toString(), is(equalTo(EN_STRING)));
    }
}
