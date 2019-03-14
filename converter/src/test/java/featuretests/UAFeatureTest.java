package featuretests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.text.IsEmptyString.emptyString;
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
    private static final String EMPTY_STRING = new String();

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

    @Given("the response from \\/undervisningsaktiviteter\\/UA_ID has a field {string} with value {string}")
    public void the_response_from_undervisningsaktiviteter_UA_ID_has_a_field_with_value(String key,
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
    public void the_response_from_UAaktiviteter_UA_ID_from_FS_has_a_field_that_is_an_array_with_the_key_value_pairs(
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
        uaLegantoEntry = new UaLegantoEntry(uaEntry, userInput)
            .setOrganizationEntity(organizationEntity)
            .setEmne(readValue(world.getEmneResponse(), Emne.class))
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

    @Then("SectionId is the string {string}")
    public void sectionid_is_the_string(String expectedSectionId) {
        assertThat(uaLegantoEntry.getSectionId(), is(equalTo(expectedSectionId)));
    }

    @Then("AcademicDepartment is the  string {string}")
    public void academicdepartment_is_the_string(String expectedAcedemicDepartment) {
        // Write code here that turns the phrase above into concrete actions

        assertThat(uaLegantoEntry.getAcademicDepartment(), is(equalTo(expectedAcedemicDepartment)));
    }

    @Then("ProcessingDepartment is set to the invariant value LEGANTO")
    public void processingdepartmentIsSetToTheInvariantValueLeganto() {
        assertThat(uaLegantoEntry.getProcessingDepartment(), is(equalTo("LEGANTO")));
    }

    @Then("Term1 is the string  {string}")
    public void termIsTheString(String semesterCode) {
        assertThat(uaLegantoEntry.getTerm1(), is(equalTo(semesterCode)));
    }

    @Then("Term2 is empty")
    public void term2_is_empty() {
        assertThat(uaLegantoEntry.getTerm2(), is(equalTo(EMPTY_STRING)));
    }

    @Then("Term3 is empty")
    public void term3_is_empty() {
        assertThat(uaLegantoEntry.getTerm3(), is(equalTo(EMPTY_STRING)));
    }

    @Then("Term4 is empty")
    public void term4_is_empty() {
        assertThat(uaLegantoEntry.getTerm4(), is(equalTo(EMPTY_STRING)));
    }

    @Then("StartDate is the string {string}")
    public void startdate_is_the_string(String startDate) {
        assertThat(uaLegantoEntry.getStartDate(), is(equalTo(startDate)));
    }

    @Then("EndDate is the string {string}")
    public void enddate_is_the_string(String endDate) {
        assertThat(uaLegantoEntry.getEndDate(), is(equalTo(endDate)));
    }

    @Then("WeeklyHours is empty")
    public void weeklyhours_is_empty() {
        assertThat(uaLegantoEntry.getWeeklyHours(), is(emptyString()));
    }

    @Then("Year has the value {int}")
    public void year_has_the_value(Integer year) {
        assertThat(uaLegantoEntry.getYear(), is(equalTo(year)));
    }

    @Then("SearchableId1 is empty")
    public void searchableid1_is_empty() {
        assertThat(uaLegantoEntry.getSearchableId1(), is(emptyString()));
    }

    @Then("SearchableId2 is empty")
    public void searchableid2_is_empty() {
        assertThat(uaLegantoEntry.getSearchableId2(), is(emptyString()));
    }

    @Then("AllSearchableIds is the string {string}")
    public void allsearchableids_is_the_string(String searchableId) {
        assertThat(uaLegantoEntry.getAllSearchableIds(), is(equalTo(searchableId)));
    }

    @Then("Instructor{int} is empty")
    public void instructor_is_empty(Integer index) {
        assertThat(uaLegantoEntry.getInstructor(), is(emptyString()));
    }

    @Then("Operation is empty")
    public void operationIsEmpty() {
        assertThat(uaLegantoEntry.getOperation(), is(emptyString()));
    }

    @Then("SubmitByDate is empty")
    public void submitByDateIsEmpty() {
        assertThat(uaLegantoEntry.getSubmitByDate(), is(emptyString()));
    }

    @Then("CampusParticipants is the string {string}")
    public void campusparticipantsIsTheString(String campuses) {
        assertThat(uaLegantoEntry.getCampusParticipants(), is(equalTo(campuses)));
    }

    @Then("Reading List Name is empty")
    public void readingListNameIsEmpty() {
        assertThat(uaLegantoEntry.getReadingListName(), is(emptyString()));
    }

    @Then("NumberOfParticipants has the value {string}")
    public void numberofparticipants_has_the_value(String numberOfParticipants) {
        assertThat(uaLegantoEntry.getNumberOfParticipants(), is(equalTo(numberOfParticipants)));
    }
}
