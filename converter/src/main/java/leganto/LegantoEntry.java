package leganto;

public abstract class LegantoEntry {

    public static final String FIELD_DELIMITER = "\t";
    private static final int NUMBER_OF_FIELDS = 34;

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < NUMBER_OF_FIELDS; i++) {
            builder.append(FIELD_DELIMITER);
        }

        return builder.toString();
    }

}
