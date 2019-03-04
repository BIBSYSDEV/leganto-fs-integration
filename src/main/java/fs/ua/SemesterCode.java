package fs.ua;

public enum SemesterCode {

    AUTUMN, SPRING;

    private static final String AUTUMN_NORWEGIAN = "HØST";
    private static final String SPRING_NORWEGIAN = "VÅR";
    private static final String ERROR_MESSAGE_PREFIX = "Invalid sememster code:";

    public static SemesterCode fromString(String semesterCode) {
        if (semesterCode.equalsIgnoreCase(AUTUMN_NORWEGIAN)) {
            return AUTUMN;
        } else if (semesterCode.equalsIgnoreCase(SPRING_NORWEGIAN)) {
            return SPRING;
        } else {
            throw new IllegalArgumentException(ERROR_MESSAGE_PREFIX + semesterCode);
        }
    }
}
