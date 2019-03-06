package fs.ua;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class SemesterCodeTest {

    private static final String AUTUMN_NORWEGIAN = "HØST";
    private static final String SPRING_NORWEGIAN = "VÅR";
    private static final String ARBITRARY_VALUE = "SOMETHING";

    @Test
    public void fromStringShouldReturnAutumnForHost() {
        assertThat(SemesterCode.fromString(AUTUMN_NORWEGIAN), is(equalTo(SemesterCode.AUTUMN)));
    }

    @Test
    public void fromStringShouldReturnSpringForVar() {
        assertThat(SemesterCode.fromString(SPRING_NORWEGIAN), is(equalTo(SemesterCode.SPRING)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void fromStringShouldThrowExceptionForOtherValues() {
        SemesterCode.fromString(ARBITRARY_VALUE);
    }
}
