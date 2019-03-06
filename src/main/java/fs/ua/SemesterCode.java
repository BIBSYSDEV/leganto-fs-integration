package fs.ua;

public enum SemesterCode {

    AUTUMN, SPRING;

    public static final String AUTUMN_NORWEGIAN = "HØST";
    public static final String SPRING_NORWEGIAN = "VÅR";
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

    @Override
    public String toString() {
        if (SemesterCode.AUTUMN.equals(this)) {
            return AUTUMN_NORWEGIAN;
        } else {
            return SPRING_NORWEGIAN;
        }
    }
}
