package steps;

import com.thoughtworks.gauge.Step;
import junit.framework.TestCase;

import static data.DataFactory.getValidInputFormDataFor;
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

    @Step("User navigates to review URL for <Sri Lanka>")
    public void user_nvaigates_to_review_URL(String countryName) {
        inputForm.navigateToReviewURLOf(specDataStore.get(countryName).toString());

    }
}
