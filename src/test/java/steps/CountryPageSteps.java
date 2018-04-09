package steps;

import com.thoughtworks.gauge.Step;
import data.DataFactory;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertTrue;

public class CountryPageSteps extends BaseStep {

    @Step("User should see the data they have submitted for <countryName>")
    public void User_sees_country_details(String countryName) {
        assertTrue(countryPage.areDetailsValid(DataFactory.getValidInputFormDataFor(countryName)));
    }

    @Step("User navigates to list of countries page")
    public void User_goes_to_list_of_countries_page() {
        landingPage.visitListOfCountries();

    }

    @Step("User should see list of countries along with phases")
    public void verify_country_details() {
        assertTrue(listOfCountriesPage.verifyListOfCountriesPageDetails());
        assertTrue(listOfCountriesPage.iscountryNameDisplayed());
        assertTrue(listOfCountriesPage.iscountryScoreDisplayed());
    }

    @Step("User should see the overall phase calculated correctly for a country")
    public void verifyPhaseCalcultionsForCountryLevel() {

    }
}
