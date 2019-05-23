package fs.emne;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import fs.emne.OrganizationEntityEmneEntry.Type;
import org.junit.Test;

public class OrganizationEntityEmneEntryTest {

  public static final String ARBITRARY_HREF = "href";

  @Test
  public void getttersAndSettersShouldPointoToTheRightAttributes() {
    OrganizationEntityEmneEntry org = new OrganizationEntityEmneEntry();
    assertThat(org.getHref(), is(equalTo(null)));
    assertThat(org.getType(), is(equalTo(null)));
    org.setHref(ARBITRARY_HREF);
    org.setType(Type.ADMINISTRATIV);
    assertThat(org.getType(), is(equalTo(Type.ADMINISTRATIV)));
    assertThat(org.getHref(), is(equalTo(ARBITRARY_HREF)));
  }

  @Test
  public void equalsShouldBeDeepEquals() {
    OrganizationEntityEmneEntry org1 = new OrganizationEntityEmneEntry()
      .setHref(ARBITRARY_HREF)
      .setType(Type.ADMINISTRATIV);
    OrganizationEntityEmneEntry org2 = new OrganizationEntityEmneEntry()
      .setHref(ARBITRARY_HREF)
      .setType(Type.ADMINISTRATIV);

    assertThat(org1.hashCode(), is(equalTo(org2.hashCode())));
    assertThat(org1, is(equalTo(org2)));
  }
}
