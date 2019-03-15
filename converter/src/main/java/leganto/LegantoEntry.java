package leganto;

import fs.user.Operation;

public abstract class LegantoEntry {

    public static final String FIELD_DELIMITER = "\t";
    private static final int NUMBER_OF_FIELDS = 34;
    public static final String ILLEGAL_STATE_MESSAGE = "Not available";

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < NUMBER_OF_FIELDS; i++) {
            builder.append(FIELD_DELIMITER);
        }

        return builder.toString();
    }

    public String getCourseCode() {
        throw new IllegalStateException(ILLEGAL_STATE_MESSAGE);
    }

    ;

    public String getCourseTitle() {
        throw new IllegalStateException(ILLEGAL_STATE_MESSAGE);
    }

    public String getSectionId() {
        throw new IllegalStateException(ILLEGAL_STATE_MESSAGE);
    }

    public String getAcademicDepartment() {
        throw new IllegalStateException(ILLEGAL_STATE_MESSAGE);
    }

    public String getProcessingDepartment() {
        throw new IllegalStateException(ILLEGAL_STATE_MESSAGE);
    }

    public String getTerm1() {
        throw new IllegalStateException(ILLEGAL_STATE_MESSAGE);
    }

    public String getTerm2() {
        throw new IllegalStateException(ILLEGAL_STATE_MESSAGE);
    }

    public String getTerm3() {
        throw new IllegalStateException(ILLEGAL_STATE_MESSAGE);
    }

    public String getTerm4() {
        throw new IllegalStateException(ILLEGAL_STATE_MESSAGE);
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
}
