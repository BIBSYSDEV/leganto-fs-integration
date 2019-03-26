package featuretests;

import static utils.JsonUtils.putElementArrayInNode;
import static utils.JsonUtils.putKeyInNode;
import static utils.JsonUtils.readValue;
import static utils.JsonUtils.removeKeyFromNode;
import static utils.JsonUtils.write;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Preconditions;
import cucumber.api.java.en.Given;
import fs.emne.Emne;
import fs.organizations.OrganizationEntity;
import fs.ua.UaCourseTitleFormat;
import fs.user.Operation;
import fs.user.UserInput;
import io.cucumber.datatable.DataTable;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import utils.JsonUtils;

public class Background extends CucumberTestProcessor {

    private static final int SINGLE_ELEMENT_IN_SINGLE_COLUMN_TABLE = 0;
    private static final String EMPTY_DATA_FROM_CUCUMBER_DEFINTION_FILE =
        "Datatable should not be empty. Add some data in the test";
    public static final boolean DEFAULT_INCLUDE_NUMBER_OF_PARTICIPANTS = false;
    public static final boolean DEFAULT_INCLUDE_UA = false;
    private static final String EMPTY_STRING = "";
    public static final boolean DEFAULT_INCLUDE_CAMPUS_PARTICIPANTS = false;
    public static final boolean DEFAULT_INCLUDE_INSTITUTE = false;
    private final World world;

    public Background(World world) {
        this.world = world;
    }

    @Given("the user input has no field with name {string}")
    public void the_user_input_has_no_field_with_name(String key) {
        removeKeyFromNode(world.getUserInput(), key);
    }

    @Given("the user input has a field with name {string} with value {string}")
    public void the_user_input_has_a_field_with_name_with_value(String key, String value) {
        putKeyInNode(world.getUserInput(), key, value);
    }

    @Given("the user input has a field with name {string} with value {int}")
    public void the_user_input_has_a_field_with_name_with_value(String key, Integer value) {
        // Write code here that turns the phrase above into concrete actions
        putKeyInNode(world.getUserInput(), key, value);
    }

    @Given("the user input has a field with name {string} with boolean value {string}")
    public void the_user_input_has_a_field_with_name_with_bvoolean_value(String key,
        String booleanValue) {
        putKeyInNode(world.getUserInput(), key, Boolean.valueOf(booleanValue));
    }

    @Given("the user input has a field with name {string} that is an array with string values")
    public void the_user_input_has_a_field_with_name_is_an_array_with_values(String key,
        io.cucumber.datatable.DataTable dataTable) {

        ArrayNode array = JsonUtils.mapper.createArrayNode();
        dataTable.asList().forEach(array::add);
        world.getUserInput().set(key, array);
    }

    @Given("there is a request to \\/emne\\/emneId")
    public void there_is_a_request_to_emne_emneId() {
        world.setEmneResponse(JsonUtils.newObjectNode());
    }

    @Given(
        "the response from \\/emne\\/emneId from FS has a field {string} that is an array with the key-element "
            + "pairs")
    public void the_response_from_emne_emneId_from_FS_has_a_field_that_is_an_array_with_the_key_element_pairs(
        String key, DataTable keyValuePairs) {
        List<ObjectNode> arrayElements = createElementList(keyValuePairs);
        putElementArrayInNode(world.getEmneResponse(), key, arrayElements);
    }

    @Given("the campus participants file is a semicolon separated file")
    public void theParticipantsFileIsACommaSeparatedFile() {
        JsonNode filenameField = world.getUserInput()
            .get(UserInput.CAMPUS_PARTICIPANTS_FILE_FIELD);

        world.initCampusParticipants(filenameField.asText());
    }

    @Given("the campus participants file contains a row with the following value")
    public void the_participants_file_contains_a_row_with_the_following_value(DataTable dataTable)
        throws IOException {
        Preconditions.checkArgument(!dataTable.isEmpty(), EMPTY_DATA_FROM_CUCUMBER_DEFINTION_FILE);
        String fileLine = dataTable.asList().get(SINGLE_ELEMENT_IN_SINGLE_COLUMN_TABLE);
        world.addToCourseParticipants(fileLine);
    }

    @Given("the number_of_participants file is a semicolon separated file")
    public void the_number_of_participants_file_is_a_semicolon_separated_file() {
        world.initNumberOfParticipantsFile(
            world.getUserInput().get(UserInput.NUMBER_OF_PARTICIPANTS_FILE).asText());
    }

    @Given("the number_of_participants file contains a row with the following value")
    public void the_number_of_participants_file_contains_a_row_with_the_following_value(
        DataTable dataTable)
        throws IOException {
        Preconditions.checkArgument(!dataTable.isEmpty(), EMPTY_DATA_FROM_CUCUMBER_DEFINTION_FILE);
        world.addToNumberOfParticipantsFile(dataTable.asList().get(0));
    }

    @Given("the user input field {string} has the boolean value {string}")
    public void the_user_input_field_has_the_boolean_value(String key, String booleanValue) {
        world.getUserInput().put(key, Boolean.valueOf(booleanValue));
    }

    @Given("there is a valid user input")
    public void thereIsAValidUserInput() throws IOException {
        UserInput userInput = new UserInput()
            .setIncludeUA(DEFAULT_INCLUDE_UA)
            .setNumberOfParticipantsFilename(EMPTY_STRING)
            .setCampusParticipantsFilename(EMPTY_STRING)
            .setIncludeCampusParticipants(DEFAULT_INCLUDE_CAMPUS_PARTICIPANTS)
            .setIncludeNumberOfParticipants(DEFAULT_INCLUDE_NUMBER_OF_PARTICIPANTS)
            .setIncludeInstitute(DEFAULT_INCLUDE_INSTITUTE)
            .setOperation(Operation.NORMAL)
            .setLanguageOrder(Collections.emptyList())
            .setCourseTitleFormat(UaCourseTitleFormat.DEFAULT_FORMAT);

        String userInputJson = write(userInput);
        ObjectNode userInputObjectNode = readValue(userInputJson, ObjectNode.class);
        world.setUserInput(userInputObjectNode);

    }

    @Given("there is a valid organization response")
    public void thereIsAValidOrgEntry() throws IOException {
        OrganizationEntity organizationEntity = new OrganizationEntity()
            .setInstitute(0)
            .setFaculty(0)
            .setInstitution(0);
        world.setOrganizationEntity(readValue(write(organizationEntity), ObjectNode.class));
    }

    @Given("there is a valid response from /emne/emneId")
    public void thersIsAValidEmneResponse() throws IOException {
        Emne emne = new Emne()
            .setNavn(Collections.emptyList());
        world.setEmneResponse(readValue(write(emne), ObjectNode.class));

    }

    @Given("null")
    public void thereIsAValidResponseFromUndervisningsaktiviteterUA_ID() {
    }
}
