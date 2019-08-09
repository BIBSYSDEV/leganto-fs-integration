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
import fs.ua.UaUndervisning;
import fs.ua.UndervisningsAktivitet;
import fs.user.Operation;
import fs.user.UserInput;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import utils.LocalTest;

public class UaLegantoEntryTest extends LocalTest {

    private static final int TERMINNUMER = 12;

    private static final String EMNE_HREF = "emneHref";
    private static final String EMNE_CODE = "emneCode";
    private static final String EMNE_INSITUTION = "emneInsitution";
    private static final String EMNE_VERSION = "emneVersion";
    private static final String UNDERVISNING_HREF = "undervingnHref";
    private static final String UNDERVISNINGS_AKTIVITET = "undervisningsaktivitet";
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
    private final transient UndervisningsAktivitet ua = mockUndervisningsAktivitet();

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();
    private Language preferredLanguage = Language.NB;
    private UserInput userInput = mockUserInput();
    private UaLegantoEntry entry;

    @Before
    public void init() {
        entry = new UaLegantoEntry(ua, userInput);
        entry.setEmne(mockEmne());
        entry.setOrganizationEntity(mockOrganizationEntity());
    }

    public UndervisningsAktivitet mockUndervisningsAktivitet() {
        final UaUndervisning undervisning = mockUaUndervisning();
        List<LanguageValue> uaEmneNavn = mockEmneNanv();

        return new UndervisningsAktivitet()
            .setUndervisning(undervisning)
            .setAktivitet(UNDERVISNINGS_AKTIVITET)
            .setNavn(uaEmneNavn);
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
            SemesterCode.AUTUMN_NORWEGIAN,
            Integer.toString(TERMINNUMER),
            UNDERVISNINGS_AKTIVITET);

        String actual = entry.getCourseCode();
        assertThat(actual, is(equalTo(expected)));
    }

    @Test
    public void getCourseTitleWithNBShouldReturnCourseTitleWithTitleFromEmneForNBLanguage() {
        String expectedCourseName = mockEmne().getNavn()
            .stream()
            .filter(langValue -> langValue.getLang()
                .equals(preferredLanguage))
            .findAny()
            .map(LanguageValue::getValue)
            .get();
        String expectedUACourseName = ua.getNavn()
            .stream()
            .filter(langValue -> langValue.getLang()
                .equals(preferredLanguage))
            .findAny()
            .map(LanguageValue::getValue)
            .get();

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

    @Test
    public void getAllSearchableIdsShouldThrowExceptionForNonInitializedOrganizationEntity() {
        entry.setOrganizationEntity(null);
        expectedEx.expect(NullPointerException.class);
        expectedEx.expectMessage(LegantoEntry.MISSING_ORGANIZATION_ENTITY_INFORMATION_ERROR);
        entry.getAllSearchableIds();
    }

    @Test
    public void getAllSearchableIdsShouldReturnNonEmptyString() {
        entry.getAllSearchableIds();
    }

    @Test
    public void getOldCourseCodeShouldReturnEmptyForNormalOperation() {
        userInput.setOperation(Operation.NORMAL);
        assertThat(entry.getOldCourseCode(), is(emptyString()));
    }

    @Test
    public void getOldCourseCodeShouldNotReturnEmptyForRolloverOperation() {
        userInput.setOperation(Operation.ROLLOVER);
        assertThat(entry.getOldCourseCode(), is(not(emptyString())));
    }

    @Test
    public void getOldCourseSectionIdShouldNotReturnEmptyForRolloverOperation() {
        userInput.setOperation(Operation.ROLLOVER);
        assertThat(entry.getOldCourseSectionId(), is(not(emptyString())));
    }

    @Test
    public void getOldCourseSectionIdShouldNotReturnEmptyForNormalOperation() {
        userInput.setOperation(Operation.NORMAL);
        assertThat(entry.getOldCourseSectionId(), is(emptyString()));
    }

    @Test
    public void getEndDateShouldReturnNonEmptyString() {
        assertThat(entry.getEndDate(), is(not(emptyString())));
    }

    @Test
    public void getStartDateShouldReturnNonEmptyString() {
        assertThat(entry.getStartDate(), is(not(emptyString())));
    }

    @Test
    public void getTerm1ShouldReturnNonEmptyString() {
        assertThat(entry.getTerm1(), is(not(emptyString())));
    }

    @Test
    public void getWeeklyHoursShouldReturnEmptyString() {
        assertThat(entry.getWeeklyHours(), is(emptyString()));
    }

    @Test
    public void getYearShouldReturnTheSemesterYear() {
        assertThat(entry.getYear(), is(ua.getSemester()
            .getYear()));
    }

    @Test
    public void getYearSectionIdShouldReturnEmneVersion() {
        assertThat(entry.getSectionId(), is(ua.getEmne()
            .getVersion()));
    }

    @Test
    public void getNumberOfParticpantsShouldReturnEmptyStringForNonExistingFile() {
        assertThat(entry.getNumberOfParticipants(), is(emptyString()));
    }

    private OrganizationEntity mockOrganizationEntity() {
        return new OrganizationEntity()
            .setInstitution(INSTITUTION_NUMBER)
            .setFaculty(FACULTY_NUMBER)
            .setInstitute(INSTITUTE_NUMBER);
    }

    private Emne mockEmne() {
        List<LanguageValue> emneNames = new ArrayList<>();
        emneNames.add(new LanguageValue(Language.NB, NORWEGIAN_EMNE_NAME));
        emneNames.add(new LanguageValue(Language.NN, NYNORK_EMNE_NAME));
        emneNames.add(new LanguageValue(Language.EN, ENGLISH_EMNE_NAME));
        return new Emne().setNavn(emneNames);
    }

    private List<LanguageValue> mockEmneNanv() {
        List<LanguageValue> uaEmneNavn = new ArrayList<>();
        uaEmneNavn.add(new LanguageValue(Language.NB, NORWEGIAN_UAEMNE_NAME));
        uaEmneNavn.add(new LanguageValue(Language.NN, NYNORK_UAEMNE_NAME));
        uaEmneNavn.add(new LanguageValue(Language.EN, ENGLISH_UAEMNE_NAME));
        return uaEmneNavn;
    }

    private UaUndervisning mockUaUndervisning() {
        final UEmne uEmne = new UEmne().setCode(EMNE_CODE)
            .setHref(EMNE_HREF)
            .setInstitution(EMNE_INSITUTION)
            .setVersion(EMNE_VERSION);
        final USemester uSemester = new USemester()
            .setHref(UA_SEMESTER_HREF)
            .setYear(UASEMESTER_YEAR)
            .setSemesterCode(SEMESTER_INPUT);
        return new UaUndervisning()
            .setHref(UNDERVISNING_HREF)
            .setEmne(uEmne)
            .setUaSemester(uSemester)
            .setTerminnumer(TERMINNUMER);
    }
}
