package firstcucumber.StepDefinitions;

import firstcucumber.pageobjects.POM_LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class StepDefinitions_POM_Login {
    WebDriver driver;
    POM_LoginPage loginPage;

    public StepDefinitions_POM_Login()
    {
        this.driver= Hooks_PageObject.driver;
        loginPage = new POM_LoginPage(this.driver);
    }

    @Given("^Man hinh login duoc hien thi tren browser$")
    public void man_hinh_login_duoc_hien_thi_tren_browser() {
        //Open login
        this.driver.get("http://testmaster.vn/Account/Login?ReturnUrl=%2fadmin");
        this.driver.manage().window().maximize();
    }

    @When("^User nhap thong tin username password la \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_nhap_thong_tin_username_password_la_something_and_something(String username, String password) {
        loginPage.InputUserName(username);
        loginPage.InputPassword(password);
        loginPage.Login();
    }

    @Then("^Trang chu sau khi login thanh cong duoc hien thi$")
    public void trang_chu_sau_khi_login_thanh_cong_duoc_hien_thi() throws InterruptedException {
        Thread.sleep(5000);
        String title = this.driver.getTitle();
        Assert.assertTrue(title.contains("Testmaster.vn"));
    }
}
