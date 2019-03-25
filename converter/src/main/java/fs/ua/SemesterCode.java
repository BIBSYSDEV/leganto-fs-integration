package fs.ua;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.time.LocalDate;
import java.time.Month;

public enum SemesterCode {

    AUTUMN, SPRING;

    public static final String AUTUMN_NORWEGIAN = "HØST";
    public static final String SPRING_NORWEGIAN = "VÅR";
    public static final String AUTUMN_ENGISH = "AUTUMN";
    public static final String SPRING_ENGISH = "SPRING";
    private static final String ERROR_MESSAGE_PREFIX = "Invalid sememster code:";
    private static final int FIRST_DAY_OF_MONTH = 1;
    private static final int LAST_DAY_OF_MONTH = 31;
    private static final Month FIRST_MONTH_OF_AUTUMN_SEMESTER = Month.AUGUST;
    private static final Month LAST_MONTH_OF_AUTUMN_SEMESTER = Month.JANUARY;
    private static final Month FIRST_MONTH_OF_SPRING_SEMESTER = Month.JANUARY;
    private static final Month LAST_MONTH_OF_SPRING_SEMESTER = Month.JULY;


    @JsonCreator
    public static SemesterCode fromString(String semesterCode) {
        if (semesterCode.equalsIgnoreCase(AUTUMN_NORWEGIAN)) {
            return AUTUMN;
        } else if (semesterCode.equalsIgnoreCase(SPRING_NORWEGIAN)) {
            return SPRING;
        } else {
            throw new IllegalArgumentException(ERROR_MESSAGE_PREFIX + semesterCode);
        }
    }

    @JsonValue
    @Override
    public String toString() {
        if (SemesterCode.AUTUMN.equals(this)) {
            return AUTUMN_NORWEGIAN;
        } else {
            return SPRING_NORWEGIAN;
        }
    }

    public String toEnglishString() {
        if (SemesterCode.AUTUMN.equals(this)) {
            return AUTUMN_ENGISH;
        } else {
            return SPRING_ENGISH;
        }
    }

    public LocalDate semesterStartDate(int year) {
        if (this.equals(AUTUMN)) {
            return LocalDate.of(year, FIRST_MONTH_OF_AUTUMN_SEMESTER, FIRST_DAY_OF_MONTH);
        } else {
            return LocalDate.of(year, FIRST_MONTH_OF_SPRING_SEMESTER, FIRST_DAY_OF_MONTH);
        }
    }

    public LocalDate semesterEndDate(int year) {
        if (this.equals(AUTUMN)) {
            return LocalDate.of(year, LAST_MONTH_OF_AUTUMN_SEMESTER, LAST_DAY_OF_MONTH);
        } else {
            return LocalDate.of(year, LAST_MONTH_OF_SPRING_SEMESTER, LAST_DAY_OF_MONTH);
        }
    }

}
