package firstcucumber.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class POM_CalculatorPage {
    WebDriver driver;

    @FindBy(css="span[dcg-command=\"+\"]")
    public WebElement btnPlusCSS;

    @FindBy(css="span[dcg-command=\"-\"]")
    public WebElement btnMinusCSS;

    @FindBy(css="span[dcg-command=\"*\"]")
    public WebElement btnTimesCSS;

    @FindBy(css="span[dcg-command=\"/\"]")
    public WebElement btnDivideCSS;

    @FindBy(css=".dcg-basic-expression-value > div:nth-child(1) > span:nth-child(2)")
    public WebElement outputCSS;

    @FindAll({
            @FindBy(css = "span.dcg-keypad-btn.dcg-btn-dark-on-gray[aria-label=\"0\"]"),
            @FindBy(css = "span.dcg-keypad-btn.dcg-btn-dark-on-gray[aria-label=\"1\"]"),
            @FindBy(css = "span.dcg-keypad-btn.dcg-btn-dark-on-gray[aria-label=\"2\"]"),
            @FindBy(css = "span.dcg-keypad-btn.dcg-btn-dark-on-gray[aria-label=\"3\"]"),
            @FindBy(css = "span.dcg-keypad-btn.dcg-btn-dark-on-gray[aria-label=\"4\"]"),
            @FindBy(css = "span.dcg-keypad-btn.dcg-btn-dark-on-gray[aria-label=\"5\"]"),
            @FindBy(css = "span.dcg-keypad-btn.dcg-btn-dark-on-gray[aria-label=\"6\"]"),
            @FindBy(css = "span.dcg-keypad-btn.dcg-btn-dark-on-gray[aria-label=\"7\"]"),
            @FindBy(css = "span.dcg-keypad-btn.dcg-btn-dark-on-gray[aria-label=\"8\"]"),
            @FindBy(css = "span.dcg-keypad-btn.dcg-btn-dark-on-gray[aria-label=\"9\"]")
    })
    public List<WebElement> lstItems;

    public POM_CalculatorPage(WebDriver driver) {
        this.driver = driver;
    }

    public void InitElement(){
        PageFactory.initElements(this.driver, this);
    }

    public float getRandomNumber(){
        List<WebElement> lstNumbers = this.lstItems;
        String resultStr = "";
        float number;
        Random random = new Random();
        int lengthOfNumber = random.nextInt(5) + 1;
        for(int i= 0; i < lengthOfNumber; i++){
            int index = random.nextInt(lstNumbers.size());
            if(lengthOfNumber == 1 && index == 10){
                continue;
            } else {
                WebElement btnNumber = lstNumbers.get(index);
                btnNumber.click();
                resultStr = resultStr.concat(btnNumber.getAttribute("aria-label"));
            }
        }
        number = Float.parseFloat(resultStr);
        return number;
    }

    public float getOutputNumber(){
        float output = 0;
        String result = this.outputCSS.getText();
        String outputStr = result.substring(1);
        output = Float.parseFloat(outputStr);
        return output;
    }

    public void clickPlus(){
        this.btnPlusCSS.click();
    }

    public void clickMinus(){
        this.btnMinusCSS.click();
    }

    public void clickTimes(){
        this.btnTimesCSS.click();
    }

    public void clickDivide(){
        this.btnDivideCSS.click();
    }
}
