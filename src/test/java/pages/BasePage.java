package pages;

import core.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class BasePage {

    static WebDriver driver = Driver.getDriver();
    private static final long TIMEOUT = 60;

    void visitUrl(String url) {
        driver.get(url);
    }

    WebElement waitForElementToBeVisible(WebElement element) {
        WebDriverWait driverWait = new WebDriverWait(driver, TIMEOUT);
        return driverWait.until(ExpectedConditions.visibilityOf(element));
    }

    WebElement waitForElementToBeVisible(By strategy) {
        WebDriverWait driverWait = new WebDriverWait(driver, TIMEOUT);
        return driverWait.until(ExpectedConditions.presenceOfElementLocated(strategy));
    }
}
