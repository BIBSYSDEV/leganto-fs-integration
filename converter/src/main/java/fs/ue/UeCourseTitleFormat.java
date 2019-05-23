package fs.ue;

import static fs.ua.CourseTitle.FIRST_PART_DELIMITER;
import static fs.ua.CourseTitle.FOUR_DIGIT_NUMBER;
import static fs.ua.CourseTitle.SECOND_PART_DELIMITER;

import fs.ua.SemesterCode;

public enum UeCourseTitleFormat {

  DEFAULT, ALTERNATIVE;

  public static UeCourseTitleFormat fromInteger(int courseTitleFormat) {
    switch (courseTitleFormat) {
      case 1:
        return DEFAULT;
      case 2:
        return ALTERNATIVE;
      default:
        return DEFAULT;
    }
  }

  public String formatUaCourseTitle(String emneNanv, String emneKode, SemesterCode semesterCode,
                                    int year) {

    switch (this) {
      case ALTERNATIVE:
        return alternativeFormat(emneNanv, emneKode, semesterCode, year);
      case DEFAULT:
      default:
        return defaultFormat(emneNanv, emneKode, semesterCode, year);
    }
  }

  private String defaultFormat(String emneNanv, String emneKode, SemesterCode semesterCode, int year) {
    String firstPart = String.join(FIRST_PART_DELIMITER, emneNanv, emneKode);
    String yearString = String.format(FOUR_DIGIT_NUMBER, year);
    String result = String.join(SECOND_PART_DELIMITER, firstPart, semesterCode.toString(), yearString);
    return result;
  }

  private String alternativeFormat(String emneNavn, String emneKode, SemesterCode semesterCode, int year) {
    String prefix = String.join(FIRST_PART_DELIMITER, emneKode, emneNavn);
    String yearString = String.format(FOUR_DIGIT_NUMBER, year);
    String suffix = String.format("(%s %s)", semesterCode.toString(), yearString);
    String result = String.join(SECOND_PART_DELIMITER, prefix, suffix);
    return result;
  }

}
