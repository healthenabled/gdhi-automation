package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;

public class ListOfCountriesPage extends BasePage {

    @FindBy(xpath = "//li[@class='countries-list-details-country'][1]/span[1][contains(@class, 'country-score')]")
    private WebElement countryScore;

    @FindBy(xpath = "//li[@class='countries-list-details-country'][1]/span[2][contains(@class, 'country-name')]")
    private WebElement countryNameLink;

    @FindBy(css = ".countries-list-details")
    private WebElement countriesList;

    public ListOfCountriesPage() {
        PageFactory.initElements(driver, this);

    }

    public boolean verifyListOfCountriesPageDetails() {
        return isElementVisible(countriesList);
    }

    public boolean iscountryScoreDisplayed()
    {
        return isElementVisible(countryScore);
    }

    public boolean iscountryNameDisplayed(){
        return isElementVisible(countryNameLink);
    }


}
