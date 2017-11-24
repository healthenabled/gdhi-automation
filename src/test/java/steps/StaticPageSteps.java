package steps;

import com.thoughtworks.gauge.Step;

import static org.junit.Assert.assertTrue;

public class StaticPageSteps extends BaseStep {

    @Step("User goes to the methodology page")
    public void User_goes_to_methodology_page() {
        methodologyPage.visit();
    }

    @Step("User goes to the list of indicators page from the methodology page")
    public void User_goes_to_indicators_page_from_methodology_page() {
        methodologyPage.clickIndicatorsLink();
        assertTrue(listOfIndicatorsPage.isLoaded());
    }
}
