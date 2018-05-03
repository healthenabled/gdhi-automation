package steps;

import com.thoughtworks.gauge.Step;

import static data.DataFactory.getValidInputFormDataFor;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class InputFormSteps extends BaseStep {
    @Step("User navigates to the input form")
    public void User_goes_to_the_input_form() {
        inputForm.visit();
        inputForm.validateQuestionnaireHeading();
    }

    @Step("User submits the form without entering any details")
    public void User_submits_empty_form() throws Exception {

        inputForm.submitForm();
    }

    @Step("User should see error messages for the mandatory fields")
    public void User_sees_mandatory_field_errors() {
        assertTrue(inputForm.isErrorMessageThrownIntheForm());
    }

    @Step("User fills the form for <Sri Lanka> with contact and resource information")
    public void User_submits_valid_form(String countryName) {
        inputForm.enterValidResponse(getValidInputFormDataFor(countryName));
//        assertTrue(inputForm.isSubmittedSuccessfully());
    }

    @Step("User should be able to save the partially filled form successfully")
    public void save_Form() {
        inputForm.clickOnSaveBtn();
        assertTrue(inputForm.isSavedsuccessfully());
    }

    @Step("User should not be able to submit the partially filled form")
    public void User_sees_mandatory_field_errors_on_submit() {
        inputForm.submitForm();
        assertTrue(inputForm.isErrorMessageThrownIntheForm());
    }


    @Step("User fills the form for <Sri Lanka> with health indicator answers")
    public void user_fills_indicator_info_For(String countryName) {
        System.out.println("Entering indicator scores for Sri lanka");
        inputForm.enterIndicatorScores(getValidInputFormDataFor(countryName));

    }

    @Step("User should be able to submit the data for <Sri Lanka> without any validation errors thrown")
    public void fills_form_without_errors(String countryNAme) {
        inputForm.submitForm();
        inputForm.isSubmittedSuccessfully();

    }

    @Step("User views the submitted responses for <Sri Lanka> in read only format after submission")
    public void userViewsReadOnlyFormatOfInputForm(String countryName) {
        assertFalse(inputForm.isFormReadOnly());
        assertFalse(inputForm.isQuestionnaireInfoDisabled());

    }

    @Step("User navigates to review URL for <Sri Lanka> from admin page")
    public void user_nvaigates_to_review_URL(String countryName) {

        adminPage.navigateToReviewPendingSection();
//        inputForm.navigateToQuestionnairePage("http://admin:admin@35.170.87.166:8080/admin/health_indicator_questionnaire/f5b497ff-450a-4d2c-8819-62cba609f29f/review");
        assertTrue(adminPage.isCountryDisplayedInReviewPendingSection(countryName));
//        inputForm.navigateToReviewURLOf(specDataStore.get(countryName).toString());
        inputForm.navigateToReviewURLOf(countryName);

    }

    @Step("User edits the form for <Sri Lanka> and removes data")
    public void user_edits_form_for(String countryName) {
        assertTrue(inputForm.verifyAcceptBtnPresent());
        assertTrue(inputForm.verifyRejectBtnPresent());
        assertTrue(inputForm.verifySaveBtnPresent());
        inputForm.editReviewForm(getValidInputFormDataFor(countryName));
        assertTrue(inputForm.isSaveFormSuccessful());
        assertTrue(inputForm.verifyDownloadPDF());

    }

    @Step("User publishes the data for <Sri Lanka>")
    public void publishData(String countryName) {
        assertEquals(inputForm.verifyPublishReviewDataConfirmationText(),"You are about to publish digital health index form for Sri Lanka, this cannot be reverted. Do you want to continue?");
//        inputForm.confirmPublisData();

        assertTrue(inputForm.isPublishSuccess());

    }
}
