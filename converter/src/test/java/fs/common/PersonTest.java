package fs.common;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

public class PersonTest {

  public static final String PERSONNUMMER = "bla";

  @Test
  public void getPersonnummerShouldReturnPersonnummer() {
    Person p = new Person();
    assertThat(p.getPersonnummer(),is(equalTo(null)));
    p.setPersonnummer(PERSONNUMMER);
    assertThat(p.getPersonnummer(),is(equalTo(PERSONNUMMER)));
  }

  @Test
  public void equalsShouldDeliverEqual() {
    Person p1 = new Person().setPersonnummer(PERSONNUMMER);
    Person p2 = new Person().setPersonnummer(PERSONNUMMER);
    assertThat(p1,is(equalTo(p2)));
    Person p3 = new Person();
    assertThat(p1,is(not(equalTo(p3))));
  }

  @Test
  public void hashCodeShouldDeliverHashCode() {
    Person p1 = new Person().setPersonnummer(PERSONNUMMER);
    Person p2 = new Person().setPersonnummer(PERSONNUMMER);
    assertThat(p1.hashCode(),is(equalTo(p2.hashCode())));
  }
}