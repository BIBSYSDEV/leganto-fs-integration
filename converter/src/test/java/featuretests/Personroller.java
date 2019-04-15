package featuretests;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import fs.common.Person;
import fs.personroller.PersonRole;
import io.cucumber.datatable.DataTable;

import java.util.List;
import java.util.stream.Collectors;

import utils.JsonUtils;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class Personroller extends CucumberTestProcessor {


  private final Results results;

  public Personroller(World world, Results results) {
    super(world);
    this.results = results;
  }

  @Given("there is a list of personrolle entries for this undervisningsaktivitet with the following key-value pairs")
  public void there_is_a_list_of_personrolle_entries_for_undervisningsaktivitet_with_the_following_key_value_pairs(
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

  @Given("there is a valid response from \\/personner for the following ids")
  public void there_is_a_valid_response_from_personner_for_the_following_ids(DataTable dataTable) {
    world.setPersons(createElementList(dataTable));
  }

  @Then("the field AllInstructors in the UE entry is the string {string}")
  public void the_field_AllInstructors_in_the_UE_entry_is_the_string(String instructors) {
    assertThat(results.getUeLegantoEntry().getAllInstructorIds(),is(equalTo(instructors)));
  }

}
