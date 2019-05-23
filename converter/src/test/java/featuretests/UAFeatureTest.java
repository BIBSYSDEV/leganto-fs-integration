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
import static utils.JsonUtils.write;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Preconditions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fs.common.UEmne;
import fs.emne.Emne;
import fs.organizations.OrganizationEntity;
import fs.ua.SemesterCode;
import fs.ua.USemester;
import fs.ua.UaUndervisning;
import fs.ua.UndervisningsAktivitet;
import fs.user.UserInput;
import io.cucumber.datatable.DataTable;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import leganto.UaLegantoEntry;
import utils.JsonUtils;

public class UAFeatureTest extends CucumberTestProcessor implements FeatureTestsErrorMessages {

    private static final String NOT = "not";
    private static final String EMPTY_STRING = new String();
    private static final int INCLUDE_EMPTY_STRINGS_BETWEEN_DELIMITER = -1;
    private static final int EXTRA_DELIMITER_AT_EOL_SIGNIGNIFING_EOL = 1;
    public static final String NULL_UA_RESPONSE_MESSAGE = "UA response is null";

    private UaLegantoEntry uaLegantoEntry;
    private transient ObjectNode uaResponse;

    public UAFeatureTest(World world) {
        super(world);
    }

    @Given("the response from \\/undervisningsaktiviteter\\/UA_ID has a field {string} with value {string}")
    public void the_response_from_undervisningsaktiviteter_UA_ID_has_a_field_with_value(String key,
        String value) {
        JsonUtils.putKeyInNode(uaResponse, key, value);
    }

    @Given("the response from \\/undervisningsaktiviteter\\/UA_ID has a field {string} with value {int}")
    public void the_response_from_undervisningsaktiviteter_UA_ID_has_a_field_with_value(String key,
        Integer value) {
        putKeyInNode(uaResponse, key, value);
    }

    @Given("there is a request to organisasjonsEnhetStudieUrl")
    public void there_is_a_request_to_organisasjonsEnhetStudieUrl() {
        world.setOrganizationEntity(newObjectNode());
    }

    @Given("the response to organisasjonsEnhetUrl has a field {string} with value {int}")
    public void the_response_to_organisasjonsEnhetUrl_has_a_field_with_value(String key,
        Integer value) {
        // Write code here that turns the phrase above into concrete actions
        putKeyInNode(world.getOrganizationEntity(), key, value);
    }

    @Given(
        "the response from \\/undervisningsaktiviteter\\/UA_ID from FS has a field {string} that is an array with "
            + "the key-value pairs")
    public void the_response_from_UAaktiviteter_UA_ID_from_FS_has_a_field_that_is_an_array_with_the_key_value_pairs(
        String key, DataTable keyValuePairs) {
        ObjectNode root = uaResponse;
        List<ObjectNode> arrayValues = createElementList(keyValuePairs);
        putElementArrayInNode(root, key, arrayValues);
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

    @Given("there is a valid response from \\/undervisningsaktiviteter\\/UA_ID")
    public void thereIsAValidUaEntry() throws IOException {
        UndervisningsAktivitet ua = new UndervisningsAktivitet();
        USemester semester = new USemester()
            .setSemesterCode(SemesterCode.AUTUMN.toString())
            .setHref(EMPTY_STRING)
            .setYear(0);
        UEmne emne = new UEmne()
            .setCode(EMPTY_STRING)
            .setHref(EMPTY_STRING)
            .setInstitution(EMPTY_STRING)
            .setVersion(EMPTY_STRING);
        UaUndervisning uaUndervisning = new UaUndervisning()
            .setUaSemester(semester)
            .setEmne(emne)
            .setHref(EMPTY_STRING)
            .setTerminnumer(0);

        ua.setAktivitet(EMPTY_STRING)
            .setNavn(Collections.emptyList())
            .setUndervisning(uaUndervisning)
            .setNavn(Collections.emptyList());

        uaResponse = readValue(write(ua), ObjectNode.class);
    }

    @When("a new UA Leganto entry has been generated")
    public void new_UA_entry_has_been_generated() throws IOException {
        Preconditions.checkNotNull(uaResponse, NULL_UA_RESPONSE_MESSAGE);
        Preconditions.checkNotNull(world.getUserInput(), NULL_USER_INPUT_MESSAGE);
        Preconditions.checkNotNull(world.getOrganizationEntity(), NULL_ORG_ENTITY_MESSAGE);
        Preconditions.checkNotNull(world.getEmneResponse(), NULL_EMNE_MESSAGE);
        Preconditions.checkNotNull(world.getPersonRolleEntries(), NULL_PERSONROLE_MESSAGE);
        UndervisningsAktivitet uaEntry = readValue(uaResponse, UndervisningsAktivitet.class);

        UserInput userInput = readValue(world.getUserInput(), UserInput.class).initFiles();
        OrganizationEntity org = readValue(world.getOrganizationEntity(), OrganizationEntity.class);

        uaLegantoEntry = (UaLegantoEntry) new UaLegantoEntry(uaEntry, userInput)
            .setEmne(readValue(world.getEmneResponse(), Emne.class))
            .setOrganizationEntity(org)
        ;
    }

    @Then("the courses in FS are populated in Leganto with the following data:")
    public void the_courses_in_FS_are_populated_in_Leganto_with_the_following_data(
        DataTable dataTable) {
        List<String> fieldNamesCount = dataTable.asList();
        int expectedFieldsNumber = fieldNamesCount.size();

        int actualNumberOfFields = uaLegantoEntry.toString()
            .split(UaLegantoEntry.FIELD_DELIMITER, INCLUDE_EMPTY_STRINGS_BETWEEN_DELIMITER)
            .length;

        assertThat(actualNumberOfFields,
            is(equalTo(expectedFieldsNumber + EXTRA_DELIMITER_AT_EOL_SIGNIGNIFING_EOL)));
    }

    @Then("the field CourseCode in the UA entry is the string {string}")
    public void coursecode_is_the_string(String expectedCourseCode) {
        String courseCode = uaLegantoEntry.getCourseCode();

        assertThat(courseCode, is(equalTo(expectedCourseCode)));
    }

    @Then("the field CourseTitle in the UA entry is the string {string}")
    public void cousetitle_is_the_string(String courseTitle) {
        assertThat(uaLegantoEntry.getCourseTitle(), is(equalTo(courseTitle)));
    }

    @Then("the field SectionId in the UA entry is the string {string}")
    public void sectionid_is_the_string(String expectedSectionId) {
        assertThat(uaLegantoEntry.getSectionId(), is(equalTo(expectedSectionId)));
    }

    @Then("the field AcademicDepartment in the UA entry is the string {string}")
    public void academicdepartment_is_the_string(String expectedAcedemicDepartment) {

        assertThat(uaLegantoEntry.getAcademicDepartment(), is(equalTo(expectedAcedemicDepartment)));
    }

    @Then("the field ProcessingDepartment in the UA entry is set to the invariant value LEGANTO")
    public void processingdepartmentIsSetToTheInvariantValueLeganto() {
        assertThat(uaLegantoEntry.getProcessingDepartment(), is(equalTo("LEGANTO")));
    }

    @Then("the field Term1 in the UA entry is the string {string}")
    public void termIsTheString(String semesterCode) {
        assertThat(uaLegantoEntry.getTerm1(), is(equalTo(semesterCode)));
    }

    @Then("the field Term2 in the UA entry is empty")
    public void term2_is_empty() {
        assertThat(uaLegantoEntry.getTerm2(), is(equalTo(EMPTY_STRING)));
    }

    @Then("the field Term3 in the UA entry is empty")
    public void term3_is_empty() {
        assertThat(uaLegantoEntry.getTerm3(), is(equalTo(EMPTY_STRING)));
    }

    @Then("the field Term4 in the UA entry is empty")
    public void term4_is_empty() {
        assertThat(uaLegantoEntry.getTerm4(), is(equalTo(EMPTY_STRING)));
    }

    @Then("the field StartDate in the UA entry is the string {string}")
    public void startdate_is_the_string(String startDate) {
        assertThat(uaLegantoEntry.getStartDate(), is(equalTo(startDate)));
    }

    @Then("the field EndDate in the UA entry is the string {string}")
    public void enddate_is_the_string(String endDate) {
        assertThat(uaLegantoEntry.getEndDate(), is(equalTo(endDate)));
    }

    @Then("the field WeeklyHours in the UA entry is empty")
    public void weeklyhours_is_empty() {
        assertThat(uaLegantoEntry.getWeeklyHours(), is(emptyString()));
    }

    @Then("the field Year in the UA entry has the value {int}")
    public void year_has_the_value(Integer year) {
        assertThat(uaLegantoEntry.getYear(), is(equalTo(year)));
    }

    @Then("the field SearchableId1 in the UA entry is empty")
    public void searchableid1_is_empty() {
        assertThat(uaLegantoEntry.getSearchableId1(), is(emptyString()));
    }

    @Then("the field SearchableId2 in the UA entry is empty")
    public void searchableid2_is_empty() {
        assertThat(uaLegantoEntry.getSearchableId2(), is(emptyString()));
    }

    @Then("the field AllSearchableIds in the UA entry is the string {string}")
    public void allsearchableids_is_the_string(String searchableId) throws JsonProcessingException {

        assertThat(uaLegantoEntry.getAllSearchableIds(), is(equalTo(searchableId)));

    }

    @Then("the field Instructor{int} in the UA entry is empty")
    public void instructor_is_empty(Integer index) {
        assertThat(uaLegantoEntry.getInstructor(), is(emptyString()));
    }

    @Then("the field SubmitByDate in the UA entry is empty")
    public void submitByDateIsEmpty() {
        assertThat(uaLegantoEntry.getSubmitByDate(), is(emptyString()));
    }

    @Then("the field CampusParticipants in the UA entry is the string {string}")
    public void campusparticipantsIsTheString(String campuses) {
        assertThat(uaLegantoEntry.getCampusParticipants(), is(equalTo(campuses)));
    }

    @Then("the field Reading List Name in the UA entry is empty")
    public void readingListNameIsEmpty() {
        assertThat(uaLegantoEntry.getReadingListName(), is(emptyString()));
    }

    @Then("the field NumberOfParticipants in the UA entry has the value {int}")
    public void numberofparticipants_has_the_value(Integer numberOfParticipants) {
        assertThat(uaLegantoEntry.getNumberOfParticipants(),
            is(equalTo(numberOfParticipants.toString())));
    }

    @Then("the field Old Course Code in the UA entry is the string {string}")
    public void old_Course_Code_is_the_string(String oldCourseCode) {
        assertThat(uaLegantoEntry.getOldCourseCode(), is(equalTo(oldCourseCode)));
    }

    @Then("the field Old Course Section ID in the UA entry is the string {string}")
    public void old_Course_Section_ID_is_the_string(String oldCourseSectionId) {
        assertThat(uaLegantoEntry.getOldCourseSectionId(), is(equalTo(oldCourseSectionId)));
    }

    @Then("the field Operation in the UA entry is the string {string}")
    public void operationIsTheString(String operation) {
        assertThat(uaLegantoEntry.getOperation(), is(equalTo(operation)));
    }

    @Then("the field OldCourseCode in the UA entry is empty")
    public void oldcourseCodeIsEmpty() {
        assertThat(uaLegantoEntry.getOldCourseCode(), is(emptyString()));
    }

    @Then("the field OldCourseSectionId in the UA entry is empty")
    public void oldcoursesectionidIsEmpty() {
        assertThat(uaLegantoEntry.getOldCourseSectionId(), is(emptyString()));
    }

    @Then("the field Operation in the UA entry is empty")
    public void operationIsEmpty() {
        assertThat(uaLegantoEntry.getOperation(), is(emptyString()));
    }

}
