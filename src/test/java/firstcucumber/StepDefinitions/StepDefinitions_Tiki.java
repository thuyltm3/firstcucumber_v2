package firstcucumber.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class StepDefinitions_Tiki {
    WebDriver driver;
    String productName;
    By txtboxSearchCSS = By.cssSelector("input[class^=FormSearch__Input]");
    By lstProductItemCSS = By.cssSelector("div.search-div-product-item");
    By btnBuyCSS = By.cssSelector("button.btn:nth-child(1)");
    By statusCSS = By.cssSelector("p.status");
    By btnViewCartCSS = By.cssSelector("a.btn-view-cart");
    By lstProductNameInCartCSS = By.cssSelector("a.cart-products__name");

    public StepDefinitions_Tiki()
    {
        this.driver = Hooks.driver;
    }

    @Given("^Trang chu cua tiki duoc hien thi tren browser$")
    public void trang_chu_cua_tiki_duoc_hien_thi_tren_browserim() {
        driver.manage().window().maximize();
        this.driver.get("https://tiki.vn/");
        this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @When("^Tim kiem mat hang muon dat mua$")
    public void tim_kiem_mat_hang_muon_dat_mua() {
        WebElement txtboxSearch = this.driver.findElement(txtboxSearchCSS);
        txtboxSearch.sendKeys("tivi");
        txtboxSearch.sendKeys(Keys.ENTER);
        this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @And("^Chon xem chi tiet san pham bat ki va them vao gio hang$")
    public void chon_xem_chi_tiet_san_pham_bat_ki_va_them_vao_gio_hang() {
        List<WebElement> lstProductItems = this.driver.findElements(lstProductItemCSS);

        // Lấy sp bất kì
        Random random = new Random();
        int index = random.nextInt(lstProductItems.size());
        WebElement product = lstProductItems.get(index);
        productName = product.findElement(By.cssSelector("a")).getAttribute("title");
        System.out.println(productName);

        // Mouse chuột & view chi tiet san pham
        Actions mouseAction = new Actions(driver);
        mouseAction.moveToElement(product).click().perform();

        // chon mua san pham de them vao gio hang
        WebElement btnBuy = this.driver.findElement(btnBuyCSS);
        mouseAction.moveToElement(btnBuy).click().perform();

        this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Then("^Trong gio hang chua san pham vua chon$")
    public void trong_gio_hang_chua_san_pham_vua_chon() {
        // check status them vao gio hang
        String status = this.driver.findElement(statusCSS).getText();
        Assert.assertEquals("Thêm vào giỏ hàng thành công!", status);

        // view gio hang
        WebElement btnViewCart = this.driver.findElement(btnViewCartCSS);
        btnViewCart.click();
        List<WebElement> listProductInCart = this.driver.findElements(lstProductNameInCartCSS);
        ArrayList<String> listProductName = new ArrayList<>();
        for(WebElement product: listProductInCart) {
            listProductName.add(product.getText());
        }
        Assert.assertTrue(listProductName.contains(productName));
    }
}
