package featuretests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.text.IsEmptyString.emptyString;
import static utils.JsonUtils.putKeyInNode;
import static utils.JsonUtils.readValue;
import static utils.JsonUtils.write;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Preconditions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fs.common.Person;
import fs.common.UEmne;
import fs.emne.Emne;
import fs.organizations.OrganizationEntity;
import fs.personroller.PersonRole;
import fs.personroller.UndervisningReference;
import fs.ua.SemesterCode;
import fs.ua.USemester;
import fs.ue.UndervisiningEntry;
import fs.user.UserInput;
import io.cucumber.datatable.DataTable;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import leganto.UaLegantoEntry;
import leganto.UeLegantoEntry;
import utils.JsonUtils;

public class UeFeatureTest extends CucumberTestProcessor implements FeatureTestsErrorMessages {

  private static final int INCLUDE_EMPTY_STRINGS_BETWEEN_DELIMITER = -1;
  private static final String EMPTY_STRING = "";
  private static final String NULL_UE_RESPONSE_MESSAGE = "undervisingsentry response is empty";
  public static final String PERSON_LIST_NOT_INITIALIZED = "PersonList not initialized";


  private transient ObjectNode ueEntry;
  private transient Results result;

  public UeFeatureTest(World world, Results results) {
    super(world);
    this.result = results;
  }

  @Given("there is a valid response from \\/undervisning\\/UE_ID")
  public void there_is_a_valid_response_from_undervisning_UE_ID() throws IOException {
    UEmne uemne = new UEmne()
      .setCode(EMPTY_STRING)
      .setHref(EMPTY_STRING)
      .setInstitution(EMPTY_STRING)
      .setVersion(EMPTY_STRING);

    USemester semester = new USemester()
      .setSemesterCode(SemesterCode.AUTUMN.toString())
      .setHref(EMPTY_STRING)
      .setYear(0);

    UndervisiningEntry ue = new UndervisiningEntry()
      .setEmne(uemne)
      .setSemester(semester)
      .setTerminNummer(EMPTY_STRING)
      .setHref(EMPTY_STRING);

    String ueJson = write(ue);
    ueEntry = readValue(ueJson, ObjectNode.class);

  }

  @Given("the response from \\/undervisning\\/UE_ID has a field with name {string} and value {string}")
  public void the_response_from_undervisning_UE_ID_has_a_field_with_name_and_value(String key,
                                                                                   String value) {
    putKeyInNode(ueEntry, key, value);
  }

  @When("a new UE Leganto entry has been generated")
  public void new_UE_entry_is_generated() throws IOException {
    Preconditions.checkNotNull(ueEntry, NULL_UE_RESPONSE_MESSAGE);
    Preconditions.checkNotNull(world.getUserInput(), NULL_USER_INPUT_MESSAGE);
    Preconditions.checkNotNull(world.getOrganizationEntity(), NULL_ORG_ENTITY_MESSAGE);
    Preconditions.checkNotNull(world.getEmneResponse(), NULL_EMNE_MESSAGE);
    Preconditions.checkNotNull(world.getPersonRolleEntries(), NULL_PERSONROLE_MESSAGE);

    UndervisiningEntry ue = readValue(ueEntry, UndervisiningEntry.class);
    UserInput userInput = readValue(world.getUserInput(), UserInput.class).initFiles();
    OrganizationEntity orgEntity = readValue(world.getOrganizationEntity(),
      OrganizationEntity.class);
    Emne emne = readValue(world.getEmneResponse(), Emne.class);

    UeLegantoEntry ueLegantoEntry = (UeLegantoEntry) new UeLegantoEntry(ue, userInput)
      .setEmne(emne)
      .setOrganizationEntity(orgEntity)
      //.setInstructors(persons);
      ;
    result.setUeLegantoEntry(ueLegantoEntry);
  }

  private Person getPerson(ObjectNode json) {
    try {
      return JsonUtils.readValue(json, Person.class);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }

  @When("a new UE Leganto entry has been generated with persons")
  public void aNewUELegantoEntryHasBeenGeneratedWithPersons() throws IOException {
    new_UE_entry_is_generated();
    List<Person> persons = world.getPersons()
      .stream()
      .map(json -> getPerson(json))
      .collect(Collectors.toList());
    result.getUeLegantoEntry()
      .setInstructors(persons);
  }

  @Then("the new UE Leganto entry has the following fields")
  public void the_new_UE_Leganto_entry_has_the_following_fields(DataTable dataTable) {

    int actualNumberOfFields = result.getUeLegantoEntry()
      .toString()
      .split(UaLegantoEntry.FIELD_DELIMITER, INCLUDE_EMPTY_STRINGS_BETWEEN_DELIMITER)
      .length;
    assertThat(actualNumberOfFields, is(equalTo(dataTable.height() + 1)));
  }

  @Then("the field CourseCode in the UE entry is the string {string}")
  public void the_field_CourseCode_in_the_UE_entry_is_the_string(String courseCode) {
    assertThat(result.getUeLegantoEntry()
      .getCourseCode(), is(equalTo(courseCode)));
  }

  @Then("the field CourseTitle in the UE entry is the string {string}")
  public void theFieldCourseTitleInTheUeEntryIsTheString(String courseTitle) {
    assertThat(result.getUeLegantoEntry()
      .getCourseTitle(), is(equalTo(courseTitle)));
  }

  @Then("the field SectionId  in the UE entry is the string {string}")
  public void theFieldSectionIdInTheUEEntryIsTheString(String sectionId) {
    assertThat(result.getUeLegantoEntry()
      .getSectionId(), is(equalTo(sectionId)));
  }

  @Then("the field AcademicDepartment in the UE entry is the  string {string}")
  public void the_field_AcademicDepartment_in_the_UE_entry_is_the_string(
    String academicDepartment) {
    assertThat(result.getUeLegantoEntry()
      .getAcademicDepartment(), is(equalTo(academicDepartment)));
  }

  @Then("the field ProcessingDepartment in the UE entry is the invariant string LEGANTO")
  public void theFieldProcessingDepartmentInTheUEEntryIsTheInvariantStringLeganto() {
    assertThat(result.getUeLegantoEntry()
      .getProcessingDepartment(), is(equalTo("LEGANTO")));
  }

  @Then("the field Term1 in the UE entry is the string {string}")
  public void theFieldTerm1inTheUEEntryIsTheString(String term1) {
    assertThat(result.getUeLegantoEntry()
      .getTerm1(), is(equalTo(term1)));
  }

  @Then("the field Term2 in the UE entry is empty")
  public void the_field_Term2_in_the_UE_entry_is_empty() {
    assertThat(result.getUeLegantoEntry()
      .getTerm2(), is(emptyString()));
  }

  @Then("the field Term3 in the UE entry is empty")
  public void the_field_Term3_in_the_UE_entry_is_empty() {
    assertThat(result.getUeLegantoEntry()
      .getTerm3(), is(emptyString()));
  }

  @Then("the field Term4 in the UE entry is empty")
  public void the_field_Term4_in_the_UE_entry_is_empty() {
    assertThat(result.getUeLegantoEntry()
      .getTerm4(), is(emptyString()));
  }

  @Then("the field StartDate in the UE entry is the string {string}")
  public void theFieldStartDateInTheUEEntryIsTheString(String startDate) {
    assertThat(result.getUeLegantoEntry()
      .getStartDate(), is(equalTo(startDate)));
  }

  @Then("the field EndDate in the UE entry is the string {string}")
  public void theFieldEndDateInTheUEEntryIsTheString(String endDate) {
    assertThat(result.getUeLegantoEntry()
      .getEndDate(), is(equalTo(endDate)));
  }

  @Then("the field NumberOfParticipants in the UE entry is the integer {int}")
  public void theFieldNumberOfParticipantsInTheUEEntryIsTheInteger(Integer numberOfParticipants) {
    assertThat(result.getUeLegantoEntry()
        .getNumberOfParticipants(),
      is(equalTo(numberOfParticipants.toString())));
  }

  @Then("the field WeeklyHours in the UE entry is empty")
  public void theFieldWeeklyHoursInTheUEEntryIsEmpty() {
    assertThat(result.getUeLegantoEntry()
      .getWeeklyHours(), is(emptyString()));
  }

  @Then("the field Year in the UE entry has the value {int}")
  public void theFieldYearInTheUEEntryHasTheValue(int year) {
    assertThat(result.getUeLegantoEntry()
      .getYear(), is(equalTo(year)));
  }

  @Then("the field SearchableId1 in the UE entry is empty")
  public void theFiledSearchableId1InTheUEEntryIsEmpty() {
    assertThat(result.getUeLegantoEntry()
      .getSearchableId1(), is(emptyString()));
  }

  @Then("the field SearchableId2 in the UE entry is empty")
  public void theFiledSearchableId2InTheUEEntryIsEmpty() {
    assertThat(result.getUeLegantoEntry()
      .getSearchableId2(), is(emptyString()));
  }

  @Then("the field AllSearchableIds in the UE entry is the string {string}")
  public void the_field_AllSearchableIds_in_the_UE_entry_is_the_string(String searchableIds) {
    assertThat(result.getUeLegantoEntry()
      .getAllSearchableIds(), is(equalTo(searchableIds)));
  }

  @Then("the field Instructor{int} in the UE entry is empty")
  public void theFieldInstructorInTheUEEntryIsEmpty(int arg0) {
    assertThat(result.getUeLegantoEntry()
      .getInstructor(), is(emptyString()));
  }

  @Then("the field Operation in the UE entry is the the string {string}")
  public void the_filed_Operation_in_the_UE_entry_is_the_the_string(String operation) {
    assertThat(result.getUeLegantoEntry()
      .getOperation()
      .toString(), is(equalTo(operation)));
  }

  @Then("the field SubmitByDate in the UE entry is empty")
  public void the_field_SubmitByDate_in_the_UE_entry_is_empty() {
    assertThat(result.getUeLegantoEntry()
      .getSubmitByDate(), is(emptyString()));
  }

  @Then("the field CampusParticipants in the UE entry is the string {string}")
  public void the_field_CampusParticipants_is_the_string(String campusParticipants) {
    assertThat(result.getUeLegantoEntry()
      .getCampusParticipants(), is(equalTo(campusParticipants)));
  }

  @Then("the field ReadingListName in the is empty")
  public void the_field_ReadingListName_in_the_is_empty() {
    assertThat(result.getUeLegantoEntry()
      .getReadingListName(), is(emptyString()));
  }

  @Then("the field OldCourseCode in the UE entry is empty")
  public void the_field_OldCourseCode_in_the_UE_entry_is_empty() {
    assertThat(result.getUeLegantoEntry()
      .getOldCourseCode(), is(emptyString()));
  }

  @Then("the field OldCourseSectionId in the UE entry is empty")
  public void the_field_OldCourseSectionId_in_the_UE_entry_is_empty() {
    assertThat(result.getUeLegantoEntry()
      .getOldCourseSectionId(), is(emptyString()));
  }

  @Then("the field OldCourseCode in the UE entry is the string {string}")
  public void the_field_OldCourseCode_in_the_UE_entry_is_the_string(
    String expectedOldCourseCode) {
    assertThat(result.getUeLegantoEntry()
      .getOldCourseCode(), is(equalTo(expectedOldCourseCode)));
  }

  @Then("the field OldCourseSectionId is the string {string}")
  public void the_field_OldCourseSectionId_is_the_string(String expectedOldCourseSectionId) {
    assertThat(result.getUeLegantoEntry()
      .getOldCourseSectionId(), is(equalTo(expectedOldCourseSectionId)));
  }

  @Then("the field Operation in the UE entry  is the string {string}")
  public void the_field_Operation_in_the_UE_entry_is_the_string(String expectedOperation) {
    assertThat(result.getUeLegantoEntry()
      .getOperation(), is(equalTo(expectedOperation)));
  }

  @Then("the field Operation in the UE entry is empty")
  public void the_field_Operation_in_the_UE_entry_is_empty() {
    assertThat(result.getUeLegantoEntry()
      .getOperation(), is(emptyString()));
  }

  @Then("the field AllInstuctors in the UE entry is empty")
  public void theFieldAllInstuctorsInTheUEEntryIsEmpty() throws JsonProcessingException {
    assertThat(result.getUeLegantoEntry()
      .getAllInstructorIds(), is(emptyString()));
  }

  @Then("the field CampusParticipants in the UE entry is empty")
  public void the_field_CampusParticipants_in_the_UE_entry_is_empty() {
    assertThat(result.getUeLegantoEntry()
      .getCampusParticipants(), is(emptyString()));
  }

  @Then("the field NumberOfParticipants in the UE entry is empty")
  public void the_field_NumberOfParticipants_in_the_UE_entry_is_empty() {
    assertThat(result.getUeLegantoEntry()
      .getNumberOfParticipants(), is(emptyString()));
  }


}
