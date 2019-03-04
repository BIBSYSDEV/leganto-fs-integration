package leganto;

import fs.ua.UndervisningsAktivitet;

public class UaLegantoEntry {

    public static final String DELIMITER = "\t";
    public static final String DELIMITER_REGEX = "\\t";
    private static final int NUMBER_OF_FIELDS = 34;
    private final transient UndervisningsAktivitet ua;

    public static final String PREFIX= "UA";

    private  transient String courseCode;

    public UaLegantoEntry(UndervisningsAktivitet ua){
        this.ua=ua;
        this.courseCode

    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < NUMBER_OF_FIELDS; i++) {
            builder.append(DELIMITER);
        }

        return builder.toString();
    }

    public String getCourseCode() {
        return courseCode;

    }


}
