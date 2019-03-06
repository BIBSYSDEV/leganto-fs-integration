package featuretests;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"},
    glue = "featuretests",
    features = "src/test/resources/featuretests"
)
public class RunCucumberTest {

}

