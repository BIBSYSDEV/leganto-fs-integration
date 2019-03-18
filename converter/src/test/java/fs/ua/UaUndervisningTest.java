package fs.ua;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;

import java.io.IOException;
import java.nio.file.Paths;
import org.junit.Test;
import utils.IoUtils;
import utils.JsonUtils;

public class UaUndervisningTest {

    private static final String UA_RESOURCES = "ua";
    private static final String SAMPLE_UA_FILE = "UA.json";
    private static final Integer INPUT_FILE_TERMIN_NUMMER = 1;
    private final UndervisningsAktivitet ua;

    public UaUndervisningTest() throws IOException {
        String uaJson = IoUtils.resourceAsString(Paths.get(UA_RESOURCES, SAMPLE_UA_FILE));
        ua = JsonUtils.mapper.readValue(uaJson, UndervisningsAktivitet.class);
    }

    @Test
    public void getHrefShouldNotReturnEmpty() {
        assertThat(ua.getUndervisning().getHref(), is(not(emptyString())));
    }

    @Test
    public void getEmneShouldBeTheSameAsUndervisingsEmne() {
        assertThat(ua.getEmne(), is(equalTo(ua.getUndervisning().getEmne())));
    }

    @Test
    public void getUaSemesterShouldBeTheSameAsUndervinginsSemester() {
        assertThat(ua.getSemester(),
            is(equalTo(ua.getUndervisning().getUaSemester())));
    }

    @Test
    public void terminNumberShouldBeParsedCorrectly() {
        assertThat(ua.getUndervisning().getTerminnumer(), is(equalTo(INPUT_FILE_TERMIN_NUMMER)));
    }
}
