package leganto;

import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

import fs.ua.SemesterCode;
import fs.ua.UaEmne;
import fs.ua.UaSemester;
import fs.ua.UaUndervisning;
import fs.ua.UndervisningsAktivitet;
import org.junit.Test;

public class UaLegantoEntryTest {

    private static final String HREF = "href";
    private static final String EMNE_HREF = "emneHref";
    private static final String EMNE_CODE = "emneCode";
    private static final String EMNE_INSITUTION = "emneInsitution";
    private static final String EMNE_VERSION = "emneVersion";
    private static final String UNDERVISNING_HREF = "undervingnHref";
    private static final String UA_SEMESTER_HREF = "uaSemesterHref";

    private static final Integer UASEMESTER_YEAR = 1980;
    private UaLegantoEntry entry;

    public UaLegantoEntryTest() {

        UaEmne uaEmne = new UaEmne().setCode(EMNE_CODE).setHref(EMNE_HREF).setInstitution(EMNE_INSITUTION)
            .setVersion(EMNE_VERSION);
        UaSemester uaSemester = new UaSemester()
            .setHref(UA_SEMESTER_HREF)
            .setYear(UASEMESTER_YEAR)
            .setSemesterCode(SemesterCode.AUTUMN_NORWEGIAN);
        UaUndervisning undervisning = new UaUndervisning()
            .setHref(UNDERVISNING_HREF)
            .setEmne(uaEmne)
            .setUaSemester(uaSemester);
        UndervisningsAktivitet ua = new UndervisningsAktivitet().setUndervisning(undervisning);
        entry = new UaLegantoEntry(ua);
    }

    @Test
    public void toStringShouldNotReturnEmptyString() {
        assertThat(entry.toString(), is(not(emptyString())));
    }

    @Test
    public void getCourseCodeShouldReturn() {
        String expected = String.join("_", UaLegantoEntry.PREFIX, EMNE_CODE, EMNE_VERSION, UASEMESTER_YEAR.toString(),
            SemesterCode.AUTUMN_NORWEGIAN);

        String actual = entry.getCourseCode();
        assertThat(actual, is(equalTo(expected)));
    }
}
