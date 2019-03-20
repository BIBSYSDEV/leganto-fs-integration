package leganto;

import fs.common.Language;
import fs.ua.SemesterCode;
import fs.ua.UaCourseTitle;
import fs.ua.UndervisningsAktivitet;
import fs.user.Operation;
import fs.user.UserInput;
import java.time.LocalDate;

public class UaLegantoEntry extends LegantoEntry {

    public static final String COURSE_CODE_DELIMITER = "-";
    public static final String COURSE_CODE_PREFIX_DELIMITER = "_";
    public static final String PREFIX = "UA";

    private final transient UndervisningsAktivitet ua;

    public UaLegantoEntry(UndervisningsAktivitet ua, UserInput userInput) {
        super(userInput);
        this.ua = ua;
    }

    @Override
    public String getEndDate() {
        Integer year = ua.getSemester().getYear();
        LocalDate endDate = getSemesterCode().semesterEndDate(year);
        return dateToString(endDate);
    }

    @Override
    public String getStartDate() {
        Integer year = ua.getSemester().getYear();
        LocalDate startDate = getSemesterCode().semesterStartDate(year);
        return dateToString(startDate);
    }

    @Override
    public String getTerm1() {
        return getSemesterCode().toString();
    }

    @Override
    public String getCourseTitle() {

        String emneNavn = Language
            .getValueForLanguagePref(emne.getNavn(), userInput.getLanguageOrder())
            .orElse(getRandomValue(emne.getNavn()));

        String uaNavn = Language.getValueForLanguagePref(ua.getNanv(), userInput.getLanguageOrder())
            .orElse(getRandomValue(ua.getNanv()));

        return UaCourseTitle.DEFAULT.formatUaCourseTitle(
            uaNavn,
            emneNavn,
            ua.getUndervisning().getEmne().getCode(),
            getSemesterCode(),
            ua.getUndervisning().getUaSemester().getYear());
    }

    @Override
    public String getCourseCode() {
        String codePrefix = String
            .join(COURSE_CODE_PREFIX_DELIMITER, PREFIX, ua.getEmne().getCode());
        return String.join(COURSE_CODE_DELIMITER,
            codePrefix,
            ua.getEmne().getVersion(),
            ua.getUndervisning().getUaSemester().getYear().toString(),
            getSemesterCode().toString()
        );
    }

    @Override
    public String getSectionId() {
        return ua.getEmne().getVersion();
    }

    private SemesterCode getSemesterCode() {
        return ua.getSemester().getSemesterCode();
    }

    @Override
    public String getWeeklyHours() {
        return EMPTY_STRING;
    }

    @Override
    public Integer getYear() {
        return this.ua.getSemester().getYear();
    }

    @Override
    public String getAllSearchableIds() {
        return String.join(DEFAULT_DELIMITER,
            PREFIX,
            organizationEntity.getInstitution().toString(),
            ua.getEmne().getCode(),
            ua.getEmne().getVersion(),
            ua.getSemester().getYear().toString(),
            ua.getSemester().getSemesterCode().toString(),
            ua.getUndervisning().getTerminnumer().toString(),
            ua.getAktivitet()
        );
    }

    @Override
    public String getNumberOfParticipants() {
        return this.userInput.getNumberOfParticipants(getCourseCode()).orElse(EMPTY_STRING);
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

    @Override
    public String getOldCourseSectionId() {
        if (Operation.ROLLOVER.equals(userInput.getOperation())) {
            return ua.getEmne().getVersion();
        } else {
            return EMPTY_STRING;
        }
    }
}
