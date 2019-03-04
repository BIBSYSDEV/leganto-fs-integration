package featuretests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import java.util.ArrayList;
import java.util.List;
import leganto.UaLegantoEntry;
import utils.JsonUtils;

public class UAFeatureTest {

    private static final int INCLUDE_EMPTY_STRINGS = -1;
    private static final int INCLUDE_EMPTY_STRINGS_BETWEEN_DELIMITER = INCLUDE_EMPTY_STRINGS;
    private ObjectNode userInput;
    private ObjectNode uaResponse;
    private ObjectNode emneResponse;
    private UaLegantoEntry uAlegantoEntry = null;

    @Given("that it is time for an update")
    public void that_it_is_time_for_an_update() {
        // Write code here that turns the phrase above into concrete actions

    }

    @Given("there is a user input")
    public void there_is_a_user_input() {
        userInput = JsonUtils.newObjectNode();
    }

    @Given("the user input has a field with name {string} with value {string}")
    public void the_user_input_has_a_field_with_name_with_value(String key, String value) {
        // Write code here that turns the phrase above into concrete actions
        userInput.put(key, value);
    }

    @Given("the user input has a field with name {string} with value {int}")
    public void the_user_input_has_a_field_with_name_with_value(String key, Integer value) {
        // Write code here that turns the phrase above into concrete actions
        userInput.put(key, value);
    }

    @Given("the user input has a field with name {string} is an array  with values")
    public void the_user_input_has_a_field_with_name_is_an_array_with_values(String key,
        io.cucumber.datatable.DataTable dataTable) {

        ArrayNode array = JsonUtils.mapper.createArrayNode();
        dataTable.asList().forEach(array::add);
        userInput.set(key, array);
    }

    @Given("^there is a request to /undervisningsaktiviteter/(.+)$")
    public void there_is_a_request_to_undervisningsaktiviteter(String id) {
        // Write code here that turns the phrase above into concrete actions
        uaResponse = JsonUtils.newObjectNode();
    }

    @Given("the response from \\/undervisningsaktiviteter\\/UA_ID from FS has a field {string} with value {string}")
    public void the_response_from_undervisningsaktiviteter_UA_ID_from_FS_has_a_field_with_value(String key,
        String value) {
        // Write code here that turns the phrase above into concrete actions
        uaResponse.put(key, value);
    }

    @Given("there is a request to \\/emne\\/emneId")
    public void there_is_a_request_to_emne_emneId() {
        // Write code here that turns the phrase above into concrete actions
        emneResponse = JsonUtils.newObjectNode();
    }

    @Given("the response from \\/emne\\/emneId from FS has a field {string} that is an array with the key-element "
        + "pairs")
    public void the_response_from_emne_emneId_from_FS_has_a_field_that_is_an_array_with_the_key_element_pairs(
        String fieldName, io.cucumber.datatable.DataTable keyValuePairs) {

        List<ObjectNode> arrayElements = createElementArray(keyValuePairs);
        ArrayNode array = JsonUtils.newArrayNode();
        arrayElements.forEach(array::add);
        emneResponse.set(fieldName, array);
    }

    @Given("new UA entry has been generated")
    public void new_UA_entry_has_been_generated() {
        // Write code here that turns the phrase above into concrete actions
        UaLegantoEntry uAlegantoEntry = new UaLegantoEntry();
    }

    @When("the scheduling system requests an update")
    public void the_scheduling_system_requests_an_update() {
        // Write code here that turns the phrase above into concrete actions

    }

    @Then("CourseCode is the string {string}")
    public void coursecode_is_the_string(String string) {

        uAlegantoEntry

    }

    @Then("the courses in FS are populated in Leganto with the following data:")
    public void the_courses_in_FS_are_populated_in_Leganto_with_the_following_data(
        io.cucumber.datatable.DataTable dataTable) {
        List<String> fieldNamesCount = dataTable.asList();
        int expectedFieldsNumber = fieldNamesCount.size();

        int actualNumberOfFields = uAlegantoEntry.toString()
            .split(UaLegantoEntry.DELIMITER_REGEX, INCLUDE_EMPTY_STRINGS_BETWEEN_DELIMITER)
            .length;

        assertThat(actualNumberOfFields, is(equalTo(expectedFieldsNumber)));
    }

    private List<ObjectNode> createElementArray(DataTable keyValuePairs) {
        List<ObjectNode> arrayElements = new ArrayList<>();
        for (int row = 0; row < keyValuePairs.height(); row++) {

            ObjectNode arrayElement = JsonUtils.newObjectNode();
            createSingleArrayElement(keyValuePairs, row, arrayElement);
            arrayElements.add(arrayElement);
        }
        return arrayElements;
    }

    private void createSingleArrayElement(DataTable keyValuePairs, int row, ObjectNode arrayElement) {
        for (int valueIndex = 1; valueIndex < keyValuePairs.width(); valueIndex = valueIndex + 2) {
            int keyIndex = valueIndex - 1;
            arrayElement.put(keyValuePairs.cell(row, keyIndex), keyValuePairs.cell(row, valueIndex));
        }
    }

    @And("CouseTitle is the string {string}")
    public void cousetitleIsTheString(String courseTitle) {

    }
}
