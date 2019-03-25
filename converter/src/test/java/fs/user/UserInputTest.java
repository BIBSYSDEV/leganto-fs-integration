package fs.user;

import static fs.common.Language.EN;
import static fs.common.Language.NB;
import static fs.common.Language.NN;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static utils.JsonUtils.readValue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import fs.common.Validable;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.jws.soap.SOAPBinding.Use;
import org.junit.BeforeClass;
import org.junit.Test;
import utils.IoUtils;
import utils.JsonUtils;

public class UserInputTest {

    private static final String CAMPUS_PARTICIPANTS_FILE_FIELD = "campus_participants_file";
    private static final String NUMBER_OF_PARTICIPANTS_FILE_FIELD = "number_of_participants_file";
    private static final String OPERATION_FIELD = "operation";
    private static final String USER_INPUT_TEST_RESOURCES = "userinput";
    private static final String CAMPUS_PARTICIPANTS_RESOURCE_FILE = "campusParticipants.csv";
    private static final String NUMBER_OF_PARTICIPANTS_RESOURCE_FILE = "numberOfParticipants.csv";
    private static final String INCLUDE_NUMBER_OF_PARTICIPANTS_FIELD = "include_number_of_participants";

    private static final String ROLLOVER_OPERATION = "rollover";
    private static final String ARBITRARY_OPERATION = "arbitrary";
    private static final String DELETE_OPERATION = "delete";
    private static final String INCLUDE_CAMPUS_PARTICIPANTS_FIELD = "include_campus_participants";
    private static final boolean INCLUDE_CAMPUS_PARTICIPANTS_VALUE = true;

    private static final String LANGUAGE_ORDER_FIELD = "language_order";
    private static final String RESORUCE_FILE_COURSE_CODE = "courseCode";
    private static final String NON_EXISTING_COURSE_CODE = RESORUCE_FILE_COURSE_CODE + "error";
    private static final String CAMPUS_PARTICIPANTS_RESOURCE_VALUE = "GLOS|10,DRAG|20";
    private static final int PREFIX = 0;
    private static final int SUFFIX = 1;

    private static final boolean INCLUDE_NUMBER_OF_PARTICIPANTS_VALUE = true;
    private static final String NUMBER_OF_PARTICIPANTS_RESOURCE_VALUE = "123";
    public static final String NON_EXISTING_FILE = "hello.world";
    private static String NUMBER_OF_PARTICIPANTS_GENERATED_FILE;
    private static String CAMPUS_PARTICIPANTS_GENERATED_FILE;

    @BeforeClass
    public static void temporaryCampusParticipantsFile() throws IOException {
        String participants = IoUtils
            .resourceAsString(Paths.get(USER_INPUT_TEST_RESOURCES, CAMPUS_PARTICIPANTS_RESOURCE_FILE));

        File participantsTempFile = createTemporaryFile(CAMPUS_PARTICIPANTS_RESOURCE_FILE);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(participantsTempFile))) {
            writer.write(participants);
        }
        CAMPUS_PARTICIPANTS_GENERATED_FILE = participantsTempFile.getAbsolutePath();
    }

    @BeforeClass
    public static void temporaryNumberOfParticipantsFile() throws IOException {
        String partipants = IoUtils
            .resourceAsString(Paths.get(USER_INPUT_TEST_RESOURCES, NUMBER_OF_PARTICIPANTS_RESOURCE_FILE));
        File participantsTempFile = createTemporaryFile(NUMBER_OF_PARTICIPANTS_RESOURCE_FILE);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(participantsTempFile))) {
            writer.write(partipants);
        }

        NUMBER_OF_PARTICIPANTS_GENERATED_FILE = participantsTempFile.getAbsolutePath();
    }

    private static File createTemporaryFile(String filename) throws IOException {
        String[] splitFilename = filename.split("\\.");
        File participantsTempFile = Files
            .createTempFile(splitFilename[PREFIX], splitFilename[SUFFIX]).toFile();
        participantsTempFile.deleteOnExit();
        return participantsTempFile;
    }

    @Test
    public void getOperationShouldReturnOtherAsDefaultValueWhenOperationFieldIsMissing()
        throws JsonProcessingException {
        ObjectNode userInputJson = JsonUtils.newObjectNode();
        userInputJson.put(CAMPUS_PARTICIPANTS_FILE_FIELD, "participants.csv");
        UserInput userInput = readValue(userInputJson, UserInput.class);
        assertThat(userInput.getOperation(), is(equalTo(Operation.NORMAL)));
    }

    @Test
    public void getOperationShouldReturnOtherWhenOperationValueIsNotRolloverOrDelete()
        throws JsonProcessingException {
        ObjectNode userInputJson = JsonUtils.newObjectNode();
        userInputJson.put(CAMPUS_PARTICIPANTS_FILE_FIELD, CAMPUS_PARTICIPANTS_GENERATED_FILE);
        userInputJson.put(OPERATION_FIELD, ARBITRARY_OPERATION);
        UserInput userInput = readValue(userInputJson, UserInput.class);
        assertThat(userInput.getOperation(), is(equalTo(Operation.NORMAL)));
    }

    @Test
    public void getOperationShouldReturnRolloverWhenOperationValueIsRollover()
        throws JsonProcessingException {
        ObjectNode userInputJson = JsonUtils.newObjectNode();
        userInputJson.put(CAMPUS_PARTICIPANTS_FILE_FIELD, CAMPUS_PARTICIPANTS_GENERATED_FILE);
        userInputJson.put(OPERATION_FIELD, ROLLOVER_OPERATION);
        UserInput userInput = readValue(userInputJson, UserInput.class);
        assertThat(userInput.getOperation(), is(equalTo(Operation.ROLLOVER)));
    }

    @Test
    public void getOperationShouldReturnDeleteWhenOperationValueIsDelete()
        throws JsonProcessingException {
        ObjectNode userInputJson = JsonUtils.newObjectNode();
        userInputJson.put(CAMPUS_PARTICIPANTS_FILE_FIELD, CAMPUS_PARTICIPANTS_GENERATED_FILE);
        userInputJson.put(OPERATION_FIELD, DELETE_OPERATION);
        UserInput userInput = readValue(userInputJson, UserInput.class);
        assertThat(userInput.getOperation(), is(equalTo(Operation.DELETE)));
    }

    @Test
    public void getNumberOfParticipantsShouldReturnTheRespectiveEntryFromTheUserFileIfEntryExists() throws IOException {
        ObjectNode userInputJson = inputWithBothFiles();
        UserInput userInput = readValue(userInputJson, UserInput.class).initFiles();
        assertThat(userInput.getNumberOfParticipants(RESORUCE_FILE_COURSE_CODE).isPresent(), is(equalTo(true)));
        assertThat(userInput.getNumberOfParticipants(RESORUCE_FILE_COURSE_CODE).get(), is(equalTo(
            NUMBER_OF_PARTICIPANTS_RESOURCE_VALUE)));
    }

    @Test
    public void getNumberOfParticipantsShouldReturnEmptyifTheCourseCodeDoesNotExist() throws IOException {
        ObjectNode userInputJson = inputWithBothFiles();
        UserInput userInput = readValue(userInputJson, UserInput.class).initFiles();
        assertThat(userInput.getNumberOfParticipants(NON_EXISTING_COURSE_CODE).isPresent(), is(equalTo(false)));
    }

    @Test
    public void getNumberOfParticipantsShouldReturnEmptyIfTheDecisionFieldIsSetToFalse() throws IOException {
        ObjectNode userInputJson = inputWithBothFiles();
        userInputJson.put(INCLUDE_NUMBER_OF_PARTICIPANTS_FIELD, false);
        UserInput userInput = readValue(userInputJson, UserInput.class).initFiles();
        assertThat(userInput.getNumberOfParticipants(RESORUCE_FILE_COURSE_CODE).isPresent(), is(equalTo(false)));
    }

    @Test
    public void getCampusParticipantsShouldReturnTheRespectiveEntryfromTheUserFileIfEntryExists() throws IOException {
        ObjectNode userInputJson = inputWithBothFiles();
        UserInput userInput = readValue(userInputJson, UserInput.class).initFiles();
        assertThat(userInput.getCampusParticipants(RESORUCE_FILE_COURSE_CODE).isPresent(), is(equalTo(true)));
        assertThat(userInput.getCampusParticipants(RESORUCE_FILE_COURSE_CODE).get(), is(equalTo(
            CAMPUS_PARTICIPANTS_RESOURCE_VALUE)));
    }

    @Test
    public void getCampusParticipantsShouldReturnEmptyifTheCourseCodeDoesNotExist() throws IOException {
        ObjectNode userInputJson = inputWithBothFiles();
        UserInput userInput = readValue(userInputJson, UserInput.class).initFiles();
        assertThat(userInput.getCampusParticipants(NON_EXISTING_COURSE_CODE).isPresent(), is(equalTo(false)));
    }

    @Test
    public void getcampusOfParticipantsShouldReturnEmptyIfTheDecisionFieldIsSetToFalse() throws IOException {
        ObjectNode userInputJson = inputWithBothFiles();
        userInputJson.put(INCLUDE_CAMPUS_PARTICIPANTS_FIELD, false);
        UserInput userInput = readValue(userInputJson, UserInput.class).initFiles();
        assertThat(userInput.getCampusParticipants(RESORUCE_FILE_COURSE_CODE).isPresent(), is(equalTo(false)));
    }


    @Test(expected = NoSuchFileException.class)
    public void initFilesShouldThrowExceptionIfFilesDoNotExistAndTheDecisionFieldAIsTrue() throws IOException {
        ObjectNode json=inputWithBothFiles();
        UserInput userInput=readValue(json,UserInput.class);
        userInput.setNumberOfParticipantsFilename(NON_EXISTING_FILE);
        userInput.initFiles();

    }

    @Test(expected = NoSuchFileException.class)
    public void initFilesShouldThrowExceptionIfFilesDoNotExistAndTheDecisionFieldBIsTrue() throws IOException {
        ObjectNode json=inputWithBothFiles();
        UserInput userInput=readValue(json,UserInput.class);
        userInput.setCampusParticipantsFilename(NON_EXISTING_FILE);
        userInput.initFiles();

    }


    @Test
    public void initFilesShouldNotThrowExceptionIfFilesDoNotExistAndTheDecisionFieldsAreFalse() throws IOException {
        ObjectNode json=inputWithBothFiles();
        UserInput userInput=readValue(json,UserInput.class);
        userInput.setIncludeCampusParticipants(false);
        userInput.setIncludeNumberOfParticipants(false);
        userInput.setCampusParticipantsFilename(NON_EXISTING_FILE);
        userInput.setNumberOfParticipantsFilename(NON_EXISTING_FILE);
        userInput.initFiles();

        assertThat(userInput.getCampusParticipants(RESORUCE_FILE_COURSE_CODE).isPresent(),is(equalTo(false)));
        assertThat(userInput.getNumberOfParticipants(RESORUCE_FILE_COURSE_CODE).isPresent(),is(equalTo(false)));


    }

    @Test
    public void jsonFieldsShouldBeParsedCorrectly() throws IOException {

        ObjectNode userInputJson = inputWithBothFiles();
        UserInput userInput = readValue(userInputJson, UserInput.class).initFiles();
        assertThat(userInput.getOperation(), is(equalTo(Operation.NORMAL)));
        assertThat(userInput.getIncludeCampusParticipants(), is(equalTo(true)));
        assertThat(userInput.getLanguageOrder(), contains(NN, EN, NB));
    }

    @Test
    public void fieldsShouldNotBePrimitive() throws InvocationTargetException, IllegalAccessException {
        UserInput userInput = new UserInput();
        List<Method> getters = Arrays.asList(userInput.getClass().getDeclaredMethods())
            .stream()
            .filter(Validable::isGetter)
            .collect(Collectors.toList());
        for (Method getter : getters) {
            Object result = getter.invoke(userInput);
            boolean isNull = Objects.isNull(result);
            boolean isNotPrimitive = Objects.nonNull(result) && !result.getClass().isPrimitive();

            assertThat(isNull || isNotPrimitive, is(equalTo(true)));
        }
    }

    private ObjectNode inputWithBothFiles() {
        ObjectNode userInputJson = JsonUtils.newObjectNode();
        userInputJson.put(INCLUDE_CAMPUS_PARTICIPANTS_FIELD, INCLUDE_CAMPUS_PARTICIPANTS_VALUE);
        userInputJson.put(CAMPUS_PARTICIPANTS_FILE_FIELD, CAMPUS_PARTICIPANTS_GENERATED_FILE);
        userInputJson.put(INCLUDE_NUMBER_OF_PARTICIPANTS_FIELD, INCLUDE_NUMBER_OF_PARTICIPANTS_VALUE);
        userInputJson.put(NUMBER_OF_PARTICIPANTS_FILE_FIELD, NUMBER_OF_PARTICIPANTS_GENERATED_FILE);

        ArrayNode laguageOrder = JsonUtils.newArrayNode();
        laguageOrder.add(NN.toString());
        laguageOrder.add(EN.toString());
        laguageOrder.add(NB.toString());

        userInputJson.set(LANGUAGE_ORDER_FIELD, laguageOrder);
        return userInputJson;
    }
}
