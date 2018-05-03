package pages;

import core.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;
import java.util.List;
import java.util.NoSuchElementException;

class BasePage {

    static WebDriver driver = Driver.getDriver();
    private static final long TIMEOUT = 30;

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

    WebElement waitForElementToBeClickable(WebElement element) {
        WebDriverWait driverWait = new WebDriverWait(driver, TIMEOUT);
        return driverWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    WebElement waitForElementToBeClickable(By strategy) {
        WebDriverWait driverWait = new WebDriverWait(driver, TIMEOUT);
        return driverWait.until(ExpectedConditions.elementToBeClickable(strategy));
    }

    boolean isElementVisible(WebElement element) {
        try {
            waitForElementToBeVisible(element);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    void sleep(double time) {
        try {
            Thread.sleep((long) (time * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void autoCompleteSearch(WebElement textBoxElement, String autoCompleteElementId, String searchText) {
        waitForElementToBeVisible(textBoxElement);
        textBoxElement.clear();
        char[] chars = searchText.toCharArray();
        for (char character : chars) {
            textBoxElement.sendKeys(Character.toString(character));
            sleep(0.1);
        }
        sleep(0.5);
        waitForElementToBeClickable(By.xpath("//div[@id='" + autoCompleteElementId + "']//b[text()='" + searchText + "']/../..")).click();
    }

    void autoCompleteSearch(WebElement textbox,String searchText){
        waitForElementToBeVisible(textbox);
        sleep(2);
        textbox.clear();
        textbox.sendKeys(searchText);
        textbox.sendKeys(Keys.ENTER);
        textbox.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
    }

    void focusOnElement(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element);
        action.sendKeys(Keys.ARROW_DOWN);
        action.perform();
    }

    void focusAndEnterText(WebElement element, String text) {
        focusOnElement(element);
        element.sendKeys(text);
    }

    void scrollToElementAndClick(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).sendKeys(Keys.ENTER);
        actions.perform();
    }


    public List<WebElement> getListofElements(By xpath) {
        return driver.findElements(xpath);
    }


}
