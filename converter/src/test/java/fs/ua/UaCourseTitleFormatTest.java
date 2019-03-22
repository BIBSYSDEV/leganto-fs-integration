package fs.ua;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class UaCourseTitleFormatTest {

    private static final int DEFAULT_FORMAT = 1;
    private static final int ALTERNATIVE_FORMAT = 2;
    private static final Integer COURSE_YEAR = 1980;
    private static final String EMNE_KODE = "emneKode";
    private static final String EMNE_NANV = "emneNavn";
    private static final String UA_NANV = "uaNavn";

    private static final SemesterCode SEMESTER_CODE = SemesterCode.AUTUMN;

    @Test
    public void formatUAemneNanvShouldReturnDefaultFormat() {
        String actualString = UaCourseTitleFormat.fromInteger(DEFAULT_FORMAT)
            .formatUaCourseTitle(UA_NANV, EMNE_NANV, EMNE_KODE, SEMESTER_CODE, COURSE_YEAR);
        String expectedString = "emneNavn - uaNavn - emneKode HØST 1980";
        assertThat(actualString, is(equalTo(expectedString)));
    }

    @Test
    public void formatUAemneNanvAlternativeFormatShouldReturnAlternativeFormat() {
        String actualString = UaCourseTitleFormat.fromInteger(ALTERNATIVE_FORMAT)
            .formatUaCourseTitle(UA_NANV, EMNE_NANV, EMNE_KODE, SEMESTER_CODE, COURSE_YEAR);
        String expectedString = "emneKode - emneNavn - uaNavn (HØST 1980)";
        assertThat(actualString, is(equalTo(expectedString)));
    }
}
