package featuretests;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import cucumber.api.java.en.Given;
import io.cucumber.datatable.DataTable;
import java.util.List;
import utils.JsonUtils;

public class Personroller extends CucumberTestProcessor {

    private String EMPTY_STRING = "";

    public Personroller(World world) {
        super(world);
    }

    @Given("there is a list of personrolle entries for this undervisningsaktivitet with the following key-value pairs")
    public void there_is_a_list_of_personrolle_entries_for_this_undervisningsaktivitet_with_the_following_key_value_pairs(
        DataTable keyValuePairs) {

        List<ObjectNode> personroller = createElementList(keyValuePairs);
        ArrayNode personrolleEntries = JsonUtils.newArrayNode();
        personroller.forEach(personrolleEntries::add);
        world.setPersonRoleEntries(personrolleEntries);
    }

    @Given("there is a possibly empty personroller list")
    public void there_is_a_possibly_empty_personroller_list() {
        world.setPersonRoleEntries(JsonUtils.newArrayNode());
    }


}
