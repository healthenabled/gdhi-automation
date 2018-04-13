package steps;

import com.thoughtworks.gauge.Step;
import junit.framework.TestCase;

import static data.DataFactory.getValidInputFormDataFor;
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


}
