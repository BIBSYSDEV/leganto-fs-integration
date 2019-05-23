package fs.ua;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import java.time.Month;

import org.junit.Test;

public class SemesterCodeTest {

  private static final String AUTUMN_NORWEGIAN = "HØST";
  private static final String SPRING_NORWEGIAN = "VÅR";
  private static final String ARBITRARY_VALUE = "SOMETHING";
  private static final int ARBITRARY_YEAR = 1990;
  private static final int FIRST_DAY_OF_MONTH = 1;
  private static final int LAST_DAY_OF_MONTH = 31;
  private static final Month FIRST_MONTH_OF_SPRING_SEMESTER = Month.JANUARY;
  private static final Month FIRST_MONTH_OF_AUTUM_SEMESTER = Month.AUGUST;
  private static final Month LAST_MONTH_OF_SPRING_SEMESTER = Month.JULY;
  private static final Month LAST_MONTH_OF_AUTUM_SEMESTER = Month.JANUARY;

  @Test
  public void fromStringShouldReturnAutumnForHost() {
    assertThat(SemesterCode.fromString(AUTUMN_NORWEGIAN), is(equalTo(SemesterCode.AUTUMN)));
  }

  @Test
  public void fromStringShouldReturnSpringForVar() {
    assertThat(SemesterCode.fromString(SPRING_NORWEGIAN), is(equalTo(SemesterCode.SPRING)));
  }

  @Test(expected = IllegalArgumentException.class)
  public void fromStringShouldThrowExceptionForOtherValues() {
    SemesterCode.fromString(ARBITRARY_VALUE);
  }

  @Test
  public void semesterStartDateShouldBeTheFirstDayOfJanuaryForSpringSemester() {
    assertThat(SemesterCode.SPRING.semesterStartDate(ARBITRARY_YEAR)
        .getDayOfMonth(),
      is(equalTo(FIRST_DAY_OF_MONTH)));
    assertThat(SemesterCode.SPRING.semesterStartDate(ARBITRARY_YEAR)
      .getMonth(), is(equalTo(
      FIRST_MONTH_OF_SPRING_SEMESTER)));
  }

  @Test
  public void semesterStartDateShouldBeTheFirstDayOfAugustForAutumnSemester() {
    assertThat(SemesterCode.AUTUMN.semesterStartDate(ARBITRARY_YEAR)
        .getDayOfMonth(),
      is(equalTo(FIRST_DAY_OF_MONTH)));
    assertThat(SemesterCode.AUTUMN.semesterStartDate(ARBITRARY_YEAR)
      .getMonth(), is(equalTo(
      FIRST_MONTH_OF_AUTUM_SEMESTER)));
  }

  @Test
  public void semesterEndDateShouldBeTheLastDayOfJulyForSpringSemester() {
    assertThat(SemesterCode.SPRING.semesterEndDate(ARBITRARY_YEAR)
      .getDayOfMonth(), is(equalTo(LAST_DAY_OF_MONTH)));
    assertThat(SemesterCode.SPRING.semesterEndDate(ARBITRARY_YEAR)
      .getMonth(), is(equalTo(
      LAST_MONTH_OF_SPRING_SEMESTER)));
  }

  @Test
  public void semesterEndDateShouldBeTheLastDayOfJanuaryForAutumnSemester() {
    assertThat(SemesterCode.AUTUMN.semesterEndDate(ARBITRARY_YEAR)
      .getDayOfMonth(), is(equalTo(LAST_DAY_OF_MONTH)));
    assertThat(SemesterCode.AUTUMN.semesterEndDate(ARBITRARY_YEAR)
      .getMonth(), is(equalTo(
      LAST_MONTH_OF_AUTUM_SEMESTER)));
  }
}
