package fs.user;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.file.Paths;
import org.junit.Test;
import utils.IoUtils;

public class ParticipantsFileTest {

    private static final String SAMPLE_PARTICIPANTS_FILE = "participantsNumber.csv";
    private static final String USERINPUT_RESOURCE_FOLDDER = "userinput";
    private static final String COURSE_CODE_KEY_IN_RESOURCE_FILE = "courseCode";
    private static final String NON_EXISTING_COURSE_CODE_KEY_IN_RESOURCE_FILE = "lskjdf";
    private static final String VALUE_IN_FILE = "123";
    private ParticipantsFile participantsFile;


    public ParticipantsFileTest() throws FileNotFoundException {
        InputStream input = IoUtils
            .resourceAsStream(Paths.get(USERINPUT_RESOURCE_FOLDDER, SAMPLE_PARTICIPANTS_FILE));
        participantsFile = new ParticipantsFile(input).init();

    }

    @Test
    public void getParcticipantsNumberShouldReturnAnOptionalWithTheRespectiveValueInTheFile() {
        assertThat(participantsFile.getPartcipants(COURSE_CODE_KEY_IN_RESOURCE_FILE).isPresent(),
            is(true));
        assertThat(participantsFile.getPartcipants(COURSE_CODE_KEY_IN_RESOURCE_FILE).get(),
            is(equalTo(
                VALUE_IN_FILE)));
    }

    @Test
    public void getParcticipantsNumberShouldReturnAnEmptyOptionalForNonExistingKeys() {
        assertThat(participantsFile.getPartcipants(NON_EXISTING_COURSE_CODE_KEY_IN_RESOURCE_FILE)
                .isPresent(),
            is(false));

    }
}