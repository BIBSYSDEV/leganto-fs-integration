package leganto;

public class LegantoEntry {

    private static final int NUMBER_OF_FIELDS=34;

    public static final String DELIMITER = "\t";




    public String toString(){
        StringBuilder builder= new StringBuilder();
        for(int i=0;i<NUMBER_OF_FIELDS;i++)
            builder.append(DELIMITER);

        return builder.toString();
    }
}
