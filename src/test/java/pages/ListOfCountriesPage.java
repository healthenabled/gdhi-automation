package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ListOfCountriesPage extends BasePage {

    @FindBy(xpath = "//li[@class='countries-list-details-country'][1]/span[1][contains(@class, 'country-score')]")
    private WebElement countryScore;

    @FindBy(xpath = "//li[@class='countries-list-details-country'][1]/span[2][contains(@class, 'country-name')]")
    private WebElement countryNameLink;

    @FindBy(css = ".countries-list-details")
    private WebElement countriesList;

    @FindBy(xpath = "//span[@class='country-name'][text()='Sri Lanka']")
    private WebElement countryNameText;

    @FindBy(xpath = "//span[@class='country-name'][text()='Sri Lanka']/parent::li/span[1][text()='2']")
    private WebElement countryScoreText;

    @FindBy(xpath = "//div[@class='country-name page-title'][contains(text(),'Sri Lanka')]")
    private WebElement countryPageTitle;

    public ListOfCountriesPage() {
        PageFactory.initElements(driver, this);

    }

    public boolean verifyListOfCountriesPageDetails() {
        return isElementVisible(countriesList);
    }

    public boolean iscountryScoreDisplayed(String countryScore) {
        return isElementVisible(countryScoreText);
    }

    public boolean iscountryNameDisplayed(String countryName) {
        return isElementVisible(countryNameText);
    }


    public void navigateToCountryPage(String countryName) {
        countryNameText.click();
        waitForElementToBeVisible(countryPageTitle);
    }
}
