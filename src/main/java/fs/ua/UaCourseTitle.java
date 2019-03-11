package fs.ua;

public enum UaCourseTitle {

    DEFAULT;

    private static final String FOUR_DIGIT_NUMBER = "%04d";
    private static final String DELIMITER = "_";

    public static UaCourseTitle fromNumber(int number) {
        switch (number) {
            case 1:
                return DEFAULT;
            default:
                return DEFAULT;
        }
    }

    public String formatUaCourseTitle(String uaNanv, String emneNanv, String emneKode, SemesterCode semesterCode,
        int year) {
        //more formatting cases will go here
        return defaultFormat(uaNanv, emneNanv, emneKode, semesterCode, year);
    }

    private String defaultFormat(String uaNanv, String emneNanv, String emneKode, SemesterCode semesterCode, int year) {
        return String.join(DELIMITER, emneNanv, uaNanv, emneKode, semesterCode.toString(),
            String.format(FOUR_DIGIT_NUMBER, year));
    }

}
