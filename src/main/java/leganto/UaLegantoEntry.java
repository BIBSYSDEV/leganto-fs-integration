package leganto;

import fs.ua.UndervisningsAktivitet;

public class UaLegantoEntry {

    public static final String FIELD_DELIMITER = "\t";
    public static final String FIELD_DELIMITER_REGEX = "\\t";
    private static final int NUMBER_OF_FIELDS = 34;
    public static final String COURSE_CODE_DELIMITER = "-";
    public static final String COURSE_CODE_PREFIX_DELIMITER="_";
    private final transient UndervisningsAktivitet ua;

    public static final String PREFIX= "UA";

    private  transient String courseCode;

    public UaLegantoEntry(UndervisningsAktivitet ua){
        this.ua=ua;
        this.courseCode= initCourseCode(ua);

    }

    private String initCourseCode(UndervisningsAktivitet ua) {
        String codePrefix=String.join(COURSE_CODE_PREFIX_DELIMITER, PREFIX,ua.getEmne().getCode());
        return String.join(COURSE_CODE_DELIMITER,
            codePrefix,
            ua.getEmne().getVersion(),
            ua.getUndervisning().getUaSemester().getYear().toString(),
            ua.getUndervisning().getUaSemester().getSemesterCode().toString());
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


}
