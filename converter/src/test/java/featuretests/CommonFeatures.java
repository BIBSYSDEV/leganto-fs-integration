package featuretests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

import cucumber.api.java.en.Then;
import io.cucumber.datatable.DataTable;
import java.util.List;
import leganto.UaLegantoEntry;

public   class CommonFeatures extends CucumberTestProcessor {

    private static final int INCLUDE_EMPTY_STRINGS_BETWEEN_DELIMITER = -1;
    private static final int EXTRA_DELIMITER_AT_EOL_SIGNIGNIFING_EOL = 1;

    @Then("the courses in FS are populated in Leganto with the following data:")
    public void the_courses_in_FS_are_populated_in_Leganto_with_the_following_data(
        DataTable dataTable) {
        List<String> fieldNamesCount = dataTable.asList();
        int expectedFieldsNumber = fieldNamesCount.size();

        int actualNumberOfFields = legantoEntry.toString()
            .split(UaLegantoEntry.FIELD_DELIMITER, INCLUDE_EMPTY_STRINGS_BETWEEN_DELIMITER)
            .length;

        assertThat(actualNumberOfFields,
            is(equalTo(expectedFieldsNumber + EXTRA_DELIMITER_AT_EOL_SIGNIGNIFING_EOL)));
    }

}
