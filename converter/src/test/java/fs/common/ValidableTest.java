package fs.common;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

import org.junit.Test;

public class ValidableTest extends Validable {

  @Test
  public void isValidShoudReturnTrueForPojowithNonNullValues() {
    SimpleValidableTestClass value = new SimpleValidableTestClass();
    value.setSampleInt(2);
    value.setSampleString("sample");
    assertThat(value.isValid(), is(equalTo(true)));
  }

  @Test
  public void isValidShoudReturnFalseForPojowithNonNullValues() {
    SimpleValidableTestClass value = new SimpleValidableTestClass();
    value.setSampleString("sample");
    assertThat(value.isValid(), is(equalTo(false)));
  }

  @Test
  public void isValidShouldReturnTrueForComplexObjectsWithValidableFields() {
    NestedValidableTestClass value = new NestedValidableTestClass();
    SimpleValidableTestClass nestedValue = new SimpleValidableTestClass();
    nestedValue.setSampleString("sample");
    nestedValue.setSampleInt(1);
    value.setValidable(nestedValue);
    value.setSampleInt(1);
    value.setSampleString("hello");

    assertThat(value.isValid(), is(equalTo(true)));
  }

  @Test
  public void isValidShouldReturnFalseForComplexObjectsWithValidableFieldsThatAreNull() {
    NestedValidableTestClass value = new NestedValidableTestClass();
    value.setSampleInt(1);
    value.setSampleString("hello");
    assertThat(value.isValid(), is(equalTo(false)));
  }

  @Test
  public void isValidShouldReturnFalseForComplexObjectsWithValidableFieldsThatAreInvliad() {
    NestedValidableTestClass value = new NestedValidableTestClass();
    SimpleValidableTestClass nestedValue = new SimpleValidableTestClass();
    nestedValue.setSampleString("sample");
    value.setValidable(nestedValue);
    value.setSampleInt(1);
    value.setSampleString("hello");
    assertThat(value.isValid(), is(equalTo(false)));
  }

  @Test
  public void isValidShouldReturnFalseForComplexObjectsThatAreInvliadWithNullSimpleFields() {
    NestedValidableTestClass value = new NestedValidableTestClass();
    SimpleValidableTestClass nestedValue = new SimpleValidableTestClass();
    nestedValue.setSampleString("sample");
    value.setValidable(nestedValue);
    value.setSampleInt(1);

    assertThat(value.isValid(), is(equalTo(false)));
  }

  @Test
  public void isGetterShouldMatchValidGetters() {
    String get1 = "getFoo";
    assertThat(matchesGetterPattern(get1), is(equalTo(true)));
    String get2 = "isFoo";
    assertThat(matchesGetterPattern(get2), is(equalTo(true)));
  }

  @Test
  public void isGetterShoulNotdMatchInvalidGetters() {
    String get1 = "getfoo";
    assertThat(matchesGetterPattern(get1), is(equalTo(false)));
    String get2 = "isfoo";
    assertThat(matchesGetterPattern(get2), is(equalTo(false)));
  }

  @Test
  public void isValidShouldReturnTrueForAnnontatedGettersWithNullValues() {
    ValidableClassWithAnnotation value = new ValidableClassWithAnnotation();

    assertThat(value.isValid(), is(equalTo(true)));
  }

  private class ValidableClassWithAnnotation extends Validable {

    public String getEmpytString() {
      return "";
    }

    @IgnoreValidable
    public String getIgnored() {
      return null;
    }
  }

  private class SimpleValidableTestClass extends Validable {

    private String sampleString;

    private Integer sampleInt;

    public String getSampleString() {
      return sampleString;
    }

    public void setSampleString(String sampleString) {
      this.sampleString = sampleString;
    }

    public Integer getSampleInt() {
      return sampleInt;
    }

    public void setSampleInt(Integer sampleInt) {
      this.sampleInt = sampleInt;
    }

    public String getsomething() {
      return null;
    }
  }

  private class NestedValidableTestClass extends Validable {

    private String sampleString;

    private Integer sampleInt;

    private SimpleValidableTestClass validable;

    public String getSampleString() {
      return sampleString;
    }

    public void setSampleString(String sampleString) {
      this.sampleString = sampleString;
    }

    public Integer getSampleInt() {
      return sampleInt;
    }

    public void setSampleInt(Integer sampleInt) {
      this.sampleInt = sampleInt;
    }

    public SimpleValidableTestClass getValidable() {
      return validable;
    }

    public void setValidable(SimpleValidableTestClass validable) {
      this.validable = validable;
    }
  }
}
