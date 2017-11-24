package core;

import com.thoughtworks.gauge.AfterSuite;
import com.thoughtworks.gauge.BeforeSuite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private static WebDriver webDriver = null;

    private static void startDriver() {
        String browser = System.getenv("BROWSER");

        if (browser.toLowerCase().equals("firefox")) {
            webDriver = new FirefoxDriver();
        }

        if (browser.toLowerCase().equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getenv("CHROME_DRIVER_PATH"));
            if (System.getenv("CHROME_HEADLESS") != null) {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("headless");
                chromeOptions.addArguments("window-size=1280x800");
                webDriver = new ChromeDriver(chromeOptions);
            } else {
                webDriver = new ChromeDriver();
            }
        }

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    private static void stopDriver() {
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
        }
    }

    @BeforeSuite
    public void beforeSuite() {
        startDriver();
    }

    @AfterSuite
    public void afterSuite() {
        stopDriver();
    }

    public static WebDriver getDriver() {
        return webDriver;
    }
}
