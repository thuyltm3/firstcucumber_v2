package firstcucumber.StepDefinitions;

import firstcucumber.common.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks_PageObject {
    public static WebDriver driver;

    @Before
    public void Before()
    {
        driver = DriverManager.getDriver();
    }

    @After
    public void After(Scenario scenario)
    {
        if(scenario.isFailed())
        {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed (screenshot, "image/png");
        }
        DriverManager.closeWebDriver();
    }
}
