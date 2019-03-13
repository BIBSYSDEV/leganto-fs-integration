package leganto;

import fs.common.Language;
import fs.emne.Emne;
import fs.organizations.OrganizationEntity;
import fs.ua.SemesterCode;
import fs.ua.UaCourseTitle;
import fs.ua.UndervisningsAktivitet;
import fs.user.UserInput;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class UaLegantoEntry {

    public static final String FIELD_DELIMITER = "\t";
    public static final String COURSE_CODE_DELIMITER = "-";
    public static final String COURSE_CODE_PREFIX_DELIMITER = "_";
    public static final String PREFIX = "UA";
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ISO_DATE;
    private static final int NUMBER_OF_FIELDS = 34;
    private static final String ORGANIZATION_DELIMITER = "_";
    private static final String INVALID_EMNE_RECORD = "Emne record without emneNavn";
    private static final String PROCESSING_DEPARTMENT_INVARIANT = "LEGANTO";
    private static final String EMPTY_STRING = "";

    private final transient UndervisningsAktivitet ua;

    private final transient List<Language> languageOrder;
    private transient OrganizationEntity organisationEntity;
    private transient Emne emne;
    private transient String courseTitle;
    private transient String courseCode;

    private transient String sectionId;
    private transient String academicDepartment;
    private transient String term1;
    private transient String startDate;
    private transient String endDate;
    private transient Integer year;

    public UaLegantoEntry(UndervisningsAktivitet ua, UserInput userInput) {
        this.ua = ua;
        this.languageOrder = userInput.getLanguages();
    }

    public UaLegantoEntry populateFields() {
        this.courseCode = initCourseCode();
        this.courseTitle = initCourseTitle();
        this.sectionId = iniSectionId();
        this.academicDepartment = initAcademicDepartment();
        this.term1 = initTerm1();
        this.startDate = initStartDate();
        this.endDate = initEndDate();
        this.year = initYear();
        return this;
    }

    private Integer initYear() {
        return this.ua.getSemester().getYear();
    }

    private String initEndDate() {
        Integer year = ua.getSemester().getYear();
        LocalDate endDate = getSemesterCode().semesterEndDate(year);
        return dateFormatter.format(endDate);
    }

    private String initStartDate() {
        Integer year = ua.getSemester().getYear();
        LocalDate startDate = getSemesterCode().semesterStartDate(year);
        return dateFormatter.format(startDate);
    }

    private String initTerm1() {
        return this.term1 = getSemesterCode().toString();
    }

    private String initAcademicDepartment() {
        return String.join(ORGANIZATION_DELIMITER,
            organisationEntity.getInstitution().toString(),
            organisationEntity.getFaculty().toString(),
            organisationEntity.getInstitute().toString());
    }

    private String initCourseTitle() {

        String emneNavn = Language.getValueForLanguagePref(emne.getNavn(), languageOrder)
            .orElse(emne.getNavn().stream()
                .findAny().orElseThrow(() -> new IllegalArgumentException(INVALID_EMNE_RECORD))
                .getValue());

        String uaNavn = Language.getValueForLanguagePref(ua.getNanv(), languageOrder)
            .orElse(ua.getNanv().stream()
                .findAny().orElseThrow(() -> new IllegalArgumentException(INVALID_EMNE_RECORD))
                .getValue());

        return UaCourseTitle.DEFAULT.formatUaCourseTitle(
            uaNavn,
            emneNavn,
            ua.getUndervisning().getEmne().getCode(),
            getSemesterCode(),
            ua.getUndervisning().getUaSemester().getYear());
    }

    private String initCourseCode() {
        String codePrefix = String.join(COURSE_CODE_PREFIX_DELIMITER, PREFIX, ua.getEmne().getCode());
        return String.join(COURSE_CODE_DELIMITER,
            codePrefix,
            ua.getEmne().getVersion(),
            ua.getUndervisning().getUaSemester().getYear().toString(),
            getSemesterCode().toString()
        );
    }

    private String iniSectionId() {
        return ua.getEmne().getVersion();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < NUMBER_OF_FIELDS; i++) {
            builder.append(FIELD_DELIMITER);
        }

        return builder.toString();
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public UaLegantoEntry setEmne(Emne emne) {
        this.emne = emne;
        return this;
    }

    public String getSectionId() {
        return this.sectionId;
    }

    public String getAcademicDepartment() {
        return this.academicDepartment;
    }

    public UaLegantoEntry setOrganizationEntity(OrganizationEntity organizationEntity) {
        this.organisationEntity = organizationEntity;
        return this;
    }

    public String getProcessingDepartment() {
        return PROCESSING_DEPARTMENT_INVARIANT;
    }

    public String getTerm1() {
        return term1;
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

    public String getStartDate() {
        return this.startDate;
    }

    private SemesterCode getSemesterCode() {
        return ua.getSemester().getSemesterCode();
    }

    public String getEndDate() {
        return this.endDate;
    }

    public String getWeeklyHours() {
        return EMPTY_STRING;
    }

    public Integer getYear() {
        return this.year;
    }
}