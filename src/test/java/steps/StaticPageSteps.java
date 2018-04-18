package steps;

import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;

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


    @Step("User should see below list of indicators <table>")
    public void verifyIndicatorList(Table table) {
        assertTrue(listOfIndicatorsPage.isLoaded());
        System.out.println(table.getColumnValues("Indicators"));
        System.out.println("Actual indicators:::" +listOfIndicatorsPage.getActualListOfIndicators());
        assertTrue(listOfIndicatorsPage.getActualListOfIndicators().containsAll(table.getColumnValues("Indicators")));
    }


}
