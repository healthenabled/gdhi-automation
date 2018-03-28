package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.List;

public class InputForm extends BasePage {

    @FindBy(className = "submit-btn")
    private WebElement submitButton;

    @FindBy(id = "countryName")
    private WebElement countryName;

    @FindBy(id = "Organisation")
    private WebElement organisation;

    @FindBy(id = "date")
    private WebElement date;

    @FindBy(id = "nameofPersonEnteringData")
    private WebElement dataEntryName;

    @FindBy(id = "roleOfPersonEnteringData")
    private WebElement dataEntryRole;

    @FindBy(id = "emailOfPersonEnteringData")
    private WebElement dataEntryEmail;

    @FindBy(id = "nameofPersonCollectedData")
    private WebElement dataCollectorName;

    @FindBy(id = "roleofPersonCollectedData")
    private WebElement dataCollectorRole;

    @FindBy(id = "emailofPersonCollectedData")
    private WebElement dataCollectorEmail;

    @FindBy(id = "nameofCountryContact")
    private WebElement countryContactName;

    @FindBy(id = "roleofCountryContact")
    private WebElement countryContactRole;

    @FindBy(id = "emailofCountryContact")
    private WebElement countryContactEmail;

    @FindBy(id = "resource1")
    private WebElement resource1;

    @FindBy(id = "resource2")
    private WebElement resource2;

    @FindBy(id = "resource3")
    private WebElement resource3;

    @FindBy(id = "resource4")
    private WebElement resource4;

    @FindBy(id = "resource5")
    private WebElement resource5;

    @FindBy(id = "countrySummary")
    private WebElement countrySummary;

    @FindBy(css = ".success")
    private WebElement successMessage;

    @FindBy( id = "health-indicator-questionnaire-heading")
    private WebElement questionnaireHeading;

    public InputForm() {

        PageFactory.initElements(driver, this);
    }

    public void visit() {
        visitUrl(System.getenv("INPUT_FORM_URL"));
    }

    public void submitForm() {
        sleep(1);
//        scrollToElementAndClick(submitButton);
        focusOnElement(submitButton);
        sleep(1);
        submitButton.click();
//        waitForElementToBeClickable(submitButton).click();
//        waitForElementToBeClickable(submitButton).click();
//        submitButton.click();
    }

    public boolean doesFormHaveErrors() {
        return waitForElementToBeVisible(countryName).getAttribute("class").contains("has-error");
    }

    public void enterValidResponse(HashMap<String, String> data) {
        autoCompleteSearch(countryName, "eac-container-countryName", data.get("countryName"));
        organisation.sendKeys(data.get("organisation"));
        date.sendKeys(data.get("date"));
        dataEntryName.sendKeys(data.get("dataEntryName"));
        dataEntryRole.sendKeys(data.get("dataEntryRole"));
        dataEntryEmail.sendKeys(data.get("dataEntryEmail"));
        dataCollectorName.sendKeys(data.get("dataCollectorName"));
        dataCollectorRole.sendKeys(data.get("dataCollectorRole"));
        dataCollectorEmail.sendKeys(data.get("dataCollectorEmail"));
        countryContactName.sendKeys(data.get("countryContactName"));
        countryContactRole.sendKeys(data.get("countryContactRole"));
        countryContactEmail.sendKeys(data.get("countryContactEmail"));
        resource1.sendKeys(data.get("resource1"));
        resource2.sendKeys(data.get("resource2"));
        resource3.sendKeys(data.get("resource3"));
        resource4.sendKeys(data.get("resource4"));
        resource5.sendKeys(data.get("resource5"));
        countrySummary.sendKeys(data.get("countrySummary"));
        enterIndicatorScores(data);
        submitForm();
    }

    public boolean isSubmittedSuccessfully() {

        return isElementVisible(successMessage);
    }

    private void enterIndicatorScores(HashMap<String, String> data) {
        List<WebElement> indicatorElements = driver.findElements(By.cssSelector(".accordian"));
        int counter;
        for(WebElement indicatorElement : indicatorElements) {
            counter = indicatorElements.indexOf(indicatorElement) + 1;
            int indicatorPhase = Integer.parseInt(data.get("indicator" + counter + "Score")) + 1;
            focusOnElement(indicatorElement);

            WebElement accordian = indicatorElement.findElement(By.xpath(".."));
            accordian.findElement(By.cssSelector("span")).click();
            sleep(1);

            WebElement accordianContent = accordian.findElement(By.cssSelector(".accordian-content"));
            focusOnElement(accordianContent);
            chooseIndicatorPhase(accordianContent, indicatorPhase);

            WebElement rationale = accordianContent.findElement(By.cssSelector(".description"));
            focusOnElement(rationale);
            rationale.sendKeys("Rationale for indicator " + counter);
        }
    }

    private void chooseIndicatorPhase(WebElement parentElement, int phase) {
        String radioCss = "input[value='" + phase + "']";
        WebElement score = parentElement.findElement(By.cssSelector(radioCss));
        focusOnElement(score);
        waitForElementToBeClickable(score);
        score.click();
    }

    public void validateQuestionnaireHeading() {
//        sleep(2);
        assert (questionnaireHeading.getText().contains("GDHI Country Data Collection Form"));
    }
}
