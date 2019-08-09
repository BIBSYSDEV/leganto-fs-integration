package fs.ua;

import static fs.ua.CourseTitle.FIRST_PART_DELIMITER;
import static fs.ua.CourseTitle.FOUR_DIGIT_NUMBER;
import static fs.ua.CourseTitle.SECOND_PART_DELIMITER;

import java.util.Objects;

public enum UaCourseTitleFormat {

    DEFAULT, ALTERNATIVE;

    public static final int DEFAULT_FORMAT = 1;
    public static final int ALTERNATIVE_FORMAT = 2;
    public static final String WRONG_FORMAT_CODE = "Format integer codes should either be 1 or 2";

    public static UaCourseTitleFormat fromInteger(int format) {
        switch (format) {
            case ALTERNATIVE_FORMAT:
                return ALTERNATIVE;
            case DEFAULT_FORMAT:
                return DEFAULT;
            default:
                throw new IllegalArgumentException(WRONG_FORMAT_CODE);
        }
    }

    public String formatUaCourseTitle(String uaNavn, String emneNavn, String emneKode, SemesterCode semesterCode,
                                      int year) {
        Objects.requireNonNull(uaNavn);
        Objects.requireNonNull(emneNavn);
        Objects.requireNonNull(emneKode);
        Objects.requireNonNull(semesterCode);

        switch (this) {
            case ALTERNATIVE:
                return alternativeFormat(uaNavn, emneNavn, emneKode, semesterCode, year);
            case DEFAULT:
            default:
                return defaultFormat(uaNavn, emneNavn, emneKode, semesterCode, year);
        }
    }

    private String defaultFormat(String uaNavn, String emneNavn, String emneKode, SemesterCode semesterCode, int year) {
        String firstPart = String.join(FIRST_PART_DELIMITER, emneNavn, uaNavn, emneKode);
        String yearString = String.format(FOUR_DIGIT_NUMBER, year);
        String result = String.join(SECOND_PART_DELIMITER, firstPart, semesterCode.toString(), yearString);

        return result;
    }

    private String alternativeFormat(String uaNavn, String emneNavn, String emneKode, SemesterCode semesterCode,
                                     int year) {
        String firstPart = String.join(FIRST_PART_DELIMITER, emneKode, emneNavn, uaNavn);
        String yearString = String.format(FOUR_DIGIT_NUMBER, year);
        String suffix = String.format("(%s %s)", semesterCode.toString(), yearString);
        String result = String.join(SECOND_PART_DELIMITER, firstPart, suffix);

        return result;
    }

}
