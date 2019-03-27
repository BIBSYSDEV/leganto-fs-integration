package utils;

import fs.common.Language;
import fs.ua.UaCourseTitleFormat;
import fs.user.UserInput;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LocalTest {

    public static final boolean INCLUDE_NUMBER_OF_PARTICIPANTS = false;
    private static final String CAMPUS_PARTICIPANTS_FILENAME = "campus_participants.csv";
    private static final String NUMBER_OF_PARTICIPANTS_FILENAME = "number_of_participants.csv";
    private static final boolean INCLUDE_INSTITUTE = true;
    private static final boolean INCLUDE_CAMPUS_PARTICIPANTS = false;

    protected UserInput mockUserInput() {
        Language[] languagesArray = {Language.NB, Language.NN, Language.EN};
        List<Language> languageOrder = Arrays.asList(languagesArray);
        return new UserInput()
            .setLanguageOrder(languageOrder)
            .setIncludeInstitute(INCLUDE_INSTITUTE)
            .setCourseTitleFormat(UaCourseTitleFormat.DEFAULT_FORMAT)
            .setCampusParticipantsFilename(CAMPUS_PARTICIPANTS_FILENAME)
            .setIncludeCampusParticipants(INCLUDE_CAMPUS_PARTICIPANTS)
            .setNumberOfParticipantsFilename(NUMBER_OF_PARTICIPANTS_FILENAME)
            .setIncludeNumberOfParticipants(INCLUDE_NUMBER_OF_PARTICIPANTS)
            .setIncludeUA(true)
            .setRoleCodes(Collections.emptyList());
    }
}
