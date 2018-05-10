package steps;

import com.thoughtworks.gauge.Step;
import data.DataFactory;

import static org.junit.Assert.assertTrue;

public class CountryPageSteps extends BaseStep {

    @Step("User should see the data they have submitted for <countryName>")
    public void User_sees_country_details(String countryName) {
        assertTrue(countryPage.areDetailsValid(DataFactory.getValidInputFormDataFor(countryName)));
    }

    @Step("User navigates to list of countries page")
    public void User_goes_to_list_of_countries_page() {
        landingPage.visitListOfCountries();
        assertTrue(listOfCountriesPage.verifyListOfCountriesPageDetails());

    }

//    @Step("User should see list of countries along with phases")
//    public void verify_country_details() {
//        assertTrue(listOfCountriesPage.verifyListOfCountriesPageDetails());
//        assertTrue(listOfCountriesPage.iscountryNameDisplayed(countryName));
//        assertTrue(listOfCountriesPage.iscountryScoreDisplayed(countryScore));
//    }

    @Step("User should see the overall phase calculated correctly for a country")
    public void verifyPhaseCalcultionsForCountryLevel() {

    }


    @Step("User should see the <Sri Lanka> and <4> in list of published countries page along with phase")
    public void verifyPublishedCountryDisplayedInList(String countryName, String countryScore) {
        listOfCountriesPage.iscountryNameDisplayed(countryName);
        listOfCountriesPage.iscountryScoreDisplayed(countryScore);
    }

    @Step("User navigates to country details page for <Sri Lanka>")
    public void naviagteToCountryDetailsPAge(String countryName) {
listOfCountriesPage.navigateToCountryPage(countryName);
    }
}
