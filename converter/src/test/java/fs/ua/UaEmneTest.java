package fs.ua;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

import org.junit.Test;

public class UaEmneTest {

    private static final String VERSION = "version";
    private static final String INSTITUTION = "institution";
    private static final String HREF = "href";
    private static final String CODE = "code";
    private final transient UaEmne uaEmne;

    public UaEmneTest() {
        uaEmne = new UaEmne();
        uaEmne.setCode(CODE);
        uaEmne.setHref(HREF);
        uaEmne.setInstitution(INSTITUTION);
        uaEmne.setVersion(VERSION);
    }

    @Test
    public void getHrefShouldReturnTheCorrectVale() {
        assertThat(uaEmne.getHref(), is(equalTo(HREF)));
    }

    @Test
    public void getInstitutionReturnsTheCorrectrValue() {
        assertThat(uaEmne.getInstitution(), is(equalTo(INSTITUTION)));
    }

    @Test
    public void getCodenReturnsTheCorrectrValue() {
        assertThat(uaEmne.getCode(), is(equalTo(CODE)));
    }

    @Test
    public void getVersionReturnsTheCorrectrValue() {
        assertThat(uaEmne.getVersion(), is(equalTo(VERSION)));
    }
}
