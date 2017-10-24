package core;

import com.thoughtworks.gauge.AfterSuite;
import com.thoughtworks.gauge.BeforeSuite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
    private static WebDriver webDriver = null;

    @BeforeSuite
    public void beforeSuite() {
        if (webDriver == null) {
            System.setProperty("webdriver.chrome.driver", System.getenv("CHROME_DRIVER_PATH"));
            webDriver = new ChromeDriver();
            webDriver.manage().window().maximize();
        }
    }

    @AfterSuite
    public void afterSuite() {
        if (webDriver != null) {
            webDriver.close();
            webDriver = null;
        }
    }

    public static WebDriver getDriver() {
        return webDriver;
    }
}
