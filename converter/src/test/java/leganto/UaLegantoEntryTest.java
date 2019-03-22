package leganto;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

import fs.common.Language;
import fs.common.LanguageValue;
import fs.common.UEmne;
import fs.emne.Emne;
import fs.organizations.OrganizationEntity;
import fs.ua.SemesterCode;
import fs.ua.USemester;
import fs.ua.UaCourseTitleFormat;
import fs.ua.UaUndervisning;
import fs.ua.UndervisningsAktivitet;
import fs.user.ParticipantsFile;
import fs.user.UserInput;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class UaLegantoEntryTest {

    private static final String EMNE_HREF = "emneHref";
    private static final String EMNE_CODE = "emneCode";
    private static final String EMNE_INSITUTION = "emneInsitution";
    private static final String EMNE_VERSION = "emneVersion";
    private static final String UNDERVISNING_HREF = "undervingnHref";
    private static final String UA_SEMESTER_HREF = "uaSemesterHref";

    private static final Integer UASEMESTER_YEAR = 1980;
    private static final String NORWEGIAN_EMNE_NAME = "NorwegianEmneName";
    private static final String NYNORK_EMNE_NAME = "NynorkEmneName";
    private static final String ENGLISH_EMNE_NAME = "EnglishEmneName";

    private static final String NORWEGIAN_UAEMNE_NAME = "NorwegianUAEmneName";
    private static final String NYNORK_UAEMNE_NAME = "NynorkUAEmneName";
    private static final String ENGLISH_UAEMNE_NAME = "EnglishAEmneName";
    private static final String SEMESTER_INPUT = SemesterCode.AUTUMN_NORWEGIAN;
    private static final int INSTITUTION_NUMBER = 222;
    private static final int FACULTY_NUMBER = 35;
    private static final int INSTITUTE_NUMBER = 7;
    private static final Integer ARBITRARY_NUMBER_OF_PARTICIPANTS = 100;
    private static final String CAMPUS_PARTICIPANTS_STRING = "GLOS|10|DRAG|20";

    private final transient Emne emne;
    private final transient UndervisningsAktivitet ua;
    private UaLegantoEntry entry;

    private Language preferredLanguage = Language.NB;

    public UaLegantoEntryTest() throws FileNotFoundException {

        final UaUndervisning undervisning = mockUaUndervisning();

        List<LanguageValue> uaEmneNavn = mockEmneNanv();

        ua = new UndervisningsAktivitet()
            .setUndervisning(undervisning)
            .setNanv(uaEmneNavn);

        emne = mockEmne();
        OrganizationEntity organizationEntity = mockOrganizationEntity();

        Language[] languagesArray = {Language.NB, Language.NN, Language.EN};
        UserInput userInput = mockUserInput(languagesArray);

        entry = (UaLegantoEntry) new UaLegantoEntry(ua, userInput)
            .setEmne(emne)
            .setOrganizationEntity(organizationEntity);

        String numberOfPartcipants = numberOfPartcipantsString();
        InputStream campusParticipantsStream = stringToInputStream(numberOfPartcipants);
        InputStream numberOfParticipantsStream = stringToInputStream(numberOfPartcipants);

        userInput.initFiles(campusParticipantsStream, numberOfParticipantsStream);
    }

    private UserInput mockUserInput(Language[] languagesArray) {
        List<Language> languageOrder = Arrays.asList(languagesArray);
        return new UserInput()
            .setLanguageOrder(languageOrder)
            .setIncludeInstitute(true)
            .setCourseTitleFormat(UaCourseTitleFormat.DEFAULT_FORMAT);

    }

    private OrganizationEntity mockOrganizationEntity() {
        return new OrganizationEntity()
            .setInstitution(INSTITUTION_NUMBER)
            .setFaculty(FACULTY_NUMBER)
            .setInstitute(INSTITUTE_NUMBER);
    }

    private Emne mockEmne() {
        List<LanguageValue> emneNames = new ArrayList<>();
        emneNames.add(new LanguageValue(Language.NB.toString(), NORWEGIAN_EMNE_NAME));
        emneNames.add(new LanguageValue(Language.NN.toString(), NYNORK_EMNE_NAME));
        emneNames.add(new LanguageValue(Language.EN.toString(), ENGLISH_EMNE_NAME));
        return new Emne().setNavn(emneNames);
    }

    private List<LanguageValue> mockEmneNanv() {
        List<LanguageValue> uaEmneNavn = new ArrayList<>();
        uaEmneNavn.add(new LanguageValue(Language.NB.toString(), NORWEGIAN_UAEMNE_NAME));
        uaEmneNavn.add(new LanguageValue(Language.NN.toString(), NYNORK_UAEMNE_NAME));
        uaEmneNavn.add(new LanguageValue(Language.EN.toString(), ENGLISH_UAEMNE_NAME));
        return uaEmneNavn;
    }

    private UaUndervisning mockUaUndervisning() {
        final UEmne uEmne = new UEmne().setCode(EMNE_CODE).setHref(EMNE_HREF)
            .setInstitution(EMNE_INSITUTION)
            .setVersion(EMNE_VERSION);
        final USemester uSemester = new USemester()
            .setHref(UA_SEMESTER_HREF)
            .setYear(UASEMESTER_YEAR)
            .setSemesterCode(SEMESTER_INPUT);
        return new UaUndervisning()
            .setHref(UNDERVISNING_HREF)
            .setEmne(uEmne)
            .setUaSemester(uSemester);
    }

    private String numberOfPartcipantsString() {
        return String.join(ParticipantsFile.CSV_DELIMITER, entry.getCourseCode(),
            ARBITRARY_NUMBER_OF_PARTICIPANTS.toString());
    }

    private InputStream stringToInputStream(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @Test
    public void toStringShouldNotReturnEmptyString() {
        assertThat(entry.toString(), is(not(emptyString())));
    }

    @Test
    public void getCourseCodeShouldReturnCourseCodeWithEmneCodeEmndeVersionSemesterAndYear() {
        String firstPart = String.join(UaLegantoEntry.COURSE_CODE_PREFIX_DELIMITER,
            UaLegantoEntry.PREFIX,
            EMNE_CODE
        );

        String expected = String.join(UaLegantoEntry.COURSE_CODE_DELIMITER,
            firstPart,
            EMNE_VERSION,
            UASEMESTER_YEAR.toString(),
            SemesterCode.AUTUMN_NORWEGIAN);

        String actual = entry.getCourseCode();
        assertThat(actual, is(equalTo(expected)));
    }

    @Test
    public void getCourseTitleWithNBShouldReturnCourseTitleWithTitleFromEmneForNBLanguage() {

        String expectedCourseName = emne.getNavn()
            .stream()
            .filter(langValue -> langValue.getLang().equalsIgnoreCase(preferredLanguage.toString()))
            .findAny().map(LanguageValue::getValue).get();
        String expectedUACourseName = ua.getNanv()
            .stream()
            .filter(langValue -> langValue.getLang().equalsIgnoreCase(preferredLanguage.toString()))
            .findAny().map(LanguageValue::getValue).get();

        assertThat(entry.getCourseTitle(), containsString(expectedCourseName));
        assertThat(entry.getCourseTitle(), containsString(expectedUACourseName));
        assertThat(entry.getCourseTitle(), containsString(SEMESTER_INPUT));
        assertThat(entry.getCourseTitle(), containsString(UASEMESTER_YEAR.toString()));
    }

    @Test
    public void getTerm2ShouldReturnEmptyString() {
        assertThat(entry.getTerm2(), is(emptyString()));
    }

    @Test
    public void getTerm3ShouldReturnEmptyString() {
        assertThat(entry.getTerm3(), is(emptyString()));
    }

    @Test
    public void getTerm4ShouldReturnEmptyString() {
        assertThat(entry.getTerm4(), is(emptyString()));
    }

    @Test
    public void getStartDateShouldReturnANonEmptyStartDate() {
        assertThat(entry.getStartDate(), is(not(equalTo(null))));
    }

    @Test
    public void getStartDateShouldCANonEmptyStartDate() {
        assertThat(entry.getStartDate(), is(not(equalTo(null))));
    }
}
