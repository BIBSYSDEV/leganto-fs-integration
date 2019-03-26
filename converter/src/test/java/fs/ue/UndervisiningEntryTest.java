package fs.ue;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.nio.file.Paths;
import org.junit.Test;
import utils.IoUtils;
import utils.JsonUtils;

public class UndervisiningEntryTest {

    public static final String RESOURCES_FOLDER = "ue";
    public static final String SAMPLE_UE = "UE.json";
    private String ueJson = IoUtils.resourceAsString(Paths.get(RESOURCES_FOLDER, SAMPLE_UE));

    @Test
    public void undervsigingsAktiviterShouldBeAbleToParseItsOwnJson() throws IOException {
        UndervisiningEntry ue = JsonUtils.mapper.readValue(ueJson, UndervisiningEntry.class);
        String newJson = JsonUtils.write(ue);
        UndervisiningEntry newUE = JsonUtils.readValue(newJson, UndervisiningEntry.class);
        assertThat(newUE, is(equalTo(ue)));

    }

}
