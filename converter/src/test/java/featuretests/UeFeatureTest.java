package featuretests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.text.IsEmptyString.emptyString;
import static utils.JsonUtils.putKeyInNode;
import static utils.JsonUtils.readValue;

import com.fasterxml.jackson.databind.node.ObjectNode;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fs.emne.Emne;
import fs.organizations.OrganizationEntity;
import fs.ue.UndervisiningEntry;
import fs.user.UserInput;
import io.cucumber.datatable.DataTable;
import java.io.IOException;
import leganto.UaLegantoEntry;
import leganto.UeLegantoEntry;
import utils.JsonUtils;

public class UeFeatureTest extends CucumberTestProcessor {

    private static final int INCLUDE_EMPTY_STRINGS_BETWEEN_DELIMITER = -1;

    private final World world;
    private transient ObjectNode ueEntry;
    private UeLegantoEntry ueLegantoEntry;

    public UeFeatureTest(World world) {
        this.world = world;
    }

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
    public void new_UE_entry_is_generated() throws IOException {
        UndervisiningEntry ue = readValue(ueEntry, UndervisiningEntry.class);
        UserInput userInput = readValue(world.getUserInput(), UserInput.class);

        OrganizationEntity orgEntity = readValue(world.getOrganizationEntity(), OrganizationEntity.class);
        Emne emne = readValue(world.getEmneResponse(), Emne.class);
        ueLegantoEntry = (UeLegantoEntry) new UeLegantoEntry(ue, userInput)
            .setEmne(emne)
            .setOrganizationEntity(orgEntity);
    }

    @Then("the new UE Leganto entry has the following fields")
    public void the_new_UE_Leganto_entry_has_the_following_fields(DataTable dataTable) {

        int actualNumberOfFields = ueLegantoEntry.toString()
            .split(UaLegantoEntry.FIELD_DELIMITER, INCLUDE_EMPTY_STRINGS_BETWEEN_DELIMITER)
            .length;
        assertThat(actualNumberOfFields, is(equalTo(dataTable.height() + 1)));
    }

    @Then("the field CourseCode in the UE entry is the string {string}")
    public void the_field_CourseCode_in_the_UE_entry_is_the_string(String courseCode) {
        assertThat(ueLegantoEntry.getCourseCode(), is(equalTo(courseCode)));
    }

    @Then("the field CourseTitle in the UE entry is the string {string}")
    public void theFieldCourseTitleInTheUeEntryIsTheString(String courseTitle) {
        assertThat(ueLegantoEntry.getCourseTitle(), is(equalTo(courseTitle)));
    }

    @Then("the field SectionId  in the UE entry is the string {string}")
    public void theFieldSectionIdInTheUEEntryIsTheString(String sectionId) {
        assertThat(ueLegantoEntry.getSectionId(), is(equalTo(sectionId)));
    }

    @Then("the field AcademicDepartment in the UE entry is the  string {string}")
    public void the_field_AcademicDepartment_in_the_UE_entry_is_the_string(String academicDepartment) {
        assertThat(ueLegantoEntry.getAcademicDepartment(), is(equalTo(academicDepartment)));
    }

    @Then("the field ProcessingDepartment in the UE entry is the invariant string LEGANTO")
    public void theFieldProcessingDepartmentInTheUEEntryIsTheInvariantStringLeganto() {
        assertThat(ueLegantoEntry.getProcessingDepartment(), is(equalTo("LEGANTO")));
    }

    @Then("the field Term1 in the UE entry is the string {string}")
    public void theFieldTerm1inTheUEEntryIsTheString(String term1) {
        assertThat(ueLegantoEntry.getTerm1(), is(equalTo(term1)));
    }

    @Then("the field Term2 in the UE entry is empty")
    public void the_field_Term2_in_the_UE_entry_is_empty() {
        assertThat(ueLegantoEntry.getTerm2(), is(emptyString()));
    }

    @Then("the field Term3 in the UE entry is empty")
    public void the_field_Term3_in_the_UE_entry_is_empty() {
        assertThat(ueLegantoEntry.getTerm3(), is(emptyString()));
    }

    @Then("the field Term4 in the UE entry is empty")
    public void the_field_Term4_in_the_UE_entry_is_empty() {
        assertThat(ueLegantoEntry.getTerm4(), is(emptyString()));
    }

    @Then("the field StartDate in the UE entry is the string {string}")
    public void theFieldStartDateInTheUEEntryIsTheString(String startDate) {
        assertThat(ueLegantoEntry.getStartDate(), is(equalTo(startDate)));
    }

    @Then("the field EndDate in the UE entry is the string {string}")
    public void theFieldEndDateInTheUEEntryIsTheString(String endDate) {
        assertThat(ueLegantoEntry.getEndDate(), is(equalTo(endDate)));
    }

    @Then("the field NumberOfParticipants in the UE entry is the integer {int}")
    public void theFieldNumberOfParticipantsInTheUEEntryIsTheInteger(Integer numberOfParticipants) {
        assertThat(ueLegantoEntry.getNumberOfParticipants(), is(equalTo(numberOfParticipants.toString())));
    }

    @Then("the field WeeklyHours in the UE entry is empty")
    public void theFieldWeeklyHoursInTheUEEntryIsEmpty() {
        assertThat(ueLegantoEntry.getWeeklyHours(), is(emptyString()));
    }

    @Then("the field Year in the UE entry has the value {int}")
    public void theFieldYearInTheUEEntryHasTheValue(int year) {
        assertThat(ueLegantoEntry.getYear(), is(equalTo(year)));
    }

    @Then("the field SearchableId1 in the UE entry is empty")
    public void theFiledSearchableId1InTheUEEntryIsEmpty() {
        assertThat(ueLegantoEntry.getSearchableId1(), is(emptyString()));
    }

    @Then("the field SearchableId2 in the UE entry is empty")
    public void theFiledSearchableId2InTheUEEntryIsEmpty() {
        assertThat(ueLegantoEntry.getSearchableId2(), is(emptyString()));
    }

    @Then("the field AllSearchableIds in the UE entry is the string {string}")
    public void the_field_AllSearchableIds_in_the_UE_entry_is_the_string(String searchableIds) {
        assertThat(ueLegantoEntry.getAllSearchableIds(), is(equalTo(searchableIds)));
    }

    @Then("the field Instructor{int} in the UE entry is empty")
    public void theFieldInstructorInTheUEEntryIsEmpty(int arg0) {
        assertThat(ueLegantoEntry.getInstructor(), is(emptyString()));
    }

    @Then("the field Operation in the UE entry is the the string {string}")
    public void the_filed_Operation_in_the_UE_entry_is_the_the_string(String operation) {
        assertThat(ueLegantoEntry.getOperation().toString(), is(equalTo(operation)));
    }

    @Then("the field SubmitByDate in the UE entry is empty")
    public void the_field_SubmitByDate_in_the_UE_entry_is_empty() {
        assertThat(ueLegantoEntry.getSubmitByDate(), is(emptyString()));
    }

    @Then("the field CampusParticipants in the UE entry is the string {string}")
    public void the_field_CampusParticipants_is_the_string(String campusParticipants) {
        assertThat(ueLegantoEntry.getCampusParticipants(), is(equalTo(campusParticipants)));
    }

    @Then("the field ReadingListName in the is empty")
    public void the_field_ReadingListName_in_the_is_empty() {
        assertThat(ueLegantoEntry.getReadingListName(), is(emptyString()));
    }

    @Then("the field OldCourseCode in the UE entry is empty")
    public void the_field_OldCourseCode_in_the_UE_entry_is_empty() {
        assertThat(ueLegantoEntry.getOldCourseCode(), is(emptyString()));
    }

    @Then("the field OldCourseSectionId in the UE entry is empty")
    public void the_field_OldCourseSectionId_in_the_UE_entry_is_empty() {
        assertThat(ueLegantoEntry.getOldCourseSectionId(), is(emptyString()));
    }

    @Then("the field OldCourseCode in the UE entry is the string {string}")
    public void the_field_OldCourseCode_in_the_UE_entry_is_the_string(String expectedOldCourseCode) {
        assertThat(ueLegantoEntry.getOldCourseCode(), is(equalTo(expectedOldCourseCode)));
    }

    @Then("the field OldCourseSectionId is the string {string}")
    public void the_field_OldCourseSectionId_is_the_string(String expectedOldCourseSectionId) {
        assertThat(ueLegantoEntry.getOldCourseSectionId(), is(equalTo(expectedOldCourseSectionId)));
    }

    @Then("the field Operation in the UE entry  is the string {string}")
    public void the_field_Operation_in_the_UE_entry_is_the_string(String expectedOperation) {
        assertThat(ueLegantoEntry.getOperation(), is(equalTo(expectedOperation)));
    }

    @Then("the field Operation in the UE entry is empty")
    public void the_field_Operation_in_the_UE_entry_is_empty() {
        assertThat(ueLegantoEntry.getOperation(), is(emptyString()));
    }


}
