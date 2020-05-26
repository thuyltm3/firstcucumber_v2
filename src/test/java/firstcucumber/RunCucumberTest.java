package firstcucumber;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/report"},     // xuat report html
        features = "src/test/resources/firstcucumber/POM_calculator.feature", // chi dinh file feature run test
        dryRun = false,                                // set dryRun = true de gen ra code implement tu file feature (khi thieu implement)
        glue = "firstcucumber.StepDefinitions"         // chỉ định package implement TC (stepDefinitions)
)
public class RunCucumberTest {
}
