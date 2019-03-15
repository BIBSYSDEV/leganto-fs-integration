package leganto;

import fs.common.Language;
import fs.emne.Emne;
import fs.organizations.OrganizationEntity;
import fs.ua.SemesterCode;
import fs.ua.UaCourseTitle;
import fs.ua.UndervisningsAktivitet;
import fs.user.Operation;
import fs.user.UserInput;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UaLegantoEntry extends LegantoEntry {

    public static final String COURSE_CODE_DELIMITER = "-";
    public static final String COURSE_CODE_PREFIX_DELIMITER = "_";
    public static final String PREFIX = "UA";
    private static final String DEFAULT_DELIMITER = "_";
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ISO_DATE;

    private static final String INVALID_EMNE_RECORD = "Emne record without emneNavn";
    private static final String PROCESSING_DEPARTMENT_INVARIANT = "LEGANTO";
    private static final String EMPTY_STRING = "";
    private static final String CAMPUS_PARTICIPANTS_DELIMITER = ",";

    private final transient UndervisningsAktivitet ua;

    private final transient UserInput userInput;

    private transient OrganizationEntity organisationEntity;
    private transient Emne emne;


    public UaLegantoEntry(UndervisningsAktivitet ua, UserInput userInput) {
        this.ua = ua;
        this.userInput = userInput;
    }

    public String getEndDate() {
        Integer year = ua.getSemester().getYear();
        LocalDate endDate = getSemesterCode().semesterEndDate(year);
        return dateFormatter.format(endDate);
    }

    public String getStartDate() {
        Integer year = ua.getSemester().getYear();
        LocalDate startDate = getSemesterCode().semesterStartDate(year);
        return dateFormatter.format(startDate);
    }

    public String getTerm1() {
        return getSemesterCode().toString();
    }

    public String getAcademicDepartment() {
        return String.join(DEFAULT_DELIMITER,
            organisationEntity.getInstitution().toString(),
            organisationEntity.getFaculty().toString(),
            organisationEntity.getInstitute().toString());
    }

    public String getCourseTitle() {

        String emneNavn = Language
            .getValueForLanguagePref(emne.getNavn(), userInput.getLanguageOrder())
            .orElse(emne.getNavn().stream()
                .findAny().orElseThrow(() -> new IllegalArgumentException(INVALID_EMNE_RECORD))
                .getValue());

        String uaNavn = Language.getValueForLanguagePref(ua.getNanv(), userInput.getLanguageOrder())
            .orElse(ua.getNanv().stream()
                .findAny().orElseThrow(() -> new IllegalArgumentException(INVALID_EMNE_RECORD))
                .getValue());

        return UaCourseTitle.DEFAULT.formatUaCourseTitle(
            uaNavn,
            emneNavn,
            ua.getUndervisning().getEmne().getCode(),
            getSemesterCode(),
            ua.getUndervisning().getuSemester().getYear());
    }

    public String getCourseCode() {
        String codePrefix = String
            .join(COURSE_CODE_PREFIX_DELIMITER, PREFIX, ua.getEmne().getCode());
        return String.join(COURSE_CODE_DELIMITER,
            codePrefix,
            ua.getEmne().getVersion(),
            ua.getUndervisning().getuSemester().getYear().toString(),
            getSemesterCode().toString()
        );
    }

    public String getSectionId() {
        return ua.getEmne().getVersion();
    }



    public UaLegantoEntry setEmne(Emne emne) {
        this.emne = emne;
        return this;
    }


    public UaLegantoEntry setOrganizationEntity(OrganizationEntity organizationEntity) {
        this.organisationEntity = organizationEntity;
        return this;
    }

    public String getProcessingDepartment() {
        return PROCESSING_DEPARTMENT_INVARIANT;
    }


    public String getTerm2() {
        return EMPTY_STRING;
    }

    public String getTerm3() {
        return EMPTY_STRING;
    }

    public String getTerm4() {
        return EMPTY_STRING;
    }


    private SemesterCode getSemesterCode() {
        return ua.getSemester().getSemesterCode();
    }


    public String getWeeklyHours() {
        return EMPTY_STRING;
    }

    public Integer getYear() {
        return this.ua.getSemester().getYear();
    }

    public String getSearchableId1() {
        return EMPTY_STRING;
    }

    public String getSearchableId2() {
        return EMPTY_STRING;
    }

    public String getAllSearchableIds() {
        return String.join(DEFAULT_DELIMITER,
            PREFIX,
            organisationEntity.getInstitution().toString(),
            ua.getEmne().getCode(),
            ua.getEmne().getVersion(),
            ua.getSemester().getYear().toString(),
            ua.getSemester().getSemesterCode().toString(),
            ua.getUndervisning().getTerminnumer().toString(),
            ua.getAktivitet()
        );
    }

    public String getInstructor() {
        return EMPTY_STRING;
    }

    public Operation getOperation() {
        return userInput.getOperation();
    }

    public String getSubmitByDate() {
        return EMPTY_STRING;
    }

    public String getCampusParticipants() {
        if (userInput.getCampuses().isEmpty()) {
            return EMPTY_STRING;
        } else {
            return String.join(CAMPUS_PARTICIPANTS_DELIMITER, userInput.getCampuses());
        }
    }

    public String getReadingListName() {
        return EMPTY_STRING;
    }

    public String getNumberOfParticipants() {
        return this.userInput.getParticipants(getCourseCode()).orElse(EMPTY_STRING);
    }

    public String getOldCourseCode() {
        if (Operation.ROLLOVER.equals(userInput.getOperation())) {
            return calculateOldCourseCode();
        } else {
            return EMPTY_STRING;
        }

    }

    private String calculateOldCourseCode() {
        Integer lastYear = ua.getSemester().getYear() - 1;
        String courseCodePrefix = String.join(COURSE_CODE_PREFIX_DELIMITER, PREFIX,
            ua.getEmne().getCode()
        );
        return String.join(COURSE_CODE_DELIMITER,
            courseCodePrefix,
            ua.getEmne().getVersion(),
            lastYear.toString(),
            getSemesterCode().toString()
        );
    }

    public String getOldCourseSectionId() {
        if (Operation.ROLLOVER.equals(userInput.getOperation())) {
            return ua.getEmne().getVersion();
        } else {
            return EMPTY_STRING;
        }

    }
}
