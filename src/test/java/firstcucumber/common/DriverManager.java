package firstcucumber.common;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverManager {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private static enum Browser {
        FIREFOX,
        CHROME,
        IE,
        ANDROID,
        IOS
    }

    public static WebDriver createInstance(String browserName) throws MalformedURLException {
        WebDriver driver;
        browserName = (browserName != null) ? browserName : "chrome";
        String version = System.getProperty("version");
        String deviceName = System.getProperty("device");
        switch (Browser.valueOf(browserName.toUpperCase())) {
            case ANDROID:
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
                capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, version);
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
                capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
                capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
                URL url = new URL("http://127.0.0.1:4723/wd/hub");

                driver = new AndroidDriver(url, capabilities);
                break;
            case IOS:
                DesiredCapabilities iosCap = new DesiredCapabilities();
                iosCap.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
                iosCap.setCapability(MobileCapabilityType.PLATFORM_VERSION, version);
                iosCap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
                iosCap.setCapability(MobileCapabilityType.BROWSER_NAME, "Safari");
                iosCap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);

                URL iosUrl = new URL("http://127.0.0.1:4723/wd/hub");

                driver = new IOSDriver(iosUrl, iosCap);
            case IE:
                driver = new InternetExplorerDriver();
                break;
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/gheckodriver");
                driver = new FirefoxDriver();
                break;
            default:
                System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
                driver = new ChromeDriver();
                break;
        }
        // maximize browser's window on start
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            String browserName = System.getProperty("browser", "chrome");
            try {
                setWebDriver(createInstance(browserName));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return driver.get();
    }

    public static void setWebDriver(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        DriverManager.driver.set(driver);
    }

    public static void closeWebDriver()
    {
        driver.get().quit();
        driver.remove();
    }
}