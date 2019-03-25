package fs.ua;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class UaCourseTitleFormatTest {

    public static final int INVALID_FORMAT = 3;
    private static final int DEFAULT_FORMAT = 1;
    private static final int ALTERNATIVE_FORMAT = 2;
    private static final Integer COURSE_YEAR = 1980;
    private static final String EMNE_KODE = "emneKode";
    private static final String EMNE_NANV = "emneNavn";
    private static final String UA_NANV = "uaNavn";
    private static final SemesterCode SEMESTER_CODE = SemesterCode.AUTUMN;

    @Test(expected = IllegalArgumentException.class)
    public void fromIntegerShouldOnlyAcceptPredefinedValues() {
        UaCourseTitleFormat.fromInteger(INVALID_FORMAT);
    }

    @Test
    public void formatUAemneNanvShouldReturnDefaultFormat() {
        String actualString = UaCourseTitleFormat.fromInteger(DEFAULT_FORMAT)
            .formatUaCourseTitle(UA_NANV, EMNE_NANV, EMNE_KODE, SEMESTER_CODE, COURSE_YEAR);
        String expectedString = "emneNavn - uaNavn - emneKode HØST 1980";
        assertThat(actualString, is(equalTo(expectedString)));
    }

    @Test(expected = NullPointerException.class)
    public void formatUAemneNavnShouldThrowNullPointerExceptionForMissingUANavn() {
        UaCourseTitleFormat.fromInteger(DEFAULT_FORMAT)
            .formatUaCourseTitle(null, EMNE_NANV, EMNE_KODE, SEMESTER_CODE, COURSE_YEAR);
    }

    @Test(expected = NullPointerException.class)
    public void formatUAemneNavnShouldThrowNullPointerExceptionForMissingEmneNavn() {
        UaCourseTitleFormat.fromInteger(DEFAULT_FORMAT)
            .formatUaCourseTitle(UA_NANV, null, EMNE_KODE, SEMESTER_CODE, COURSE_YEAR);
    }

    @Test(expected = NullPointerException.class)
    public void formatUAemneNavnShouldThrowNullPointerExceptionForMissingEmneKode() {
        UaCourseTitleFormat.fromInteger(DEFAULT_FORMAT)
            .formatUaCourseTitle(UA_NANV, EMNE_NANV, null, SEMESTER_CODE, COURSE_YEAR);
    }

    @Test(expected = NullPointerException.class)
    public void formatUAemneNavnShouldThrowNullPointerExceptionForMissingSemesterCode() {
        UaCourseTitleFormat.fromInteger(DEFAULT_FORMAT)
            .formatUaCourseTitle(UA_NANV, EMNE_NANV, EMNE_KODE, null, COURSE_YEAR);
    }

    @Test
    public void formatUAemneNanvAlternativeFormatShouldReturnAlternativeFormat() {
        String actualString = UaCourseTitleFormat.fromInteger(ALTERNATIVE_FORMAT)
            .formatUaCourseTitle(UA_NANV, EMNE_NANV, EMNE_KODE, SEMESTER_CODE, COURSE_YEAR);
        String expectedString = "emneKode - emneNavn - uaNavn (HØST 1980)";
        assertThat(actualString, is(equalTo(expectedString)));
    }
}
