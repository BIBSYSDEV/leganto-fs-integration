package leganto;

import fs.common.LanguageValue;
import fs.emne.Emne;
import fs.organizations.OrganizationEntity;
import fs.user.Operation;
import fs.user.UserInput;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public abstract class LegantoEntry {

    public static final String FIELD_DELIMITER = "\t";
    protected static final String DEFAULT_DELIMITER = "_";
    protected static final String PROCESSING_DEPARTMENT_INVARIANT = "LEGANTO";
    protected static final String EMPTY_STRING = "";
    private static final String ILLEGAL_STATE_MESSAGE = "Not available";
    private static final int NUMBER_OF_FIELDS = 34;
    private static final String INVALID_EMNE_RECORD = "Emne record without emneNavn";
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ISO_DATE;

    protected final transient UserInput userInput;
    protected transient Emne emne;
    protected transient OrganizationEntity organizationEntity;

    public LegantoEntry(UserInput userInput) {
        this.userInput = userInput;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < NUMBER_OF_FIELDS; i++) {
            builder.append(FIELD_DELIMITER);
        }

        return builder.toString();
    }

    protected String getRandomValue(List<LanguageValue> valueList) {
        return valueList.stream()
            .findAny().orElseThrow(() -> new IllegalArgumentException(INVALID_EMNE_RECORD))
            .getValue();
    }

    public String getCourseCode() {
        throw new IllegalStateException(ILLEGAL_STATE_MESSAGE);
    }

    public String getCourseTitle() {
        throw new IllegalStateException(ILLEGAL_STATE_MESSAGE);
    }

    public String getSectionId() {
        throw new IllegalStateException(ILLEGAL_STATE_MESSAGE);
    }

    public final String getAcademicDepartment() {
        return String.join(DEFAULT_DELIMITER,
            organizationEntity.getInstitution().toString(),
            organizationEntity.getFaculty().toString(),
            organizationEntity.getInstitute().toString());
    }

    public final String getProcessingDepartment() {
        return PROCESSING_DEPARTMENT_INVARIANT;
    }

    public String getTerm1() {
        throw new IllegalStateException(ILLEGAL_STATE_MESSAGE);
    }

    public final String getTerm2() {
        return EMPTY_STRING;
    }

    public String getTerm3() {
        return EMPTY_STRING;
    }

    public String getTerm4() {
        return EMPTY_STRING;
    }

    public String getStartDate() {
        throw new IllegalStateException(ILLEGAL_STATE_MESSAGE);
    }

    public String getEndDate() {
        throw new IllegalStateException(ILLEGAL_STATE_MESSAGE);
    }

    public String getWeeklyHours() {
        throw new IllegalStateException(ILLEGAL_STATE_MESSAGE);
    }

    public Integer getYear() {
        throw new IllegalStateException(ILLEGAL_STATE_MESSAGE);
    }

    public String getSearchableId1() {
        throw new IllegalStateException(ILLEGAL_STATE_MESSAGE);
    }

    public String getSearchableId2() {
        throw new IllegalStateException(ILLEGAL_STATE_MESSAGE);
    }

    public String getAllSearchableIds() {
        throw new IllegalStateException(ILLEGAL_STATE_MESSAGE);
    }

    public String getInstructor() {
        throw new IllegalStateException(ILLEGAL_STATE_MESSAGE);
    }

    public Operation getOperation() {
        throw new IllegalStateException(ILLEGAL_STATE_MESSAGE);
    }

    public String getSubmitByDate() {
        throw new IllegalStateException(ILLEGAL_STATE_MESSAGE);
    }

    public String getCampusParticipants() {
        throw new IllegalStateException(ILLEGAL_STATE_MESSAGE);
    }

    public String getReadingListName() {
        throw new IllegalStateException(ILLEGAL_STATE_MESSAGE);
    }

    public String getNumberOfParticipants() {
        throw new IllegalStateException(ILLEGAL_STATE_MESSAGE);
    }

    public String getOldCourseCode() {
        throw new IllegalStateException(ILLEGAL_STATE_MESSAGE);
    }

    public String getOldCourseSectionId() {
        throw new IllegalStateException(ILLEGAL_STATE_MESSAGE);
    }

    public final Emne getEmne() {
        return emne;
    }

    public final LegantoEntry setEmne(Emne emne) {
        this.emne = emne;
        return this;
    }

    public final LegantoEntry setOrganizationEntity(OrganizationEntity organizationEntity) {
        this.organizationEntity = organizationEntity;
        return this;
    }

    protected String dateToString(LocalDate date) {
        return dateFormatter.format(date);
    }
}
