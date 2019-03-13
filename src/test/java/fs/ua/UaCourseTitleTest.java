package fs.ua;

import static fs.ua.UaCourseTitle.DEFAULT;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class UaCourseTitleTest {

    private static final int DEFAULT_FORMAT = 1;
    private static final int NON_DEFAULT_FORMAT = 2;
    private static final Integer COURSE_YEAR = 1980;
    private static final String EMNE_KODE = "emneKode";
    private static final String EMNE_NANV = "emneNanv";
    private static final String UA_NANV = "uaNanv";
    private static final String DELIMITER = "_";
    private static final SemesterCode SEMESTER_CODE = SemesterCode.AUTUMN;

    @Test
    public void formatUAemneNanvShouldReturnDefaultFormat() {
        String actualString = DEFAULT.formatUaCourseTitle(UA_NANV, EMNE_NANV, EMNE_KODE, SEMESTER_CODE, COURSE_YEAR);
        String expectedString = String
            .join(DELIMITER, EMNE_NANV, UA_NANV, EMNE_KODE, SEMESTER_CODE.toString(), COURSE_YEAR.toString());
        assertThat(actualString, is(equalTo(expectedString)));
    }
}
