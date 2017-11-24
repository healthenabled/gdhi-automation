package steps;

import com.thoughtworks.gauge.Step;

import static data.DataFactory.getValidInputFormDataFor;
import static org.junit.Assert.assertTrue;

public class InputFormSteps extends BaseStep {
    @Step("User navigates to the input form")
    public void User_goes_to_the_input_form() {
        inputForm.visit();
    }

    @Step("User submits the form without entering any details")
    public void User_submits_empty_form() {
        inputForm.submitForm();
    }

    @Step("User should see error messages for the mandatory fields")
    public void User_sees_mandatory_field_errors() {
        assertTrue(inputForm.doesFormHaveErrors());
    }

    @Step("User provides valid responses for <countryName> to the questionnairre")
    public void User_submits_valid_form(String countryName) {
        inputForm.enterValidResponse(getValidInputFormDataFor(countryName));
        assertTrue(inputForm.isSubmittedSuccessfully());
    }
}
