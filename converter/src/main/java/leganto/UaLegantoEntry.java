package leganto;

import com.google.common.base.Preconditions;
import fs.common.Language;
import fs.personroller.UndervisningReference;
import fs.ua.SemesterCode;
import fs.ua.USemester;
import fs.ua.UaCourseTitleFormat;
import fs.ua.UndervisningsAktivitet;
import fs.user.Operation;
import fs.user.UserInput;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UaLegantoEntry extends LegantoEntry {

    public static final String COURSE_CODE_DELIMITER = "_";
    public static final String COURSE_CODE_PREFIX_DELIMITER = "_";
    public static final String PREFIX = "UA";

    private final transient UndervisningsAktivitet ua;

    public UaLegantoEntry(UndervisningsAktivitet ua, UserInput userInput) {
        super(userInput);
        Objects.requireNonNull(ua);
        Preconditions.checkArgument(ua.isValid());
        this.ua = ua;
    }
    @Override
    public USemester getSemester(){
        return ua.getSemester();
    }

    @Override
    public String getTerm1() {
        return getSemesterCode().toEnglishString();
    }

    @Override
    public String getCourseTitle() {

        String emneNavn = Language
            .getValueForLanguagePref(emne.getNavn(), userInput.getLanguageOrder())
            .orElse(getRandomValue(emne.getNavn()));

        String uaNavn = Language.getValueForLanguagePref(ua.getNavn(), userInput.getLanguageOrder())
            .orElse(getRandomValue(ua.getNavn()));

        UaCourseTitleFormat titleFormat = UaCourseTitleFormat.fromInteger(userInput.getCourseTitleFormat());
        return titleFormat.formatUaCourseTitle(
            uaNavn,
            emneNavn,
            ua.getUndervisning()
                .getEmne()
                .getCode(),
            getSemesterCode(),
            ua.getUndervisning()
                .getUaSemester()
                .getYear());
    }

    @Override
    public String getCourseCode() {
        String codePrefix = String
            .join(COURSE_CODE_PREFIX_DELIMITER, PREFIX, ua.getEmne()
                .getCode());
        return String.join(COURSE_CODE_DELIMITER,
            codePrefix,
            ua.getEmne()
                .getVersion(),
            ua.getUndervisning()
                .getUaSemester()
                .getYear()
                .toString(),
            getSemesterCode().toString(),
            ua.getUndervisning()
                .getTerminnumer()
                .toString(),
            ua.getAktivitet()
        );
    }

    @Override
    public String getSectionId() {
        return ua.getEmne()
            .getVersion();
    }

    private SemesterCode getSemesterCode() {
        return ua.getSemester()
            .getSemesterCode();
    }

    @Override
    public String getWeeklyHours() {
        return EMPTY_STRING;
    }

    @Override
    public Integer getYear() {
        return this.ua.getSemester()
            .getYear();
    }

    @Override
    public String getAllSearchableIds() {
        List<String> searchableIds = new ArrayList<>();
        Objects.requireNonNull(organizationEntity, MISSING_ORGANIZATION_ENTITY_INFORMATION_ERROR);

        String id1 = String.join(DEFAULT_DELIMITER,
            PREFIX,
            organizationEntity.getInstitution()
                .toString(),
            ua.getEmne()
                .getCode(),
            ua.getEmne()
                .getVersion(),
            ua.getSemester()
                .getYear()
                .toString(),
            ua.getSemester()
                .getSemesterCode()
                .toString(),
            ua.getUndervisning()
                .getTerminnumer()
                .toString(),
            ua.getAktivitet()
        );
        searchableIds.add(id1);
        return String.join(SEARCHABLE_IDS_DELIMITER, searchableIds);
    }

    @Override
    public String getNumberOfParticipants() {
        return this.userInput.getNumberOfParticipants(getCourseCode())
            .orElse(EMPTY_STRING);
    }

    @Override
    public String getCampusParticipants() {
        return userInput.getCampusParticipants(getCourseCode())
            .orElse(ua.getCampus());
    }

    @Override
    public String getOldCourseCode() {
        if (Operation.ROLLOVER.equals(userInput.getOperation())) {
            return calculateOldCourseCode();
        } else {
            return EMPTY_STRING;
        }
    }

    private String calculateOldCourseCode() {
        Integer lastYear = ua.getSemester()
            .getYear() - 1;
        String courseCodePrefix = String.join(COURSE_CODE_PREFIX_DELIMITER, PREFIX,
            ua.getEmne()
                .getCode()
        );
        return String.join(COURSE_CODE_DELIMITER,
            courseCodePrefix,
            ua.getEmne()
                .getVersion(),
            lastYear.toString(),
            getSemesterCode().toString()
        );
    }

    @Override
    public String getOldCourseSectionId() {
        if (Operation.ROLLOVER.equals(userInput.getOperation())) {
            return ua.getEmne()
                .getVersion();
        } else {
            return EMPTY_STRING;
        }
    }

    @Override
    protected UndervisningReference undervisningsReference() {
        return new UndervisningReference(ua.getUndervisning()
            .getHref());
    }
}
