package pages;

import org.openqa.selenium.By;

public class LandingPage extends BasePage {

    public void visit() {
        visitUrl(System.getenv("APP_BASE_URL"));
    }

    public void clickLink(String linkText) {
        waitForElementToBeVisible(By.linkText(linkText)).click();
    }
}
