package featuretests;

import static utils.JsonUtils.putElementArrayInNode;
import static utils.JsonUtils.putKeyInNode;
import static utils.JsonUtils.removeKeyFromNode;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import cucumber.api.java.en.Given;
import io.cucumber.datatable.DataTable;
import java.util.List;
import utils.JsonUtils;

public class Background extends CucumberTestProcessor {

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
        putKeyInNode(world.getUserInput(), key, value);
    }

    @Given("the user input has no field with name {string}")
    public void the_user_input_has_no_field_with_name(String key) {
        removeKeyFromNode(world.getUserInput(), key);
    }


    @Given("the user input has a field with name {string} with value {int}")
    public void the_user_input_has_a_field_with_name_with_value(String key, Integer value) {
        // Write code here that turns the phrase above into concrete actions
        putKeyInNode(world.getUserInput(), key, value);
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
}
