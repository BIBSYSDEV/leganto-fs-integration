package fs.ua;

import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.nio.file.Paths;
import org.junit.Test;
import utils.IoUtils;
import utils.JsonUtils;

public class UndervisningsAktivitetTest {

    private static final SemesterCode INPUT_FILE_SEMESTER = SemesterCode.AUTUMN;
    private static final int INPUT_FILE_YEAR = 1999;
    private static final String INPUT_FILE_AKTIVITET_VALUE = "MEAKB00000";
    private static final String INPUT_FILE_SEMESTER_HREF = "https://api.fellesstudentsystem.no/semestre/1999,H%C3%98ST";

    private String uaJson = IoUtils.resourceAsString(Paths.get("ua", "UA.json"));

    @Test
    public void uaShouldParseEmneField() throws IOException {
        UndervisningsAktivitet ua = JsonUtils.mapper
            .readValue(uaJson, UndervisningsAktivitet.class);
        assertThat(ua.getUndervisning().getEmne().getCode(), is(not(emptyString())));
    }

    @Test
    public void undervsigingsAktiviterShouldBeAbleToParseItsOwnJson() throws IOException {
        UndervisningsAktivitet ua = JsonUtils.mapper
            .readValue(uaJson, UndervisningsAktivitet.class);
        String newJson = JsonUtils.write(ua);
        UndervisningsAktivitet newUA = JsonUtils.readValue(newJson, UndervisningsAktivitet.class);
        assertThat(newUA, is(equalTo(ua)));

    }

    @Test
    public void setUndervisningShouldSetTheUnderVisningField() {
        UaUndervisning uau = new UaUndervisning();
        UndervisningsAktivitet ua = new UndervisningsAktivitet().setUndervising(uau);
        assertThat(ua.getUndervisning(), is(not(equalTo(null))));
    }

    @Test
    public void fromJsonShouldParseAJsonObject() throws IOException {
        UndervisningsAktivitet ua = UndervisningsAktivitet.fromJson(uaJson);
        assertThat(ua.getUndervisning().getUaSemester().getYear(), is(equalTo(INPUT_FILE_YEAR)));
        assertThat(ua.getUndervisning().getUaSemester().getSemesterCode(),
            is(equalTo(INPUT_FILE_SEMESTER)));
        assertThat(ua.getUndervisning().getUaSemester().getHref(),
            is(equalTo(INPUT_FILE_SEMESTER_HREF)));
        assertThat(ua.getAktivitet(), is(equalTo(INPUT_FILE_AKTIVITET_VALUE)));
    }
}
