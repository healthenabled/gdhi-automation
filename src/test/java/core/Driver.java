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
//                chromeOptions.setCapability("chrome.switches", Arrays.asList("--disable-javascript"));
//                chromeOptions.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);

                webDriver = new ChromeDriver(chromeOptions);
                System.out.println("starting in Headless mode");




            } else {
                System.out.println("Starting ChromeDriver...");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--kiosk");
                options.addArguments("--no-sandbox");
//                  options.setCapability("chrome.switches", Arrays.asList("--disable-javascript"));
                webDriver = new ChromeDriver(options);

                System.out.println("starting in normal mode");

            }
        }

        System.out.println("About webdriver..." + webDriver.toString());
//        webDriver.manage().window().maximize();
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
