package leganto;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.AnyOf.anyOf;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.StringContains.containsString;

import fs.common.Language;
import fs.common.LanguageValue;
import fs.emne.Emne;
import fs.organizations.OrganizationEntity;
import fs.personroller.PersonRole;
import fs.personroller.PersonRole.Person;
import fs.personroller.UndervisningReference;
import fs.user.Operation;
import fs.user.UserInput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.junit.Before;
import org.junit.Test;
import utils.LocalTest;

public class LegantoEntryTest extends LocalTest {

    public static final String UNDERVISNING_HREF = "undervisningRef";
    private static final String ARBITRARY_NORWEGIAN_TEXT = "noeHer";
    private static final String ARBITRARY_ENGLISH_TEXT = "something";
    private static final Integer INSTITUTION = 123;
    private static final Integer FACULTY = 45;
    private static final Integer INSTITUTE = 67;
    private static final String CAMPUS1 = "GLOS";
    private static final String CAMPUS2 = "DRAG";
    private static final String EMPTY_STRING = "";
    private transient LegantoEntry legantoEntry;
    private transient UserInput userInput;

    @Before
    public void initialize() {
        List<String> campuses = new ArrayList<>();
        campuses.add(CAMPUS1);
        campuses.add(CAMPUS2);
        userInput = mockUserInput();

        legantoEntry = new LegantoEntry(userInput) {
            @Override
            public Optional<String> toOptionalString() {
                return Optional.empty();
            }

            @Override
            protected UndervisningReference undervisningsReference() {
                return UNDERVISNING_HREF;
            }
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
        values.add(new LanguageValue(Language.NB, ARBITRARY_NORWEGIAN_TEXT));
        values.add(new LanguageValue(Language.EN, ARBITRARY_ENGLISH_TEXT));
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
        legantoEntry.getRandomValue(values);
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
    public void getAcademicDepartmentShouldInlucdeIncludeIfTheFlagIsSet() {
        userInput.setIncludeInstitute(true);
        assertThat(legantoEntry.getAcademicDepartment(), containsString(INSTITUTION.toString()));
        assertThat(legantoEntry.getAcademicDepartment(), containsString(FACULTY.toString()));
        assertThat(legantoEntry.getAcademicDepartment(), containsString(INSTITUTE.toString()));
    }

    @Test
    public void getAcademicDepartmentShouldNotInlucdeIncludeIfTheFlagIsNotSet() {
        userInput.setIncludeInstitute(false);
        assertThat(legantoEntry.getAcademicDepartment(), containsString(INSTITUTION.toString()));
        assertThat(legantoEntry.getAcademicDepartment(), containsString(FACULTY.toString()));
        assertThat(legantoEntry.getAcademicDepartment(), not(containsString(INSTITUTE.toString())));
    }

    @Test
    public void getProcessingDepartment() {
        assertThat(legantoEntry.getProcessingDepartment(), is(equalTo(LegantoEntry.PROCESSING_DEPARTMENT_INVARIANT)));
    }

    @Test(expected = IllegalStateException.class)
    public void getTerm1() {
        legantoEntry.getTerm1();
    }

    @Test
    public void getTerm2() {
        assertThat(legantoEntry.getTerm2(), is(emptyString()));
    }

    @Test
    public void getTerm3() {
        assertThat(legantoEntry.getTerm3(), is(emptyString()));
    }

    @Test
    public void getTerm4() {
        assertThat(legantoEntry.getTerm4(), is(emptyString()));
    }

    @Test(expected = IllegalStateException.class)
    public void getStartDateShouldBeImplemented() {
        legantoEntry.getStartDate();
    }

    @Test(expected = IllegalStateException.class)
    public void getEndDateShouldBeImplemented() {
        legantoEntry.getEndDate();
    }

    @Test
    public final void getWeeklyHoursShouldReturnEmptyString() {
        assertThat(legantoEntry.getWeeklyHours(), is(emptyString()));
    }

    @Test(expected = IllegalStateException.class)
    public void getYear() {
        legantoEntry.getYear();
    }

    @Test
    public void getSearchableId1ShouldReturnEmptyString() {
        assertThat(legantoEntry.getSearchableId1(), is(emptyString()));
    }

    @Test
    public void getSearchableId2ShouldReturnEmptyString() {
        assertThat(legantoEntry.getSearchableId2(), is(emptyString()));
    }

    @Test(expected = IllegalStateException.class)
    public void getAllSearchableIds() {
        legantoEntry.getAllSearchableIds();
    }

    @Test
    public void getInstructor() {
        assertThat(legantoEntry.getInstructor(), is(emptyString()));
    }

    @Test
    public void getOperation() {
        assertThat(legantoEntry.getOperation(), is(equalTo(Operation.NORMAL.toString())));
    }

    @Test
    public void getSubmitByDate() {
        assertThat(legantoEntry.getSubmitByDate(), is(emptyString()));
    }

    @Test
    public void getReadingListName() {
        assertThat(legantoEntry.getReadingListName(), is(emptyString()));
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

    @Test
    public void getAllInstructorIdsShouldReturnTheIdsOfPersonRoles() {
        List<String> ids = new ArrayList<>();
        ids.add("id1");
        ids.add("id2");
        List<PersonRole> personRoles = ids.stream()
            .map(id -> new Person().setPersonLopeNummer(id))
            .map(person -> new PersonRole().setPerson(person))
            .collect(Collectors.toList());
        Map<UndervisningReference, List<PersonRole>> roles = new HashMap<>();
        roles.put(new UndervisningReference(UNDERVISNING_HREF), personRoles);
        assertThat(legantoEntry.getAllInstructorIds(roles), is(equalTo("id1,id2")));
    }

    @Test
    public void getAllInstructorIdsShouldReturnEmptyStringForEmptyList() {

        Map<UndervisningReference, List<PersonRole>> personRoles = Collections.emptyMap();
        assertThat(legantoEntry.getAllInstructorIds(personRoles), is((emptyString())));
    }
}
