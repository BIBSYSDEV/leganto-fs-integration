package fs.user;

import static fs.common.Language.EN;
import static fs.common.Language.NB;
import static fs.common.Language.NN;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.junit.BeforeClass;
import org.junit.Test;
import utils.IoUtils;
import utils.JsonUtils;

public class UserInputTest {

    private static final String PARTICIPANTS_FILE_FIELD = "participants_file";
    private static final String OPERATION_FIELD = "operation";
    private static final String USER_INPUT_TEST_RESOURCES = "userinput";
    private static final String PARTICIPANTS_RESOURCE_FILE = "participantsNumber.csv";
    private static final String ROLLOVER_OPERATION = "rollover";
    private static final String ARBITRARY_OPERATION = "arbitrary";
    private static final String DELETE_OPERATION = "delete";
    private static final String CAMPUS_PARTICIPANTS_FIELD = "campus_participants";
    private static final String CAMPUS_PARTICIPANT_1 = "campus1";
    private static final String CAMPUS_PARTICIPANT_2 = "campus2";
    private static final String LANGUAGE_ORDER_FIELD = "language_order";
    private static final String RESORUCE_FILE_COURSE_CODE = "courseCode";
    private static final Integer RESOURCE_FILE_PARTICIPANTS_NUMBER = 123;
    private static final int PREFIX = 0;
    private static final int SUFFIX = 1;
    private static String PARTICIPANTS_GENERATED_FILE;

    @BeforeClass
    public static void temporaryFileForParticipants() throws IOException {
        String participants = IoUtils
            .resourceAsString(Paths.get(USER_INPUT_TEST_RESOURCES, PARTICIPANTS_RESOURCE_FILE));

        String[] splitFilename = PARTICIPANTS_RESOURCE_FILE.split("\\.");
        File participantsTempFile = Files
            .createTempFile(splitFilename[PREFIX], splitFilename[SUFFIX]).toFile();
        participantsTempFile.deleteOnExit();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(participantsTempFile))) {
            writer.write(participants);
        }
        PARTICIPANTS_GENERATED_FILE = participantsTempFile.getAbsolutePath();
    }

    @Test
    public void getOperationShouldReturnOtherAsDefaultValueWhenOperationFieldIsMissing()
        throws JsonProcessingException {
        ObjectNode userInputJson = JsonUtils.newObjectNode();
        userInputJson.put(PARTICIPANTS_FILE_FIELD, "participants.csv");
        UserInput userInput = JsonUtils.readValue(userInputJson, UserInput.class);
        assertThat(userInput.getOperation(), is(equalTo(Operation.OTHER)));
    }

    @Test
    public void getOperationShouldReturnOtherWhenOperationValueIsNotRolloverOrDelete()
        throws JsonProcessingException {
        ObjectNode userInputJson = JsonUtils.newObjectNode();
        userInputJson.put(PARTICIPANTS_FILE_FIELD, PARTICIPANTS_GENERATED_FILE);
        userInputJson.put(OPERATION_FIELD, ARBITRARY_OPERATION);
        UserInput userInput = JsonUtils.readValue(userInputJson, UserInput.class);
        assertThat(userInput.getOperation(), is(equalTo(Operation.OTHER)));
    }

    @Test
    public void getOperationShouldReturnRolloverWhenOperationValueIsRollover()
        throws JsonProcessingException {
        ObjectNode userInputJson = JsonUtils.newObjectNode();
        userInputJson.put(PARTICIPANTS_FILE_FIELD, PARTICIPANTS_GENERATED_FILE);
        userInputJson.put(OPERATION_FIELD, ROLLOVER_OPERATION);
        UserInput userInput = JsonUtils.readValue(userInputJson, UserInput.class);
        assertThat(userInput.getOperation(), is(equalTo(Operation.ROLLOVER)));
    }

    @Test
    public void getOperationShouldReturnDeleteWhenOperationValueIsDelete()
        throws JsonProcessingException {
        ObjectNode userInputJson = JsonUtils.newObjectNode();
        userInputJson.put(PARTICIPANTS_FILE_FIELD, PARTICIPANTS_GENERATED_FILE);
        userInputJson.put(OPERATION_FIELD, DELETE_OPERATION);
        UserInput userInput = JsonUtils.readValue(userInputJson, UserInput.class);
        assertThat(userInput.getOperation(), is(equalTo(Operation.DELETE)));
    }

    @Test
    public void jsonFieldsShouldBeParsedCorrectly() throws IOException {
        ObjectNode userInputJson = JsonUtils.newObjectNode();
        userInputJson.put(PARTICIPANTS_FILE_FIELD, PARTICIPANTS_GENERATED_FILE);

        ArrayNode campusParticipants = JsonUtils.newArrayNode();
        campusParticipants.add(CAMPUS_PARTICIPANT_1);
        campusParticipants.add(CAMPUS_PARTICIPANT_2);
        userInputJson.set(CAMPUS_PARTICIPANTS_FIELD, campusParticipants);

        ArrayNode laguageOrder = JsonUtils.newArrayNode();
        laguageOrder.add(NN.toString());
        laguageOrder.add(EN.toString());
        laguageOrder.add(NB.toString());

        userInputJson.set(LANGUAGE_ORDER_FIELD, laguageOrder);
        UserInput userInput = JsonUtils.readValue(userInputJson, UserInput.class).initPartcipants();
        assertThat(userInput.getOperation(), is(equalTo(Operation.OTHER)));
        assertThat(userInput.getCampuses(),
            containsInAnyOrder(CAMPUS_PARTICIPANT_1, CAMPUS_PARTICIPANT_2));
        assertThat(userInput.getLanguageOrder(), contains(NN, EN, NB));
        assertThat(userInput.getParticipants(RESORUCE_FILE_COURSE_CODE).isPresent(), is(equalTo(
            true)));
        assertThat(userInput.getParticipantsFilename(), is(equalTo(PARTICIPANTS_GENERATED_FILE)));

        assertThat(userInput.getParticipants(RESORUCE_FILE_COURSE_CODE).get(), is(equalTo(
            RESOURCE_FILE_PARTICIPANTS_NUMBER.toString())));

    }

}