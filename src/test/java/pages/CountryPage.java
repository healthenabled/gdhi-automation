package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;

public class CountryPage extends BasePage {

    @FindBy(css = ".country-name")
    private WebElement countryNameHeading;

    @FindBy(css = "div.score.phase2")
    private WebElement overallScore;

    @FindBy(css = ".health-indicators")
    private WebElement digitalHealthIndicatorSection;

    @FindBy(css = ".development-indicators")
    private WebElement developmentIndicatorSection;

    @FindBy(css = ".export a")
    private WebElement exportLink;

    @FindBy(css = ".country-summary")
    private WebElement countrySummarySection;

    @FindBy(xpath = "//div[contains(@class,'country-summary-text')]")
    private WebElement countrySummaryText;

    @FindBy(xpath = "//div[contains(@class,'country-summary-title')][text()='Resources']")
    private WebElement resourcesText;

    @FindBy(xpath = "//ul[@class='country-text']")
    private WebElement resourcesSection;

    public CountryPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean  areDetailsValid(HashMap<String, String> data) {
        boolean isValid;
        isValid = countryNameHeading.getText().equals(data.get("countryName"));
        isValid = isValid && isElementVisible(overallScore);
        isValid = isValid && isElementVisible(digitalHealthIndicatorSection);
        isValid = isValid && isElementVisible(developmentIndicatorSection);
        isValid = isValid && isElementVisible(exportLink);
        isValid = isValid && countrySummaryText.getText().equals(data.get("countrySummary"));
        isValid = isValid && resourcesText.getText().equalsIgnoreCase(data.get("resourcesText"));
        isValid = isValid && isElementVisible(resourcesSection);
        return isValid;
    }
}
