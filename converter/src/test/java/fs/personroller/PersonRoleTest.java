package fs.personroller;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

import fs.personroller.PersonRole.Person;
import org.junit.Test;

public class PersonRoleTest {

  public static final String ARBITRARY_PERSON_NUMBER = "randomId";
  public static final String ARBITRARY_HREF = "someHref";

  @Test
  public void setPersonShouldSetAPerson() {
    PersonRole personRole = new PersonRole();
    assertThat(personRole.getPerson(), is(equalTo(null)));
    Person person = new Person().setPersonLopeNummer(ARBITRARY_PERSON_NUMBER);
    personRole.setPerson(person);
    assertThat(personRole.getPerson(), is(equalTo(person)));
  }

  @Test
  public void personRoleEqualsShouldBeDeepEqual() {
    UndervisningReference undervisningReference = new UndervisningReference(ARBITRARY_HREF);

    PersonRole personRole = new PersonRole().setUndervisning(undervisningReference);
    PersonRole anotherPersonRole = new PersonRole().setUndervisning(undervisningReference);

    assertThat(personRole, is(equalTo(anotherPersonRole)));
  }

  @Test
  public void personRoleHashCodeShouldBeTheHashCodeOfItsFields() {
    UndervisningReference undervisningReference = new UndervisningReference(ARBITRARY_HREF);

    PersonRole personRole = new PersonRole().setUndervisning(undervisningReference);
    PersonRole anotherPersonRole = new PersonRole().setUndervisning(undervisningReference);

    assertThat(personRole.hashCode(), is(equalTo(anotherPersonRole.hashCode())));
  }

  @Test
  public void personEqualsShouldDoDeepEqualCheck() {
    Person person = new Person()
      .setPersonLopeNummer(ARBITRARY_PERSON_NUMBER)
      .setHref(ARBITRARY_HREF);

    Person anotherPerson = new Person()
      .setPersonLopeNummer(ARBITRARY_PERSON_NUMBER)
      .setHref(ARBITRARY_HREF);

    assertThat(person, is(equalTo(anotherPerson)));
  }
}
