package pages;

import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InputForm extends BasePage {

    @FindBy(xpath = "//button[@class='submit-btn btn btn-green']/i")
    private WebElement submitButton;

    @FindBy(css = "button.submit-btn.btn.btn-green")
    private WebElement publishBtn;

    @FindBy(css = "button.submit-btn.btn.btn-red")
    private WebElement rejectBtn;

    @FindBy(xpath = "//button[text()=' Save ']")
    private WebElement reviewPageSaveBtn;

    @FindBy(xpath = "//button[text()=' Download PDF']")
    private WebElement reviewPageDownloadPDFBtn;

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

    @FindBy(id = "nameofPersonApprovedData")
    private WebElement dataCollectorName;

    @FindBy(id = "roleofPersonApprovedData")
    private WebElement dataCollectorRole;

    @FindBy(id = "emailofPersonApprovedData")
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

    @FindBy(id = "health-indicator-questionnaire-heading")
    private WebElement questionnaireHeading;

    @FindBy(xpath = "//*[contains(text(),'Please correct the highlighted fields.')]")
    private WebElement invalidFormErrorMessageText;

    @FindBy(xpath = "//*[contains(text(),'Form saved successfully!')]")
    private WebElement saveSuccessMessage;

    @FindBy(xpath = "//*[contains(text(),'Data is now live')]")
    private WebElement publishSuccessMessage;

    @FindBy(xpath = "//button[text()=' Save as Draft']")
    private WebElement saveBtn;

    @FindBy(css = "button.submit-btn.btn.btn-green")
    private WebElement submitBtn;

    @FindBy(xpath = "//span[text()='Not Available or Not Applicable']")
    private WebElement NATextElement;

    @FindBy(css = "div.accordion.expanded>div.accordion-content>div>div>div.row.description_container>textarea.description")
    private WebElement questionRationaleText;

    @FindBy(xpath = "//div[@class='tab-content'][2]/div/table[@id='fifthTable']/tbody/tr/td[text()='Sri Lanka']/../td/button[text()='Review']")
    private WebElement reviewBtnForCountry;

    @FindBy(xpath = "//div[@class='dg-content']")
    private WebElement alertMessage;

    @FindBy(xpath = "//button[@class='dg-btn dg-btn--ok dg-pull-right']")
    private WebElement alertConfirmPublishBtn;

    public InputForm() {

        PageFactory.initElements(driver, this);
    }

    public void visit() {
        visitUrl(System.getenv("INPUT_FORM_URL"));
    }

    public void submitForm() {
        sleep(2);
        submitButton.click();

    }

    public boolean isErrorMessageThrownIntheForm() {
        sleep(1);
        return invalidFormErrorMessageText.isDisplayed();
    }

    public void enterValidResponse(HashMap<String, String> data) {
//        autoCompleteSearch(countryName, "eac-container-countryName", data.get("countryName"));
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
//        resource3.sendKeys(data.get("resource3"));
//        resource4.sendKeys(data.get("resource4"));
//        resource5.sendKeys(data.get("resource5"));
        countrySummary.sendKeys(data.get("countrySummary"));
//        enterIndicatorScores(data);
//        submitForm();
    }


    public boolean isSubmittedSuccessfully() {

        return isElementVisible(successMessage);
    }

    public void enterIndicatorScores(HashMap<String, String> data) {
        System.out.println("inside indicator scores");
        submitBtn.click();
        List<WebElement> indicatorElements = driver.findElements(By.cssSelector("div.accordion.expanded>div.accordion-content>div>div"));
        int counter;
        for (WebElement indicatorElement : indicatorElements) {

                        counter = indicatorElements.indexOf(indicatorElement) + 1;
            int indicatorPhase = Integer.parseInt(data.get("indicator" + counter + "Score")) + 1;
            sleep(1);
            indicatorElement.findElement(By.cssSelector("div.scores:nth-child(3)>label.radio-container")).click();

//             chooseIndicatorPhase(indicatorElement,indicatorPhase);
            WebElement rationale = indicatorElement.findElement(By.cssSelector("div.row.description_container>textarea"));
            focusOnElement(rationale);
            rationale.sendKeys("Rationale for indicator " + counter);
        }
    }

    private void chooseIndicatorPhase(WebElement parentElement, int phase) {
sleep(1);
        parentElement.findElement(By.xpath("//span[text()='Not Available or Not Applicable']/following-sibling::input")).sendKeys();

//        scrollToElementAndClick(parentElement.findElement(By.xpath("//span[text()='Not Available or Not Applicable']/following-sibling::input")));
//        scrollToElementAndClick(NATextElement);
//        waitForElementToBeVisible(NATextElement).click();
    }

    public void validateQuestionnaireHeading() {
        assert (questionnaireHeading.getText().contains("GDHI Country Data Collection Form"));
    }

    public void navigateToQuestionnairePage(String URL) {
        visitUrl(URL);
    }

    public boolean isQuestionnaireFormOpenedFor(String countryName) {
        String countryPageTitle = "//div[@class='page-title'][contains(text(),'" + countryName + "')]";
        return waitForElementToBeVisible(By.xpath(countryPageTitle)).isDisplayed();
    }

    public void clickOnSaveBtn() {
        saveBtn.click();
    }

    public boolean isSavedsuccessfully() {
        return isElementVisible(saveSuccessMessage);
        }

    public boolean isFormReadOnly() {

        return date.isEnabled();
    }

    public boolean isQuestionnaireInfoDisabled() {

        return questionRationaleText.isEnabled();
    }

    public void navigateToReviewURLOf(String countryName) {
//        String reviewURL=countryURL.concat("/review");
//        System.out.println("REview URL is.... "+reviewURL);
//        visitUrl(reviewURL);
        reviewBtnForCountry.click();
        ArrayList tabs = new ArrayList(driver.getWindowHandles());
        System.out.println(tabs.size());
        driver.switchTo().window((String) tabs.get(1));
    }

    public boolean verifyAcceptBtnPresent() {
        return publishBtn.isDisplayed();
    }

    public boolean verifyRejectBtnPresent() {
        return rejectBtn.isDisplayed();
    }


    public boolean verifySaveBtnPresent() {

        return reviewPageSaveBtn.isDisplayed();
    }


    public boolean verifyDownloadPDF() {
        return reviewPageDownloadPDFBtn.isDisplayed();
    }

    public boolean isSaveFormSuccessful() {
        return isElementVisible(saveSuccessMessage);
    }

    public void editReviewForm(HashMap<String, String> data) {
        countryContactName.clear();
        countryContactName.sendKeys(data.get("countryContactNameInReview"));
        countryContactRole.clear();
        countryContactRole.sendKeys(data.get("countryContactRoleInReview"));
        countryContactEmail.clear();
        countryContactEmail.sendKeys(data.get("countryContactEmailInReview"));
        reviewPageSaveBtn.click();

    }

    public String verifyPublishReviewDataConfirmationText() {
        publishBtn.click();
        String alertText = alertMessage.getText();
        alertConfirmPublishBtn.click();
        return alertText;


    }

    public boolean isPublishSuccess() {
        sleep(2);
        return publishSuccessMessage.isDisplayed();
    }
}
