package fs.ua;

public enum UAemneNavnFormat {

    DEFAULT;

    private static final String FOUR_DIGIT_NUMBER = "%04d";

    public static UAemneNavnFormat fromNumber(int number) {
        switch (number) {
            case 1:
                return DEFAULT;
            default:
                return DEFAULT;
        }
    }

    public String formatUAemneNanv(String uaNanv, String emneNanv, String emneKode, int year) {
        //more formatting cases will go here
        return defaultFormat(uaNanv, emneNanv, emneKode, year);
    }

    private String defaultFormat(String uaNanv, String emneNanv, String emneKode, int year) {
        return String.join(emneNanv, uaNanv, emneKode, String.format(FOUR_DIGIT_NUMBER, year));
    }

}
