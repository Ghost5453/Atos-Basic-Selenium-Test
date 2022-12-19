package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class DuckDuckGoResultsPage extends AbstractPage {

    public final static By findResults = By.cssSelector("div.results h2 span");

    public DuckDuckGoResultsPage(WebDriver myDriver)
    {
        super(myDriver);
    }

    public List<String> getResults(String myQuery)
    {
        List<String> resultsStr = new ArrayList<>();
        List<WebElement> results;
        getWait().until(ExpectedConditions.titleContains(myQuery));
        getWait().until(ExpectedConditions.visibilityOfElementLocated(findResults));

        results = getDriver().findElements(findResults);

        for (WebElement element: results)
        {
            resultsStr.add(element.getText());
        }

        return resultsStr;
    }
}
