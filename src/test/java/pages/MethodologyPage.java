package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MethodologyPage extends BasePage {

    @FindBy(css = "a[href='/methodology']")
    private WebElement methodologyLink;

    @FindBy(css = ".methodology-title")
    private WebElement title;

    @FindBy(css = ".methodology a")
    private WebElement listOfIndicatorsLink;

    public MethodologyPage() {
        PageFactory.initElements(driver, this);
    }

    public void visit() {
        waitForElementToBeClickable(methodologyLink);
        methodologyLink.click();
        waitForElementToBeVisible(title);
    }

    public void clickIndicatorsLink() {
        listOfIndicatorsLink.click();
    }
}
