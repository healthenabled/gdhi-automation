package pages;

import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.datastore.DataStore;
import com.thoughtworks.gauge.datastore.DataStoreFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class AdminPage extends BasePage {
    @FindBy(css = "div.search-box.hd-element")
    private WebElement adminPageTextBox;

    @FindBy(css = "div .autocomplete__inputs input")
    private WebElement autocompleteTextBox;

    @FindBy(xpath = "//button[text()='Generate URL']")
    private WebElement generateURLButton;

    @FindBy(xpath = "//*[contains(text(),'URL Generated Successfully')]")
    private WebElement urlGenerationSuccessMessageText;

    @FindBy(xpath = "//button[text()='Copy url']")
    private WebElement copyURLLink;

    @FindBy(xpath = "//*[contains(text(),'URL Copied Successfully')]")
    private WebElement copyLinkSuccessMessageText;

    @FindBy(id = "url-box")
    private WebElement urlBox;

    public AdminPage() {
        PageFactory.initElements(driver, this);
    }


    public void visit() {
        System.out.println("Opening URL " + System.getenv("ADMIN_URL"));
        visitUrl(System.getenv("ADMIN_URL"));
//        visitUrl("http://admin:admin@35.170.87.166:8080/admin/");
    }

    public void waitForPageToLoad() {

        waitForElementToBeVisible(adminPageTextBox);

    }

    public void searchForCountryAndGenerateURL(String country) {
        autoCompleteSearch(autocompleteTextBox, country);
        sleep(2);
        generateURLButton.click();
        waitForPageToLoad();

    }

    public boolean verifyURLGeneratedSuccessfully() {
        sleep(1);
        return urlGenerationSuccessMessageText.isDisplayed();
    }

    public boolean verifycopyLinkForURLIsDisplayed() {
        return copyURLLink.isDisplayed();
    }

    public String copyCountryQuestionnaireLink() throws IOException, UnsupportedFlavorException {
        String result = urlBox.getAttribute("value");
//        Toolkit toolkit = Toolkit.getDefaultToolkit();
//        Clipboard clipboard = toolkit.getSystemClipboard();
//        String result = (String) clipboard.getData(DataFlavor.stringFlavor);

//        System.out.println("String from Clipboard:" + result);
        System.out.println("URL for country is " + result);
        return result;
    }

    public boolean verifycopyLinkSuccessMessage() {
        copyURLLink.click();
        sleep(1);
        return copyLinkSuccessMessageText.isDisplayed();
    }


}
