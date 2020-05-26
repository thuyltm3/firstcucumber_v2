package firstcucumber.StepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

public class StepDefinitions_Login {
    WebDriver driver;

    public StepDefinitions_Login()
    {
        this.driver= Hooks.driver;
    }

    // Scenario (1), (2)
    @Given("The login screen is displayed on browser")
    public void the_login_screen_is_displayed_on_browser() {
        //Open login
        this.driver.get("http://testmaster.vn/Account/Login?ReturnUrl=%2fadmin");
        // full screen
        this.driver.manage().window().maximize();
    }

    @When("^The User attempt to login with his credentials is (.*) and (.*)$")
    public void the_User_attempt_to_login_with_his_credentials(String username, String password) {
        WebElement txtUserName = this.driver.findElement(By.cssSelector("input[type=\"Email\"]"));
        WebElement txtPassword = this.driver.findElement(By.cssSelector("input[type=\"password\"]"));
        WebElement btnLogin = this.driver.findElement(By.cssSelector("button.btn-login"));

        txtUserName.sendKeys(username);
        txtPassword.sendKeys(password);
        btnLogin.click();
    }

    @Then("The homepage will be showed")
    public void the_homepage_will_be_showed() throws InterruptedException {
        Thread.sleep(5000);
        String title = this.driver.getTitle();
        Assert.assertTrue(title.contains("Testmaster.vn"));
    }

    // Scenario (2)
    @When("^The user attempt to login with (.+) and invalid (.+)$")
    public void theUserAttemptToLoginWithUsernameAndInvalidPassword(String username, String password)
    {
        WebElement txtUserName = this.driver.findElement(By.cssSelector("input[type=\"Email\"]"));
        WebElement txtPassword = this.driver.findElement(By.cssSelector("input[type=\"password\"]"));
        WebElement btnLogin = this.driver.findElement(By.cssSelector("button.btn-login"));

        txtUserName.sendKeys(username);
        txtPassword.sendKeys(password);

        txtPassword.sendKeys(Keys.ENTER);
    }

    @Then("^The error (.+) is showed$")
    public void the_error_is_showed(String message) throws Throwable {
    }

    // Scenario (3)
    @Given("^The user input info 10 records$")
    public void the_user_input_info_10_records(DataTable data) {
        List<Map<String, String>> lst = data.asMaps(String.class, String.class);
        for(Map<String, String> m: lst){
            System.out.println(m.get("username"));
            System.out.println(m.get("email"));
            System.out.println(m.get("born"));
        }
    }
}
