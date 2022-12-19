package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DuckDuckGoSearchPage extends AbstractPage
{
    public final static By searchInput = By.id("search_form_input_homepage");
    public final static By searchButt = By.id("search_button_homepage");

    public DuckDuckGoSearchPage(WebDriver myDriver)
    {
        super(myDriver);
    }

    public void loadPage()
    {
        getDriver().get("https://duckduckgo.com/");
    }

    public void search(String myQuery)
    {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(searchInput));
        getWait().until(ExpectedConditions.visibilityOfElementLocated(searchButt));
        getDriver().findElement(searchInput).sendKeys(myQuery);
        getDriver().findElement(searchButt).click();
    }

}
