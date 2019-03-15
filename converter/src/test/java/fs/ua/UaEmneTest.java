package fs.ua;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

import fs.common.UEmne;
import org.junit.Test;

public class UaEmneTest {

    private static final String VERSION = "version";
    private static final String INSTITUTION = "institution";
    private static final String HREF = "href";
    private static final String CODE = "code";
    private final transient UEmne uEmne;

    public UaEmneTest() {
        uEmne = new UEmne();
        uEmne.setCode(CODE);
        uEmne.setHref(HREF);
        uEmne.setInstitution(INSTITUTION);
        uEmne.setVersion(VERSION);
    }

    @Test
    public void getHrefShouldReturnTheCorrectVale() {
        assertThat(uEmne.getHref(), is(equalTo(HREF)));
    }

    @Test
    public void getInstitutionReturnsTheCorrectrValue() {
        assertThat(uEmne.getInstitution(), is(equalTo(INSTITUTION)));
    }

    @Test
    public void getCodenReturnsTheCorrectrValue() {
        assertThat(uEmne.getCode(), is(equalTo(CODE)));
    }

    @Test
    public void getVersionReturnsTheCorrectrValue() {
        assertThat(uEmne.getVersion(), is(equalTo(VERSION)));
    }
}
