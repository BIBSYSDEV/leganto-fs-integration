package featuretests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

import com.fasterxml.jackson.databind.node.ObjectNode;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fs.ua.UndervisningsAktivitet;
import io.cucumber.datatable.DataTable;
import java.io.IOException;
import java.util.List;
import leganto.UaLegantoEntry;
import utils.JsonUtils;

public class UAFeatureTest {

    private static final int INCLUDE_EMPTY_STRINGS = -1;
    private static final int INCLUDE_EMPTY_STRINGS_BETWEEN_DELIMITER = INCLUDE_EMPTY_STRINGS;
    private static final int EXTRA_DELIMITER_AT_EOL_SIGNIGNIFING_EOL = 1;
    private ObjectNode uaResponse;
    private UaLegantoEntry uaLegantoEntry = null;

    @Given("^there is a request to /undervisningsaktiviteter/(.+)$")
    public void there_is_a_request_to_undervisningsaktiviteter(String id) {
        // Write code here that turns the phrase above into concrete actions
        uaResponse = JsonUtils.newObjectNode();
    }

    @Given("the response from \\/undervisningsaktiviteter\\/UA_ID from FS has a field {string} with value {string}")
    public void the_response_from_undervisningsaktiviteter_UA_ID_from_FS_has_a_field_with_value(String key,
        String value) {
        // Write code here that turns the phrase above into concrete actions
        JsonUtils.putKeyInNode(key, value, uaResponse);
    }

    @Given("there is a request to organisasjonsEnhetUrl")
    public void there_is_a_request_to_organisasjonsEnhetUrl() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Given("the response to organisasjonsEnhetUrl has a field {string} with value {int}")
    public void the_response_to_organisasjonsEnhetUrl_has_a_field_with_value(String string, Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Given("the response to organisasjonsEnhetUrl has a filed {string} with value {int}")
    public void the_response_to_organisasjonsEnhetUrl_has_a_filed_with_value(String string, Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @When("new UA entry has been generated")
    public void new_UA_entry_has_been_generated() throws IOException {
        uaLegantoEntry = new UaLegantoEntry(UndervisningsAktivitet.fromJson(JsonUtils.write(uaResponse)));
    }

    @Then("CourseCode is the string {string}")
    public void coursecode_is_the_string(String expectedCourseCode) {
        String courseCode = uaLegantoEntry.getCourseCode();

        assertThat(courseCode, is(equalTo(expectedCourseCode)));
    }

    @Then("the courses in FS are populated in Leganto with the following data:")
    public void the_courses_in_FS_are_populated_in_Leganto_with_the_following_data(
        io.cucumber.datatable.DataTable dataTable) {
        List<String> fieldNamesCount = dataTable.asList();
        int expectedFieldsNumber = fieldNamesCount.size();

        int actualNumberOfFields = uaLegantoEntry.toString()
            .split(UaLegantoEntry.FIELD_DELIMITER, INCLUDE_EMPTY_STRINGS_BETWEEN_DELIMITER)
            .length;

        assertThat(actualNumberOfFields, is(equalTo(expectedFieldsNumber + EXTRA_DELIMITER_AT_EOL_SIGNIGNIFING_EOL)));
    }

    @Given("the response from \\/undervisningsaktiviteter\\/UA_ID from FS has a field {string} that is an array with "
        + "the key-value pairs")
    public void the_response_from_undervisningsaktiviteter_UA_ID_from_FS_has_a_field_that_is_an_array_with_the_key_value_pairs(
        String string, io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        throw new cucumber.api.PendingException();
    }

    @Given("the response from \\/undervisningsaktiviteter\\/UA_ID has a field {string} with value {int}")
    public void the_response_from_undervisningsaktiviteter_UA_ID_has_a_field_with_value(String string, Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Given("there is a request to {string}")
    public void there_is_a_request_to(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Given("the user input has a field with name {string} that is an array with values")
    public void the_user_input_has_a_field_with_name_that_is_an_array_with_values(String string, DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        throw new cucumber.api.PendingException();
    }

    @Given("the user input has field with name {string} with value true")
    public void the_user_input_has_field_with_name_with_value_true(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Given("the response from \\/undervisningsaktiviteter\\/UA_ID from FS has no field {string}")
    public void the_response_from_undervisningsaktiviteter_UA_ID_from_FS_has_no_field(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("CouseTitle is the string {string}")
    public void cousetitle_is_the_string(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("Section ID is  the string {string}")
    public void section_ID_is_the_string(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("Academic Department is the  string {string}")
    public void academic_Department_is_the_string(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("Processing Department is set to the invariant value LEGANTO")
    public void processing_Department_is_set_to_the_invariant_value_LEGANTO() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("Term{int} is the string  {string}")
    public void term_is_the_string(Integer int1, String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("Term{int} is empty")
    public void term_is_empty(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("StartDate is the string {string}")
    public void startdate_is_the_string(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("EndDate is  the string {string}")
    public void enddate_is_the_string(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("NumberOfParticipants has the value {int}")
    public void numberofparticipants_has_the_value(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("WeeklyHours is empty")
    public void weeklyhours_is_empty() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("Year has the value {int}")
    public void year_has_the_value(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("SearchableId{int} is empty")
    public void searchableid_is_empty(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("ALL_SEARCHABLE_IDS is the string {string}")
    public void all_searchable_ids_is_the_string(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("Instructor{int} is empty")
    public void instructor_is_empty(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("ALL_INSTRUCTORS is not empty")
    public void all_instructors_is_not_empty() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("Operation is value of the field {string} of the input")
    public void operation_is_value_of_the_field_of_the_input(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("Submit By Date is empty")
    public void submit_By_Date_is_empty() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("Campuses and Campus Participants has the value of the user input field {string}")
    public void campuses_and_Campus_Participants_has_the_value_of_the_user_input_field(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("Reading List Name is empty")
    public void reading_List_Name_is_empty() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Given("the user input field {string} has the value {string}")
    public void the_user_input_field_has_the_value(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @When("the scheduling system requests an update")
    public void the_scheduling_system_requests_an_update() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("all the fields are populated correctly")
    public void all_the_fields_are_populated_correctly() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("Old Course Code is the string {string}")
    public void old_Course_Code_is_the_string(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("Old Course Section ID is the string  {string}")
    public void old_Course_Section_ID_is_the_string(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Given("the user input field {string} has not the value {string}")
    public void the_user_input_field_has_not_the_value(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("Old Course Code is empty")
    public void old_Course_Code_is_empty() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("Old Course Section empty")
    public void old_Course_Section_empty() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }








}
