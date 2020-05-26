package firstcucumber.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class POM_TodoPage {
    // Co 2 bước khi làm với Page Factory
    // 1. Define các mapping
    // 2. Init các page factory

    WebDriver driver;

    @FindBy(css="input.new-todo")
    public WebElement txtInput;

    @FindBys(@FindBy(css="ul.todo-list label"))
    public List<WebElement> lstItems;

    // Khởi tạo qua contructor
    public POM_TodoPage(WebDriver driver) {
        this.driver = driver;
    }

    // Khởi tạo qua page fatory (lm cách này thì phải khởi tạo trước mỗi TC ko sẽ gây lỗi)
    public void InitElement(){
        PageFactory.initElements(this.driver, this);
    }
}
