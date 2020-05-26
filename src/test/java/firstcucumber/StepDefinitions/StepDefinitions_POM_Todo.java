package firstcucumber.StepDefinitions;

import firstcucumber.pageobjects.POM_TodoPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class StepDefinitions_POM_Todo {
    WebDriver driver;
    DataTable lstKeyword;
    POM_TodoPage todoPage;

    public StepDefinitions_POM_Todo()
    {
        this.driver = Hooks_PageObject.driver;
        this.todoPage = new POM_TodoPage(this.driver);
    }

    @Given("^Mo page todo$")
    public void mo_page_todo() {
        this.driver.get("http://todomvc.com/examples/react-backbone/");
        this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        this.todoPage.InitElement(); // Làm theo Page Factory thì trước mỗi step đều phải init element
    }

    @And("^Insert vao textbox todo cac data ben duoi$")
    public void insert_vao_textbox_todo_cac_data_ben_duoi(DataTable data){
        this.lstKeyword = data;
        todoPage.InitElement();
        WebElement txtInput = todoPage.txtInput;
        List<Map<String, String>> lst = data.asMaps(String.class, String.class);
        for (Map<String, String> s: lst) {
            txtInput.clear();
            txtInput.sendKeys(s.get("item"));
            txtInput.sendKeys(Keys.ENTER);
        }
    }

    @When("^Refress page$")
    public void refress_page() {
        this.driver.navigate().refresh();
        this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        this.todoPage.InitElement();
    }

    @Then("^Thu tu cac item hien thi theo thu tu nhu luc insert$")
    public void thu_tu_cac_item_hien_thi_theo_thu_tu_nhu_luc_insert(){
        List<Map<String, String>> lst = this.lstKeyword.asMaps(String.class, String.class);
        ArrayList<String> lstKeyword = new ArrayList<>();
        for(Map<String, String> s: lst)
        {
            lstKeyword.add(s.get("item"));
        }

        ArrayList<String> lstDisplayedResult = new ArrayList<>();
        List<WebElement> lstEl = todoPage.lstItems;
        for(WebElement el: lstEl)
        {
            lstDisplayedResult.add(el.getText().trim());
        }

        Assert.assertEquals(lstKeyword, lstDisplayedResult);
    }
}
