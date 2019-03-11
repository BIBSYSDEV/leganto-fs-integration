package featuretests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static utils.JsonUtils.newObjectNode;
import static utils.JsonUtils.putElementArrayInNode;
import static utils.JsonUtils.putKeyInNode;
import static utils.JsonUtils.readValue;
import static utils.JsonUtils.removeKeyFromNode;

import com.fasterxml.jackson.databind.node.ObjectNode;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fs.emne.Emne;
import fs.organizations.OrganizationEntity;
import fs.ua.UndervisningsAktivitet;
import fs.user.UserInput;
import io.cucumber.datatable.DataTable;
import java.io.IOException;
import java.util.List;
import leganto.UaLegantoEntry;
import utils.JsonUtils;

public class UAFeatureTest extends CucumberTestProcessor {

    private static final int INCLUDE_EMPTY_STRINGS = -1;
    private static final int INCLUDE_EMPTY_STRINGS_BETWEEN_DELIMITER = INCLUDE_EMPTY_STRINGS;
    private static final int EXTRA_DELIMITER_AT_EOL_SIGNIGNIFING_EOL = 1;

    private static final String NOT = "not";

    private final World world;

    private UaLegantoEntry uaLegantoEntry = null;

    private transient ObjectNode uaResponse;
    private transient ObjectNode organisasjon;

    public UAFeatureTest(World world) {
        this.world = world;
    }

    @Given("^there is a request to /undervisningsaktiviteter/(.+)$")
    public void there_is_a_request_to_undervisningsaktiviteter(String id) {
        // Write code here that turns the phrase above into concrete actions
        uaResponse = JsonUtils.newObjectNode();
    }

    @Given("the response from \\/undervisningsaktiviteter\\/UA_ID from FS has a field {string} with value {string}")
    public void the_response_from_undervisningsaktiviteter_UA_ID_from_FS_has_a_field_with_value(String key,
        String value) {
        JsonUtils.putKeyInNode(uaResponse, key, value);
    }

    @Given("there is a request to organisasjonsEnhetStudieUrl")
    public void there_is_a_request_to_organisasjonsEnhetStudieUrl() {
        organisasjon = newObjectNode();
    }

    @Given("the response to organisasjonsEnhetUrl has a field {string} with value {int}")
    public void the_response_to_organisasjonsEnhetUrl_has_a_field_with_value(String key, Integer value) {
        // Write code here that turns the phrase above into concrete actions
        putKeyInNode(organisasjon, key, value);
    }

    @Given("the response from \\/undervisningsaktiviteter\\/UA_ID from FS has a field {string} that is an array with "
        + "the key-value pairs")
    public void
    the_response_from_undervisningsaktiviteter_UA_ID_from_FS_has_a_field_that_is_an_array_with_the_key_value_pairs(
        String key, DataTable keyValuePairs) {
        ObjectNode root = uaResponse;
        List<ObjectNode> arrayValues = createElementList(keyValuePairs);
        putElementArrayInNode(root, key, arrayValues);
    }

    @Given("the response from \\/undervisningsaktiviteter\\/UA_ID has a field {string} with value {int}")
    public void the_response_from_undervisningsaktiviteter_UA_ID_has_a_field_with_value(String key, Integer value) {
        putKeyInNode(uaResponse, key, value);
    }

    @Given("there is a request to {string}")
    public void there_is_a_request_to(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Given("the user input has field with name {string} with value true")
    public void the_user_input_has_field_with_name_with_value_true(String key) {
        putKeyInNode(world.getUserInput(), key, true);
    }

    @Given("the response from \\/undervisningsaktiviteter\\/UA_ID from FS has no field {string}")
    public void the_response_from_undervisningsaktiviteter_UA_ID_from_FS_has_no_field(String key) {
        removeKeyFromNode(uaResponse, key);
    }

    @Given("the user input field {string} has the value {string}")
    public void the_user_input_field_has_not_the_value(String compositeKey, String value) {
        putKeyInNode(world.getUserInput(), compositeKey, value);
    }

    @Given("the user input field {string} has not the value {string}")
    public void the_user_input_field_has_the_value(String compositeKey, String value) {
        String alteredValue = String.join("", NOT, value);
        putKeyInNode(world.getUserInput(), compositeKey, alteredValue);
    }

    @When("new UA entry has been generated")
    public void new_UA_entry_has_been_generated() throws IOException {

        UndervisningsAktivitet uaEntry = readValue(uaResponse, UndervisningsAktivitet.class);
        UserInput userInput = readValue(world.getUserInput(), UserInput.class);
        OrganizationEntity organizationEntity = readValue(organisasjon, OrganizationEntity.class);
        uaLegantoEntry = new UaLegantoEntry()
            .setUndervisningsAktivitet(uaEntry)
            .setOrganizationEntity(organizationEntity)
            .setEmne(readValue(world.getEmneResponse(), Emne.class))
            .setLanguageOrder(userInput.getLanguages())
            .populateFields();
    }

    @Then("CourseCode is the string {string}")
    public void coursecode_is_the_string(String expectedCourseCode) {
        String courseCode = uaLegantoEntry.getCourseCode();

        assertThat(courseCode, is(equalTo(expectedCourseCode)));
    }

    @Then("the courses in FS are populated in Leganto with the following data:")
    public void the_courses_in_FS_are_populated_in_Leganto_with_the_following_data(
        DataTable dataTable) {
        List<String> fieldNamesCount = dataTable.asList();
        int expectedFieldsNumber = fieldNamesCount.size();

        int actualNumberOfFields = uaLegantoEntry.toString()
            .split(UaLegantoEntry.FIELD_DELIMITER, INCLUDE_EMPTY_STRINGS_BETWEEN_DELIMITER)
            .length;

        assertThat(actualNumberOfFields, is(equalTo(expectedFieldsNumber + EXTRA_DELIMITER_AT_EOL_SIGNIGNIFING_EOL)));
    }

    @Then("CouseTitle is the string {string}")
    public void cousetitle_is_the_string(String courseTitle) {
        assertThat(uaLegantoEntry.getCourseTitle(), is(equalTo(courseTitle)));
    }

    @Then("SectionId is  the string {string}")
    public void sectionid_is_the_string(String expectedSectionId) {
        assertThat(uaLegantoEntry.getSectionId(), is(equalTo(expectedSectionId)));
    }

    @Then("AcademicDepartment is the  string {string}")
    public void academicdepartment_is_the_string(String expectedAcedemicDepartment) {
        // Write code here that turns the phrase above into concrete actions

        assertThat(uaLegantoEntry.getAcademicDepartment(), is(equalTo(expectedAcedemicDepartment)));
    }


}
