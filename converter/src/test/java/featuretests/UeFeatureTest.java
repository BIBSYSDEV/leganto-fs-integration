package featuretests;

import static utils.JsonUtils.putKeyInNode;
import static utils.JsonUtils.readValue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.node.ObjectNode;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import leganto.UeLegantoEntry;
import utils.JsonUtils;

public class UeFeatureTest {

    private transient ObjectNode ueEntry;

    @Given("there is a request to \\/undervisning\\/UE_ID")
    public void there_is_a_request_to_undervisning_UE_ID() {
        ueEntry = JsonUtils.newObjectNode();
    }

    @Given("the response from \\/undervisning\\/UE_ID has a field with name {string} and value {string}")
    public void the_response_from_undervisning_UE_ID_has_a_field_with_name_and_value(String key,
        String value) {
        putKeyInNode(ueEntry, key, value);
    }

    @When("a new UE Leganto entry has been generated")
    public void a_new_UE_entry_is_generated() throws JsonProcessingException {
        UeLegantoEntry entry = readValue(ueEntry, UeLegantoEntry.class)

    }


}
