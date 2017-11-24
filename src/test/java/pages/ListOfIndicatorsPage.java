package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ListOfIndicatorsPage extends BasePage {

    @FindBy(css = ".indicators-info-content")
    private WebElement indicatorsTable;

    public ListOfIndicatorsPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean isLoaded() {
        return isElementVisible(indicatorsTable);
    }
}
