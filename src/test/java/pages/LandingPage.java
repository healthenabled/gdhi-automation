package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends BasePage {

    @FindBy(css = ".indicator-panel-button")
    private WebElement panelButton;

    @FindBy(css = ".indicator-panel")
    private WebElement indicatorPanelbox;

    @FindBy(css = ".indicator-panel-container-name")
    private WebElement panelName;

    @FindBy(css = ".indicator-panel-error")
    private WebElement panelError;

    @FindBy(css = ".indicator-panel-container-context-section")
    private WebElement contextSection;

    @FindBy(id = "search-box")
    private WebElement searchBox;

    @FindBy(css = "div .autocomplete__inputs input")
    private WebElement autocompleteTextBox;

    @FindBy(css = ".countries-list-heading")
    private WebElement listOfCountriesHeading;

    @FindBy(css = ".countries-list-details")
    private WebElement countriesList;

    @FindBy(css = ".indicator-panel-container-category-section-name")
    private WebElement categoryName;

    @FindBy(css = "a[href='/indicators_info']")
    private WebElement listOfIndicatorFooterLink;

    public LandingPage() {

        PageFactory.initElements(driver, this);
    }

    public void visit() {

        visitUrl(System.getenv("APP_BASE_URL"));
    }

    public void waitForPageToLoad() {

            waitForElementToBeVisible(panelButton);
        }

    public String getIndicatorPanelName() {

        return waitForElementToBeVisible(panelName).getText();
    }

    public String getPanelButtonName() {

        return waitForElementToBeVisible(panelButton).getText();
    }

    public boolean doesDigitalHealthDataAppear() {
        return isElementVisible(categoryName);
    }

    public boolean doesDigitalHealthDataErrorAppear() {
        return isElementVisible(panelError);
    }

    public boolean doesContextSectionAppear() {
        return isElementVisible(contextSection);
    }

    public void searchForCountry(String countryName) {
        autoCompleteSearch(autocompleteTextBox, countryName);
        sleep(5);
    }

    public void visitListOfCountries() {
        focusOnElement(panelButton);
        panelButton.click();
    }

    public void visitCountryDetails() {
        visitListOfCountries();
    }

    public boolean isListOfCountriesAvailable() {
        return isElementVisible(countriesList);
    }

    public void visitListOfIndicators() {
        listOfIndicatorFooterLink.click();
    }
}
