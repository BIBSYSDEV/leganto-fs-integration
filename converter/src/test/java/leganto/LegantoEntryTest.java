package leganto;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.AnyOf.anyOf;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.StringContains.containsString;

import fs.common.Language;
import fs.common.LanguageValue;
import fs.emne.Emne;
import fs.organizations.OrganizationEntity;
import fs.user.UserInput;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class LegantoEntryTest {

    private static final String ARBITRARY_NORWEGIAN_TEXT = "noeHer";
    private static final String ARBITRARY_ENGLISH_TEXT = "something";
    private static final Integer INSTITUTION = 123;
    private static final Integer FACULTY = 45;
    private static final Integer INSTITUTE = 67;
    private transient LegantoEntry legantoEntry;

    @Before
    public void initialize() {
        legantoEntry = new LegantoEntry(new UserInput()) {
        };
        OrganizationEntity organizationEntity = new OrganizationEntity()
            .setInstitution(INSTITUTION)
            .setFaculty(FACULTY)
            .setInstitute(INSTITUTE);
        legantoEntry.setOrganizationEntity(organizationEntity);
    }

    @Test
    public void getRandomValuesShouldChooseAValueFromANonEmptyList() {
        List<LanguageValue> values = new ArrayList<>();
        values.add(new LanguageValue(Language.NB.toString(), ARBITRARY_NORWEGIAN_TEXT));
        values.add(new LanguageValue(Language.EN.toString(), ARBITRARY_ENGLISH_TEXT));
        String randomValue = legantoEntry.getRandomValue(values);
        assertThat(randomValue, anyOf(
            is(equalTo(ARBITRARY_ENGLISH_TEXT)),
            is(equalTo(ARBITRARY_NORWEGIAN_TEXT))
            )
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void getRandomValuesShouldChooseAThrowAnExceptionForAnEmpytList() {
        List<LanguageValue> values = new ArrayList<>();
        String randomValue = legantoEntry.getRandomValue(values);
    }

    @Test(expected = IllegalStateException.class)
    public void getCourseCodeShouldThrowAnException() {
        legantoEntry.getCourseCode();
    }

    @Test(expected = IllegalStateException.class)
    public void getCourseTitle() {
        legantoEntry.getCourseTitle();
    }

    @Test(expected = IllegalStateException.class)
    public void getSectionId() {
        legantoEntry.getSectionId();
    }

    @Test
    public void getAcademicDepartment() {
        assertThat(legantoEntry.getAcademicDepartment(), containsString(INSTITUTION.toString()));
        assertThat(legantoEntry.getAcademicDepartment(), containsString(FACULTY.toString()));
        assertThat(legantoEntry.getAcademicDepartment(), containsString(INSTITUTE.toString()));
    }

    @Test(expected = IllegalStateException.class)
    public void getProcessingDepartment() {
        legantoEntry.getProcessingDepartment();
    }

    @Test(expected = IllegalStateException.class)
    public void getTerm1() {
        legantoEntry.getTerm1();
    }

    @Test(expected = IllegalStateException.class)
    public void getTerm2() {
        legantoEntry.getTerm2();
    }

    @Test(expected = IllegalStateException.class)
    public void getTerm3() {
        legantoEntry.getTerm3();
    }

    @Test(expected = IllegalStateException.class)
    public void getTerm4() {
        legantoEntry.getTerm4();
    }

    @Test(expected = IllegalStateException.class)
    public void getStartDate() {
        legantoEntry.getStartDate();
    }

    @Test(expected = IllegalStateException.class)
    public void getEndDate() {
        legantoEntry.getEndDate();
    }

    @Test(expected = IllegalStateException.class)
    public void getWeeklyHours() {
        legantoEntry.getWeeklyHours();
    }

    @Test(expected = IllegalStateException.class)
    public void getYear() {
        legantoEntry.getYear();
    }

    @Test(expected = IllegalStateException.class)
    public void getSearchableId1() {
        legantoEntry.getSearchableId1();
    }

    @Test(expected = IllegalStateException.class)
    public void getSearchableId2() {
        legantoEntry.getSearchableId2();
    }

    @Test(expected = IllegalStateException.class)
    public void getAllSearchableIds() {
        legantoEntry.getAllSearchableIds();
    }

    @Test(expected = IllegalStateException.class)
    public void getInstructor() {
        legantoEntry.getInstructor();
    }

    @Test(expected = IllegalStateException.class)
    public void getOperation() {
        legantoEntry.getOperation();
    }

    @Test(expected = IllegalStateException.class)
    public void getSubmitByDate() {
        legantoEntry.getSubmitByDate();
    }

    @Test(expected = IllegalStateException.class)
    public void getCampusParticipants() {
        legantoEntry.getCampusParticipants();
    }

    @Test(expected = IllegalStateException.class)
    public void getReadingListName() {
        legantoEntry.getReadingListName();
    }

    @Test(expected = IllegalStateException.class)
    public void getNumberOfParticipants() {
        legantoEntry.getNumberOfParticipants();
    }

    @Test(expected = IllegalStateException.class)
    public void getOldCourseCode() {
        legantoEntry.getOldCourseCode();
    }

    @Test(expected = IllegalStateException.class)
    public void getOldCourseSectionId() {
        legantoEntry.getOldCourseSectionId();
    }

    @Test
    public void setEmne() {
        Emne emne = new Emne();
        legantoEntry.setEmne(emne);
        assertThat(legantoEntry.getEmne(), is(equalTo(emne)));
    }

    @Test
    public void setOrganizationEntity() {
        OrganizationEntity organizationEntity = new OrganizationEntity();
        legantoEntry.setOrganizationEntity(organizationEntity);
        assertThat(legantoEntry.organizationEntity, is(equalTo(organizationEntity)));
    }
}
