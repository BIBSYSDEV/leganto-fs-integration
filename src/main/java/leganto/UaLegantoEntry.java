package leganto;

import fs.common.Language;
import fs.emne.Emne;
import fs.organizations.OrganizationEntity;
import fs.ua.UndervisningsAktivitet;
import java.util.List;

public class UaLegantoEntry {

    public static final String FIELD_DELIMITER = "\t";
    public static final String FIELD_DELIMITER_REGEX = "\\t";
    public static final String COURSE_CODE_DELIMITER = "-";
    public static final String COURSE_CODE_PREFIX_DELIMITER = "_";
    public static final String PREFIX = "UA";
    private static final int NUMBER_OF_FIELDS = 34;
    private static final String COURSE_TITLE_DELIMITER = "_";
    private static final String ORGANIZATION_DELIMITER = "_";
    private static final String INVALID_EMNE_RECORD = "Emne record without emneNavn";

    private transient String courseTitle;
    private transient String courseCode;
    private transient UndervisningsAktivitet ua;
    private transient OrganizationEntity organisationEntity;
    private transient Emne emne;

    private transient List<Language> languageOrder;
    private transient String sectionId;
    private transient String academicDepartment;

    public UaLegantoEntry() {
    }

    public UaLegantoEntry populateFields() {
        this.courseCode = initCourseCode();
        this.courseTitle = initCourseTitle();
        this.sectionId = iniSectionId();
        this.academicDepartment = initAcademicDepartment();
        return this;
    }

    private String initAcademicDepartment() {
        return String.join(ORGANIZATION_DELIMITER,
            organisationEntity.getInstitution().toString(),
            organisationEntity.getFaculty().toString(),
            organisationEntity.getInstitute().toString());
    }

    private String initCourseTitle() {

        String emneNavn = Language.getValueForLanguage(emne.getNavn(), languageOrder)
            .orElse(emne.getNavn().stream()
                .findAny().orElseThrow(() -> new IllegalArgumentException(INVALID_EMNE_RECORD))
                .getValue());

        String uaNavn = Language.getValueForLanguage(ua.getNanv(), languageOrder)
            .orElse(ua.getNanv().stream()
                .findAny().orElseThrow(() -> new IllegalArgumentException(INVALID_EMNE_RECORD))
                .getValue());

        return String.join(COURSE_TITLE_DELIMITER,
            emneNavn,
            uaNavn,
            ua.getUndervisning().getEmne().getCode(),
            ua.getUndervisning().getUaSemester().getSemesterCode().toString(),
            ua.getUndervisning().getUaSemester().getYear().toString());
    }

    public UaLegantoEntry setLanguageOrder(List<Language> languageOrder) {
        this.languageOrder = languageOrder;
        return this;
    }

    private String initCourseCode() {
        String codePrefix = String.join(COURSE_CODE_PREFIX_DELIMITER, PREFIX, ua.getEmne().getCode());
        return String.join(COURSE_CODE_DELIMITER,
            codePrefix,
            ua.getEmne().getVersion(),
            ua.getUndervisning().getUaSemester().getYear().toString(),
            ua.getUndervisning().getUaSemester().getSemesterCode().toString());
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

    public UaLegantoEntry setUndervisningsAktivitet(UndervisningsAktivitet ua) {
        this.ua = ua;
        return this;
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
}
