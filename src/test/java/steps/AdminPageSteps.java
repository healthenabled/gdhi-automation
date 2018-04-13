package steps;

import com.thoughtworks.gauge.Step;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import static junit.framework.TestCase.assertTrue;


public class AdminPageSteps extends BaseStep {


    @Step("User navigates to admin page")
    public void naviagteToAdminPage() {
        adminPage.visit();
        adminPage.waitForPageToLoad();

    }

    @Step("User generates input form URL for <Sri Lanka>")
    public void generateURL(String country) {
        adminPage.searchForCountryAndGenerateURL(country);
        assertTrue(adminPage.verifyURLGeneratedSuccessfully());
    }

    @Step("User copies the form link for <Sri Lanka>")
    public void copyFormLink(String countryName) throws IOException, UnsupportedFlavorException {

        assertTrue(adminPage.verifycopyLinkForURLIsDisplayed());
       assertTrue(adminPage.verifycopyLinkSuccessMessage());
        specDataStore.put(countryName,adminPage.copyCountryQuestionnaireLink());
    }

    @Step("User navigates to the input form for <Sri Lanka>")
    public void navigateToQuestionnaireForm(String countryName) {
        inputForm.navigateToQuestionnairePage(specDataStore.get(countryName).toString());
        inputForm.isQuestionnaireFormOpenedFor(countryName);
    }
}
