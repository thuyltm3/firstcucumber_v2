package firstcucumber.StepDefinitions;

import firstcucumber.pageobjects.POM_CalculatorPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class StepDefinitions_POM_Calculator {

    WebDriver driver;
    POM_CalculatorPage calculatorPage;
    float sum = 0;

    public StepDefinitions_POM_Calculator(){
        this.driver = Hooks_PageObject.driver;
        this.calculatorPage = new POM_CalculatorPage(this.driver);
        this.calculatorPage.InitElement();
    }

    @Given("^Man hinh calculator duoc hien thi tren browser$")
    public void man_hinh_calculator_duoc_hien_thi_tren_browser() {
        driver.manage().window().maximize();
        driver.get("https://www.desmos.com/scientific");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        this.calculatorPage.InitElement();
    }

    @When("^User chon cong cac so bat ky$")
    public void user_chon_cong_cac_so_bat_ky() {
        Random random = new Random();
        int countPlus = random.nextInt(5) + 1;
        System.out.println("count: "+ countPlus);
        int i = 0;
        sum = this.calculatorPage.getRandomNumber();
        while(i < countPlus) {
            calculatorPage.clickPlus();
            float randomNumber = this.calculatorPage.getRandomNumber();
            sum = sum + randomNumber;
            i++;
        }
    }

    @Then("^Man hinh hien thi ket qua phep cong chinh xac$")
    public void man_hinh_hien_thi_ket_qua_phep_cong_chinh_xac() {
        this.calculatorPage.InitElement();
        float actualNumber = this.calculatorPage.getOutputNumber();
        float expectedNumber = sum;
        Assert.assertEquals(expectedNumber, actualNumber, 0);
    }
}
