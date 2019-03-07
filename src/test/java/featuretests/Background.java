package featuretests;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import cucumber.api.java.en.Given;
import io.cucumber.datatable.DataTable;
import java.util.ArrayList;
import java.util.List;
import utils.JsonUtils;

public class Background {

    private final World world;

    public Background(World world) {
        this.world = world;
    }

    @Given("there is a user input")
    public void there_is_a_user_input() {
        world.setUserInput(JsonUtils.newObjectNode());
    }

    @Given("the user input has a field with name {string} with value {string}")
    public void the_user_input_has_a_field_with_name_with_value(String key, String value) {
        // Write code here that turns the phrase above into concrete actions
        JsonUtils.putKeyInNode(key, value, world.getUserInput());
    }

    @Given("the user input has a field with name {string} with value {int}")
    public void the_user_input_has_a_field_with_name_with_value(String key, Integer value) {
        // Write code here that turns the phrase above into concrete actions
        JsonUtils.putKeyInNode(key, value, world.getUserInput());
    }

    @Given("the user input has a field with name {string} is an array  with values")
    public void the_user_input_has_a_field_with_name_is_an_array_with_values(String key,
        io.cucumber.datatable.DataTable dataTable) {

        ArrayNode array = JsonUtils.mapper.createArrayNode();
        dataTable.asList().forEach(array::add);
        world.getUserInput().set(key, array);
    }

    @Given("there is a request to \\/emne\\/emneId")
    public void there_is_a_request_to_emne_emneId() {
        // Write code here that turns the phrase above into concrete actions
        world.setEmneResponse(JsonUtils.newObjectNode());
    }

    @Given("the response from \\/emne\\/emneId from FS has a field {string} that is an array with the key-element "
        + "pairs")
    public void the_response_from_emne_emneId_from_FS_has_a_field_that_is_an_array_with_the_key_element_pairs(
        String fieldName, io.cucumber.datatable.DataTable keyValuePairs) {

        List<ObjectNode> arrayElements = createElementArray(keyValuePairs);
        ArrayNode array = JsonUtils.newArrayNode();
        arrayElements.forEach(array::add);
        world.getEmneResponse().set(fieldName, array);
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
}
