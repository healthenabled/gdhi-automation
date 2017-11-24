package steps;

import com.thoughtworks.gauge.Step;
import data.DataFactory;

import static org.junit.Assert.assertTrue;

public class CountryPageSteps extends BaseStep {

    @Step("User should see the data they have submitted for <countryName>")
    public void User_sees_country_details(String countryName) {
        assertTrue(countryPage.areDetailsValid(DataFactory.getValidInputFormDataFor(countryName)));
    }
}
