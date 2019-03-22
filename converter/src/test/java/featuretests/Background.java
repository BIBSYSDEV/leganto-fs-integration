package featuretests;

import static utils.JsonUtils.putElementArrayInNode;
import static utils.JsonUtils.putKeyInNode;
import static utils.JsonUtils.removeKeyFromNode;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Preconditions;
import cucumber.api.java.en.Given;
import fs.user.UserInput;
import io.cucumber.datatable.DataTable;
import java.io.IOException;
import java.util.List;
import utils.JsonUtils;

public class Background extends CucumberTestProcessor {

    private static final int SINGLE_ELEMENT_IN_SINGLE_COLUMN_TABLE = 0;
    private static final String EMPTY_DATA_FROM_CUCUMBER_DEFINTION_FILE =
        "Datatable should not be empty. Add some data in the test";
    private final World world;

    public Background(World world) {
        this.world = world;
    }

    @Given("there is a user input")
    public void there_is_a_user_input() {
        world.setUserInput(JsonUtils.newObjectNode());
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
    public void the_user_input_has_a_field_with_name_with_bvoolean_value(String key, String booleanValue) {
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

    @Given("the response from \\/emne\\/emneId from FS has a field {string} that is an array with the key-element "
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
    public void the_participants_file_contains_a_row_with_the_following_value(DataTable dataTable) throws IOException {
        Preconditions.checkArgument(!dataTable.isEmpty(), EMPTY_DATA_FROM_CUCUMBER_DEFINTION_FILE);
        String fileLine = dataTable.asList().get(SINGLE_ELEMENT_IN_SINGLE_COLUMN_TABLE);
        world.addToCourseParticipants(fileLine);
    }

    @Given("the number_of_participants file is a semicolon separated file")
    public void the_number_of_participants_file_is_a_semicolon_separated_file() {
        world.initNumberOfParticipantsFile(world.getUserInput().get(UserInput.NUMBER_OF_PARTICIPANTS_FILE).asText());
    }

    @Given("the number_of_participants file contains a row with the following value")
    public void the_number_of_participants_file_contains_a_row_with_the_following_value(DataTable dataTable)
        throws IOException {
        Preconditions.checkArgument(!dataTable.isEmpty(), EMPTY_DATA_FROM_CUCUMBER_DEFINTION_FILE);
        world.addToNumberOfParticipantsFile(dataTable.asList().get(0));
    }


    @Given("the user input field {string} has the boolean value {string}")
    public void the_user_input_field_has_the_boolean_value(String key, String booleanValue) {
        world.getUserInput().put(key,Boolean.valueOf(booleanValue));
    }

}
