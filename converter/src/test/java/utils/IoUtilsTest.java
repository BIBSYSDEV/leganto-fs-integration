package utils;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Test;

public class IoUtilsTest {

    private static final String EXISTING_FILE = "UA.json";
    private static final String EXISTING_FOLDER = "ua";
    private static final int EMPTY_STREAM = 0;
    private static final int EMPTY_LIST = EMPTY_STREAM;
    private final Path testFile = Paths.get(EXISTING_FOLDER, EXISTING_FILE);

    @Test
    public void resourceAsStreamShouldReturnNonEmptyStreamForExistingFile() throws IOException {
        InputStream stream = IoUtils.resourceAsStream(testFile);
        assertThat(stream.available(), is(greaterThan(EMPTY_STREAM)));
    }

    @Test
    public void resourceAsListShouldReturnNonEmptyListForExistingFile() throws IOException {
        List<String> list = IoUtils.resourceAsList(testFile);
        assertThat(list.size(), is(greaterThan(EMPTY_LIST)));
    }

    @Test
    public void resourceAsStringShouldReturnNonEmptyStringForExistingFile() throws IOException {
        String input = IoUtils.resourceAsString(testFile);
        assertThat(input.length(), is(greaterThan(EMPTY_LIST)));
    }

    @Test
    public void resourceAsStringhouldPreserveTheNewlines() throws IOException, URISyntaxException {
        String input = IoUtils.resourceAsString(testFile);
        int expectedNumberOfLines = IoUtils.resourceAsList(testFile)
            .size();
        assertThat(input.split(System.lineSeparator()).length, is(equalTo(expectedNumberOfLines)));
    }
}
