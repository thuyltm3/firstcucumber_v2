package firstcucumber.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class POM_LoginPage {
    /*
    * Với kiểu Page Object, Sẽ chứa 2 phần:
    * - Các định nghĩa locator
    * - Các method để tương tác với các locator này
    * */
    WebDriver driver;
    public POM_LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Define locator
    By usernameLoc = By.cssSelector("input[type=\"Email\"]");
    By passwordLoc = By.cssSelector("input[type=\"password\"]");
    By btnLoginLoc = By.cssSelector("button.btn-login");

    // Define method
    public void InputUserName(String username){
        WebElement txtUsername = this.driver.findElement(usernameLoc);
        txtUsername.clear();
        txtUsername.sendKeys(username);
    }

    public void InputPassword(String password){
        WebElement txtPassword = this.driver.findElement(passwordLoc);
        txtPassword.clear();
        txtPassword.sendKeys(password);
    }

    public void Login(){
        this.driver.findElement(btnLoginLoc).click();
    }

    public void getUserName(){

    }

    public void getMessage(){

    }

}
