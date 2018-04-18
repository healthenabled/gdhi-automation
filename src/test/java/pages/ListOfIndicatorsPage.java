package pages;

import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ListOfIndicatorsPage extends BasePage {

    @FindBy(css = ".indicators-info-content")
    private WebElement indicatorsTable;


    public ListOfIndicatorsPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean isLoaded() {
        return isElementVisible(indicatorsTable);
    }
    

    public List getActualListOfIndicators() {
        List<String> actualIndicators = new ArrayList();
        List<WebElement> actualIndicatorText = getListofElements(By.xpath("//div[@class='accordion expanded']/div[@class='align-No sub-header']"));
        for (WebElement element:actualIndicatorText) {
            System.out.println("Actual indicators " +element.getText());
            actualIndicators.add(element.getText().toLowerCase());
        }
        return actualIndicators;
    }
}
