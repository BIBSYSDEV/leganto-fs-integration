package leganto;

import fs.common.Language;
import fs.common.UEmne;
import fs.ua.USemester;
import fs.ue.UndervisiningEntry;
import fs.user.Operation;
import fs.user.UserInput;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UeLegantoEntry extends LegantoEntry {

    private static final String COURSE_CODE_DELIMITER = "-";
    private static final String UE_ID_PREFIX = "UE";
    private static final String UA_ID_PREFIX = "UA";
    private static final String ID_SEPARATOR = ",";
    private static final int PREVIOUS_YEAR = 1;

    private final transient UndervisiningEntry ue;

    public UeLegantoEntry(UndervisiningEntry ue, UserInput userInput) {
        super(userInput);
        this.ue = ue;
    }

    @Override
    public String getCourseCode() {
        return generateCourseCode(ue.getSemester().getYear());
    }

    private String generateCourseCode(Integer year) {
        return String.join(COURSE_CODE_DELIMITER,
            getUeEmne().getCode(),
            getUeEmne().getVersion(),
            year.toString(),
            getUeSemester().getSemesterCode().toString());
    }

    @Override
    public String getCourseTitle() {
        return Language
            .getValueForLanguagePref(emne.getNavn(), userInput.getLanguageOrder())
            .orElse(getRandomValue(emne.getNavn()));
    }

    @Override
    public String getSectionId() {
        return getUeEmne().getVersion();
    }

    @Override
    public String getTerm1() {
        return getUeSemester().getSemesterCode().toString();
    }

    @Override
    public String getStartDate() {
        LocalDate startDate = getUeSemester().getSemesterCode().semesterStartDate(getUeSemester().getYear());
        return dateToString(startDate);
    }

    @Override
    public String getEndDate() {
        LocalDate endDate = getUeSemester().getSemesterCode().semesterEndDate(getUeSemester().getYear());
        return dateToString(endDate);
    }

    @Override
    public Integer getYear() {
        return getUeSemester().getYear();
    }

    @Override
    public String getAllSearchableIds() {

        List<String> searchableId1 = new ArrayList<>();
        searchableId1.add(UE_ID_PREFIX);
        searchableId1.addAll(searchableIdSuffix());
        String searchableId1String = String.join(DEFAULT_DELIMITER, searchableId1);

        List<String> searchableId2 = new ArrayList<>();
        searchableId2.add(UA_ID_PREFIX);
        searchableId2.addAll(searchableIdSuffix());
        String searchableId2String = String.join(DEFAULT_DELIMITER, searchableId2);

        return String.join(ID_SEPARATOR, searchableId1String, searchableId2String);
    }

    private List<String> searchableIdSuffix() {
        return Arrays.asList(
            organizationEntity.getInstitution().toString(),
            getUeEmne().getCode(),
            getUeEmne().getVersion(),
            getYear().toString(),
            getUeSemester().getSemesterCode().toString(),
            ue.getTerminNummer()
        );
    }

    @Override
    public String getNumberOfParticipants() {
        return userInput.getParticipants(getCourseCode()).orElse(EMPTY_STRING);
    }

    @Override
    public String getOldCourseCode() {
        if (Operation.ROLLOVER.equals(userInput.getOperation())) {
            return generateCourseCode(getUeSemester().getYear() - PREVIOUS_YEAR);
        } else {
            return EMPTY_STRING;
        }
    }

    @Override
    public String getOldCourseSectionId() {
        if (Operation.ROLLOVER.equals(userInput.getOperation())) {
            return ue.getEmne().getVersion();
        } else {
            return EMPTY_STRING;
        }
    }

    private UEmne getUeEmne() {
        return ue.getEmne();
    }

    private USemester getUeSemester() {
        return ue.getSemester();
    }
}
