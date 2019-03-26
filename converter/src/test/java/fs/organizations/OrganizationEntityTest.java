package fs.organizations;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Random;
import org.junit.Test;
import utils.IoUtils;

public class OrganizationEntityTest {

    private static final String RESOURCES_FOLDER = "ua";
    private static final String ORGANIZATION_RESOURCE = "organizations_enhet.json";

    private final OrganizationEntity org;
    private final Random random = new Random(System.currentTimeMillis());

    public OrganizationEntityTest() throws IOException {
        String orgJson = IoUtils.resourceAsString(Paths.get(RESOURCES_FOLDER, ORGANIZATION_RESOURCE));
        org = OrganizationEntity.fromJson(orgJson);
    }

    @Test
    public void fromJsonShouldReturnAValidObject() {
        assertThat(org.isValid(), is(equalTo(true)));
    }

    @Test
    public void getAndSetInstitutionShouldHandleInstitution() {
        Integer randInt = random.nextInt(10000);
        org.setInstitution(randInt);
        assertThat(org.getInstitution(), is(equalTo(randInt)));
    }

    @Test
    public void getAndSetFacultyShouldHandleFaculty() {
        Integer randInt = random.nextInt(10000);
        org.setFaculty(randInt);
        assertThat(org.getFaculty(), is(equalTo(randInt)));
    }

    @Test
    public void getAndSetInstituteShouldHandleInstitute() {
        Integer randInt = random.nextInt(10000);
        org.setInstitute(randInt);
        assertThat(org.getInstitute(), is(equalTo(randInt)));
    }

    @Test
    public void fieldShouldNotBePrimitives() {
        OrganizationEntity org = new OrganizationEntity();
        assertThat(org.getInstitution(), is(equalTo(null)));
        assertThat(org.getInstitute(), is(equalTo(null)));
        assertThat(org.getFaculty(), is(equalTo(null)));
    }
}
