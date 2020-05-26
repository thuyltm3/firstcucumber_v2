package firstcucumber.StepDefinitions;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ActionSelenium {

    // Đọc data từ file properties input vào textbox search trên trang tiki.vn
    // Test scroll đến element
    @Test
    @Ignore
    public void testScroll()
    {
        // Khai báo file properties
        Properties dataProperties= new Properties();
        // Đọc (key, value) từ file data properties
        String environment = System.getProperty("environment", "staging");
        try {
            Reader dataReader = new FileReader(
                    "/home/thuyltm3/IdeaProjects/Automation_test/firstcucumber/src/test/resources/testdata/inputData."+environment+".properties");
            dataProperties.load(dataReader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(environment);

        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://tiki.vn/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement txtSearchBox = driver.findElement(By.cssSelector("input[class^=\"FormSearch__Input\"]"));
        txtSearchBox.sendKeys(dataProperties.getProperty("keyword"));
        txtSearchBox.sendKeys(Keys.ENTER);

        // Lấy ra list element của các sp tìm kiếm
        List<WebElement> lstResultItems = driver.findElements(By.cssSelector("div.search-div-product-item"));

        // Get element của sp bất kỳ
        Random rdn = new Random();
        int index =rdn.nextInt(lstResultItems.size());
        WebElement focuItem = lstResultItems.get(index);

        // Mouse chuột & click chọn mua sp
        Actions mouseAction = new Actions(driver);
        mouseAction.moveToElement(focuItem).click().perform();
    }

    // Test import/upload file với Sikulix (chụp ảnh nhận diện element bằng lib OpenCV java)
    @Test
    @Ignore
    public void Sikulix_Test() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
//        System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver");
//        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://gofile.io/uploadFiles");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement btnUpload = driver.findElement(By.cssSelector("button#btnChooseFiles"));
        btnUpload.click();

        Screen screen = new Screen();
        try {
            screen.click("/home/thuyltm3/IdeaProjects/Automation_test/firstcucumber/src/test/resources/images/selectFolderDownloads.png");
            screen.click("/home/thuyltm3/IdeaProjects/Automation_test/firstcucumber/src/test/resources/images/selectFolderDownloads.png");
            screen.click("/home/thuyltm3/IdeaProjects/Automation_test/firstcucumber/src/test/resources/images/iconSearchFile.png");
            screen.type("/home/thuyltm3/IdeaProjects/Automation_test/firstcucumber/src/test/resources/images/searchFileName.png", "SI");
            screen.click("/home/thuyltm3/IdeaProjects/Automation_test/firstcucumber/src/test/resources/images/selectFile.png");
            screen.click("/home/thuyltm3/IdeaProjects/Automation_test/firstcucumber/src/test/resources/images/selectFile.png");

            Thread.sleep(1000);
            screen.click("/home/thuyltm3/IdeaProjects/Automation_test/firstcucumber/src/test/resources/images/btnOpen.png");
            Thread.sleep(1000);
        } catch (FindFailed findFailed) {
            findFailed.printStackTrace();
        } catch (InterruptedException e) {
            e.getMessage();
        }

        WebElement btnStartUpload = driver.findElement(By.cssSelector("button#btnUpload"));
        btnStartUpload.click();
    }

    @Test
    @Ignore
    public void Test_SignIn_With_Facebook() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");

        ChromeOptions options = new ChromeOptions();
        // Disable những notification spam của trình duyệt
        options.addArguments("--disable-notifications");

        // Test ở chế độ ngầm (không mở trình duyệt)
        options.addArguments("--headless");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://tiki.vn/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement btnUser = driver.findElement(By.cssSelector(".tikicon.icon-user"));
        Actions mouseAction = new Actions(driver);
        mouseAction.moveToElement(btnUser).perform();

        Thread.sleep(1000);

        // Get list các option Đăng ký/ Đăng nhập...
        List<WebElement> lstSignIn = driver.findElements(By.cssSelector("div[class*=\"Userstyle__UserDropDown\"] button"));
        // Click option đăng nhập bằng facebook
        lstSignIn.get(2).click();

        Thread.sleep(1000);

        // Chọn cửa sổ ban đầu
        String currentWindow = driver.getWindowHandle();
        for(String winHandle: driver.getWindowHandles())
        {
            // switch sang cửa sổ mới
            driver.switchTo().window(winHandle);
        }

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement txtEmail = driver.findElement(By.cssSelector("div#email_container input"));
        txtEmail.sendKeys("khanh.tx@live.com");

        //Return Origin
        driver.switchTo().window(currentWindow);
        //..
    }

    public float test(){
        String resultStr = "";
        float number = 0;
        String[] a = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "."};
        Random random = new Random();
        int lengthOfNumber = random.nextInt(5) + 1;
        for(int i= 0; i < lengthOfNumber; i++){
            int index = random.nextInt(a.length);
            if(lengthOfNumber == 1 && index == 10){
                continue;
            } else{
                resultStr = resultStr.concat(a[index]);
            }
        }
        number = Float.parseFloat(resultStr);
        return number;
    }

    @Test
    public void countPhanTu(){
        Random random = new Random();
        int count = random.nextInt(5) + 2;
        System.out.println("count: "+ count);
        int i = 0;
        float sum = 0;
        while(i< count){
            float x = test();
            sum = sum + x;
            System.out.println(x);
            i++;
        }
        System.out.println(sum);
    }
}
