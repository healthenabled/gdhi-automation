package steps;

import com.thoughtworks.gauge.Step;
import pages.LandingPage;

class BaseStep {
    LandingPage landingPage = new LandingPage();

    @Step("User opens the application url in a browser")
    public void openBaseUrl() {
        landingPage.visit();
    }

    @Step("User clicks on the <link_name> link")
    public void clickLink(String linkText) {
        landingPage.clickLink(linkText);
    }
}
