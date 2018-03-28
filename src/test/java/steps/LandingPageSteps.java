package steps;

import com.thoughtworks.gauge.Step;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LandingPageSteps extends BaseStep {

    @Step("User opens the application url in a browser")
    public void openBaseUrl() {
        landingPage.visit();
        landingPage.waitForPageToLoad();
    }

    @Step("The default map view appears")
    public void The_default_map_view_appears() {
        assertEquals(landingPage.getIndicatorPanelName(), "State of Digital Health around the world today");
        assertEquals(landingPage.getPanelButtonName().toLowerCase(), "VIEW LIST OF COUNTRIES".toLowerCase());
    }

    @Step("User goes to the map page")
    public void User_goes_to_the_map_page() {

        landingPage.visit();
    }

    @Step("User searches for <countryName>")
    public void User_searches_for_a_country(String countryName) {
        landingPage.searchForCountry(countryName);
    }

    @Step("User will not see the digital health indicator data in the map panel")
    public void User_not_see_the_digital_health_data() {
        assertTrue(landingPage.doesDigitalHealthDataErrorAppear());
    }

    @Step("User will see the context data in the map panel")
    public void User_sees_the_context_data() {

        assertTrue(landingPage.doesContextSectionAppear());
    }

    @Step("User should see the digital health indicator data")
    public void User_sees_the_digital_health_data() {
        assertTrue(landingPage.doesDigitalHealthDataAppear());
    }

    @Step("User views the list of countries")
    public void User_goes_to_list_of_countries_page() {
        landingPage.visitListOfCountries();
        assertTrue(landingPage.isListOfCountriesAvailable());
    }

    @Step("User goes the country details page")
    public void User_goes_to_country_details_page() {
        landingPage.visitCountryDetails();
    }

    @Step("User navigates to the list of indicators page")
    public void user_navigates_to_list_of_indicators() {
        landingPage.visitListOfIndicators();
        assertTrue(listOfIndicatorsPage.isLoaded());
        }
}
