package fs.ua;

import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Paths;
import org.junit.Test;
import utils.IoUtils;
import utils.JsonUtils;

public class UndervisningsAktivitetTest {



    private String uaJson= IoUtils.resourceAsString(Paths.get("ua","UA.json"));

    @Test
    public void uaShouldParseEmneField() throws IOException {
        UndervisningsAktivitet ua= JsonUtils.mapper.readValue(uaJson,UndervisningsAktivitet.class);
        assertThat(ua.getUndervisning().getEmne().getCode(),is(not(emptyString())));

    }

}
